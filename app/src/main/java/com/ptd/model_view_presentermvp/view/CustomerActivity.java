package com.ptd.model_view_presentermvp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ptd.model_view_presentermvp.R;
import com.ptd.model_view_presentermvp.model.User;
import com.ptd.model_view_presentermvp.presenter.ShowListPresenter;

public class CustomerActivity extends AppCompatActivity {

    private ShowListPresenter mShowListPresenter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customer);

        Intent intent = getIntent();

        if (intent != null) {
            user = (User) intent.getSerializableExtra("EXTRA_USER");

            // quy trình xử lý
            // Activity get data --> send to Fragment --> send to Presenter for processing.
            ListCustomerFragment listCustomerFragment = ListCustomerFragment.newInstance(user);
            getSupportFragmentManager().beginTransaction().replace(R.id.fm_show_list, listCustomerFragment).commit();
        }





    }
}