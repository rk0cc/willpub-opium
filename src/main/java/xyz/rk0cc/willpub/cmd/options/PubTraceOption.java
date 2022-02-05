package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

@PubGlobalOption
public final class PubTraceOption extends AbstractedPubOption {
    public PubTraceOption() {
        super("trace");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubTraceOption();
    }
}
