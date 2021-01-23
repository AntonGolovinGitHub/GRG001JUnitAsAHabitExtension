package tech.getrealgood.util.service;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class FunnyMessageExtension implements BeforeAllCallback {

    private static final Logger log = LoggerFactory.getLogger(FunnyMessageExtension.class);

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        log.info(() -> "What am I getting myself into here?");
    }
}
