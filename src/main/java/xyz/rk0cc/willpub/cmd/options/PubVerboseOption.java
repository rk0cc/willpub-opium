package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

@PubGlobalOption
public final class PubVerboseOption extends AbstractedPubOption {
    public PubVerboseOption() {
        super("verbose");
    }
}
