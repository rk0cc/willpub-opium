package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * An entity of the {@link PubOption option} which uses for
 * {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand#addOption(PubOption, boolean) apply it in the subcommand}.
 *
 * @since 1.0.0
 */
public sealed abstract class PubOption permits AbstractedPubOption, PubDisableAllowedOption, PubOptionWithValue {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PubOption pubOption = (PubOption) o;
        return optionName.equals(pubOption.optionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}