package tech.getrealgood.util.ext;

import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

public class InvokeTwiceInvocationContext implements TestTemplateInvocationContext {

    @Override
    public String getDisplayName(int invocationIndex) {
        return "Run # " + invocationIndex;
    }
}