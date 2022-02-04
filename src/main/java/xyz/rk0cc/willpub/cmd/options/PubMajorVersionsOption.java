package xyz.rk0cc.willpub.cmd.options;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubUpgradeSubCommand} that to ignore upper-bound in version
 * constraint.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-upgrade#--major-versions">
 *          <code>--major-versions</code> tags in <code>pub upgrade</code> subcommands.
 *      </a>
 */
public final class PubMajorVersionsOption extends AbstractedPubOption {
    public PubMajorVersionsOption() {
        super("major-versions");
    }
}
