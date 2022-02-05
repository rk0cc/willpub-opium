package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for {@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand} that to locate package from local machine.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add#--pathdirectory_path">
 *          <code>--path</code> option in <code>pub add</code> subcommand.
 *      </a>
 */
public final class PubPathOption extends PubOptionWithValue<PubPathOption> {
    /**
     * Construct <code>--path</code> option.
     *
     * @param optionValue Path to package.
     */
    public PubPathOption(@Nonnull String optionValue) {
        super("path", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPathOption(currentOptionValue());
    }
}
