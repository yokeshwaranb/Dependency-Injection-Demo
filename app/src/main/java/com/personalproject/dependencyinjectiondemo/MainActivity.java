package com.personalproject.dependencyinjectiondemo;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyMainActivity";

    private LoginViewModel loginViewModel;
    private AppContainer appContainer;
    private LoginUserData loginData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i(TAG, "onCreate. Login flow has started. Populate loginContainer in AppContainer");

        appContainer = ((MyApplication) getApplication()).appContainer;

        // Login flow has started. Populate loginContainer in AppContainer
        appContainer.loginContainer = new LoginContainer(appContainer.userRepository);

        loginViewModel = appContainer.loginContainer.loginViewModelFactory.create();
        loginData = appContainer.loginContainer.loginData;
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy. Removing the instance of loginContainer in the AppContainer");
        // Login flow is finishing
        // Removing the instance of loginContainer in the AppContainer
        appContainer.loginContainer = null;

        super.onDestroy();
    }
}