package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

@PubGlobalOption
public final class PubHelpOption extends AbstractedPubOption {
    public PubHelpOption() {
        super("help");
    }
}
