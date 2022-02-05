package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;
import xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand;

import javax.annotation.Nonnull;

/**
 * An option for {@link PubAddSubCommand} that to indicate which reference will be uses to import Git package.
 * <br/>
 * This option required {@link PubGitUrlOption} applied already in subcommands.
 *
 * @since 1.0.0
 *
 * @see PubGitUrlOption Indicate the package's Git repository.
 * @see PubGitPathOption Locate path to package in Git repository.
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add#--git-refbranch_or_commit">
 *          <code>--git-ref</code> documentation in <code>pub add</code> subcommand.
 *      </a>
 */
@PubPerquisitesOptions(perquisites = PubGitUrlOption.class, affectedSubCommands = PubAddSubCommand.class)
public final class PubGitRefOption extends PubOptionWithValue {
    /**
     * Construct <code>--git-ref</code> option.
     *
     * @param optionValue Reference of the Git repository, it can be branch name, tags and commit hash.
     */
    public PubGitRefOption(@Nonnull String optionValue) {
        super("git-ref", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubGitRefOption(currentOptionValue());
    }
}
