package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

public final class PubOutdatedSubCommand extends AbstractedPubSubCommand {
    public PubOutdatedSubCommand() {
        super("outdated", Set.of(
                PubJsonOption.class,
                PubPrereleasesOption.class,
                PubTransitiveOption.class,
                PubUpToDateOption.class,
                PubColorOption.class,
                PubDependencyOverridesOption.class,
                PubDevDependenciesOption.class
        ));
    }
}
