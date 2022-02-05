package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubPathOption extends PubOptionWithValue<PubPathOption> {
    public PubPathOption(@Nonnull String optionValue) {
        super("path", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPathOption(currentOptionValue());
    }
}
