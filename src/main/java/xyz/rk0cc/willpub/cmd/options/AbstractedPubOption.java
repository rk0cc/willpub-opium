package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * A factory for building {@link PubOption} with implemented {@link #buildOption()} already.
 *
 * @since 1.0.0
 */
public non-sealed abstract class AbstractedPubOption extends PubOption {
    protected AbstractedPubOption(@Nonnull String optionName) {
        super(optionName);
    }

    @Nonnull
    @Override
    public final String buildOption() {
        return "--" + optionName();
    }
}
