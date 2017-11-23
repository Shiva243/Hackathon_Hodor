package com.napier.rpm.web.support;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author NAP1051
 * @param <T>
 */
public abstract class CometScriptCall<T> implements Runnable {

    protected final String CLIENT_FUNCTION_NAME;

    protected final ConcurrentLinkedQueue<T[]> queue = new ConcurrentLinkedQueue<T[]>();

    public CometScriptCall(String clientFunctionName) {
        this.CLIENT_FUNCTION_NAME = clientFunctionName;
    }

    public void addMessage(T[] t) {
        queue.add(t);
    }

}
