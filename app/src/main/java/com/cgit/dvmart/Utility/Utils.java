package com.cgit.dvmart.Utility;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class Utils {

    public static void showDialog(Context context, String title, String message){
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK",((dialog, which) -> dialog.dismiss())).create().show();
    }
}
