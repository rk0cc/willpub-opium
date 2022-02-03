package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public non-sealed abstract class PubOptionWithValue extends PubOption {
    private String optionValue;

    PubOptionWithValue(@Nonnull String optionName, @Nonnull String optionValue) {
        super(optionName);
        optionValueSetter(optionValue);
    }

    private void optionValueSetter(@Nonnull String optionValue) {
        if (!optionValue.isBlank()) {
            char fc = optionValue.charAt(0), lc = optionValue.charAt(optionValue.length() - 1);
            boolean quoted = fc == '"' || fc == '\'';

            if (optionValue.contains("\r") || optionValue.contains("\n"))
                throw new IllegalArgumentException("Detected end of line charter");
            else if (optionValue.contains("\s") && !quoted)
                throw new IllegalArgumentException("Whitespace value required wrapped entire string in quote");

            if (quoted) {
                if (fc != lc)
                    throw new IllegalArgumentException("Value's close quote is not matched charter from start quote");
                else if (optionValue.substring(1, optionValue.length() - 1).contains(String.valueOf(fc)))
                    throw new IllegalArgumentException("The option value contains same quote for capturing string.");
            }
        }

        this.optionValue = optionValue;
    }

    @Nonnull
    public final PubOptionWithValue setOptionValue(@Nonnull String optionValue) {
        optionValueSetter(optionValue);
        return this;
    }

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
