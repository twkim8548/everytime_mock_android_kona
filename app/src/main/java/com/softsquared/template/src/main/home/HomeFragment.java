package com.softsquared.template.src.main.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softsquared.template.R;
import com.softsquared.template.src.main.home.interfaces.HomeActivityView;
import com.softsquared.template.src.main.home.models.FavoriteCommunityInfo;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment implements HomeActivityView {

    private ViewGroup viewGroup;
    private HomeFavoriteCommunityAdapter homeFavoriteCommunityAdapter;
    private FavoriteCommunityResponse favoriteCommunityResponse;
    private FavoriteCommunityInfo favoriteCommunityInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);

        SetFavoriteCommunity();

        return viewGroup;

    }

    private void SetFavoriteCommunity()
    {
        homeFavoriteCommunityAdapter = new HomeFavoriteCommunityAdapter();
        RecyclerView favoriteCommunityRecyclerView = viewGroup.findViewById(R.id.home_middle_favorite_community_recyclerview);
        favoriteCommunityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        favoriteCommunityRecyclerView.setAdapter(homeFavoriteCommunityAdapter);
    }

    @Override
    public void onSuccessGetFavoriteCommunity(FavoriteCommunityResponse favoriteCommunityResponse) {

        ArrayList<FavoriteCommunityInfo> favoriteCommunityInfoArrayList = favoriteCommunityResponse.getResult();
        homeFavoriteCommunityAdapter.clear();
        for(FavoriteCommunityInfo favoriteCommunityInfo : favoriteCommunityInfoArrayList)
            homeFavoriteCommunityAdapter.add(favoriteCommunityInfo);

        homeFavoriteCommunityAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetFavoriteCommunity() {

    }
}
