package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.PubOption;
import xyz.rk0cc.willpub.exceptions.cmd.IllegalSubCommandArgumentException;

import javax.annotation.Nonnull;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Subclass of {@link PubSubCommand} that allow parsing arguments when executing suncommand.
 *
 * @since 1.0.0
 */
public non-sealed abstract class PubSubCommandWithArgs extends PubSubCommand {
    private final boolean optBeforeArgs;
    private String args;

    /**
     * Construct {@link PubSubCommand} with argument preferences.
     *
     * @param optBeforeArgs Option appeared before argument for this command.
     * @param subCommandName Name of the subcommand.
     * @param acceptedOption A {@link Set} of {@link PubOption} {@link Class} that indicate which option can be
     *                       {@link #addOption(PubOption, boolean) applied}.
     * @param args A {@link String} argument when executing this subcommand (without whitespace and flags).
     */
    protected PubSubCommandWithArgs(
            boolean optBeforeArgs,
            @Nonnull String subCommandName,
            @Nonnull Set<Class<? extends PubOption>> acceptedOption,
            @Nonnull String... args
    ) {
        super(subCommandName, acceptedOption);
        this.optBeforeArgs = optBeforeArgs;
        this.applyArgs(args);
    }

    /**
     * Construct {@link PubSubCommand} with argument preferences with option appeared after the argument.
     *
     * @param subCommandName Name of the subcommand.
     * @param acceptedOption A {@link Set} of {@link PubOption} {@link Class} that indicate which option can be
     *                       {@link #addOption(PubOption, boolean) applied}.
     * @param args A {@link String} argument when executing this subcommand (without whitespace and flags).
     */
    protected PubSubCommandWithArgs(
            @Nonnull String subCommandName,
            @Nonnull Set<Class<? extends PubOption>> acceptedOption,
            @Nonnull String... args
    ) {
        this(false, subCommandName, acceptedOption, args);
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

    /**
     * Display current assembled argument in this subcommand.
     *
     * @return Assembled subcommand's argument value.
     */
    @Nonnull
    public final String currentArgs() {
        return args;
    }

    private void optionApplier(@Nonnull StringBuilder builder) {
        if (!isEmptyOptions())
            builder.append(subCommandOptionFlags());
    }

    private void argsApplier(@Nonnull StringBuilder builder) {
        if (!args.isBlank())
            builder.append(args);
    }

    @Nonnull
    @Override
    public final String buildSubCommand() {
        StringBuilder builder = new StringBuilder();
        builder.append(subCommandProgram());

        if (!args.isBlank() || !isEmptyOptions()) {
            builder.append(" ");
            if (optBeforeArgs) {
                optionApplier(builder);
                builder.append(" ");
                argsApplier(builder);
            } else {
                argsApplier(builder);
                builder.append(" ");
                optionApplier(builder);
            }
        }

        return builder.toString().trim();
    }
}
