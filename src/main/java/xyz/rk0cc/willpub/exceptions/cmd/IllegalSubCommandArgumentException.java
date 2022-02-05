package xyz.rk0cc.willpub.exceptions.cmd;

import xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand;

import javax.annotation.Nonnull;
import java.util.Arrays;

public final class IllegalSubCommandArgumentException extends IllegalSubCommandSyntaxException {
    private final String[] args;

    public IllegalSubCommandArgumentException(
            @Nonnull Class<? extends PubSubCommand> subCommand,
            @Nonnull String[] args,
            String message
    ) {
        super(subCommand, message);
        this.args = args;
    }

    public IllegalSubCommandArgumentException(
            @Nonnull Class<? extends PubSubCommand> subCommand,
            @Nonnull String[] args
    ) {
        this(subCommand, args, "Detected one of the arguments has illegal syntax");
    }

    @Nonnull
    @Override
    public String getSubCommandInfoMessage() {
        return super.getSubCommandInfoMessage() +
                "\nArguments: " + Arrays.toString(args);
    }
}
