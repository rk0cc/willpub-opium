package xyz.rk0cc.willpub.cmd.subcmd;

import org.junit.jupiter.api.*;
import xyz.rk0cc.willpub.cmd.options.*;

import static org.junit.jupiter.api.Assertions.*;

final class PubSubCommandBuildTest {
    @DisplayName("Build pub subcommand string")
    @Test
    void testBuildCmdString() {
        PubAddSubCommand acmd = (PubAddSubCommand) new PubAddSubCommand("foo")
                .setArgs("http")
                .addOption(new PubOfflineOption());

        assertEquals("pub add http --offline", acmd.buildSubCommand());
    }

    @DisplayName("Build pub subcommand string which option appeared before argument")
    @Test
    void testBuildOptBeforeArgs() {
        PubUpgradeSubCommand ucmd = (PubUpgradeSubCommand) new PubUpgradeSubCommand("path", "meta")
                .addOption(new PubDryRunOption());

        assertEquals("pub upgrade --dry-run path meta", ucmd.buildSubCommand());
    }
}
