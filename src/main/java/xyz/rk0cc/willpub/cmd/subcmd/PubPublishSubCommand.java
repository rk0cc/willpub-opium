package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} that publish package to repository.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-lish"><code>pub publish</code> subcommand documentation</a>
 */
public final class PubPublishSubCommand extends AbstractedPubSubCommand {
    /**
     * Construct publish documentation.
     */
    public PubPublishSubCommand() {
        super("publish", Set.of(
                PubDryRunOption.class,
                PubForceOption.class
        ));
    }
}
