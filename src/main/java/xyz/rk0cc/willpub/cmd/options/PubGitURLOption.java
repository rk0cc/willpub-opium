package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * Applying Git URL option on {@link xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand}.
 *
 * @since 1.0.0
 */
public final class PubGitURLOption extends PubOptionWithValue {
    /**
     * Construct option with applied Git URL of the package.
     *
     * @param optionValue Git repository URL of the package.
     */
    public PubGitURLOption(@Nonnull String optionValue) {
        super("git-url", optionValue);
    }

    /**
     * Construct option for add Git package in the current project.
     */
    public PubGitURLOption() {
        super("git-url");
    }
}
