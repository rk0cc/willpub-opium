package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

/**
 * A {@link PubSubCommand subcommands} that print dependency graph for a package.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-deps"><code>pub dev</code> subcommand documentation.</a>
 */
public final class PubDepsSubCommand extends AbstractedPubSubCommand {
    /**
     * Construct subcommand for displaying dependencies.
     */
    public PubDepsSubCommand() {
        super("deps", Set.of(
                PubStyleOption.class,
                PubDevOption.class,
                PubExecutablesOption.class,
                PubJsonOption.class
        ));
    }
}
