
package tech.getrealgood.util.ext;

import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class MethodTimingExtension implements
        BeforeTestExecutionCallback, AfterTestExecutionCallback,
        LifecycleMethodExecutionExceptionHandler, TestExecutionExceptionHandler {

    private static final String START_TIME = "start time";

    private static final String END_TIME = "end time";

    private static final Logger log = LoggerFactory.getLogger(MethodTimingExtension.class);

    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context
                .getRequiredTestMethod()));
    }

    @Override
    public void handleBeforeEachMethodExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        throw throwable;
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {

        try {

            final long startTime = System.currentTimeMillis();

            getStore(context).put(START_TIME, startTime);
        } catch (Exception ex) {
            log.error(() -> "Unable to process method run time: " + ex.getMessage());
        }

    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        throw throwable;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {

        try {

            final long endTime = System.currentTimeMillis();

            getStore(context).put(END_TIME, endTime);

            final long start_time = (Long) getStore(context).get(START_TIME);

            final long end_time = (Long) getStore(context).get(END_TIME);

            final long total_local_run_time = (end_time - start_time);

            log.info(() -> "Running of unit test " + context.getRequiredTestMethod() + " took: "
                    + total_local_run_time  + " milliseconds");

            Long totalTime = (Long) context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).get(StoreConstants.TOTAL_TIME);

            long total_time = 0l;

            if(totalTime != null)
                total_time = totalTime;

            total_time += total_local_run_time;

            context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put(StoreConstants.TOTAL_TIME, total_time);

        } catch(Exception ex) {

            log.error(() -> "Unable to process method run time: " + ex.getMessage());

        }

    }

}