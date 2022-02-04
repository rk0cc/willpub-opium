package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;
import xyz.rk0cc.willpub.cmd.subcmd.PubAddSubCommand;

import javax.annotation.Nonnull;

@PubPerquisitesOptions(perquisites = PubGitURLOption.class, affectedSubCommands = PubAddSubCommand.class)
public final class PubGitRefOption extends PubOptionWithValue {
    public PubGitRefOption(@Nonnull String optionValue) {
        super("git-ref", optionValue);
    }
}
