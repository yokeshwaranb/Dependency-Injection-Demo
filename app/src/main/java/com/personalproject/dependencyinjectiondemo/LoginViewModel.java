package com.personalproject.dependencyinjectiondemo;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public LoginViewModel(UserRepository userRepository) {
        Log.i("LoginViewModel", "LoginViewModel Constructor");
    }
}
