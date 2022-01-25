package xyz.rk0cc.willpub.cmd.options;

/**
 * Option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand} to indicate the dependency will be added as dev
 * dependency instead of regular dependency.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add#-d---dev">'--dev' option in 'pub add'</a>
 */
public final class PubDevOption extends AbstractedPubOption {
    /**
     * Construct <code>--dev</code> option to associated subcommand.
     */
    public PubDevOption() {
        super("dev");
    }
}
