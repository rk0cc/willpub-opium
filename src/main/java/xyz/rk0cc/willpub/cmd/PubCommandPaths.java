package xyz.rk0cc.willpub.cmd;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.Objects;

public final class PubCommandPaths {
    private final Path dartSDK, flutterSDK;

    public PubCommandPaths(@Nonnull Path dartSDK, @Nullable Path flutterSDK) {
        this.dartSDK = dartSDK;
        this.flutterSDK = flutterSDK;
    }

    public PubCommandPaths(@Nonnull Path dartSDK) {
        this(dartSDK, null);
    }

    public boolean hasFlutterSDK() {
        return !Objects.isNull(flutterSDK);
    }

    public static PubCommandPaths resolveFromDirectory() {
        return null;
    }
}