package agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
* @Description:    JavaAgent
* @Author:         wangbang
* @CreateDate:     2019-08-20
*/
public class AgentMain {
    public static void premain(String agentOps, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.named("org.springframework.web.servlet.DispatcherServlet"))
                .transform((builder, type, classLoader, module) ->
                        builder.method(ElementMatchers.named("doDispatch"))
                                .intercept(MethodDelegation.to(DoDispatchInterceptor.class)))
                .installOn(instrumentation);
    }
}

