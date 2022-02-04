package xyz.rk0cc.willpub.cmd.subcmd;

import org.junit.jupiter.api.*;
import xyz.rk0cc.willpub.cmd.options.*;
import xyz.rk0cc.willpub.exceptions.cmd.IllegalSubCommandOptionException;
import xyz.rk0cc.willpub.exceptions.cmd.PerquisitesOptionsNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

final class PubSubCommandOptionApplyTest {
    @DisplayName("Apply global option")
    @Test
    void testGlobalOptionApply() {
        assertDoesNotThrow(() -> new PubGetSubCommand().addOption(new PubHelpOption()));
        assertDoesNotThrow(() -> new PubAddSubCommand("path").addOption(new PubVerbosityOption()));
        assertDoesNotThrow(
                () -> new PubOutdatedSubCommand().addOption(new PubDirectoryOption("/foo"))
                        .addOption(new PubHelpOption())
        );
    }

    @DisplayName("Apply option which only limited subcommand supported.")
    @Test
    void testSubCommandSpecificOptionApply() {
        assertDoesNotThrow(
                () -> new PubDepsSubCommand().addOption(new PubStyleOption(PubStyleOption.StyleLayout.TREE))
                        .addOption(new PubJsonOption())
        );
        assertThrows(
                IllegalSubCommandOptionException.class,
                () -> new PubDepsSubCommand().addOption(new PubNullSafetyOption())
        );
    }

    @DisplayName("Apply option which required perquisites")
    @Test
    void testPerquisitesOptionApply() {
        assertThrows(
                PerquisitesOptionsNotFoundException.class,
                () -> new PubAddSubCommand("foo").addOption(new PubGitRefOption("master"))
        );
        assertDoesNotThrow(
                () -> new PubAddSubCommand("bar").addOption(new PubGitUrlOption("foobar"))
                        .addOption(new PubGitRefOption("master"))
        );
    }
}
