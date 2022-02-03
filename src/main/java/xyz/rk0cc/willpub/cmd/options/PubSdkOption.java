package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubSdkOption extends PubOptionWithValue {
    public PubSdkOption(@Nonnull String optionName, @Nonnull String optionValue) {
        super("sdk", optionValue);
    }
}
