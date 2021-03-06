package com.eldhopj.socialmedialogins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    FirebaseAuth mAuth;
    LoginManager loginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        loginManager = LoginManager.getInstance();
    }

    public void logout(View view) {
        loginManager.logOut(); // Login out facebook
        mAuth.signOut();
        if (mAuth.getCurrentUser() == null) {
            mainActivityIntent();
        }

    }

    private void mainActivityIntent() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
