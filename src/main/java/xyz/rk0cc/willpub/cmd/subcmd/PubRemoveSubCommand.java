package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} that the name of the package will be removed.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-remove"><code>pub remove</code> subcommand documentation</a>
 */
public final class PubRemoveSubCommand extends PubSubCommandWithArgs {
    public PubRemoveSubCommand(@Nonnull String packageName) {
        super("remove", Set.of(
                PubOfflineOption.class,
                PubDryRunOption.class,
                PubPrecompileOption.class
        ), packageName);
    }
}
