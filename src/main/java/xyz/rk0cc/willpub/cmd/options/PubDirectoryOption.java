package xyz.rk0cc.willpub.cmd.options;

import xyz.rk0cc.willpub.cmd.annotation.PubGlobalOption;

import javax.annotation.Nonnull;

/**
 * Apply targeted project directory instead of location of program's directory.
 * <br/>
 * It is recommended to provide this option to every {@link xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand} since it should
 * be different location of this program and the project.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd#--directorydir-or--c-dir">'--directory' option in documentation.</a>
 */
@PubGlobalOption
public final class PubDirectoryOption extends PubOptionWithValue {
    /**
     * Construct an option with given project directory path as option value.
     *
     * @param optionValue Path to project directory.
     */
    public PubDirectoryOption(@Nonnull String optionValue) {
        super("directory", optionValue);
    }
}
