package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubDowngradeSubCommand extends PubSubCommandWithArgs {
    private static final Set<Class<? extends PubOption>> DOWNGRADE_OPTION = Set.of(
            PubOfflineOption.class,
            PubDryRunOption.class
    );

    public PubDowngradeSubCommand(@Nonnull String packageName) {
        super("downgrade", DOWNGRADE_OPTION, packageName);
    }

    public PubDowngradeSubCommand() {
        super("downgrade", DOWNGRADE_OPTION);
    }
}
