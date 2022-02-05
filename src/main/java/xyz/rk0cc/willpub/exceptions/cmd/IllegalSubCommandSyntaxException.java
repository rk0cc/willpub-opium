package xyz.rk0cc.willpub.exceptions.cmd;

import xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand;

import javax.annotation.Nonnull;

public class IllegalSubCommandSyntaxException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "The subcommand has invalid syntax.";

    public final Class<? extends PubSubCommand> subCommand;

    public IllegalSubCommandSyntaxException(
            @Nonnull Class<? extends PubSubCommand> subCommand,
            String message,
            Throwable throwable
    ) {
        super(message, throwable);
        this.subCommand = subCommand;
    }

    public IllegalSubCommandSyntaxException(@Nonnull Class<? extends PubSubCommand> subCommand, String message) {
        this(subCommand, message, null);
    }

    public IllegalSubCommandSyntaxException(@Nonnull Class<? extends PubSubCommand> subCommand, Throwable throwable) {
        this(subCommand, DEFAULT_MESSAGE, throwable);
    }

    public IllegalSubCommandSyntaxException(@Nonnull Class<? extends PubSubCommand> subCommand) {
        this(subCommand, DEFAULT_MESSAGE);
    }

    @Nonnull
    public String getSubCommandInfoMessage() {
        return "Subcommand: " + subCommand.getName();
    }

    @Override
    public final String toString() {
        return super.toString() +
                "\n\n" +
                getSubCommandInfoMessage() +
                "\n\n";
    }
}
