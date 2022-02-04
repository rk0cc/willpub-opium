package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

/**
 * An option for <code>pub global</code> (does not exist in OPIUM) to activate Dart executable into PATH.
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-global#--executablename-or--x-name">Related documentation.</a>
 */
public final class PubExecutableOption extends PubOptionWithValue {
    /**
     * Construct <code>--executable</code> option.
     *
     * @param optionValue Name of the executable which specified in the PATH.
     */
    public PubExecutableOption(@Nonnull String optionValue) {
        super("executable", optionValue);
    }
}
