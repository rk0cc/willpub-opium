package xyz.rk0cc.willpub.cmd.options;

public final class PubOfflineOption extends PubDisableAllowedOption {
    public PubOfflineOption(boolean disableOption) {
        super("offline", disableOption);
    }

    public PubOfflineOption() {
        super("offline");
    }
}
