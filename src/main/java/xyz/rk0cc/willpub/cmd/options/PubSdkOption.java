package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand} that to indicate which SDK shipped with the
 * package.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add#--sdksdk_name">
 *          <code>--sdk</code> option in <code>pub add</code> subcommand.
 *      </a>
 */
public final class PubSdkOption extends PubOptionWithValue<PubSdkOption> {
    /**
     * Construct <code>--sdk</code> option.
     *
     * @param optionValue Name of SDK.
     */
    public PubSdkOption(@Nonnull String optionValue) {
        super("sdk", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubSdkOption(currentOptionValue());
    }
}
