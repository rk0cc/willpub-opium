package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option can be parsed as disable with giving '<code>no-</code>' prefix before the option name.
 *
 * @since 1.0.0
 */
public non-sealed abstract class PubDisableAllowedOption extends PubOption {
    /**
     * Decide the default option is disabled when construct {@link PubDisableAllowedOption}. Default value is
     * <code>false</code>.
     */
    public static boolean DISABLE_AS_DEFAULT_OPTION = false;

    private boolean disableOption;

    PubDisableAllowedOption(@Nonnull String optionName, boolean disableOption) {
        super(optionName);
        this.disableOption = disableOption;
    }

    PubDisableAllowedOption(@Nonnull String optionName) {
        this(optionName, DISABLE_AS_DEFAULT_OPTION);
    }

    /**
     * Parse current option as disable.
     *
     * @return Same {@link PubDisableAllowedOption option} allows to chain methods.
     */
    @Nonnull
    public final PubDisableAllowedOption disableThisOption() {
        this.disableOption = true;
        return this;
    }

    /**
     * Parse current option as enable.
     *
     * @return Same {@link PubDisableAllowedOption option} allows to chain methods.
     */
    @Nonnull
    public final PubDisableAllowedOption enableThisOption() {
        this.disableOption = false;
        return this;
    }

    /**
     * Check this option parse as disabled.
     *
     * @return <code>true</code> if disabled.
     */
    public final boolean isParseDisabled() {
        return disableOption;
    }

    @Nonnull
    @Override
    public final String buildOption() {
        StringBuilder builder = new StringBuilder();
        builder.append("--");

        if (disableOption)
            builder.append("no-");

        builder.append(optionName());

        return builder.toString();
    }
}
