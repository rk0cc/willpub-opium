package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

@PubGlobalOption
public final class PubTraceOption extends AbstractedPubOption {
    public PubTraceOption() {
        super("trace");
    }
}
