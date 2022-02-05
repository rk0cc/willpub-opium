package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand} that to override default hosted repository URL.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add#--hosted-urlpackage_server_url">
 *          <code>--hosted-url</code> option in <code>pub add</code> subcommand.
 *      </a>
 */
public final class PubHostedUrlOption extends PubOptionWithValue {
    /**
     * Construct <code>--hosted-url</code> option.
     *
     * @param optionValue URL to the package repository site.
     */
    public PubHostedUrlOption(@Nonnull String optionValue) {
        super("hosted-url", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubHostedUrlOption(currentOptionValue());
    }
}
