package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;

import javax.annotation.Nonnull;

@PubPerquisitesOptions(perquisites = {PubGitURLOption.class})
public final class PubGitRefOption extends PubOptionWithValue {
    public PubGitRefOption(@Nonnull String optionValue) {
        super("git-ref", optionValue);
    }
}
