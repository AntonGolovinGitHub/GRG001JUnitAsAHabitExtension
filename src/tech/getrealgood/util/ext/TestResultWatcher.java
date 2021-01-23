package tech.getrealgood.util.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Optional;

public class TestResultWatcher implements TestWatcher {

    private static final Logger log = LoggerFactory.getLogger(TestResultWatcher.class);

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

        log.info(() -> context.getRequiredTestMethod() + " is disabled");

    }

    @Override
    public void testSuccessful(ExtensionContext context) {

        log.info(() -> context.getRequiredTestMethod() + " was successful");

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

        log.info(() -> context.getRequiredTestMethod() + " was aborted");

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        log.info(() -> context.getRequiredTestMethod() + " failed");

    }
}