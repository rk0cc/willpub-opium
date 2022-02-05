package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubTransitiveOption extends PubDisableAllowedOption {
    public PubTransitiveOption(boolean disableOption) {
        super("transitive", disableOption);
    }

    public PubTransitiveOption() {
        super("transitive");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubTransitiveOption(isParseDisabled());
    }
}
