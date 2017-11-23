package com.napier.rpm.web.support;

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
 * @author NAP1051
 */
@Component("panicAlerter")
public class ClientScriptCaller implements InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientScriptCaller.class);
  /*  client.alerter.page.url=/
    		client.alerter.page.function=panicAlertSounded
    		client.alerter.scheduler.initialdelay=1
    		client.alerter.scheduler.period=10
    		client.alerter.scheduler.nothreads=1*/
    private ScheduledThreadPoolExecutor executor; 
    
    private String pushMessagePage="/";
    //@Value("${client.alerter.page.function}")
    private String clientFunctionName="panicAlertSounded";
    //@Value("${client.alerter.scheduler.initialdelay}")
    private int initialDelay=1;
    //@Value("${client.alerter.scheduler.period}")
    private int period=10;
    //@Value("${client.alerter.scheduler.nothreads}")
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
