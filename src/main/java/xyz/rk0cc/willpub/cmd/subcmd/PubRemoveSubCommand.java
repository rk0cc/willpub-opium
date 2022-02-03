package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubRemoveSubCommand extends PubSubCommandWithArgs {
    public PubRemoveSubCommand(@Nonnull String packageName) {
        super("remove", Set.of(
                PubOfflineOption.class,
                PubDryRunOption.class,
                PubPreCompileOption.class
        ), packageName);
    }
}
