package com.ptd.model_view_presentermvp.presenter;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import com.ptd.model_view_presentermvp.ShowDataAdapter;
import com.ptd.model_view_presentermvp.model.User;
import com.ptd.model_view_presentermvp.view.ListCustomerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *  show all content for Fragment and Activity
 */
public class ShowListPresenter {
    private RecyclerView rvContent;
    private Context context;
    private User user;
    private List<User> listUser = new ArrayList<>();

    public ShowListPresenter(Context context, User user, RecyclerView rvContent) {
        this.context = context;
        this.user = user;
        this.rvContent = rvContent;
    }

    public void processData() {
        addData();
        ShowDataAdapter adapter = new ShowDataAdapter(listUser);
        rvContent.setAdapter(adapter);
    }

    private void addData() {
        for (int i = 1; i <= 50; i++) {
            listUser.add(new User(user.getEmail(), user.getPassword(), "Pham Thai Duong " + i, 21+i));
        }
    }

}
