package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubDepsSubCommand} that to configure how dependencies information
 * shown.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-deps#--stylestyle-or--s-style">
 *          <code>--style</code> option in <code>pub deps</code>.
 *      </a>
 */
public final class PubStyleOption extends PubOptionWithValue<PubStyleOption> {
    /**
     * Construct <code>--style</code> option.
     *
     * @param optionValue Indicate style of display dependencies.
     */
    public PubStyleOption(@Nonnull String optionValue) {
        super("style", optionValue);
    }

    /**
     * Construct <code>--style</code> option.
     *
     * @param optionValue Indicate style of display dependencies.
     */
    public PubStyleOption(@Nonnull StyleLayout optionValue) {
        this(optionValue.name().toLowerCase());
    }

    /**
     * Set style option value by {@link StyleLayout}.
     *
     * @param optionValue Enum of the style layout.
     *
     * @return Same object of {@link PubStyleOption} to chaining option.
     *
     * @see #setOptionValue(String)
     */
    @Nonnull
    public PubStyleOption setOptionValue(@Nonnull StyleLayout optionValue) {
        return setOptionValue(optionValue.name().toLowerCase());
    }

    /**
     * Get an option value in {@link StyleLayout}.
     *
     * @return Current applied value under {@link StyleLayout}.
     */
    @Nonnull
    public StyleLayout currentOptionValueEnum() {
        return StyleLayout.valueOf(currentOptionValue().toUpperCase());
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubStyleOption(currentOptionValue());
    }

    /**
     * An {@link Enum} for applying value in {@link PubStyleOption}.
     *
     * @since 1.0.0
     */
    public enum StyleLayout {
        /**
         * Print dependencies in tree view.
         */
        TREE,
        /**
         * Print dependencies as a list.
         */
        LIST,
        /**
         * Print dependencies as a compact list.
         */
        COMPACT
    }
}
