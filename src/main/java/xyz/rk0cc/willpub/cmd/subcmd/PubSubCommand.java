package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;
import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;
import xyz.rk0cc.willpub.cmd.options.PubOption;
import xyz.rk0cc.willpub.exceptions.cmd.IllegalSubCommandOptionException;
import xyz.rk0cc.willpub.exceptions.cmd.PerquisitesOptionsNotFoundException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * An object representing subcommands in <code>pub</code>.
 * <br/>
 * You can not inherit from this class directly when implementing new {@link PubSubCommand}, please follow the table
 * depending on the subcommand structures:
 * <table border="1">
 *      <tr>
 *          <th>Sub-abstract class</th>
 *          <th>Suitable for</th>
 *      </tr>
 *      <tr>
 *          <td>{@link AbstractedPubSubCommand}</td>
 *          <td>A command without any arguments parse.</td>
 *      </tr>
 *      <tr>
 *          <td>{@link PubSubCommandWithArgs}</td>
 *          <td>A command with arguments parse.</td>
 *      </tr>
 * </table>
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd"><code>pub</code> subcommand documentation</a>
 */
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

    /**
     * Check does this subcommand's option is empty.
     *
     * @return <code>true</code> if no {@link PubOption} applied.
     */
    public final boolean isEmptyOptions() {
        return appliedOption.isEmpty();
    }

    /**
     * Apply {@link PubOption} to this subcommand.
     * <br/>
     * Applied {@link PubOption} will be {@link PubOption#clone() cloned} and save internally.
     *
     * @param option A {@link PubOption} which pending to apply this subcommand.
     * @param replaceIfExisted Replace option data if applied {@link PubOption} is existed in this subcommand already.
     *
     * @return Same object of subcommand which allows chaining methods.
     *
     * @throws IllegalSubCommandOptionException If this subcommand applied unsupported {@link PubOption}.
     * @throws PerquisitesOptionsNotFoundException Some {@link PubOption} has {@link PubPerquisitesOptions} which
     *                                             required {@link PubPerquisitesOptions.PerquisitesPolicy#EITHER either}
     *                                             or {@link PubPerquisitesOptions.PerquisitesPolicy#BOTH both}
     *                                             {@link PubOption} which mentioned in the
     *                                             {@link PubPerquisitesOptions#perquisites() perquisites}. If applying
     *                                             {@link PubOption} without meeting requirement, this exception
     *                                             thrown.
     */
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
            appliedOption.put(option.getClass(), option.clone());

        appliedOption.putIfAbsent(option.getClass(), option.clone());

        return this;
    }

    /**
     * Apply or replace if existed this option to this subcommand.
     *
     * @param option Specify which {@link PubOption} is applied into this subcommand.
     *
     * @return Current subcommand that allowing chaining methods.
     *
     * @throws IllegalSubCommandOptionException If this subcommand applied unsupported {@link PubOption}.
     * @throws PerquisitesOptionsNotFoundException If applied specific {@link PubOption} does not meet
     *                                             {@link PubPerquisitesOptions perquisites} requirement.
     *
     * @see #addOption(PubOption, boolean)
     */
    @Nonnull
    public final PubSubCommand addOption(@Nonnull PubOption option) {
        return addOption(option, true);
    }

    /**
     * Get applied {@link PubOption} in this subcommands.
     *
     * @param option {@link Class} of the {@link PubOption}.
     * @param <O> Target type of {@link PubOption}.
     *
     * @return A {@link PubOption} with record when {@link #addOption(PubOption, boolean) applied}. Or <code>null</code>
     *         if not applied yet.
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public final <O extends PubOption> O getOption(@Nonnull Class<O> option) {
        PubOption result = appliedOption.get(option);
        return Objects.isNull(result) ? null : (O) result.clone();
    }

    /**
     * Inspect {@link PubOption} {@link Class} is applied into this subcommand already or not.
     *
     * @param option {@link Class} of {@link PubOption} that want to inspect is existed in this subcommand or not.
     *
     * @return <code>true</code> if existed.
     */
    public final boolean hasOption(@Nonnull Class<? extends PubOption> option) {
        return appliedOption.containsKey(option);
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

        // When found at least one options has perquisites
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
    public final PubSubCommand clearOption() {
        appliedOption.clear();
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
