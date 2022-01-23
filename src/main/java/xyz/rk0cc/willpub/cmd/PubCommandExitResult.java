package xyz.rk0cc.willpub.cmd;

public interface PubCommandExitResult<E extends Enum<? extends PubCommandExitResult<E>>> {
    int exitCode();
}
