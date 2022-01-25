package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubGetSubCommand extends PubSubCommand {
    public PubGetSubCommand(@Nonnull String subCommandName) {
        super(subCommandName, Set.of(
                PubOfflineOption.class,
                PubDryRunOption.class,
                PubPreCompileOption.class
        ));
    }
}
