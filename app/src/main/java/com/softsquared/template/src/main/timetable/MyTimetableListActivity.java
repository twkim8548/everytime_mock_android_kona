package com.softsquared.template.src.main.timetable;

import android.drm.DrmStore;
import android.os.Bundle;
import android.util.Log;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.timetable.interfaces.TimetableActivityView;
import com.softsquared.template.src.main.timetable.models.AddTimetableResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableInfo;
import com.softsquared.template.src.main.timetable.models.MyTimetableListInfo;
import com.softsquared.template.src.main.timetable.models.MyTimetableListResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableResponse;
import com.softsquared.template.src.main.timetable.models.TimetableInfo;
import com.softsquared.template.src.main.timetable.models.TimetableResponse;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyTimetableListActivity extends BaseActivity implements TimetableActivityView {

    private MyTimetableListAdapter myTimetableListAdapter;
    private TimetableService timetableService;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView myTimetableRecyclerview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_list_layout);

        timetableService = new TimetableService(this);

        setTimetable();
    }

    public void setTimetable()
    {
        int column = 1;
        myTimetableListAdapter = new MyTimetableListAdapter(this);
        myTimetableRecyclerview = findViewById(R.id.timetable_my_list_recyclerview);
        gridLayoutManager = new GridLayoutManager(this, column);
        myTimetableRecyclerview.setLayoutManager(gridLayoutManager);
        myTimetableRecyclerview.setAdapter(myTimetableListAdapter);
        timetableService.getMyTimetableList();
    }



    @Override
    public void onSuccessGetTimetable(TimetableResponse timetableResponse) {

    }

    @Override
    public void onFailureGetTimetable() {

    }

    @Override
    public void onSuccessGetMyTimetable(MyTimetableResponse myTimetableResponse) {

    }

    @Override
    public void onFailureGetMyTimetable() {

    }

    @Override
    public void onSuccessPostAddMyTimetable(AddTimetableResponse addTimetableResponse) {

    }

    @Override
    public void onFailurePostAddMyTimetable() {

    }

    @Override
    public void onSuccessGetMyTimetableList(MyTimetableListResponse myTimetableListResponse) {
        myTimetableListAdapter.clear();
        for(MyTimetableListInfo myTimetableListInfo : myTimetableListResponse.getResult())
        {
            myTimetableListAdapter.add(myTimetableListInfo);
        }
        myTimetableListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetMyTimetableList() {

    }
}
