package xyz.rk0cc.willpub.cmd.options;

public final class PubDependencyOverridesOption extends PubDisableAllowedOption {
    public PubDependencyOverridesOption(boolean disableOption) {
        super("dependency-overrides", disableOption);
    }

    public PubDependencyOverridesOption() {
        super("dependency-overrides");
    }
}
