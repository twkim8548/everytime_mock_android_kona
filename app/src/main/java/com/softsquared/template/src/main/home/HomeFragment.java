package com.softsquared.template.src.main.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softsquared.template.R;
import com.softsquared.template.src.main.home.models.FavoriteCommunityResponse;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private ViewGroup viewGroup;
    private HomeFavoriteCommunityAdapter homeFavoriteCommunityAdapter;
    private FavoriteCommunityResponse favoriteCommunityResponse;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);
        SetFavoriteCommunity();

        return viewGroup;

    }

    private void SetFavoriteCommunity()
    {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i ++)
        {
            list.add(String.format("TEXT %d", i));
        }

        homeFavoriteCommunityAdapter = new HomeFavoriteCommunityAdapter();
        RecyclerView favoriteCommunityRecyclerView =viewGroup.findViewById(R.id.home_middle_favorite_community_recyclerview);
        favoriteCommunityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        favoriteCommunityRecyclerView.setAdapter(homeFavoriteCommunityAdapter);
    }
}
