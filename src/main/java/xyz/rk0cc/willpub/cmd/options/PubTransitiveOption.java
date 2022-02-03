package xyz.rk0cc.willpub.cmd.options;

public final class PubTransitiveOption extends PubDisableAllowedOption {
    public PubTransitiveOption(boolean disableOption) {
        super("transitive", disableOption);
    }

    public PubTransitiveOption() {
        super("transitive");
    }
}
