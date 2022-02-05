package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubCacheSubCommand} that to constraint which version of the package
 * should be {@link xyz.rk0cc.willpub.cmd.subcmd.PubCacheSubCommand.CacheAction#ADD cached}.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-cache#--version-constraint">
 *          <code>--version</code> in <code>pub cache</code> subcommand.
 *      </a>
 */
public final class PubVersionOption extends PubOptionWithValue<PubVersionOption> {
    /**
     * Construct <code>--version</code> option.
     *
     * @param optionValue Indicate which version constraint should be cached.
     */
    public PubVersionOption(@Nonnull String optionValue) {
        super("version", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubVersionOption(currentOptionValue());
    }
}
