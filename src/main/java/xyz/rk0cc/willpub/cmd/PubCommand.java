package xyz.rk0cc.willpub.cmd;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.*;

public class PubCommand {
    private final DartFlutterProgramAvailability availability;

    public PubCommand(@Nullable String dartSDK, @Nullable String flutterSDK) {
        this.availability = new DartFlutterProgramAvailability(dartSDK, flutterSDK);
    }

    public PubCommand() {
        this(null, null);
    }

    public final ProgramInstalledStatus dartStatus() {
        return availability.dartStatus();
    }

    public final ProgramInstalledStatus flutterStatus() {
        return availability.flutterStatus();
    }

    public enum ProgramInstalledStatus {
        FOUND,
        NOT_FOUND,
        ERROR
    }
}

final class DartFlutterProgramAvailability {
    private static final int CMD_FOUND_EXIT_CODE = 0,
                             WINDOWS_CMD_NOT_FOUND_EXIT_CODE = 9009,
                             UNIX_CMD_NOT_FOUND_EXIT_CODE = 127;

    private final PubCommand.ProgramInstalledStatus dart, flutter;

    DartFlutterProgramAvailability(@Nullable String dartSDK, @Nullable String flutterSDK) {
        ProgramExitCodeCaller dartECC = new ProgramExitCodeCaller("dart", dartSDK),
                flutterECC = new ProgramExitCodeCaller("flutter", flutterSDK);

        FutureTask<Integer> dec = new FutureTask<>(dartECC), fec = new FutureTask<>(flutterECC);

        try {
            dec.wait();
            fec.wait();

            this.dart = resolveStatus(dec.get());
            this.flutter = resolveStatus(fec.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unexpected exceptions when checking Dart and Flutter SDK.", e);
        }
    }

    PubCommand.ProgramInstalledStatus dartStatus() {
        return dart;
    }

    PubCommand.ProgramInstalledStatus flutterStatus() {
        return flutter;
    }

    private static PubCommand.ProgramInstalledStatus resolveStatus(int status) {
        if (status == CMD_FOUND_EXIT_CODE) return PubCommand.ProgramInstalledStatus.FOUND;

        if (System.getProperty("os.name").equalsIgnoreCase("windows")) {
            return status == WINDOWS_CMD_NOT_FOUND_EXIT_CODE
                    ? PubCommand.ProgramInstalledStatus.NOT_FOUND
                    : PubCommand.ProgramInstalledStatus.ERROR;
        } else {
            return status == UNIX_CMD_NOT_FOUND_EXIT_CODE
                    ? PubCommand.ProgramInstalledStatus.NOT_FOUND
                    : PubCommand.ProgramInstalledStatus.ERROR;
        }
    }

    @SuppressWarnings("ClassCanBeRecord")
    private static final class ProgramExitCodeCaller implements Callable<Integer> {

        private final String programName, sdkPath;

        private ProgramExitCodeCaller(@Nonnull String programName, @Nullable String sdkPath) {
            this.programName = programName;
            this.sdkPath = sdkPath;
        }

        @Nonnull
        @Override
        public Integer call() throws Exception {
            Process p = Runtime.getRuntime().exec(
                    Objects.isNull(sdkPath) ? programName : Paths.get(sdkPath, programName).toString()
            );
            p.waitFor();
            return p.exitValue();
        }
    }
}
