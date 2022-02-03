package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubHostedUrlOption extends PubOptionWithValue {
    public PubHostedUrlOption(@Nonnull String optionValue) {
        super("hosted-url", optionValue);
    }
}
