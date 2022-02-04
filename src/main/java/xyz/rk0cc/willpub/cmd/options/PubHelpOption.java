package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

/**
 * An {@link PubGlobalOption global option} that just printing usage for subcommands only.
 *
 * @since 1.0.0
 *
 * @apiNote This option do absolutely nothing in OPIUM since it mainly run in background which the context of console
 *          will be hidden during execution.
 */
@PubGlobalOption
public final class PubHelpOption extends AbstractedPubOption {
    /**
     * Construct <code>--help</code> option.
     */
    public PubHelpOption() {
        super("help");
    }
}
