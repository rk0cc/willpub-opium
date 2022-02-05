package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubOutdatedSubCommand} that does prerelease package determine as
 * last package version.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-outdated#--no-prereleases">
 *          <code>--prerelease</code> option in <code>pub outdated</code>.
 *      </a>
 */
public final class PubPrereleasesOption extends PubDisableAllowedOption<PubPrereleasesOption> {
    /**
     * Construct <code>--prerelease</code> option with disable or not.
     *
     * @param disableOption Parse it as disable option or not.
     */
    public PubPrereleasesOption(boolean disableOption) {
        super("prereleases", disableOption);
    }

    /**
     * Construct <code>--prerelease</code> with {@link PubDisableAllowedOption#DISABLE_AS_DEFAULT_OPTION default option}.
     */
    public PubPrereleasesOption() {
        super("prereleases");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPrereleasesOption(isParseDisabled());
    }
}
