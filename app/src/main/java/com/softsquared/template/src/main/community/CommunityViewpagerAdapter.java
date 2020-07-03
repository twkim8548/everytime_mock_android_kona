package com.softsquared.template.src.main.community;

import com.softsquared.template.src.main.community.commuad.CommuAdFragment;
import com.softsquared.template.src.main.community.entire.EntireFragment;
import com.softsquared.template.src.main.community.information.InformationFragment;
import com.softsquared.template.src.main.community.organization.OrganizationFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CommunityViewpagerAdapter extends FragmentPagerAdapter {
    private int mPageCount;

    public CommunityViewpagerAdapter(@NonNull FragmentManager fm, int mPageCount) {
        super(fm, mPageCount);
        this.mPageCount = mPageCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                EntireFragment entireFragment = new EntireFragment();
                return entireFragment;
            case 1:
                InformationFragment informationFragment = new InformationFragment();
                return informationFragment;
            case 2:
                CommuAdFragment commuAdFragment = new CommuAdFragment();
                return commuAdFragment;
            case 3:
                OrganizationFragment organizationFragment = new OrganizationFragment();
                return organizationFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
