package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} that getting all dependencies' information in <code>pubspec.yaml</code>.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-get"><code>pub get</code> subcommand documentation</a>
 */
public final class PubGetSubCommand extends AbstractedPubSubCommand {
    /**
     * Construct subcommand of getting dependencies.
     */
    public PubGetSubCommand() {
        super("get", Set.of(
                PubOfflineOption.class,
                PubDryRunOption.class,
                PubPrecompileOption.class
        ));
    }
}
