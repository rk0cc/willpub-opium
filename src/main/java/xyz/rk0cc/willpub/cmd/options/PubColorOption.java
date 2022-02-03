package xyz.rk0cc.willpub.cmd.options;

public final class PubColorOption extends PubDisableAllowedOption {
    public PubColorOption(boolean disableOption) {
        super("color", disableOption);
    }

    public PubColorOption() {
        super("color");
    }
}
