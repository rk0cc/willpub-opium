package xyz.rk0cc.willpub.cmd.subcmd;

import org.junit.jupiter.api.*;
import xyz.rk0cc.willpub.exceptions.cmd.IllegalSubCommandArgumentException;

import static org.junit.jupiter.api.Assertions.*;

final class PubSubCommandParseTest {
    @DisplayName("Reject parsing option in argument")
    @Test
    void testRejectOptionInArgs() {
        assertThrows(
                IllegalSubCommandArgumentException.class,
                () -> new PubAddSubCommand("--foo")
        );
        assertThrows(
                IllegalSubCommandArgumentException.class,
                () -> new PubAddSubCommand("--foo=bar")
        );
        assertThrows(
                IllegalSubCommandArgumentException.class,
                () -> new PubCacheSubCommand("hello foo bar")
        );
        assertThrows(
                IllegalSubCommandArgumentException.class,
                () -> new PubDowngradeSubCommand("path -s")
        );
        assertThrows(
                IllegalSubCommandArgumentException.class,
                () -> new PubTokenSubCommand(PubTokenSubCommand.TokenAction.ADD)
        );
        assertThrows(
                IllegalSubCommandArgumentException.class,
                () -> new PubAddSubCommand("-x")
        );
        assertThrows(
                IllegalSubCommandArgumentException.class,
                () -> new PubUpgradeSubCommand("path", "xyz", "-K", "dd")
        );
    }
}
