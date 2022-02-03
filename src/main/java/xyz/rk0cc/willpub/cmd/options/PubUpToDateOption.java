package xyz.rk0cc.willpub.cmd.options;

public final class PubUpToDateOption extends PubDisableAllowedOption {
    public PubUpToDateOption(boolean disableOption) {
        super("up-to-date", disableOption);
    }

    public PubUpToDateOption() {
        super("up-to-date");
    }
}
