package com.ivankocijan.hellomvvm.activities;

import com.ivankocijan.hellomvvm.R;
import com.ivankocijan.hellomvvm.mvp.view.BaseView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pd = new ProgressDialog(this);
        pd.setMessage(getString(R.string.please_wait));
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

    }

    @Override
    public void showLoader() {
        pd.show();
    }

    @Override
    public void hideLoader() {
        pd.hide();
    }

    @Override
    public void showMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name))
                .setMessage(message)
                .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }
}
