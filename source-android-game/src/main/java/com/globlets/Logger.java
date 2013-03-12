package com.globlets;

import android.util.Log;

public class Logger {
    private static void info(String tag, String message) {
        Log.i(tag, message);
    }

    private final String tagName;

    private Logger(Class<?> clazz) {
        tagName = clazz.getCanonicalName();
    }

    public static Logger forClass(Class<?> clazz) {
        return new Logger(clazz);
    }

    public void enter(String method) {
        info(tagName, "::" + method + " enter");
    }

    public void touch(String method) {
        info(tagName, "::" + method + " touch");
    }

    public void leave(String method) {
        info(tagName, "::" + method + " leave");
    }

    public void info(String message) {
        info(tagName, message);
    }
}
