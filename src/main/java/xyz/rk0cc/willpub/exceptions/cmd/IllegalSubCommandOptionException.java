package xyz.rk0cc.willpub.exceptions.cmd;

import xyz.rk0cc.willpub.cmd.options.PubOption;
import xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand;

import javax.annotation.Nonnull;

public final class IllegalSubCommandOptionException extends IllegalArgumentException {
    public final Class<? extends PubSubCommand> subCommand;
    public final Class<? extends PubOption> option;

    public IllegalSubCommandOptionException(
            @Nonnull Class<? extends PubSubCommand> subCommand,
            @Nonnull Class<? extends PubOption> option,
            String message
    ) {
        super(message);
        this.subCommand = subCommand;
        this.option = option;
    }

    public IllegalSubCommandOptionException(
            @Nonnull Class<? extends PubSubCommand> subCommand,
            @Nonnull Class<? extends PubOption> option
    ) {
        this(subCommand, option, "Subcommand does not support applied option");
    }

    @Nonnull
    @Override
    public String toString() {
        return super.toString() +
                "\n\nSubcommand: " + subCommand.getName() +
                "\nOption: " + option.getName() +
                "\n\n";
    }
}
