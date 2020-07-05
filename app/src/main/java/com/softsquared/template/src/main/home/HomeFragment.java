package com.softsquared.template.src.main.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.softsquared.template.R;
import com.softsquared.template.src.main.MainActivity;
import com.softsquared.template.src.main.home.interfaces.HomeActivityView;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;
import com.softsquared.template.src.main.home.models.HotContentInfo;
import com.softsquared.template.src.main.home.models.HotContentResponse;
import com.softsquared.template.src.main.home.models.RealtimeInfo;
import com.softsquared.template.src.main.home.models.RealtimeResponse;
import com.softsquared.template.src.main.home.mypage.MypageActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.sSharedPreferences;

public class HomeFragment extends Fragment implements HomeActivityView {

    private ViewGroup viewGroup;
    private HomeFavoriteCommunityAdapter homeFavoriteCommunityAdapter;
    private HomeHotContentAdapter homeHotContentAdapter;
    private HomeRealtimeAdapter homeRealtimeAdapter;
    private FavoriteCommunityResponse favoriteCommunityResponse;
    private FavoriteCommunityInfo favoriteCommunityInfo;
    private HomeService homeService;
    private Context context;
    private MainActivity mainActivity;
    private GridLayoutManager gridLayoutManager;

    private FrameLayout mypageFramelayout;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        mainActivity =(MainActivity)getContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);

//        tryGetFavoriteCommunity();
        Log.e("jwt 확인", "LoginActivity::onSuccessLogin() jwt: " + sSharedPreferences.getString(X_ACCESS_TOKEN, ""));
        homeService = new HomeService(this);
        setFavoriteCommunity();
        setRealtime();
        setHotContent();
        setView();
        onClick();

        return viewGroup;

    }

//    private void tryGetFavoriteCommunity()
//    {
//        homeService.getFavoriteCommunityList();
//    }

    private void setView()
    {
        mypageFramelayout = viewGroup.findViewById(R.id.home_top_mypage_img);
    }

    private void onClick()
    {
        mypageFramelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MypageActivity.class);
                startActivity(intent);
            }
        });
    }




    private void setFavoriteCommunity()
    {
        int column = 1;
        homeFavoriteCommunityAdapter = new HomeFavoriteCommunityAdapter(this);
        RecyclerView favoriteCommunityRecyclerView = viewGroup.findViewById(R.id.home_middle_favorite_community_recyclerview);
        gridLayoutManager = new GridLayoutManager(getContext(), column);
        favoriteCommunityRecyclerView.setLayoutManager(gridLayoutManager);
        favoriteCommunityRecyclerView.setAdapter(homeFavoriteCommunityAdapter);
        homeService.getFavoriteCommunityList();
    }

    private void setHotContent()
    {
        int column = 1;
        homeHotContentAdapter = new HomeHotContentAdapter(this);
        RecyclerView homeHotContentRecyclerview = viewGroup.findViewById(R.id.home_hot_content_recyclerview);
        gridLayoutManager = new GridLayoutManager(getContext(), column);
        homeHotContentRecyclerview.setLayoutManager(gridLayoutManager);
        homeHotContentRecyclerview.setAdapter(homeHotContentAdapter);
        homeService.getHotContent();
    }

    private void setRealtime()
    {
        int column = 1;
        homeRealtimeAdapter = new HomeRealtimeAdapter(this);
        RecyclerView homeRealtimeRecyclerview = viewGroup.findViewById(R.id.home_realtime_recyclerview);
        gridLayoutManager = new GridLayoutManager(getContext(), column);
        homeRealtimeRecyclerview.setLayoutManager(gridLayoutManager);
        homeRealtimeRecyclerview.setAdapter(homeRealtimeAdapter);
        homeService.getRealtime();
    }

    @Override
    public void onSuccessGetFavoriteCommunity(FavoriteCommunityResponse favoriteCommunityResponse) {
        homeFavoriteCommunityAdapter.clear();
        for(FavoriteCommunityInfo favoriteCommunityInfo : favoriteCommunityResponse.getResult())
        {
            homeFavoriteCommunityAdapter.add(favoriteCommunityInfo);
        }
        homeFavoriteCommunityAdapter.notifyDataSetChanged();



    }

    @Override
    public void onFailureGetFavoriteCommunity() {

    }

    @Override
    public void onSuccessGetHotContent(HotContentResponse hotContentResponse) {
        homeHotContentAdapter.clear();
        for(HotContentInfo hotContentInfo : hotContentResponse.getResult())
        {
            homeHotContentAdapter.add(hotContentInfo);
        }
        homeHotContentAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetHotContent() {

    }

    @Override
    public void onSuccessGetPopularContent(RealtimeResponse realtimeResponse) {
        homeRealtimeAdapter.clear();
        for(RealtimeInfo realtimeInfo : realtimeResponse.getResult())
        {
            homeRealtimeAdapter.add(realtimeInfo);
        }
        homeRealtimeAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetPopularContent() {

    }
}
