package xyz.rk0cc.willpub.cmd;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;

public final class PubCommandPathProvider implements Serializable, Cloneable {
    private Path dartSDK, flutterSDK;

    public PubCommandPathProvider(@Nullable Path dartSDK, @Nullable Path flutterSDK) {
        this.setDartSDK(dartSDK);
        this.setFlutterSDK(flutterSDK);
    }

    private void assertion(@Nullable Path sdks) {
        if (sdks == null) return;

        assert sdks.isAbsolute();

        File f = sdks.toFile();

        if (!f.canExecute())
            throw new IllegalArgumentException("Applied SDK '" + sdks + "' is not executable.");
    }

    public void setDartSDK(@Nullable Path dartSDK) {
        assertion(dartSDK);
        this.dartSDK = dartSDK;
    }

    public void setFlutterSDK(@Nullable Path flutterSDK) {
        assertion(flutterSDK);
        this.flutterSDK = flutterSDK;
    }

    public void clearAllAppliedSDK() {
        setDartSDK(null);
        setFlutterSDK(null);
    }

    @Nullable
    public Path getDartSDK() {
        return dartSDK;
    }

    @Nullable
    public Path getFlutterSDK() {
        return flutterSDK;
    }

    @Nonnull
    public String buildDartExecCmd() {
        return dartSDK == null ? "dart" : dartSDK.toString();
    }

    @Nonnull
    public String buildFlutterExecCmd() {
        return flutterSDK == null ? "flutter" : flutterSDK.toString();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Nonnull
    @Override
    public PubCommandPathProvider clone() {
        return new PubCommandPathProvider(dartSDK, flutterSDK);
    }
}
