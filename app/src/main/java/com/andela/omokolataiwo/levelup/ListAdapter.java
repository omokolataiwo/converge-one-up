package com.andela.omokolataiwo.levelup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ItemList> userProfilesDataSet;
    private Context context;

    public ListAdapter(List<ItemList> itemList, Context context) {
        this.userProfilesDataSet = itemList;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemList itemList = userProfilesDataSet.get(position);
        holder.usernameTextView.setText(itemList.getUsername());
        Picasso.get().load(itemList.getProfilePicture()).into(holder.profilePictureImageView);
    }

    @Override
    public int getItemCount() {
        return userProfilesDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView profilePictureImageView;
        public TextView usernameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            profilePictureImageView = (CircleImageView) itemView.findViewById(R.id.imageView);
            usernameTextView = itemView.findViewById(R.id.username);
        }
    }
}
