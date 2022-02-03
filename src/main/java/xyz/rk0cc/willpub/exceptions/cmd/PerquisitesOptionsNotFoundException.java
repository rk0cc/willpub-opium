package xyz.rk0cc.willpub.exceptions.cmd;

import xyz.rk0cc.willpub.cmd.annotation.PubPerquisitesOptions;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class PerquisitesOptionsNotFoundException extends RuntimeException {
    public PerquisitesOptionsNotFoundException(@Nonnull PubPerquisitesOptions annotation) {
        super("Applied option is not eligible to apply yet: " +
                Arrays.stream(annotation.perquisites())
                        .map(Class::getSimpleName)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
    }
}
