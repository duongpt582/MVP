package com.ptd.model_view_presentermvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptd.model_view_presentermvp.model.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowDataAdapter extends RecyclerView.Adapter<ShowDataAdapter.MyViewHolder> {

    private List<User> userList = new ArrayList<>();

    public ShowDataAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(userList.get(position).getName());
        holder.tvAge.setText(""+userList.get(position).getAge());
        holder.tvEmail.setText(userList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvAge, tvEmail;
        private CircleImageView ivAvt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);
            ivAvt = itemView.findViewById(R.id.iv_avt);
            tvEmail = itemView.findViewById(R.id.tv_email);

        }
    }
}
