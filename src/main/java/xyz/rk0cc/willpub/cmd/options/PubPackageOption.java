package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubPackageOption extends PubOptionWithValue {
    public PubPackageOption(@Nonnull String optionValue) {
        super("uploader", optionValue);
    }
}
