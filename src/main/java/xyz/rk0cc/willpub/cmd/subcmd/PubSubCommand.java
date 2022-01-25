package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;
import xyz.rk0cc.willpub.cmd.options.PubOption;

import javax.annotation.Nonnull;
import java.util.*;

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
            throw new IllegalArgumentException(getClass().getSimpleName() +
                    " does not accept option " +
                    optionType.getSimpleName() +
                    "."
            );
    }

    @Nonnull
    public final PubSubCommand addOption(@Nonnull PubOption option, boolean replaceIfExisted) {
        optionTypeAssertion(option.getClass());

        if (appliedOption.containsKey(option.getClass()) && replaceIfExisted)
            appliedOption.put(option.getClass(), option);

        appliedOption.putIfAbsent(option.getClass(), option);

        return this;
    }

    @Nonnull
    public final PubSubCommand removeOption(@Nonnull Class<? extends PubOption> optionType) {
        appliedOption.remove(optionType);
        return this;
    }

    @Nonnull
    final String $buildSubCommand() {
        StringBuilder builder = new StringBuilder();
        builder.append("pub ");
        builder.append(subCommandName);

        for (PubOption o : appliedOption.values()) {
            builder.append(" ");
            builder.append(o.buildOption());
        }

        return builder.toString();
    }

    @Nonnull
    public abstract String buildSubCommand();
}
