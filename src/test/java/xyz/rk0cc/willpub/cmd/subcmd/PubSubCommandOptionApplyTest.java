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
        assertDoesNotThrow(() -> new PubAddSubCommand("path")
                .addOption(new PubVerbosityOption(PubVerbosityOption.VerbosityLevel.ALL)));
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

    @DisplayName("Remove related option if perquisites option removed")
    @Test
    void testAutoRemoveIfPerquisitesOptionRemoved() {
        PubSubCommand subCommand = new PubAddSubCommand("foo")
                .addOption(new PubGitUrlOption("xyz"))
                .addOption(new PubGitPathOption("aaa/bbb/"));

        assertTrue(subCommand.hasOption(PubGitPathOption.class));

        subCommand.removeOption(PubGitUrlOption.class);

        assertFalse(subCommand.hasOption(PubGitPathOption.class));
    }
}
