package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubUpgradeSubCommand} that which marked resolvable in
 * {@link xyz.rk0cc.willpub.cmd.subcmd.PubOutdatedSubCommand} and ignore upper-bound in <code>pubspec.yaml</code>.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-upgrade#--major-versions">
 *          <code>--major-versions</code> tags in <code>pub upgrade</code> subcommands.
 *      </a>
 * @see PubNullSafetyOption
 */
public final class PubMajorVersionsOption extends AbstractedPubOption {
    /**
     * Construct <code>--major-versions</code> option.
     */
    public PubMajorVersionsOption() {
        super("major-versions");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubMajorVersionsOption();
    }
}
