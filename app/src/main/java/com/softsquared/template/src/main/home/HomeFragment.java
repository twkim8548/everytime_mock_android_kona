package com.softsquared.template.src.main.home;

import android.content.Intent;
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
import com.softsquared.template.src.main.home.mypage.MypageActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.softsquared.template.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.template.src.ApplicationClass.sSharedPreferences;

public class HomeFragment extends Fragment implements HomeActivityView {

    private ViewGroup viewGroup;
    private HomeFavoriteCommunityAdapter homeFavoriteCommunityAdapter;
    private FavoriteCommunityResponse favoriteCommunityResponse;
    private FavoriteCommunityInfo favoriteCommunityInfo;
    private HomeService homeService;

    private FrameLayout mypageFramelayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);

//        tryGetFavoriteCommunity();
        Log.e("jwt 확인", "LoginActivity::onSuccessLogin() jwt: " + sSharedPreferences.getString(X_ACCESS_TOKEN, ""));
        SetFavoriteCommunity();

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

//    private void onClick()
//    {
//        mypageFramelayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MypageActivity.class);
//
//            }
//        });
//    }




    private void SetFavoriteCommunity()
    {
        homeFavoriteCommunityAdapter = new HomeFavoriteCommunityAdapter();
        RecyclerView favoriteCommunityRecyclerView = viewGroup.findViewById(R.id.home_middle_favorite_community_recyclerview);
        favoriteCommunityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        favoriteCommunityRecyclerView.setAdapter(homeFavoriteCommunityAdapter);
    }

    @Override
    public void onSuccessGetFavoriteCommunity(FavoriteCommunityResponse favoriteCommunityResponse) {
        homeFavoriteCommunityAdapter.clear();
        ArrayList<FavoriteCommunityInfo> favoriteCommunityInfoArrayList = favoriteCommunityResponse.getResult();
        for(FavoriteCommunityInfo favoriteCommunityInfo : favoriteCommunityInfoArrayList)
            homeFavoriteCommunityAdapter.add(favoriteCommunityInfo);

        homeFavoriteCommunityAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetFavoriteCommunity() {

    }
}
