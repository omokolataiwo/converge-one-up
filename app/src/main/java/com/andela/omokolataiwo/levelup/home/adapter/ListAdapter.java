package com.andela.omokolataiwo.levelup.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andela.omokolataiwo.levelup.R;
import com.andela.omokolataiwo.levelup.contract.RecyclerItemClickListener;
import com.andela.omokolataiwo.levelup.home.models.GithubProfile;
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
   * Recycler Item Click Listener.
   */
  private final RecyclerItemClickListener recyclerItemClickListener;

  /**
   * ListAdapter constructor.
   *
   * @param itemList                  Item from Github response
   * @param recyclerItemClickListener the recycler item click listener
   */
  public ListAdapter(List<GithubProfile> itemList,
                     RecyclerItemClickListener recyclerItemClickListener) {
    this.userProfilesDataSet = itemList;
    this.recyclerItemClickListener = recyclerItemClickListener;
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
    final GithubProfile itemList = userProfilesDataSet.get(position);
    final String username = itemList.getLogin();
    final String profileImage = itemList.getAvatarUrl();

    holder.usernameTextView.setText(username);

    Picasso.get().load(profileImage)
      .placeholder(R.drawable.developer_default_img)
      .into(holder.profilePictureImageView);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        recyclerItemClickListener.onItemClick(itemList);
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
