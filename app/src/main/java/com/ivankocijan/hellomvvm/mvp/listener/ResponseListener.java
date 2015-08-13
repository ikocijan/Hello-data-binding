package com.ivankocijan.hellomvvm.mvp.listener;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 12.08.15.
 */
public interface ResponseListener <T>{

    void onSuccess(T response);

    void onError(String error);
}
