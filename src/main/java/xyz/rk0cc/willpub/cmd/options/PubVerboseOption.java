package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

@PubGlobalOption
public final class PubVerboseOption extends AbstractedPubOption {
    public PubVerboseOption() {
        super("verbose");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubVerboseOption();
    }
}
