package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;
import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;
import xyz.rk0cc.willpub.cmd.options.PubOption;
import xyz.rk0cc.willpub.exceptions.cmd.IllegalSubCommandOptionException;
import xyz.rk0cc.willpub.exceptions.cmd.PerquisitesOptionsNotFoundException;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

public sealed abstract class PubSubCommand permits AbstractedPubSubCommand, PubSubCommandWithArgs {
    private final String subCommandName;
    private final Set<Class<? extends PubOption>> acceptedOption;
    private final LinkedHashMap<Class<? extends PubOption>, PubOption> appliedOption = new LinkedHashMap<>();

    PubSubCommand(@Nonnull String subCommandName, @Nonnull Set<Class<? extends PubOption>> acceptedOption) {
        this.subCommandName = subCommandName;
        this.acceptedOption = Collections.unmodifiableSet(acceptedOption);
    }

    @Nonnull
    final String subCommandName() {
        return subCommandName;
    }

    private void optionTypeAssertion(@Nonnull Class<? extends PubOption> optionType) {
        if (optionType.getAnnotation(PubGlobalOption.class) == null && !acceptedOption.contains(optionType))
            throw new IllegalSubCommandOptionException(getClass(), optionType);
    }

    @Nonnull
    public final PubSubCommand addOption(@Nonnull PubOption option, boolean replaceIfExisted) {
        optionTypeAssertion(option.getClass());

        final PubPerquisitesOptions ppo = option.getClass().getAnnotation(PubPerquisitesOptions.class);

        if (ppo != null &&
                (ppo.affectedSubCommands().length == 0 ||
                        Arrays.stream(ppo.affectedSubCommands()).anyMatch(asc -> asc.equals(this.getClass())))) {
            int matchedCount = 0;

            for (Class<? extends PubOption> o : ppo.perquisites()) {
                if (appliedOption.containsKey(o))
                    matchedCount++;
            }

            boolean bothCond = ppo.policy() == PubPerquisitesOptions.PerquisitesPolicy.BOTH
                    && matchedCount >= ppo.perquisites().length;

            boolean eitherCond = ppo.policy() == PubPerquisitesOptions.PerquisitesPolicy.EITHER
                    && matchedCount >= 1;

            if (!(bothCond || eitherCond))
                throw new PerquisitesOptionsNotFoundException(ppo);
        }

        if (appliedOption.containsKey(option.getClass()) && replaceIfExisted)
            appliedOption.put(option.getClass(), option);

        appliedOption.putIfAbsent(option.getClass(), option);

        return this;
    }

    /**
     * Apply or replace if existed this option to this subcommand.
     *
     * @param option Specify which {@link PubOption} is applied into this subcommand.
     *
     * @return Current subcommand that allowing chaining methods.
     *
     * @see #addOption(PubOption, boolean)
     */
    @Nonnull
    public final PubSubCommand addOption(@Nonnull PubOption option) {
        return addOption(option, true);
    }

    @Nonnull
    public final PubSubCommand removeOption(@Nonnull Class<? extends PubOption> optionType) {
        appliedOption.remove(optionType);

        // Found options that have perquisites
        final Set<Class<? extends PubOption>> perqOpt = appliedOption.keySet().stream()
                .filter(oc -> {
                    PubPerquisitesOptions p = oc.getAnnotation(PubPerquisitesOptions.class);

                    if (Objects.isNull(p)) return false;
                    else if (p.affectedSubCommands().length == 0) return true;

                    return Arrays.stream(p.affectedSubCommands()).anyMatch(asc -> asc.equals(this.getClass()));
                })
                .collect(Collectors.toUnmodifiableSet());

        if (!perqOpt.isEmpty()) {
            for (Class<? extends PubOption> hasPo : perqOpt) {
                PubPerquisitesOptions ppo = Objects.requireNonNull(hasPo.getAnnotation(PubPerquisitesOptions.class));
                switch (ppo.policy()) {
                    case BOTH -> appliedOption.remove(hasPo);
                    case EITHER -> {
                        if (Arrays.stream(ppo.perquisites()).noneMatch(appliedOption::containsKey))
                            appliedOption.remove(hasPo);
                    }
                }
            }
        }

        return this;
    }

    @Nonnull
    final String subCommandProgram() {
        return "pub " + subCommandName;
    }

    @Nonnull
    final String subCommandOptionFlags() {
        StringBuilder ofb = new StringBuilder();
        Iterator<PubOption> ipo = appliedOption.values().iterator();

        while (ipo.hasNext()) {
            PubOption cho = ipo.next();

            ofb.append(cho.buildOption());

            if (ipo.hasNext())
                ofb.append(" ");
        }

        return ofb.toString();
    }

    @Nonnull
    public abstract String buildSubCommand();
}
