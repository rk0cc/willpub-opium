package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option that precompile executable in immediate dependencies or not.
 * <h3>Supported dependencies:</h3>
 * <ul>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubGetSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubRemoveSubCommand}</li>
 *     <li>{@link xyz.rk0cc.willpub.cmd.subcmd.PubUpgradeSubCommand}</li>
 * </ul>
 *
 * @since 1.0.0
 */
public final class PubPrecompileOption extends PubDisableAllowedOption<PubPrecompileOption> {
    /**
     * Construct <code>--precompile</code> option with parse as disabled or not.
     *
     * @param disableOption Parse as disable precompile option.
     */
    public PubPrecompileOption(boolean disableOption) {
        super("precompile", disableOption);
    }

    /**
     * Construct <code>--precompile</code> option with
     * {@link PubDisableAllowedOption#DISABLE_AS_DEFAULT_OPTION default option}
     */
    public PubPrecompileOption() {
        super("precompile");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPrecompileOption(isParseDisabled());
    }
}
