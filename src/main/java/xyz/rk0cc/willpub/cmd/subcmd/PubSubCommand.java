package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;
import xyz.rk0cc.willpub.cmd.options.PubOption;

import javax.annotation.Nonnull;
import java.util.*;

public sealed abstract class PubSubCommand permits PubGetSubCommand, PubSubCommandWithArgs {
    private final String subCommandName;
    private final Set<Class<? extends PubOption>> acceptedOption;
    private final LinkedHashSet<PubOption> appliedOption = new LinkedHashSet<>();

    PubSubCommand(@Nonnull String subCommandName, @Nonnull Set<Class<? extends PubOption>> acceptedOption) {
        this.subCommandName = subCommandName;
        this.acceptedOption = Collections.unmodifiableSet(acceptedOption);
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

        if (appliedOption.contains(option) && replaceIfExisted)
            removeOption(option.getClass());

        appliedOption.add(option);

        return this;
    }

    @Nonnull
    public final PubSubCommand removeOption(@Nonnull Class<? extends PubOption> optionType) {
        appliedOption.removeIf(o -> o.getClass().equals(optionType));
        return this;
    }

    @Nonnull
    public String buildSubCommand() {
        StringBuilder builder = new StringBuilder();
        builder.append("pub ");
        builder.append(subCommandName);

        for (PubOption o : appliedOption) {
            builder.append(" ");
            builder.append(o.buildOption());
        }

        return builder.toString();
    }
}
