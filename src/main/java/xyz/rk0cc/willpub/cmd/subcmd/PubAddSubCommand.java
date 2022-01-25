package xyz.rk0cc.willpub.cmd.subcmd;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubAddSubCommand extends PubSubCommandWithArgs {
    public PubAddSubCommand(@Nonnull String args) {
        super("add", Set.of(), args);
    }
}