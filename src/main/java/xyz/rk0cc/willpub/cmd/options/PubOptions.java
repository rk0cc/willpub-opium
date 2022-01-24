package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.AllowDisabled;
import xyz.rk0cc.willpub.cmd.annotation.ValueRequired;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class PubOptions {
    private final String optionName;
    private String value;

    PubOptions(@Nonnull String optionName) {
        this.optionName = optionName;
        this.value = null;
    }

    private boolean isValueRequired() {
        return getClass().getAnnotation(ValueRequired.class) != null;
    }

    private boolean disableAllows() {
        return getClass().getAnnotation(AllowDisabled.class) != null;
    }

    private boolean validValue(@Nullable String value) {
        if (value == null) return true;
        else if (value.matches("(\\r?\\n)")) return false;
        return value.contains("\"") || !value.contains("\s");
    }

    @Nonnull
    public final PubOptions applyValue(@Nullable String value) {
        if (isValueRequired() && value != null)
            throw new IllegalArgumentException("Value required option can not apply null");
        else if (!validValue(value))
            throw new IllegalArgumentException("Applied value '" + value + "' is invalid");

        this.value = value;
        return this;
    }

    @Nonnull
    public final String assembleOption(boolean disable) {
        if (disable && !disableAllows())
            throw new IllegalArgumentException("This option can not be disabled");

        StringBuilder builder = new StringBuilder();
        builder.append("--");
        if (disable) builder.append("no-");
        builder.append(optionName);
        if (value != null) {
            builder.append("=");
            builder.append(value);
        }

        return builder.toString();
    }
}
