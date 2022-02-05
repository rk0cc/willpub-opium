package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * An entity of the {@link PubOption option} which uses for
 * {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand#addOption(PubOption, boolean) apply it in the subcommand}.
 *
 * @since 1.0.0
 */
public sealed abstract class PubOption implements Cloneable
        permits AbstractedPubOption, PubDisableAllowedOption, PubOptionWithValue {
    private final String optionName;

    PubOption(@Nonnull String optionName) {
        this.optionName = optionName;
    }

    @Nonnull
    final String optionName() {
        return optionName;
    }

    /**
     * Build a {@link String} of this option and
     * {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand#buildSubCommand() assemble completed command}.
     *
     * @return Option section in the subcommand.
     */
    @Nonnull
    public abstract String buildOption();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PubOption pubOption = (PubOption) o;
        return optionName.equals(pubOption.optionName) && buildOption().equals(pubOption.buildOption());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getClass(), optionName);
    }

    @Nonnull
    @Override
    public abstract PubOption clone();
}