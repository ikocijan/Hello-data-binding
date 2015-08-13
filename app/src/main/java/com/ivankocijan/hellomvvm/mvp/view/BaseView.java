package com.ivankocijan.hellomvvm.mvp.view;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public interface BaseView {

    void showLoader();

    void hideLoader();

    void showMessage(String message);

}
