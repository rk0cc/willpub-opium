package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.PubOption;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * An abstracted {@link PubSubCommand} that does not require any arguments to applied.
 *
 * @since 1.0.0
 */
public non-sealed abstract class AbstractedPubSubCommand extends PubSubCommand {
    /**
     * Construct subcommand with given name and {@link Set} of {@link PubOption} {@link Class} which supported for this
     * subcommand (it supported already when {@link PubOption} annotated with
     * {@link xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption}).
     *
     * @param subCommandName Subcommand name.
     * @param acceptedOption A {@link Set} of {@link PubOption} {@link Class} that this subcommand can be accepted.
     */
    protected AbstractedPubSubCommand(
            @Nonnull String subCommandName,
            @Nonnull Set<Class<? extends PubOption>> acceptedOption
    ) {
        super(subCommandName, acceptedOption);
    }

    @Nonnull
    @Override
    public final String buildSubCommand() {
        return subCommandProgram() + " " + subCommandOptionFlags();
    }
}
