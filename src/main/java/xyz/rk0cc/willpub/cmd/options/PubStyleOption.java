package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubStyleOption extends PubOptionWithValue<PubStyleOption> {
    public PubStyleOption(@Nonnull String optionValue) {
        super("style", optionValue);
    }

    public PubStyleOption(@Nonnull StyleLayout optionValue) {
        this(optionValue.name().toLowerCase());
    }

    @Nonnull
    public PubStyleOption setOptionValue(@Nonnull StyleLayout optionValue) {
        return setOptionValue(optionValue.name().toLowerCase());
    }

    @Nonnull
    public StyleLayout currentOptionValueEnum() {
        return StyleLayout.valueOf(currentOptionValue().toUpperCase());
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubStyleOption(currentOptionValue());
    }

    public enum StyleLayout {
        TREE,
        LIST,
        COMPACT
    }
}
