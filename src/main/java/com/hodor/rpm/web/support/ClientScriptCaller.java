package com.hodor.rpm.web.support;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 */
@Component("panicAlerter")
public class ClientScriptCaller implements InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientScriptCaller.class);
    private ScheduledThreadPoolExecutor executor; 
    
    private String clientFunctionName="panicAlertSounded";
    private int initialDelay=1;
    private int period=10;
    private int noScheduledThreads=1;
    private AllSessionsCometScriptCall<String> messageExecutor;

    public ClientScriptCaller() {
        LOGGER.debug("** ClientScriptCaller()");
    }

    @Override
    public void afterPropertiesSet() {
        LOGGER.debug(">> ClientScriptCaller created and initialized. Creating scheduled executor");
        messageExecutor = new AllSessionsCometScriptCall<String>(clientFunctionName);
        executor = new ScheduledThreadPoolExecutor(noScheduledThreads);
        executor.scheduleAtFixedRate(messageExecutor, initialDelay, period, TimeUnit.SECONDS);
    }

    @Override
    public void destroy() {
        LOGGER.debug(">> destroying scheduled executor");
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            LOGGER.warn("Thread interrupted when executor was shutting down.", ex);
        }
    }

    public <T> void addMessage(String[] functionArguments) {
        Assert.notNull(functionArguments);
        Assert.notNull(messageExecutor);
        messageExecutor.addMessage(functionArguments);
    }

}
