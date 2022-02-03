package xyz.rk0cc.willpub.cmd.options;

/**
 * Colourizing output for highlighting result of subcommands.
 *
 * @since 1.0.0
 */
public final class PubColorOption extends PubDisableAllowedOption {
    /**
     * Construct option with initial option of colourizing subcommand result.
     *
     * @param disableOption Should disable colourizing when constructed.
     */
    public PubColorOption(boolean disableOption) {
        super("color", disableOption);
    }

    /**
     * Construct option with default option of colourizing.
     */
    public PubColorOption() {
        super("color");
    }
}
