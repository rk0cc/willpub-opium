package xyz.rk0cc.willpub.cmd.options;

/**
 * Export result in <a href="https://www.json.org/json-en.html">JSON</a> format if any
 * {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand subcommands} support this option.
 *
 * @since 1.0.0
 */
public final class PubJsonOption extends AbstractedPubOption {
    /**
     * Construct <code>--json</code> option.
     */
    public PubJsonOption() {
        super("json");
    }
}
