package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} that grant or revoke non-package owners to upload package to repository.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-uploader"><code>pub uploader</code> subcommand documentation</a>
 */
public final class PubUploaderSubCommand extends PubSubCommandWithArgs {
    /**
     * Construct subcommand to grant or revoke upload permission for the user of email address.
     *
     * @param option {@link UploaderOption Apply option} to given email address.
     * @param email Email address that affects after executing this subcommand.
     */
    public PubUploaderSubCommand(@Nonnull UploaderOption option, @Nonnull String email) {
        super(true, "uploader", Set.of(PubPackageOption.class), option.name().toLowerCase(), email);
    }

    /**
     * An option that allows applied email address user can be uploaded or not.
     *
     * @since 1.0.0
     */
    public enum UploaderOption {
        /**
         * Grant given email address to upload the package.
         */
        ADD,
        /**
         * Revoke given email address to upload the package.
         */
        REMOVE
    }
}
