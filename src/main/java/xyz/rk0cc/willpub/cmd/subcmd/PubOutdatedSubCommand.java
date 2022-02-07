package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} that printing outdated dependencies in current package.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-outdated"><code>pub outdated</code> subcommand documentation</a>
 */
public final class PubOutdatedSubCommand extends AbstractedPubSubCommand {
    /**
     * Construct subcommand for displaying outdated dependencies.
     */
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
