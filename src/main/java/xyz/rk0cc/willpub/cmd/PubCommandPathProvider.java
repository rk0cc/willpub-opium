package xyz.rk0cc.willpub.cmd;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.Serializable;
import java.nio.file.*;

public final class PubCommandPathProvider implements Serializable, Cloneable {
    private Path dartSDK, flutterSDK;

    public PubCommandPathProvider(@Nullable Path dartSDK, @Nullable Path flutterSDK) {
        this.setDartSDK(dartSDK);
        this.setFlutterSDK(flutterSDK);
    }

    private void assertion(@Nullable Path sdks) {
        if (sdks == null) return;

        if (!sdks.isAbsolute())
            throw new IllegalArgumentException("SDK path must be absolute.");

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


    @Nonnull
    public static PubCommandPathProvider resolveSDKFromDirectory(@Nonnull Path sdkPath) throws FileSystemException {
        if (!sdkPath.isAbsolute())
            throw new IllegalArgumentException("The path must be absolute");

        File sdkDir = sdkPath.toFile();
        if (!sdkDir.isDirectory())
            throw new NotDirectoryException(sdkDir.getAbsolutePath());

        final boolean win = System.getProperty("os.name").equalsIgnoreCase("windows");

        return new PubCommandPathProvider(
                sdkPath.resolve("dart" + (win ? ".bat" : "")),
                sdkPath.resolve("flutter" + (win ? ".bat" : ""))
        );
    }
}
