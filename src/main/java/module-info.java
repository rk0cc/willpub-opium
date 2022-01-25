module xyz.rk0cc.willpub.cmd {
    requires jsr305;

    //opens xyz.rk0cc.willpub.exceptions.cmd;
    opens xyz.rk0cc.willpub.cmd;
    opens xyz.rk0cc.willpub.cmd.options;
    opens xyz.rk0cc.willpub.cmd.subcmd;

    //exports xyz.rk0cc.willpub.exceptions.cmd;
    exports xyz.rk0cc.willpub.cmd;
    exports xyz.rk0cc.willpub.cmd.options;
    exports xyz.rk0cc.willpub.cmd.subcmd;
}