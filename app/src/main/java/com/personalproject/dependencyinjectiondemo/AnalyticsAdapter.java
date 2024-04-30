package com.personalproject.dependencyinjectiondemo;

import android.util.Log;

import javax.inject.Inject;

public class AnalyticsAdapter {

    private static final String TAG = "MyAnalyticsAdapter";

    private final AnalyticsService service;

    @Inject
    AnalyticsAdapter(AnalyticsService service) {
        Log.i(TAG, "AnalyticsAdapter constructor");
        this.service = service;
    }
}
