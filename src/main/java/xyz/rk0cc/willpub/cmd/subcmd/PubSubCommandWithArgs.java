package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.PubOption;

import javax.annotation.Nonnull;
import java.util.Set;

public sealed abstract class PubSubCommandWithArgs extends PubSubCommand permits PubAddSubCommand, PubCacheSubCommand, PubDowngradeSubCommand {
    private String args;

    PubSubCommandWithArgs(
            @Nonnull String subCommandName,
            @Nonnull Set<Class<? extends PubOption>> acceptedOption,
            @Nonnull String... args
    ) {
        super(subCommandName, acceptedOption);
        this.applyArgs(args);
    }

    private void applyArgs(@Nonnull String... args) {
        StringBuilder builder = new StringBuilder();
        for (String a : args) {
            if (a.matches("\\r|\\n|\\s|(-[A-Za-z]+(\\s.*)?)|(--[A-Za-z\\-_]+(=.*)?)"))
                throw new IllegalArgumentException("Argument has illegal charter parsed");
            else {
                builder.append(a);
                builder.append(" ");
            }
        }

        this.args = builder.toString().trim();
    }

    @Nonnull
    public final PubSubCommandWithArgs setArgs(@Nonnull String... args) {
        applyArgs(args);
        return this;
    }

    @Nonnull
    public final String currentArgs() {
        return args;
    }

    @Nonnull
    @Override
    public final String buildSubCommand() {
        return subCommandProgram() + " " + args + (args.isBlank() ? "" : " ") + subCommandOptionFlags();
    }
}
