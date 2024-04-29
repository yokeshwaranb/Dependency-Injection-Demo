package com.personalproject.dependencyinjectiondemo;

import android.util.Log;

import retrofit2.Retrofit;

class UserLocalDataSource {
    public UserLocalDataSource() {
        Log.i("MyUserLocalDataSource", "UserLocalDataSource Constructor");
    }
}

class UserRemoteDataSource {

    private final Retrofit retrofit;

    public UserRemoteDataSource(Retrofit retrofit) {
        Log.i("MyUserRemoteDataSource", "UserRemoteDataSource Constructor");
        this.retrofit = retrofit;
    }
}

class UserRepository {

    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

    public UserRepository(UserLocalDataSource userLocalDataSource, UserRemoteDataSource userRemoteDataSource) {
        Log.i("MyUserRepository", "UserRepository Constructor");
        this.userLocalDataSource = userLocalDataSource;
        this.userRemoteDataSource = userRemoteDataSource;
    }
}
