package com.personalproject.dependencyinjectiondemo;

import android.util.Log;

import retrofit2.Retrofit;

// Container with Login-specific dependencies
class LoginContainer {

    private final UserRepository userRepository;

    public LoginContainer(UserRepository userRepository) {
        Log.i("MyLoginContainer", "LoginContainer Constructor");
        this.userRepository = userRepository;
        loginViewModelFactory = new LoginViewModelFactory(userRepository);
    }

    public LoginUserData loginData = new LoginUserData();

    public LoginViewModelFactory loginViewModelFactory;


}

class LoginUserData {
}

// Container of objects shared across the whole app
public class AppContainer {

    // Since you want to expose userRepository out of the container, you need to satisfy
    // its dependencies as you did before
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://example.com")
            .build();

    private UserRemoteDataSource remoteDataSource = new UserRemoteDataSource(retrofit);
    private UserLocalDataSource localDataSource = new UserLocalDataSource();

    // userRepository is not private; it'll be exposed
    public UserRepository userRepository = new UserRepository(localDataSource, remoteDataSource);

    // LoginContainer will be null when the user is NOT in the login flow
    public LoginContainer loginContainer;
}
