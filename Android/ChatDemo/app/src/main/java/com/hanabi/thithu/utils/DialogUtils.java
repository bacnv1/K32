package com.hanabi.thithu.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtils {
    private static ProgressDialog dialog;

    public static void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static void show(Context context) {
        dismiss();
        dialog = new ProgressDialog(context);
        dialog.setMessage("Loading...");
    }
}
