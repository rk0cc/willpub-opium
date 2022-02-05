package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option to include <a href="https://dart.dev/tools/pub/glossary#transitive-dependency">transitive dependencies</a>
 * when calling {@link xyz.rk0cc.willpub.cmd.subcmd.PubOutdatedSubCommand}.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-outdated#--no-transitive">
 *          <code>--transitive</code> option in <code>pub outdated</code> subcommand.
 *      </a>
 */
public final class PubTransitiveOption extends PubDisableAllowedOption<PubTransitiveOption> {
    /**
     * Construct <code>--transitive</code> option.
     *
     * @param disableOption Parse as disable or not.
     */
    public PubTransitiveOption(boolean disableOption) {
        super("transitive", disableOption);
    }

    /**
     * Construct <code>--transitive</code> option with
     * {@link PubDisableAllowedOption#DISABLE_AS_DEFAULT_OPTION default option}.
     */
    public PubTransitiveOption() {
        super("transitive");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubTransitiveOption(isParseDisabled());
    }
}
