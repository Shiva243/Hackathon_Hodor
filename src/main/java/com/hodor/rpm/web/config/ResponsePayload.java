package com.hodor.rpm.web.config;

/**
 * @author nap0640
 *
 * @param <T>
 */
public class ResponsePayload<T> {

    private T data;
    private int appStatus;

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the appStatus
     */
    public int getAppStatus() {
        return appStatus;
    }

    /**
     * @param appStatus the appStatus to set
     */
    public void setAppStatus(int appStatus) {
        this.appStatus = appStatus;
    }

}
