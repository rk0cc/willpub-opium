package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubPathOption extends PubOptionWithValue {
    public PubPathOption(@Nonnull String optionValue) {
        super("path", optionValue);
    }
}
