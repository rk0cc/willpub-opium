package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubUploaderSubCommand} that to grant a user who uses the email
 * address to upload name of the package.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-uploader#--packagepackage-name">
 *          <code>--package</code> option in <code>pub uploader</code> documentation
 *      </a>
 */
public final class PubPackageOption extends PubOptionWithValue<PubPackageOption> {
    /**
     * Construct <code>--package</code> option.
     *
     * @param optionValue Package name which want to apply an email address.
     */
    public PubPackageOption(@Nonnull String optionValue) {
        super("package", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPackageOption(currentOptionValue());
    }
}
