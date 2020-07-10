package com.softsquared.template.src.main.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;
import com.softsquared.template.src.main.notice.NoticeActivity;
import com.softsquared.template.src.main.noticePost.NoticePostActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFavoriteCommunityAdapter extends RecyclerView.Adapter<HomeFavoriteCommunityAdapter.CommuViewHolder> {

    private String num;
    private ArrayList<FavoriteCommunityInfo> communityResponseArrayList = new ArrayList<>();

    private HomeFragment homeFragment;

    public HomeFavoriteCommunityAdapter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public CommuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_favorite_community, parent, false);
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

        void setting(final FavoriteCommunityInfo favoriteCommunityInfo)
        {

            commuName.setText(favoriteCommunityInfo.getNoticeName());
            commuArticle.setText(favoriteCommunityInfo.getContentTitle());
            switch (favoriteCommunityInfo.getCheckNew())
            {
                case "new":
                {
                    commuRecent.setVisibility(View.VISIBLE);
                    break;
                }
                case "0":
                {
                    commuRecent.setVisibility(View.INVISIBLE);
                    break;
                }
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(itemView.getContext(), NoticeActivity.class);
                    intent.putExtra("noticeIdx", favoriteCommunityInfo.getNoticeIdx());
                    Log.e("noticeIdx", "" +favoriteCommunityInfo.getNoticeIdx());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
