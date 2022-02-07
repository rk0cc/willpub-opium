package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;
import xyz.rk0cc.willpub.exceptions.cmd.IllegalSubCommandArgumentException;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * A {@link PubSubCommand subcommand} that configure given repository URL token that using for publish.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-token"><code>pub token</code> subcommand documentation</a>
 */
public final class PubTokenSubCommand extends PubSubCommandWithArgs {
    private static final Set<Class<? extends PubOption>> TOKEN_OPTS = Set.of(
            PubAllOption.class,
            TokenVarOption.class
    );

    /**
     * Construct subcommand option for given <code>hostedURL</code>.
     *
     * @param action Pending {@link TokenAction action} when executing this command with hostedURL.
     * @param hostedURL Target of repository URL.
     *
     * @throws IllegalSubCommandArgumentException This constructor does not apply for {@link TokenAction#LIST} and throw
     *                                            it instead.
     */
    public PubTokenSubCommand(@Nonnull TokenAction action, @Nonnull String hostedURL) {
        super("token", TOKEN_OPTS, action.name().toLowerCase(), hostedURL);

        if (action == TokenAction.LIST)
            throw new IllegalSubCommandArgumentException(getClass(), new String[] {
                    action.name().toLowerCase(),
                    hostedURL
            }, "List does not required arguments.");
    }

    /**
     * Construct subcommand option without specific <code>hostedURL</code> applied.
     *
     * @param action Pending {@link TokenAction action} when executing this subcommand.
     *
     * @throws IllegalSubCommandArgumentException When applying {@link TokenAction#ADD} which must require given URL.
     */
    public PubTokenSubCommand(@Nonnull TokenAction action) {
        super("token", TOKEN_OPTS, action.name().toLowerCase());

        if (action == TokenAction.ADD)
            throw new IllegalSubCommandArgumentException(getClass(), new String[] {
                    action.name().toLowerCase()
            }, "Add require hosted URL as an argument.");
    }

    /**
     * An {@link Enum} for applying action when executing {@link PubTokenSubCommand}.
     *
     * @since 1.0.0
     */
    public enum TokenAction {
        /**
         * Indicate {@link PubTokenSubCommand} that add token to specific <code>hostedURL</code>.
         * <br/>
         * Applying it to {@link PubTokenSubCommand#PubTokenSubCommand(TokenAction) no hostedURL reference constructor}
         * cause {@link IllegalSubCommandArgumentException} throws.
         */
        ADD,
        /**
         * List all applied token configuration and print it to console.
         * <br/>
         * Applying it to {@link PubTokenSubCommand#PubTokenSubCommand(TokenAction, String) hostedURL reference constructor}
         * cause {@link IllegalSubCommandArgumentException} throws.
         */
        LIST,
        /**
         * Indicate {@link PubTokenSubCommand} that remove one or all <code>hostedURL</code> token record.
         */
        REMOVE
    }

    /**
     * Exclusive {@link PubOption} for {@link PubTokenSubCommand} that to indicate which environment variable uses
     * to apply subcommand.
     *
     * @since 1.0.0
     */
    public static final class TokenVarOption extends PubOptionWithValue<TokenVarOption> {
        /**
         * Construct an option with given environment variable name for getting token value.
         *
         * @param optionValue Environemnt variable name which storing token value.
         */
        public TokenVarOption(@Nonnull String optionValue) {
            super("env-var", optionValue);
        }

        @Nonnull
        @Override
        public PubOption clone() {
            return new TokenVarOption(currentOptionValue());
        }
    }
}
