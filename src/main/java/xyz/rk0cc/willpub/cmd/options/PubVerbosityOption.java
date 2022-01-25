package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

@PubGlobalOption
public final class PubVerbosityOption extends PubOptionWithValue {
    public PubVerbosityOption(@Nonnull String optionValue) {
        super("verbosity", optionValue);
    }

    public PubVerbosityOption() {
        super("verbosity", "all");
    }
}
