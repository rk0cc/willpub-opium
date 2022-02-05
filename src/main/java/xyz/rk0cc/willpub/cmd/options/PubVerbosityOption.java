package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

/**
 * An {@link PubGlobalOption global option} that to determine {@link VerbosityLevel level} of the information will be
 * displayed.
 *
 * @since 1.0.0
 *
 * @see PubVerboseOption
 * @see <a href="https://dart.dev/tools/pub/cmd#--verbositylevel">
 *          <code>--verbosity</code> in pub global option.
 *      </a>
 */
@PubGlobalOption
public final class PubVerbosityOption extends PubOptionWithValue<PubVerbosityOption> {
    /**
     * Construct <code>--verbosity</code> option.
     *
     * @param optionValue Level of the information will be displayed.
     */
    public PubVerbosityOption(@Nonnull String optionValue) {
        super("verbosity", optionValue);
    }

    /**
     * Construct <code>--verbosity</code> option.
     *
     * @param optionValue Level of the information will be displayed.
     */
    public PubVerbosityOption(@Nonnull VerbosityLevel optionValue) {
        super("verbosity", optionValue.name().toLowerCase());
    }

    /**
     * Set option value with {@link VerbosityLevel}.
     *
     * @param optionValue An enum value of {@link VerbosityLevel}.
     *
     * @return Same object that allowing chaining methods.
     *
     * @see #setOptionValue(String)
     */
    @Nonnull
    public PubVerbosityOption setOptionValue(@Nonnull VerbosityLevel optionValue) {
        return setOptionValue(optionValue.name().toLowerCase());
    }

    /**
     * Get a current option value under {@link VerbosityLevel}.
     *
     * @return {@link VerbosityLevel} value.
     *
     * @see #currentOptionValue()
     */
    @Nonnull
    public VerbosityLevel currentOptionValueInEnum() {
        return VerbosityLevel.valueOf(currentOptionValue().toUpperCase());
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubVerbosityOption(currentOptionValue());
    }

    /**
     * An {@link Enum} for {@link PubVerbosityOption} that to determine what information will be displayed or not.
     *
     * @since 1.0.0
     */
    public enum VerbosityLevel {
        /**
         * Display all output, including internal tracing message.
         */
        ALL,
        /**
         * Show I/O operate.
         */
        IO,
        /**
         * Show error, warning and user message.
         */
        NORMAL,
        /**
         * Shows steps during version resolution.
         */
        SOLVER
    }
}
