package com.softsquared.template.src.main.community;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.community.entire.EntireFragment;
import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.notice.NoticeActivity;

import java.util.ArrayList;
import java.util.Comparator;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CommunityPinAdapter extends RecyclerView.Adapter<CommunityPinAdapter.PinViewholder> {

    private ArrayList<PinInfo> pinInfoArrayList = new ArrayList<>();

    public CommunityPinAdapter(EntireFragment entireFragment) {
        this.entireFragment = entireFragment;
    }

    private EntireFragment entireFragment;


    @NonNull
    @Override
    public PinViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pin_community_recyclerview, parent, false);
        return new PinViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PinViewholder holder, int position) {
        holder.bind(pinInfoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return pinInfoArrayList.size();
    }

    public void add(PinInfo pinInfo) {pinInfoArrayList.add(pinInfo);}

    public void clear() {pinInfoArrayList.clear();}




    public class PinViewholder extends RecyclerView.ViewHolder{
        ImageView pinImg;
        TextView pinNoticeName;
        ImageView pinNew;
        ConstraintLayout pinConst;

        public PinViewholder(@NonNull View itemView) {
            super(itemView);
            pinImg = itemView.findViewById(R.id.pin_community_img);
            pinNoticeName = itemView.findViewById(R.id.pin_community_tv);
            pinNew = itemView.findViewById(R.id.pin_community_new);
        }

        void bind(final PinInfo pinInfo)
        {
            pinNoticeName.setText(pinInfo.getNoticeName());
            switch (pinInfo.getCheckNew())
            {
                case "new":
                {
                    pinNew.setVisibility(View.VISIBLE);
                    break;
                }
                case "0":
                {
                    pinNew.setVisibility(View.INVISIBLE);
                    break;
                }
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(itemView.getContext(), NoticeActivity.class);
                    intent.putExtra("noticeIdx", pinInfo.getNoticeIdx());
                    Log.e("noticeIdx", "" +pinInfo.getNoticeIdx());
                    itemView.getContext().startActivity(intent);
                }
            });
        }


    }
}
