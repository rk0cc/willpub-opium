package xyz.rk0cc.willpub.cmd.subcmd;

import xyz.rk0cc.willpub.cmd.options.*;

import javax.annotation.Nonnull;
import java.util.Set;

public final class PubTokenSubCommand extends PubSubCommandWithArgs {
    private static final Set<Class<? extends PubOption>> TOKEN_OPTS = Set.of(
            PubAllOption.class,
            TokenVarOption.class
    );

    public PubTokenSubCommand(@Nonnull TokenAction action, @Nonnull String hostedURL) {
        super("token", TOKEN_OPTS, action.name().toLowerCase(), hostedURL);

        if (action == TokenAction.LIST)
            throw new IllegalArgumentException("List does not required arguments.");
    }

    public PubTokenSubCommand(@Nonnull TokenAction action) {
        super("token", TOKEN_OPTS, action.name().toLowerCase());

        if (action == TokenAction.ADD)
            throw new IllegalArgumentException("Add require hosted URL as an argument.");
    }

    public enum TokenAction {
        ADD,
        LIST,
        REMOVE
    }

    public static final class TokenVarOption extends PubOptionWithValue {
        public TokenVarOption(@Nonnull String optionValue) {
            super("env-var", optionValue);
        }
    }
}
