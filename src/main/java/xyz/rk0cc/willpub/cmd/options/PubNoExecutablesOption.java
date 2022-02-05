package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for <code>pub global</code> that activating package without putting executable into <code>bin</code>.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-global#--no-executables">
 *          <code>--no-executables</code> in <code>pub global</code> documentation.
 *      </a>
 */
public final class PubNoExecutablesOption extends AbstractedPubOption {
    /**
     * Construct <code>--no-executables</code> option.
     */
    public PubNoExecutablesOption() {
        super("no-executables");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubNoExecutablesOption();
    }
}
