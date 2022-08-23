package com.ptd.model_view_presentermvp.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ptd.model_view_presentermvp.LoginInterface;
import com.ptd.model_view_presentermvp.model.User;
import com.ptd.model_view_presentermvp.view.CustomerActivity;


public class LoginPresenter {

    private LoginInterface mLoginInterface;
    private Context context;

    public LoginPresenter(LoginInterface mLoginInterface, Context context) {
        this.mLoginInterface = mLoginInterface;
        this.context = context;
    }

    public void login(User user) {
        // if else này là làm việc với Model để quyết định hiện lên View.
        if (user.isValidEmail()) {
            if (user.isValidPassword()) {
                mLoginInterface.loginSuccess();  // làm việc với interface để kết nối đến View

                Intent intent = new Intent(context, CustomerActivity.class);
                intent.putExtra("EXTRA_USER", user);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        //do something
                        context.startActivity(intent);
                        mLoginInterface.hideProgressBar();
                    }
                }, 1500 );//time in milisecond


            } else {
                mLoginInterface.loginError();
            }
        } else {
            mLoginInterface.loginError();
        }
    }
}
