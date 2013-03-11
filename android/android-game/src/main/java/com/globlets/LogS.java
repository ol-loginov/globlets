package com.globlets;

import android.util.Log;

public class LogS {
    private static String TAG = "globlets-android-game";

    public static void info(String message) {
        Log.i(TAG, message);
    }
}
