package tech.getrealgood.util.ext;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class TypeTimingExtension implements BeforeAllCallback,
        AfterAllCallback, LifecycleMethodExecutionExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(TypeTimingExtension.class);

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

        if(context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).get(StoreConstants.TOTAL_TIME) == null) {
            context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put(StoreConstants.TOTAL_TIME, 0L);
        }

        // log.info(() -> "About to run @BeforeAll method(s) of the test class for a new unit test");

    }

    @Override
    public void handleBeforeAllMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {

    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {

        final Long totalTime = (Long) context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).get(StoreConstants.TOTAL_TIME);

        if(totalTime != null)
            log.info(() -> "Total time taken by the unit tests is: " + totalTime + " milliseconds for class " +
                    context.getRequiredTestClass().getCanonicalName());

        // log.info(() -> "About to run @AfterAll method(s) of the test class for a new unit test");

    }

    @Override
    public void handleAfterAllMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {

    }

}