package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubPrecompileOption extends PubDisableAllowedOption<PubPrecompileOption> {
    public PubPrecompileOption(boolean disableOption) {
        super("precompile", disableOption);
    }

    public PubPrecompileOption(@Nonnull String optionName) {
        super("precompile");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPrecompileOption(isParseDisabled());
    }
}
