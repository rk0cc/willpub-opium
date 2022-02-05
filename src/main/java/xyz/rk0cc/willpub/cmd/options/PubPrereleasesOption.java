package xyz.rk0cc.willpub.cmd.options;

import javax.annotation.Nonnull;

public final class PubPrereleasesOption extends PubDisableAllowedOption<PubPrereleasesOption> {
    public PubPrereleasesOption(boolean disableOption) {
        super("prereleases", disableOption);
    }

    public PubPrereleasesOption() {
        super("prereleases");
    }

    @Nonnull
    @Override
    public PubOption clone() {
        return new PubPrereleasesOption(isParseDisabled());
    }
}
