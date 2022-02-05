package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * A {@link PubOption} parsed with given value.
 * <br/>
 * The value must be a {@link String} without new line control charter (<code>\n</code> or <code>\r</code>). If the
 * value contains whitespace charter, entire {@link String} must be quoted when parsing option value.
 *
 * @param <V> Inherited class of {@link PubOptionWithValue}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public non-sealed abstract class PubOptionWithValue<V extends PubOptionWithValue<V>> extends PubOption {
    private String optionValue;

    /**
     * Construct new {@link PubOption option} with given value.
     *
     * @param optionName Option name.
     * @param optionValue Option value.
     */
    protected PubOptionWithValue(@Nonnull String optionName, @Nonnull String optionValue) {
        super(optionName);
        optionValueSetter(optionValue);
    }

    private void optionValueSetter(@Nonnull String optionValue) {
        if (!optionValue.isBlank()) {
            char fc = optionValue.charAt(0), lc = optionValue.charAt(optionValue.length() - 1);
            boolean quoted = fc == '"' || fc == '\'';

            if (optionValue.contains("\r") || optionValue.contains("\n")) // Parsing with new line cause command executed.
                throw new IllegalArgumentException("Detected end of line charter");
            else if (optionValue.contains("\s") && !quoted) // Parse whitespace without quoted
                throw new IllegalArgumentException("Whitespace value required wrapped entire string in quote");

            if (quoted) {
                if (fc != lc) // If started and ended quoted charter is difference
                    throw new IllegalArgumentException("Value's close quote is not matched charter from start quote");
                else if (optionValue.substring(1, optionValue.length() - 1).contains(String.valueOf(fc)))
                    // If same quote symbol found in context
                    throw new IllegalArgumentException("The option value contains same quote for capturing string.");
            }
        }

        this.optionValue = optionValue;
    }

    /**
     * Apply new option value in current {@link PubOptionWithValue}.
     *
     * @param optionValue New option value.
     *
     * @return Current {@link PubOptionWithValue} that allowing chaining method.
     */
    @Nonnull
    public final V setOptionValue(@Nonnull String optionValue) {
        optionValueSetter(optionValue);
        return (V) this;
    }

    /**
     * Get current option value applied in this {@link PubOptionWithValue}.
     *
     * @return A {@link String} of option's value.
     */
    @Nonnull
    public final String currentOptionValue() {
        return optionValue;
    }

    @Nonnull
    @Override
    public final String buildOption() {
        return "--" + optionName() + "=" + optionValue;
    }
}
