package com.andela.omokolataiwo.levelup.contract;

import com.andela.omokolataiwo.levelup.home.models.GithubProfile;

/**
 * The interface Recycler item click listener.
 */
public interface RecyclerItemClickListener {
  /**
   * On item clicked.
   *
   * @param githubProfile the github profile
   */
  void onItemClick(GithubProfile githubProfile);
}
