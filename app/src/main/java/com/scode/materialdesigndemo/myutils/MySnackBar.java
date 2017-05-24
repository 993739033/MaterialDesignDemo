package com.scode.materialdesigndemo.myutils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by 知らないのセカイ on 2017/5/24.
 */

public class MySnackBar {
    private static Snackbar snackbar;

    public static void show(View view, String msg) {
        snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT);
        snackbar.setAction("enter", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
}
