package xyz.rk0cc.willpub.cmd.options;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubDepsSubCommand} that to print all available executables into
 * console.
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-deps#--executables">
 *          <code>--executables</code> in <code>pub deps</code>.
 *      </a>
 */
public final class PubExecutablesOption extends AbstractedPubOption {
    /**
     * Construct <code>--executables</code> option.
     */
    public PubExecutablesOption() {
        super("executables");
    }
}
