package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

public final class PubPublishSubCommand extends AbstractedPubSubCommand {
    public PubPublishSubCommand() {
        super("publish", Set.of(
                PubDryRunOption.class,
                PubForceOption.class
        ));
    }
}
