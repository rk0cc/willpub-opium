package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubUpgradeSubCommand extends PubSubCommandWithArgs {
    public PubUpgradeSubCommand(@Nonnull String... packagesName) {
        super("upgrade", Set.of(
                PubOfflineOption.class,
                PubDryRunOption.class,
                PubPreCompileOption.class,
                PubNullSafetyOption.class,
                PubMajorVersionsOption.class
        ), packagesName);
    }
}
