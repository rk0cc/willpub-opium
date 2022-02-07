package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * A {@link PubSubCommand subcommands} that downgrade named packages to lower version.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-downgrade"><code>pub downgrade</code> subcommand documentation</a>.
 */
public final class PubDowngradeSubCommand extends PubSubCommandWithArgs {
    private static final Set<Class<? extends PubOption>> DOWNGRADE_OPTION = Set.of(
            PubOfflineOption.class,
            PubDryRunOption.class
    );

    /**
     * Construct subcommand for downgrading package.
     *
     * @param packagesName Name of the packages that will be installed earlier version one.
     */
    public PubDowngradeSubCommand(@Nonnull String... packagesName) {
        super(true, "downgrade", DOWNGRADE_OPTION, packagesName);
    }
}
