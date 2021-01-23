package tech.getrealgood.util.ext;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class NotFunnyMethodMessageExtension implements AfterEachCallback {

    private static final Logger log = LoggerFactory.getLogger(NotFunnyMethodMessageExtension.class);

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        log.info(() -> "Did this test method pass?");
    }
}
