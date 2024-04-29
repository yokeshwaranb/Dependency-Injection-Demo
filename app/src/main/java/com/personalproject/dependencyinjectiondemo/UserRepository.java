package com.personalproject.dependencyinjectiondemo;

import android.util.Log;

import retrofit2.Retrofit;

class UserLocalDataSource {
    public UserLocalDataSource() {
        Log.i("UserLocalDataSource", "UserLocalDataSource Constructor");
    }
}

class UserRemoteDataSource {

    private final Retrofit retrofit;

    public UserRemoteDataSource(Retrofit retrofit) {
        Log.i("UserRemoteDataSource", "UserRemoteDataSource Constructor");
        this.retrofit = retrofit;
    }
}

class UserRepository {

    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

    public UserRepository(UserLocalDataSource userLocalDataSource, UserRemoteDataSource userRemoteDataSource) {
        Log.i("UserRepository", "UserRepository Constructor");
        this.userLocalDataSource = userLocalDataSource;
        this.userRemoteDataSource = userRemoteDataSource;
    }
}
