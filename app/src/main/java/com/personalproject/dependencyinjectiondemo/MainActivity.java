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

    private static final String TAG = "MainActivity";

    private LoginViewModel loginViewModel;

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

        Log.i(TAG, "onCreate");

        // In order to satisfy the dependencies of LoginViewModel, you have to also
        // satisfy the dependencies of all of its dependencies recursively.
        // First, create retrofit which is the dependency of UserRemoteDataSource
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://example.com")
                .build();

        // Then, satisfy the dependencies of UserRepository
        UserRemoteDataSource remoteDataSource = new UserRemoteDataSource(retrofit);
        UserLocalDataSource localDataSource = new UserLocalDataSource();

        // Now you can create an instance of UserRepository that LoginViewModel needs
        UserRepository userRepository = new UserRepository(localDataSource, remoteDataSource);

        // Lastly, create an instance of LoginViewModel with userRepository
        loginViewModel = new LoginViewModel(userRepository);
    }
}