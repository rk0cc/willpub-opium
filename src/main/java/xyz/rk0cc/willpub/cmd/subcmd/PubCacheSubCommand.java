package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubCacheSubCommand extends PubSubCommandWithArgs {
    private static final Set<Class<? extends PubOption>> CACHE_OPTS = Set.of(
            PubAllOption.class,
            PubVersionOption.class
    );

    public PubCacheSubCommand(@Nonnull String packageName) {
        super("cache", CACHE_OPTS, CacheAction.ADD.name().toLowerCase(), packageName);
    }

    public PubCacheSubCommand(@Nonnull CacheAction action) {
        super("cache", CACHE_OPTS, action.name().toLowerCase());
    }

    public enum CacheAction {
        ADD,
        REPAIR,
        CLEAN
    }
}
