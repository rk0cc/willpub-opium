package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;
import xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand;

import javax.annotation.Nonnull;

/**
 * An option for {@link PubAddSubCommand} that to specify path to package in Git repository.
 * <br/>
 * This option required {@link PubGitUrlOption} applied already in the subcommand.
 *
 * @since 1.0.0
 *
 * @see PubGitRefOption Indicate Git reference for adding package.
 * @see PubGitUrlOption Add package from specific Git repository address.
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add#--git-pathdirectory_path">
 *          <code>--path</code> option in <code>pub add</code> command.
 *      </a>
 */
@PubPerquisitesOptions(perquisites = PubGitUrlOption.class, affectedSubCommands = PubAddSubCommand.class)
public final class PubGitPathOption extends PubOptionWithValue<PubGitPathOption> {
    /**
     * Construct <code>--git-path</code> option.
     *
     * @param optionValue Path to package in Git repository.
     */
    public PubGitPathOption(@Nonnull String optionValue) {
        super("git-path", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubGitPathOption(currentOptionValue());
    }
}
