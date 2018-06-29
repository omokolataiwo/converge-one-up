package com.andela.omokolataiwo.levelup;

import android.content.Context;
import android.content.Intent;
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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
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
        final String username = itemList.getUsername();
        final String profileImage = itemList.getProfilePicture();

        holder.usernameTextView.setText(username);
        Picasso.get().load(profileImage).into(holder.profilePictureImageView);

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("USER_NAME", username);
                intent.putExtra("PROFILE_IMAGE", profileImage);
                context.startActivity(intent);
            }
        });
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
            profilePictureImageView = itemView.findViewById(R.id.img_user_profile);
            usernameTextView = itemView.findViewById(R.id.tv_username);
        }
    }
}
