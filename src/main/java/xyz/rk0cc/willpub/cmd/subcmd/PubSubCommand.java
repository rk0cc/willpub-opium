package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.annotation.ValueRequired;
import xyz.rk0cc.willpub.cmd.options.PubOptions;

import javax.annotation.Nonnull;
import java.util.*;

public abstract class PubSubCommand {
    private final String subCmd;
    /**
     * Which {@link PubOptions} can be applied in this subcommand, please do not mark as public scope.
     */
    private final Set<Class<? extends PubOptions>> acceptedOption;
    private final LinkedHashSet<? extends PubOptions> appliedOption = new LinkedHashSet<>();
    private final LinkedList<String> arguments = new LinkedList<>();

    PubSubCommand(@Nonnull String subCmd, @Nonnull Set<Class<? extends PubOptions>> acceptedOption) {
        this.subCmd = subCmd;
        this.acceptedOption = Collections.unmodifiableSet(acceptedOption);
    }

    private boolean isArgsRequired() {
        return getClass().getAnnotation(ValueRequired.class) != null;
    }

    private boolean isFollowArgumentPolicy() {
        return isArgsRequired() ? arguments.size() >= 1 : arguments.isEmpty();
    }

    @Nonnull
    public final PubSubCommand appendArgument(@Nonnull String arg) {
        if (!isArgsRequired())
            throw new IllegalArgumentException("This sub command does not support argument");
        else if (arg.matches("\\s|(\\r?\\n)"))
            throw new IllegalArgumentException("Each argument must be single line without whitespace");

        arguments.addLast(arg);
        return this;
    }
}
