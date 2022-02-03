package xyz.rk0cc.willpub.cmd.options;

public final class PubDevDependenciesOption extends PubDisableAllowedOption {
    public PubDevDependenciesOption(boolean disableOption) {
        super("dev-dependencies", disableOption);
    }

    public PubDevDependenciesOption() {
        super("dev-dependencies");
    }
}
