package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubVersionOption extends PubOptionWithValue<PubVersionOption> {
    public PubVersionOption(@Nonnull String optionValue) {
        super("version", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubVersionOption(currentOptionValue());
    }
}
