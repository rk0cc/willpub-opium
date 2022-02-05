package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option applied for which related with dependencies modification
 * {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand subcommands} that skip fetching package from repository online.
 * <br/>
 * If the subcommands parsed with offline enabled option, they will try to find any latest dependencies existed in local
 * machines as much as possible, and recorded into lock file. However, it has higher chance that the packages are
 * outdated already which it's recommended to run {@link xyz.rk0cc.willpub.cmd.subcmd.PubUpgradeSubCommand upgrade}
 * again if able to online (disable this option).
 * <br/>
 * <h3>Supported subcommands:</h3>
 * <ul>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubDowngradeSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubGetSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubRemoveSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubUpgradeSubCommand}</li>
 * </ul>
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-get#getting-while-offline">
 *          Getting while offline in <code>pub get</code> documentation.
 *      </a>
 */
public final class PubOfflineOption extends PubDisableAllowedOption<PubOfflineOption> {
    /**
     * Construct <code>--offline</code> option.
     *
     * @param disableOption Disable offline option or not.
     */
    public PubOfflineOption(boolean disableOption) {
        super("offline", disableOption);
    }

    /**
     * Construct <code>--offline</code> with
     * {@link PubDisableAllowedOption#DISABLE_AS_DEFAULT_OPTION current default option}.
     */
    public PubOfflineOption() {
        super("offline");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubOfflineOption(isParseDisabled());
    }
}
