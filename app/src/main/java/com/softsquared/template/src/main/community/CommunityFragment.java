package com.softsquared.template.src.main.community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.template.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class CommunityFragment extends Fragment {

    private CommunityViewpagerAdapter communityViewpagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.community_fragment, container, false);

        communityView(view);
        return view;
    }

    private void communityView(View view)
    {
        TabLayout tabLayout = view.findViewById(R.id.community_tablayout);
        final ViewPager viewPager = view.findViewById(R.id.community_viewpager);

        communityViewpagerAdapter = new CommunityViewpagerAdapter(getFragmentManager(), 4);
        viewPager.setAdapter(communityViewpagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
