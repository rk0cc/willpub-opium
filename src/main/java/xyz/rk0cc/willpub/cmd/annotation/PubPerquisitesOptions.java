package xyz.rk0cc.willpub.cmd.annotation;

import xyz.rk0cc.willpub.cmd.options.PubOption;
import xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand;

import java.lang.annotation.*;

/**
 * Annotated {@link PubOption} required {@link PerquisitesPolicy#EITHER either} or {@link PerquisitesPolicy#BOTH both}
 * {@link #perquisites() perquisites options} are assigned already in {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand}
 * or removed automatically depending on {@link #policy() perquisites policy}.
 *
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PubPerquisitesOptions {
    /**
     * Indicate which {@link Class} of {@link PubOption} is required. And as a reference when removing {@link PubOption}
     * which involved with {@link PubPerquisitesOptions annotated options}.
     *
     * @return An array of {@link PubOption} {@link Class} which required to contain
     *         {@link PerquisitesPolicy#EITHER at least one} or {@link PerquisitesPolicy#BOTH all} {@link PubOption}
     *         {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand#addOption(PubOption, boolean) assigned} already.
     */
    Class<? extends PubOption>[] perquisites();

    /**
     * Indicate which {@link PubSubCommand subcommand} are affected with perquisites. By default, it contains empty
     * array which all subcommands will be applied.
     *
     * @return An array of {@link PubSubCommand} that specify which subcommands can be affected.
     */
    Class<? extends PubSubCommand>[] affectedSubCommands() default {};

    /**
     * Indicate the {@link PerquisitesPolicy policy} when applying annotated {@link PubOption}.
     *
     * @return {@link PerquisitesPolicy} value. Default return {@link PerquisitesPolicy#BOTH}.
     */
    PerquisitesPolicy policy() default PerquisitesPolicy.BOTH;

    /**
     * Define {@link PubPerquisitesOptions annotated} {@link PubOption} that handling on modification.
     *
     * @since 1.0.0
     *
     * @see #policy()
     */
    enum PerquisitesPolicy {
        /**
         * Indicate this {@link PubOption} must be assigned all {@link #perquisites()} already in
         * {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand subcommand}.
         */
        BOTH,
        /**
         * Indicate this {@link PubOption} required at least one {@link #perquisites()} is assigned.
         */
        EITHER
    }
}
