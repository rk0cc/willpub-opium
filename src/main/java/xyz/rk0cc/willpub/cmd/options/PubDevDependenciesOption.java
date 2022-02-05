package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * Apply option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubOutdatedSubCommand} that should development dependencies
 * included the result.
 *
 * @since 1.0.0
 *
 * @see PubDependencyOverridesOption
 */
public final class PubDevDependenciesOption extends PubDisableAllowedOption {
    /**
     * Construct option that include development dependencies or not.
     *
     * @param disableOption Ignore development dependencies if set as true.
     */
    public PubDevDependenciesOption(boolean disableOption) {
        super("dev-dependencies", disableOption);
    }

    /**
     * Construct option with default option of including development dependencies.
     */
    public PubDevDependenciesOption() {
        super("dev-dependencies");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubDevDependenciesOption(isParseDisabled());
    }
}
