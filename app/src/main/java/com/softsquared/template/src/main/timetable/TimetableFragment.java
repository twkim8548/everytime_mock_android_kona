package com.softsquared.template.src.main.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.softsquared.template.R;
import com.softsquared.template.src.main.community.CommunityPinAdapter;
import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.timetable.interfaces.TimetableActivityView;
import com.softsquared.template.src.main.timetable.models.TimetableInfo;
import com.softsquared.template.src.main.timetable.models.TimetableResponse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TimetableFragment extends Fragment implements TimetableActivityView {

    private GridLayoutManager gridLayoutManager;
    private TimetableAdpater timetableAdpater;
    private RecyclerView timetableRecyclerView;
    private TimetableService timetableService;
    private ViewGroup viewGroup;
    private ConstraintLayout timetableAddBtn;
    private boolean isFadeAnimActivtity = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.timetable_fragment, container, false);
        timetableService = new TimetableService(this);

        setView();
        return viewGroup;
    }

    public void setView()
    {
        timetableAddBtn = viewGroup.findViewById(R.id.timetable_add_btn);
        final Intent intent = new Intent(getContext(), ClassActivity.class);
        timetableAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });
    }



    @Override
    public void onSuccessGetTimetable(TimetableResponse timetableResponse) {

    }

    @Override
    public void onFailureGetTimetable() {

    }
}
