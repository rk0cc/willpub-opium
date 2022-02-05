package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubPublishSubCommand} which skip confirmation and ignore all
 * warnings in package when upload to repository.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-lish#--force-or--f">
 *          <code>--force</code> tag in <code>pub publish</code>.
 *      </a>
 */
public final class PubForceOption extends AbstractedPubOption {
    /**
     * Construct <code>--force</code> option.
     */
    public PubForceOption() {
        super("force");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubForceOption();
    }
}
