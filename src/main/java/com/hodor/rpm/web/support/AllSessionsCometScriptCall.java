package com.hodor.rpm.web.support;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class AllSessionsCometScriptCall<T> extends CometScriptCall<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllSessionsCometScriptCall.class);

    public AllSessionsCometScriptCall(String clientFunctionName) {
        super(clientFunctionName);
    }

    @Override
    public void run() {

        try {
            Browser.withAllSessions(new Runnable() {
                @Override
                public void run() {
                    T[] elements;
                    while ((elements = queue.poll()) != null) {
                        ScriptSessions.addFunctionCall(CLIENT_FUNCTION_NAME, elements);
                    }
                }
            });
        } catch (Exception ex) {
            LOGGER.error("Error when firing script call: " + CLIENT_FUNCTION_NAME, ex);
        }
    }
}
