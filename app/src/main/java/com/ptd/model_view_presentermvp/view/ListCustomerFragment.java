package com.ptd.model_view_presentermvp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ptd.model_view_presentermvp.KeyValue;
import com.ptd.model_view_presentermvp.R;
import com.ptd.model_view_presentermvp.model.User;
import com.ptd.model_view_presentermvp.presenter.ShowListPresenter;


public class ListCustomerFragment extends Fragment {

    private ShowListPresenter mShowListPresenter;
    private RecyclerView rvShowData;
    private static User mUser;

    public ListCustomerFragment() {
        // Required empty public constructor
    }

    public static ListCustomerFragment newInstance(User user) {
        Log.d("test2", "newInstance: user" + user.getEmail());
        ListCustomerFragment fragment = new ListCustomerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KeyValue.BUNDLE_USER, user);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mUser = (User) bundle.getSerializable(KeyValue.BUNDLE_USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_customer, container, false);

        rvShowData = view.findViewById(R.id.rv_show_data);

        decorItemRecyclerView();

        sendDataToPresenter();

        return view;
    }

    private void decorItemRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);

        rvShowData.setLayoutManager(linearLayoutManager);
        rvShowData.addItemDecoration(dividerItemDecoration);
    }

    private void sendDataToPresenter() {
        // get data from Fragment --> send to Presenter for processing
        if (mUser != null) {
            mShowListPresenter = new ShowListPresenter(getActivity(), mUser, rvShowData);
            mShowListPresenter.processData();
        } else {
            Log.d("test", "onCreateView: null");
        }
    }
}