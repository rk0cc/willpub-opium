package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * Applying Git URL option on {@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand}.
 *
 * @since 1.0.0
 *
 * @see PubGitRefOption Referencing which Git commit record will be downloaded.
 * @see PubGitPathOption Locate package path in Git repository.
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-add#--git-urlgit_repo_url">
 *          <code>--git-url</code> option in <code>pub add</code> subcommand.
 *      </a>
 */
public final class PubGitUrlOption extends PubOptionWithValue {
    /**
     * Construct option with applied Git URL of the package.
     *
     * @param optionValue Git repository URL of the package.
     */
    public PubGitUrlOption(@Nonnull String optionValue) {
        super("git-url", optionValue);
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubGitUrlOption(currentOptionValue());
    }
}
