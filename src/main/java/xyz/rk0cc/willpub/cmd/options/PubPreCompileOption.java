package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubPreCompileOption extends PubDisableAllowedOption {
    public PubPreCompileOption(boolean disableOption) {
        super("precompile", disableOption);
    }

    public PubPreCompileOption(@Nonnull String optionName) {
        super("precompile");
    }
}
