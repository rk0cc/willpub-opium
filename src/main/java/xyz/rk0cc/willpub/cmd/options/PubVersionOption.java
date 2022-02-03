package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubVersionOption extends PubOptionWithValue {
    public PubVersionOption(@Nonnull String optionValue) {
        super("version", optionValue);
    }
}
