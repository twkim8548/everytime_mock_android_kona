package com.softsquared.template.src.main.home;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.home.models.HotContentInfo;
import com.softsquared.template.src.main.home.models.RealtimeInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRealtimeAdapter extends RecyclerView.Adapter<HomeRealtimeAdapter.RealtimeViewholder> {

    private ArrayList<RealtimeInfo> realtimeInfoArrayList = new ArrayList<>();

    private HomeFragment homeFragment;
    private Context context;

    public HomeRealtimeAdapter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public RealtimeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_realtime, parent, false);
        return new HomeRealtimeAdapter.RealtimeViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RealtimeViewholder holder, int position) {
        holder.setting(realtimeInfoArrayList.get(position));
    }



    @Override
    public int getItemCount() {
        return realtimeInfoArrayList.size();
    }

    public void add(RealtimeInfo realtimeInfo) {realtimeInfoArrayList.add(realtimeInfo);}

    public void clear() {realtimeInfoArrayList.clear();}

    public class RealtimeViewholder extends RecyclerView.ViewHolder {

        private TextView homeRealtimeWriterTv;
        private TextView homeRealtimeContentTv;
        private TextView homeRealtimeCommuTv;
        private TextView homeRealtimeDateTv;
        private TextView homeRealtimeCommentTv;
        private TextView homeRealtimeGoodTv;

        public RealtimeViewholder(@NonNull View itemView) {
            super(itemView);
            homeRealtimeWriterTv = itemView.findViewById(R.id.home_realtime_writer_tv);
            homeRealtimeContentTv = itemView.findViewById(R.id.home_realtime_content_tv);
            homeRealtimeCommuTv = itemView.findViewById(R.id.home_realtime_content_community);
            homeRealtimeDateTv = itemView.findViewById(R.id.home_realtime_date);
            homeRealtimeCommentTv = itemView.findViewById(R.id.home_realtime_comment_tv);
            homeRealtimeGoodTv = itemView.findViewById(R.id.home_realtime_good_tv);
        }

        void setting(RealtimeInfo realtimeInfo)
        {
            homeRealtimeWriterTv.setText(realtimeInfo.getContentWriter());
            homeRealtimeContentTv.setText(realtimeInfo.getContentTitle());
            homeRealtimeCommuTv.setText(realtimeInfo.getContentInf());
            homeRealtimeDateTv.setText(realtimeInfo.getWriteDay());
            homeRealtimeCommentTv.setText(String.valueOf(realtimeInfo.getCountComment()));
            homeRealtimeGoodTv.setText(String.valueOf(realtimeInfo.getCountLike()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
