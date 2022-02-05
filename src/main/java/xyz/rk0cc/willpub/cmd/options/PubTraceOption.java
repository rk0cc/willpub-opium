package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

/**
 * An {@link PubGlobalOption global option} that to print stack trace when error occurs.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd#--trace">
 *          <code>--trace</code> in pub global options.
 *      </a>
 */
@PubGlobalOption
public final class PubTraceOption extends AbstractedPubOption {
    /**
     * Construct <code>--trace</code> option.
     */
    public PubTraceOption() {
        super("trace");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubTraceOption();
    }
}
