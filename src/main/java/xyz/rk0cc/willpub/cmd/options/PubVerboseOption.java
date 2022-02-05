package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

/**
 * An alias {@link PubGlobalOption global option} of {@link PubVerbosityOption} that display
 * {@link PubVerbosityOption.VerbosityLevel#ALL all} outputs when running
 * {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand subcommands}.
 *
 * @since 1.0.0
 *
 * @see PubVerbosityOption
 * @see <a href="https://dart.dev/tools/pub/cmd#--verbose-or--v">
 *          <code>--verbose</code> in pub global option.
 *      </a>
 */
@PubGlobalOption
public final class PubVerboseOption extends AbstractedPubOption {
    /**
     * Construct <code>--verbose</code> option.
     */
    public PubVerboseOption() {
        super("verbose");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubVerboseOption();
    }
}
