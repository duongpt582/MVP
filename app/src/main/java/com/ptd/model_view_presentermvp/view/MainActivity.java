package com.ptd.model_view_presentermvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ptd.model_view_presentermvp.LoginInterface;
import com.ptd.model_view_presentermvp.presenter.LoginPresenter;
import com.ptd.model_view_presentermvp.R;
import com.ptd.model_view_presentermvp.model.User;

public class MainActivity extends AppCompatActivity implements LoginInterface {

    private TextView tvMessage;
    private EditText etEmail, etPassword;
    private Button btLogin;
    private ProgressBar progressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        progressBar.setVisibility(View.GONE);

        mLoginPresenter = new LoginPresenter(this, MainActivity.this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });

    }

    @Override
    public void loginSuccess() {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText("Login success!!!");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginError() {
        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText("Login error!!!");
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    private void clickLogin() {

        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        User user = new User(email, password);

        mLoginPresenter.login(user);
    }

    private void mapping() {
        tvMessage = findViewById(R.id.tv_message);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);
        progressBar = findViewById(R.id.pb_load_content);
    }
}