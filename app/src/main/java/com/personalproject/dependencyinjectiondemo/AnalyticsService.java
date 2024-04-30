package com.personalproject.dependencyinjectiondemo;

import android.util.Log;

import java.io.ObjectStreamException;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

public interface AnalyticsService {
    void analyticsMethods();
}

// Constructor-injected, because Hilt needs to know how to
// provide instances of AnalyticsServiceImpl, too.
class AnalyticsServiceImpl implements AnalyticsService {

    private static final String TAG = "AnalyticsServiceImpl";

    @Inject
    AnalyticsServiceImpl() {
        Log.i(TAG, "AnalyticsServiceImpl constructor");
    }

    @Override
    public void analyticsMethods() {
        Log.i(TAG, "AnalyticsServiceImpl analyticsMethods()");
        // Do some analytics
    }
}

