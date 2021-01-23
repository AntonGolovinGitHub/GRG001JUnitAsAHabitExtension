package tech.getrealgood.util.ext;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class NotFunnyMessageExtension implements AfterAllCallback  {

    private static final Logger log = LoggerFactory.getLogger(NotFunnyMessageExtension.class);

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        log.info(() -> "Did this test class or nested class fully pass?");
    }
}

