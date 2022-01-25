package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

public final class PubGetSubCommand extends AbstractedPubSubCommand {
    public PubGetSubCommand() {
        super("get", Set.of(
                PubOfflineOption.class,
                PubDryRunOption.class,
                PubPreCompileOption.class
        ));
    }
}
