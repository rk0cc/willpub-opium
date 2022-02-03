package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;

import javax.annotation.Nonnull;

@PubPerquisitesOptions(perquisites = {PubGitURLOption.class})
public final class PubGitPathOption extends PubOptionWithValue {
    public PubGitPathOption(@Nonnull String optionValue) {
        super("git-path", optionValue);
    }
}
