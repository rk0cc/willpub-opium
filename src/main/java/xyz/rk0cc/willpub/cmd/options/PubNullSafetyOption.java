package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubUpgradeSubCommand} which do similar thing in
 * {@link PubMajorVersionsOption} but required <a href="https://dart.dev/null-safety">null safety</a> which marked
 * <code>?</code> as suffix of the type to indicate this variable accepts <code>null</code> value.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-upgrade#--null-safety">
 *          <code>--null-safety</code> in <code>pub upgrade</code> documentation.
 *      </a>
 * @see PubMajorVersionsOption
 * @see <a href="https://dart.dev/null-safety#null-safety-principles">Null safety principles</a>
 */
public final class PubNullSafetyOption extends AbstractedPubOption {
    /**
     * Construct <code>--null-safety</code> option.
     */
    public PubNullSafetyOption() {
        super("null-safety");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubNullSafetyOption();
    }
}
