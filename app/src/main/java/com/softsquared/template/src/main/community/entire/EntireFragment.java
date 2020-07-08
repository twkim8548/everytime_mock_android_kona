package com.softsquared.template.src.main.community.entire;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.MainActivity;
import com.softsquared.template.src.main.community.CommunityPinAdapter;
import com.softsquared.template.src.main.community.CommunityService;
import com.softsquared.template.src.main.community.interfaces.CommunityActivityView;
import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.community.models.PinPostResult;
import com.softsquared.template.src.main.community.models.PinResponse;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;

import java.util.Comparator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.softsquared.template.src.ApplicationClass.sSharedPreferences;

public class EntireFragment extends Fragment implements CommunityActivityView {


    private MainActivity mainActivity;
    private Context context;
    private ViewGroup viewGroup;
    private CommunityPinAdapter communityPinAdapter;
    private GridLayoutManager gridLayoutManager;
    private CommunityService communityService;
    private PinResponse pinResponse;
    private PinInfo pinInfo;
    private CommunityPinAdapter.PinViewholder pinViewholder;
    private PinPostResult pinPostResult;
    private ConstraintLayout entireClassReviewConst;

    private ImageView pinImg;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        mainActivity =(MainActivity)getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup =(ViewGroup) inflater.inflate(R.layout.item_community_entire, container, false);
        communityService = new CommunityService(this);

        setView();
        setPin();
        return  viewGroup;
    }

    public void setView()
    {
        entireClassReviewConst = viewGroup.findViewById(R.id.community_class_review_const);
        entireClassReviewConst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ClassReviewActivity.class);
                startActivity(intent);
            }
        });

    }

    public void setPin()
    {
        int column = 1;
        communityPinAdapter = new CommunityPinAdapter(this);
        RecyclerView pinCommunityRecyclerView = viewGroup.findViewById(R.id.pin_community_recyclerview);
        gridLayoutManager = new GridLayoutManager(getContext(), column);
        pinCommunityRecyclerView.setLayoutManager(gridLayoutManager);
        pinCommunityRecyclerView.setAdapter(communityPinAdapter);
        communityService.getPinList();
    }


    @Override
    public void onSuccessGetPin(PinResponse pinResponse) {
        communityPinAdapter.clear();
        for(PinInfo pinInfo : pinResponse.getResult())
        {
            communityPinAdapter.add(pinInfo);
            Log.e("데이터 확인", "" + pinInfo.getNoticeIdx());
            Log.e("데이터 확인", "" + pinInfo.getNoticeName());
            Log.e("데이터 확인", "" + pinInfo.getCheckNew());

        }

        communityPinAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetPin() {

    }

    @Override
    public void onSuccessPostPin(PinPostResult pinPostResult) {
        switch (pinPostResult.getCheckStatus())
        {
            case 0:
                pinImg.setVisibility(View.INVISIBLE);
                break;
            case 1:
                pinImg.setVisibility(View.VISIBLE);
                break;
            default:break;
        }

    }

    @Override
    public void onFailurePostPin() {

    }

}
