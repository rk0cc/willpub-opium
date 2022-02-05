package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.PubOption;
import xyz.rk0cc.willpub.exceptions.cmd.IllegalSubCommandArgumentException;

import javax.annotation.Nonnull;
import java.util.Set;
import java.util.regex.Pattern;

public non-sealed abstract class PubSubCommandWithArgs extends PubSubCommand {
    private String args;

    protected PubSubCommandWithArgs(
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
            if (a.contains("\s") || a.contains("\r") || a.contains("\n"))
                throw new IllegalSubCommandArgumentException(getClass(), args, "Found control charter in arguments");

            builder.append(a);
            builder.append(" ");
        }

        String asmedArgs = builder.toString().trim();
        Pattern optFlag = Pattern.compile("(-[A-Za-z0-9]+)|(--[A-Za-z0-9\\-_]+)");

        if (optFlag.matcher(asmedArgs).find())
            throw new IllegalSubCommandArgumentException(
                    getClass(), asmedArgs.split("\\s"), "Found option parsed into arguments"
            );

        this.args = asmedArgs;
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
