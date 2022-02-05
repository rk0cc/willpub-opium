package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubUpToDateOption extends PubDisableAllowedOption {
    public PubUpToDateOption(boolean disableOption) {
        super("up-to-date", disableOption);
    }

    public PubUpToDateOption() {
        super("up-to-date");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubUpToDateOption(isParseDisabled());
    }
}
