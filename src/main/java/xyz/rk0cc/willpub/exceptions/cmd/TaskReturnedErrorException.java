package xyz.rk0cc.willpub.exceptions.cmd;

import xyz.rk0cc.willpub.cmd.PubCommand;
import xyz.rk0cc.willpub.cmd.PubCommandExitResult;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class TaskReturnedErrorException extends RuntimeException {
    private final PubCommand command;
    private final PubCommandExitResult<? extends Enum<?>> result;

    TaskReturnedErrorException(
            @Nonnull PubCommand command,
            @Nonnull PubCommandExitResult<? extends Enum<?>> result,
            @Nonnull String message,
            @Nullable Throwable throwable
    ) {
        super(message, throwable);
        assert result.exitCode() != 0; // 0 means OK.
        this.command = command;
        this.result = result;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\nExit code: " + result.exitCode() +
                "\nPub command: " + command.command() + "\n";
    }
}
