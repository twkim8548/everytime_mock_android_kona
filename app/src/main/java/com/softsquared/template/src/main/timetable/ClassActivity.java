package com.softsquared.template.src.main.timetable;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.timetable.interfaces.TimetableActivityView;
import com.softsquared.template.src.main.timetable.models.TimetableInfo;
import com.softsquared.template.src.main.timetable.models.TimetableResponse;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ClassActivity extends BaseActivity implements TimetableActivityView {

    private GridLayoutManager gridLayoutManager;
    private TimetableAdpater timetableAdpater;
    private RecyclerView timetableRecyclerView;
    private TimetableService timetableService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_select_layout);
        timetableService = new TimetableService(this);

        setTimetable();
        setTimetableWindow();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            finish();
            return false;
        }
        return false;
    }


    public void setTimetableWindow()
    {
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);
    }


    public void setTimetable()
    {
        int column = 1;
        timetableAdpater = new TimetableAdpater(this);
        timetableRecyclerView = findViewById(R.id.class_select_recyclerview);
        gridLayoutManager = new GridLayoutManager(this, column);
        timetableRecyclerView.setLayoutManager(gridLayoutManager);
        timetableRecyclerView.setAdapter(timetableAdpater);
        timetableService.getTimetable();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        finish();
    }

    @Override
    public void onSuccessGetTimetable(TimetableResponse timetableResponse) {
        timetableAdpater.clear();
        for(TimetableInfo timetableInfo : timetableResponse.getResult())
        {
            timetableAdpater.add(timetableInfo);
            Log.e("데이터 확인", "" + timetableInfo.getClassIdx());
        }
        timetableAdpater.notifyDataSetChanged();


    }

    @Override
    public void onFailureGetTimetable() {

    }
}
