package xyz.rk0cc.willpub.cmd.options;

/**
 * Perform dry run that make the {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand subcommands} does not affect any
 * changes in the project.
 *
 * @since 1.0.0
 */
public final class PubDryRunOption extends AbstractedPubOption {
    /**
     * Construct an option to dry run the option.
     */
    public PubDryRunOption() {
        super("dry-run");
    }
}
