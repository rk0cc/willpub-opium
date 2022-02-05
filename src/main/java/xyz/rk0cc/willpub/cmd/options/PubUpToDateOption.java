package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubOutdatedSubCommand} that including up-to-date packages in
 * output.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-outdated#--no-up-to-date">
 *          <code>--up-to-date</code> option in <code>pub outdated</code> subcommand.
 *      </a>
 */
public final class PubUpToDateOption extends PubDisableAllowedOption<PubUpToDateOption> {
    /**
     * Construct <code>--up-to-date</code> option.
     *
     * @param disableOption Disable this option or not.
     */
    public PubUpToDateOption(boolean disableOption) {
        super("up-to-date", disableOption);
    }

    /**
     * Construct <code>--up-to-date</code> option with
     * {@link PubDisableAllowedOption#DISABLE_AS_DEFAULT_OPTION default option}.
     */
    public PubUpToDateOption() {
        super("up-to-date");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubUpToDateOption(isParseDisabled());
    }
}
