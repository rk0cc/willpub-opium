package xyz.rk0cc.willpub.cmd.options;

public final class PubPrereleasesOption extends PubDisableAllowedOption {
    public PubPrereleasesOption(boolean disableOption) {
        super("prereleases", disableOption);
    }

    public PubPrereleasesOption() {
        super("prereleases");
    }
}
