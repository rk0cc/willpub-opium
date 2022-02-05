package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubUploaderSubCommand extends PubSubCommandWithArgs {
    public PubUploaderSubCommand(@Nonnull UploaderOption option, @Nonnull String email) {
        super(true, "uploader", Set.of(PubPackageOption.class), option.name().toLowerCase(), email);
    }

    public enum UploaderOption {
        ADD,
        REMOVE
    }
}
