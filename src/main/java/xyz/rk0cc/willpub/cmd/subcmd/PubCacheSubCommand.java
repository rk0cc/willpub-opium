package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} for managing package cache in local machine.
 * <br/>
 * Normally, packages' cache will be added automatically when installing dependencies to the projects. When execute
 * {@link PubSubCommand subcommands} when go {@link PubOfflineOption offline}, they use cached package as a reference
 * for finding packages.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-cache"><code>pub cache</code> subcommand documentation.</a>
 * @see <a href="https://dart.dev/tools/pub/glossary#system-cache">System cache explaination.</a>
 */
public final class PubCacheSubCommand extends PubSubCommandWithArgs {
    private static final Set<Class<? extends PubOption>> CACHE_OPTS = Set.of(
            PubAllOption.class,
            PubVersionOption.class
    );

    /**
     * Construct subcommand with package name which want to be {@link CacheAction#ADD cached}.
     *
     * @param packageName Package name that will be {@link CacheAction#ADD cached}.
     */
    public PubCacheSubCommand(@Nonnull String packageName) {
        super("cache", CACHE_OPTS, CacheAction.ADD.name().toLowerCase(), packageName);
    }

    /**
     * Construct subcommand with given {@link CacheAction action}.
     *
     * @param action Action of this subcommand.
     */
    public PubCacheSubCommand(@Nonnull CacheAction action) {
        super("cache", CACHE_OPTS, action.name().toLowerCase());
    }

    /**
     * An {@link Enum} for applying action on {@link PubCacheSubCommand}.
     *
     * @since 1.0.0
     */
    public enum CacheAction {
        /**
         * Add name of the package into cache.
         */
        ADD,
        /**
         * Repair all cached package.
         */
        REPAIR,
        /**
         * Remove all cached package.
         */
        CLEAN
    }
}
