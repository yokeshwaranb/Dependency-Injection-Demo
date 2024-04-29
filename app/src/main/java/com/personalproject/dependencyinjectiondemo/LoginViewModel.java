package com.personalproject.dependencyinjectiondemo;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public LoginViewModel(UserRepository userRepository) {
        Log.i("MyLoginViewModel", "LoginViewModel Constructor");
    }
}

// Definition of a Factory interface with a function to create objects of a type
interface Factory<T> {
    T create();
}

// Factory for LoginViewModel.
// Since LoginViewModel depends on UserRepository, in order to create instances of
// LoginViewModel, you need an instance of UserRepository that you pass as a parameter.
class LoginViewModelFactory implements Factory {

    UserRepository userRepository;

    public LoginViewModelFactory(UserRepository userRepository) {
        Log.i("MyLoginViewModelFactory", "LoginViewModelFactory constructor");
        this.userRepository = userRepository;
    }

    @Override
    public LoginViewModel create() {
        Log.i("MyLoginViewModelFactory", "LoginViewModel create()");
        return new LoginViewModel(userRepository);
    }
}
