package xyz.rk0cc.willpub.cmd;

import javax.annotation.Nonnull;

public interface PubCommand {
    @Nonnull
    String subCommand();

    @Nonnull
    String arguments();

    @Nonnull
    default String command() {
        return "pub " + subCommand() + " " + arguments();
    }
}
