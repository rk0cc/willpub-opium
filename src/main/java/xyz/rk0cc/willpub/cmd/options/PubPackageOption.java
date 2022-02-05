package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubPackageOption extends PubOptionWithValue<PubPackageOption> {
    public PubPackageOption(@Nonnull String optionValue) {
        super("uploader", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPackageOption(currentOptionValue());
    }
}
