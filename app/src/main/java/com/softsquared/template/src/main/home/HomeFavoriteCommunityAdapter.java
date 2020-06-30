package com.softsquared.template.src.main.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFavoriteCommunityAdapter extends RecyclerView.Adapter<HomeFavoriteCommunityAdapter.CommuViewHolder> {

    private ArrayList<FavoriteCommunityInfo> communityResponseArrayList = new ArrayList<>();

    @NonNull
    @Override
    public CommuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_favorite_community_listview, parent, false);
        return new HomeFavoriteCommunityAdapter.CommuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommuViewHolder holder, int position) {
        holder.setting(communityResponseArrayList.get(position));

    }

    @Override
    public int getItemCount() { return communityResponseArrayList.size(); }

    public void add(FavoriteCommunityInfo favoriteCommunityInfo) {communityResponseArrayList.add(favoriteCommunityInfo);}

    public void clear() {communityResponseArrayList.clear();}


    public class CommuViewHolder extends RecyclerView.ViewHolder{
        private TextView commuName;
        private TextView commuArticle;
        private ImageView commuRecent;

        public CommuViewHolder(@NonNull View itemView) {
            super(itemView);
            commuName = itemView.findViewById(R.id.favorite_community_name);
            commuArticle = itemView.findViewById(R.id.favorite_community_article);
            commuRecent = itemView.findViewById(R.id.favorite_community_new);
        }

        void setting(FavoriteCommunityInfo favoriteCommunityInfo)
        {
            commuName.setText(favoriteCommunityInfo.getFav_commu_name());
            commuArticle.setText(favoriteCommunityInfo.getFav_commu_article());
            switch (favoriteCommunityInfo.getFav_commu_recent())
            {
                case "new":
                {
                    commuRecent.setVisibility(View.VISIBLE);
                    break;
                }
                case "x":
                {
                    commuRecent.setVisibility(View.INVISIBLE);
                    break;
                }
            }
        }
    }
}
