package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} that upgrade all outdated packages to the latest one.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-upgrade"><code>pub upgrade</code> subcommand documentation</a>
 */
public final class PubUpgradeSubCommand extends PubSubCommandWithArgs {
    /**
     * Construct subcommand that indicating which name of the packages will be upgraded.
     *
     * @param packagesName Name of the packages that are going to download the latest version if released already from
     *                     repository.
     */
    public PubUpgradeSubCommand(@Nonnull String... packagesName) {
        super(true, "upgrade", Set.of(
                PubOfflineOption.class,
                PubDryRunOption.class,
                PubPrecompileOption.class,
                PubNullSafetyOption.class,
                PubMajorVersionsOption.class
        ), packagesName);
    }
}
