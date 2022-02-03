package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

public final class PubDepsSubCommand extends AbstractedPubSubCommand {
    public PubDepsSubCommand() {
        super("deps", Set.of(
                PubStyleOption.class,
                PubDevOption.class,
                PubExecutablesOption.class,
                PubJsonOption.class
        ));
    }
}
