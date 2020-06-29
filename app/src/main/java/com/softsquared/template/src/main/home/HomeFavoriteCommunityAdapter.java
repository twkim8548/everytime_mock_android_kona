package com.softsquared.template.src.main.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFavoriteCommunityAdapter extends RecyclerView.Adapter<HomeFavoriteCommunityAdapter.CommuViewHolder> {

    private ArrayList<FavoriteCommunityResponse> communityResponseArrayList = new ArrayList<>();

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

    public void add(FavoriteCommunityResponse favoriteCommunityResponse) {communityResponseArrayList.add(favoriteCommunityResponse);}

    public void clear() {communityResponseArrayList.clear();}


    public class CommuViewHolder extends RecyclerView.ViewHolder{
        private TextView commuName;
        private TextView commuArticle;

        public CommuViewHolder(@NonNull View itemView) {
            super(itemView);
            commuName = itemView.findViewById(R.id.favorite_community_name);
            commuArticle = itemView.findViewById(R.id.favorite_community_article);
        }

        void setting(FavoriteCommunityResponse favoriteCommunityResponse)
        {
            commuName.setText(favoriteCommunityResponse.getCommuName());
            commuArticle.setText(favoriteCommunityResponse.getCommuArticle());
        }
    }
}
