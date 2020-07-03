package com.softsquared.template.src.main.community.entire;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softsquared.template.R;
import com.softsquared.template.src.main.MainActivity;
import com.softsquared.template.src.main.community.CommunityPinAdapter;
import com.softsquared.template.src.main.community.CommunityService;
import com.softsquared.template.src.main.community.interfaces.PinActivityView;
import com.softsquared.template.src.main.community.models.PinInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EntireFragment extends Fragment implements PinActivityView {


    private MainActivity mainActivity;
    private Context context;
    private ViewGroup viewGroup;
    private CommunityPinAdapter communityPinAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup =(ViewGroup) inflater.inflate(R.layout.item_community_entire, container, false);

        pinSet();;
        return  viewGroup;
    }

    public void pinSet()
    {
        communityPinAdapter = new CommunityPinAdapter();
        RecyclerView pinRecyclerView = viewGroup.findViewById(R.id.pin_community_recyclerview);
        pinRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pinRecyclerView.setAdapter(communityPinAdapter);
    }

    @Override
    public void onSuccessGetPin(PinInfo pinInfo) {



    }

    @Override
    public void onFailureGetPin() {

    }
}
