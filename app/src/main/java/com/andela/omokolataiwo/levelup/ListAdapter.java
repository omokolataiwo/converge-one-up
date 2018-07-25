package com.andela.omokolataiwo.levelup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andela.omokolataiwo.levelup.models.GithubProfile;
import com.andela.omokolataiwo.levelup.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * ListAdapter populate the recycler view base on response from github API.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    /**
     * User profile from Github.
     */
    private final List<GithubProfile> userProfilesDataSet;

    /**
     * ListAdapter constructor.
     *
     * @param itemList Item from Github response
     */
    public ListAdapter(List<GithubProfile> itemList) {
        this.userProfilesDataSet = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GithubProfile itemList = userProfilesDataSet.get(position);
        final String username = itemList.getLogin();
        final String profileImage = itemList.getAvatarUrl();
        final String profileUrl = itemList.getHtmlUrl();

        holder.usernameTextView.setText(username);
        Picasso.get().load(profileImage).into(holder.profilePictureImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("profile image", profileImage);
                intent.putExtra("profile url", profileUrl);

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userProfilesDataSet.size();
    }

    /**
     * Update recycler view components.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * Profile image view.
         */
        public CircleImageView profilePictureImageView;
        /**
         * Username text view.
         */
        public TextView usernameTextView;

        /**
         * Constructor.
         *
         * @param itemView An Item
         */
        public ViewHolder(View itemView) {
            super(itemView);
            profilePictureImageView = itemView.findViewById(R.id.img_user_profile);
            usernameTextView = itemView.findViewById(R.id.tv_username);
        }
    }
}
