package com.softsquared.template.src.main.community;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.community.models.PinInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommunityPinAdapter extends RecyclerView.Adapter<CommunityPinAdapter.PinViewholder> {

    private ArrayList<PinInfo> pinInfoArrayList = new ArrayList<>();

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
        TextView pinNoticeName;

        public PinViewholder(@NonNull View itemView) {
            super(itemView);
            pinNoticeName = itemView.findViewById(R.id.pin_community_tv);
        }

        void bind(PinInfo pinInfo)
        {
            pinNoticeName.setText(pinInfo.getNoticeName());
        }
    }
}
