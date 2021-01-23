package tech.getrealgood.util.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestInvocationInterceptor implements InvocationInterceptor {

    private static final Logger log = LoggerFactory.getLogger(TestInvocationInterceptor.class);

    @Override
    public <T> T interceptTestClassConstructor(Invocation<T> invocation, ReflectiveInvocationContext<Constructor<T>>
            invocationContext, ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting constructor for " + invocationContext.getTargetClass().getName());

        return invocation.proceed();

    }

    @Override
    public void interceptBeforeAllMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext,
                                         ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting " + invocationContext.getExecutable().getName());

        invocation.proceed();

    }

    @Override
    public void interceptBeforeEachMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext,
                                          ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting " + invocationContext.getExecutable().getName());

        invocation.proceed();

    }

    @Override
    public void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting " + invocationContext.getExecutable().getName());

        invocation.proceed();

    }

    @Override
    public <T> T interceptTestFactoryMethod(Invocation<T> invocation, ReflectiveInvocationContext<Method> invocationContext,
                                            ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting " + invocationContext.getExecutable().getName());

        return invocation.proceed();

    }

    @Override
    public void interceptTestTemplateMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext,
                                            ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting " + invocationContext.getExecutable().getName());

        invocation.proceed();

    }

    @Override
    public void interceptDynamicTest(Invocation<Void> invocation, ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting a dynamic test: " + invocation.toString());


        invocation.proceed();


    }

    @Override
    public void interceptAfterEachMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method>
            invocationContext, ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting " + invocationContext.getExecutable().getName());

        invocation.proceed();


    }

    @Override
    public void interceptAfterAllMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method>
            invocationContext, ExtensionContext extensionContext) throws Throwable {

        log.info(() -> "Intercepting " + invocationContext.getExecutable().getName());

        invocation.proceed();

    }
}