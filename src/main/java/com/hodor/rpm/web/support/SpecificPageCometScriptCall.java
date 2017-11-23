package com.hodor.rpm.web.support;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class SpecificPageCometScriptCall<T> extends CometScriptCall<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpecificPageCometScriptCall.class);
    private final String PAGE_URL;

    public SpecificPageCometScriptCall(String clientFunctionName, String pageUrl) {
        super(clientFunctionName);
        this.PAGE_URL = pageUrl;
    }

    @Override
    public void run() {
        try {
            ServerContext context = ServerContextFactory.get();
            String page = context.getContextPath() + PAGE_URL;
            Browser.withPage(page, new Runnable() {
                @Override
                public void run() {
                    T[] elements;
                    while ((elements = queue.poll()) != null) {
                        ScriptSessions.addFunctionCall(CLIENT_FUNCTION_NAME, elements);
                    }
                }
            });
        } catch (Exception ex) {
            LOGGER.error("Error when firing script call for page: " + PAGE_URL, ex);
            //Do we want to do anything more like setting flags in db so that we can pull it later and fire again
        }
    }

}
