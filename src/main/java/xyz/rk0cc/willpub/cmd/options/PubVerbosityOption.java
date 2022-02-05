package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

@PubGlobalOption
public final class PubVerbosityOption extends PubOptionWithValue<PubVerbosityOption> {
    public PubVerbosityOption(@Nonnull String optionValue) {
        super("verbosity", optionValue);
    }

    public PubVerbosityOption(@Nonnull VerbosityLevel optionValue) {
        super("verbosity", optionValue.name().toLowerCase());
    }

    public PubVerbosityOption() {
        super("verbosity", "all");
    }

    @Nonnull
    public PubVerbosityOption setOptionValue(@Nonnull VerbosityLevel optionValue) {
        return setOptionValue(optionValue.name().toLowerCase());
    }

    @Nonnull
    public VerbosityLevel currentOptionValueInEnum() {
        return VerbosityLevel.valueOf(currentOptionValue().toUpperCase());
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubVerbosityOption(currentOptionValue());
    }

    public enum VerbosityLevel {
        ALL,
        IO,
        NORMAL,
        SOLVER
    }
}
