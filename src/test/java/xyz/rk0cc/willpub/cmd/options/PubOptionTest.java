package xyz.rk0cc.willpub.cmd.options;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

final class PubOptionTest {
    @DisplayName("Test option string in pub command")
    @Test
    void testOptionExport() {
        assertEquals("--help", new PubHelpOption().buildOption());
        assertEquals("--verbose", new PubVerboseOption().buildOption());
    }

    @DisplayName("Test option with disable allowed string in pub command")
    @Test
    void testOptionWithDisabledExport() {
        assertEquals("--no-offline", new PubOfflineOption().disableThisOption().buildOption());
        assertEquals("--offline", new PubOfflineOption().buildOption());
    }

    @DisplayName("Test option string which value required in pub command")
    @Test
    void testOptionValueExport() {
        assertEquals(
                "--git-url=git@example.com:foo/bar.git",
                new PubGitURLOption("git@example.com:foo/bar.git").buildOption()
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new PubGitURLOption("foo bar")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new PubGitURLOption("\"foo bar'")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new PubGitURLOption("\"go\"lol\"")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new PubGitURLOption("Hello\nWorld")
        );
    }
}
