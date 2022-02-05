package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * Export result in <a href="https://www.json.org/json-en.html">JSON</a> format.
 * <br/>
 * It usually supported for reporting subcommands as this list:
 * <ul>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubDepsSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubOutdatedSubCommand}</li>
 * </ul>
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

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubJsonOption();
    }
}
