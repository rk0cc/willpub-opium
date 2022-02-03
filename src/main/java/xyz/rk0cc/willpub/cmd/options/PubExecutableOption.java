package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubExecutableOption extends PubOptionWithValue {
    public PubExecutableOption(@Nonnull String optionValue) {
        super("executable", optionValue);
    }
}
