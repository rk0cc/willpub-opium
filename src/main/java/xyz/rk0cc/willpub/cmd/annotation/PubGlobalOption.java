package xyz.rk0cc.willpub.cmd.annotation;

import java.lang.annotation.*;

/**
 * An annotation that can be applied to all {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand pub subcommand} which the
 * validation will be skipped.
 *
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PubGlobalOption {
}
