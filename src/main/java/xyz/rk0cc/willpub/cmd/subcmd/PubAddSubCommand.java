package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} for add name of the package into current project.
 * <h3>
 *     Supported {@linkplain PubOption option} (excluded
 *     {@linkplain xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption global options}):
 * </h3>
 * <ul>
 *     <li>{@link PubGitUrlOption}</li>
 *     <li>{@link PubGitPathOption}</li>
 *     <li>{@link PubGitRefOption}</li>
 *     <li>{@link PubHostedUrlOption}</li>
 *     <li>{@link PubSdkOption}</li>
 *     <li>{@link PubPathOption}</li>
 *     <li>{@link PubPrecompileOption}</li>
 *     <li>{@link PubDevOption}</li>
 *     <li>{@link PubOfflineOption}</li>
 *     <li>{@link PubDryRunOption}</li>
 * </ul>
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add"><code>pub add</code> subcommand documentation</a>
 */
public final class PubAddSubCommand extends PubSubCommandWithArgs {
    /**
     * Construct subcommand that add package into current project.
     *
     * @param packageName Target package name that pending to add.
     */
    public PubAddSubCommand(@Nonnull String packageName) {
        super("add", Set.of(
                PubGitUrlOption.class,
                PubGitPathOption.class,
                PubGitRefOption.class,
                PubHostedUrlOption.class,
                PubPathOption.class,
                PubSdkOption.class,
                PubPrecompileOption.class,
                PubDevOption.class,
                PubOfflineOption.class,
                PubDryRunOption.class
        ), packageName);
    }
}