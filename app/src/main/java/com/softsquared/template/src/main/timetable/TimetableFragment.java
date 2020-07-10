package com.softsquared.template.src.main.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.MainActivity;
import com.softsquared.template.src.main.community.CommunityPinAdapter;
import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.notice.models.NoticeInfo;
import com.softsquared.template.src.main.timetable.interfaces.TimetableActivityView;
import com.softsquared.template.src.main.timetable.models.AddTimetableResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableInfo;
import com.softsquared.template.src.main.timetable.models.MyTimetableListResponse;
import com.softsquared.template.src.main.timetable.models.MyTimetableResponse;
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
    private ConstraintLayout timetableListBtn;
    private ConstraintLayout classAddBtn;

    private TextView monday[] = new TextView[10];
    private TextView tuesday[] = new TextView[10];
    private TextView wednesday[] = new TextView[10];
    private TextView thursday[] = new TextView[10];
    private TextView friday[] = new TextView[10];

    private MainActivity mainActivity;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //월요일
        monday[0] = (TextView) getView().findViewById(R.id.monday_1);
        monday[1] = (TextView) getView().findViewById(R.id.monday_2);
        monday[2] = (TextView) getView().findViewById(R.id.monday_3);
        monday[3] = (TextView) getView().findViewById(R.id.monday_4);
        monday[4] = (TextView) getView().findViewById(R.id.monday_5);
        monday[5] = (TextView) getView().findViewById(R.id.monday_6);
        monday[6] = (TextView) getView().findViewById(R.id.monday_7);
        monday[7] = (TextView) getView().findViewById(R.id.monday_8);
        monday[8] = (TextView) getView().findViewById(R.id.monday_9);
        monday[9] = (TextView) getView().findViewById(R.id.monday_10);
        //화요일
        tuesday[0] = (TextView) getView().findViewById(R.id.tuesday_1);
        tuesday[1] = (TextView) getView().findViewById(R.id.tuesday_2);
        tuesday[2] = (TextView) getView().findViewById(R.id.tuesday_3);
        tuesday[3] = (TextView) getView().findViewById(R.id.tuesday_4);
        tuesday[4] = (TextView) getView().findViewById(R.id.tuesday_5);
        tuesday[5] = (TextView) getView().findViewById(R.id.tuesday_6);
        tuesday[6] = (TextView) getView().findViewById(R.id.tuesday_7);
        tuesday[7] = (TextView) getView().findViewById(R.id.tuesday_8);
        tuesday[8] = (TextView) getView().findViewById(R.id.tuesday_9);
        tuesday[9] = (TextView) getView().findViewById(R.id.tuesday_10);
        //수요일
        wednesday[0] = (TextView) getView().findViewById(R.id.wednesday_1);
        wednesday[1] = (TextView) getView().findViewById(R.id.wednesday_2);
        wednesday[2] = (TextView) getView().findViewById(R.id.wednesday_3);
        wednesday[3] = (TextView) getView().findViewById(R.id.wednesday_4);
        wednesday[4] = (TextView) getView().findViewById(R.id.wednesday_5);
        wednesday[5] = (TextView) getView().findViewById(R.id.wednesday_6);
        wednesday[6] = (TextView) getView().findViewById(R.id.wednesday_7);
        wednesday[7] = (TextView) getView().findViewById(R.id.wednesday_8);
        wednesday[8] = (TextView) getView().findViewById(R.id.wednesday_9);
        wednesday[9] = (TextView) getView().findViewById(R.id.wednesday_10);
        //목요일
        thursday[0] = (TextView) getView().findViewById(R.id.thursday_1);
        thursday[1] = (TextView) getView().findViewById(R.id.thursday_2);
        thursday[2] = (TextView) getView().findViewById(R.id.thursday_3);
        thursday[3] = (TextView) getView().findViewById(R.id.thursday_4);
        thursday[4] = (TextView) getView().findViewById(R.id.thursday_5);
        thursday[5] = (TextView) getView().findViewById(R.id.thursday_6);
        thursday[6] = (TextView) getView().findViewById(R.id.thursday_7);
        thursday[7] = (TextView) getView().findViewById(R.id.thursday_8);
        thursday[8] = (TextView) getView().findViewById(R.id.thursday_9);
        thursday[9] = (TextView) getView().findViewById(R.id.thursday_10);
        //금요일
        friday[0] = (TextView) getView().findViewById(R.id.friday_1);
        friday[1] = (TextView) getView().findViewById(R.id.friday_2);
        friday[2] = (TextView) getView().findViewById(R.id.friday_3);
        friday[3] = (TextView) getView().findViewById(R.id.friday_4);
        friday[4] = (TextView) getView().findViewById(R.id.friday_5);
        friday[5] = (TextView) getView().findViewById(R.id.friday_6);
        friday[6] = (TextView) getView().findViewById(R.id.friday_7);
        friday[7] = (TextView) getView().findViewById(R.id.friday_8);
        friday[8] = (TextView) getView().findViewById(R.id.friday_9);
        friday[9] = (TextView) getView().findViewById(R.id.friday_10);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.timetable_fragment, container, false);
        timetableService = new TimetableService(this);

        timetableService.getMyTimetable(1);
//        Intent intent = intent.getIntent();
//        if(intent == null)
//            Log.e("intent없음", "NoticeActivity::onCreate() intent is null");
//        else
//        {
//            noticeIdx = intent.getIntExtra("noticeIdx", 0);
//            Log.e("intent값", "noticeIdx : " + noticeIdx);
//        }

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

        timetableListBtn = viewGroup.findViewById(R.id.timetable_list_btn);
        timetableListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyTimetableListActivity.class);
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

    private String time;
    private String day;

    @Override
    public void onSuccessGetMyTimetable(MyTimetableResponse myTimetableResponse) {
        for(MyTimetableInfo myTimetableInfo : myTimetableResponse.getResult())
        {

            time = String.valueOf(myTimetableInfo.getClassTime());
            day =  myTimetableInfo.getClassDay();

            if(day.equals("mon") && time.equals("1"))
        {
            monday[0].setText(myTimetableInfo.getClassName());
            monday[0].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
        }

            if(day.equals("mon") && time.equals("2"))
            {
                monday[1].setText(myTimetableInfo.getClassName());
                monday[1].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("3"))
            {
                monday[2].setText(myTimetableInfo.getClassName());
                monday[2].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("4"))
            {
                monday[3].setText(myTimetableInfo.getClassName());
                monday[3].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("5"))
            {
                monday[4].setText(myTimetableInfo.getClassName());
                monday[4].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("6"))
            {
                monday[5].setText(myTimetableInfo.getClassName());
                monday[5].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("7"))
            {
                monday[6].setText(myTimetableInfo.getClassName());
                monday[6].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("8"))
            {
                monday[7].setText(myTimetableInfo.getClassName());
                monday[7].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("9"))
            {
                monday[8].setText(myTimetableInfo.getClassName());
                monday[8].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("mon") && time.equals("10"))
            {
                monday[9].setText(myTimetableInfo.getClassName());
                monday[9].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("1"))
            {
                tuesday[0].setText(myTimetableInfo.getClassName());
                tuesday[0].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("2"))
            {
                tuesday[1].setText(myTimetableInfo.getClassName());
                tuesday[1].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("3"))
            {
                tuesday[2].setText(myTimetableInfo.getClassName());
                tuesday[2].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("4"))
            {
                tuesday[3].setText(myTimetableInfo.getClassName());
                tuesday[3].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("5"))
            {
                tuesday[4].setText(myTimetableInfo.getClassName());
                tuesday[4].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("6"))
            {
                tuesday[5].setText(myTimetableInfo.getClassName());
                tuesday[5].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("7"))
            {
                tuesday[6].setText(myTimetableInfo.getClassName());
                tuesday[6].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("8"))
            {
                tuesday[7].setText(myTimetableInfo.getClassName());
                tuesday[7].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("9"))
            {
                tuesday[8].setText(myTimetableInfo.getClassName());
                tuesday[8].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("tue") && time.equals("10"))
            {
                tuesday[9].setText(myTimetableInfo.getClassName());
                tuesday[9].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("1"))
            {
                wednesday[0].setText(myTimetableInfo.getClassName());
                wednesday[0].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("2"))
            {
                wednesday[1].setText(myTimetableInfo.getClassName());
                wednesday[1].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("3"))
            {
                wednesday[2].setText(myTimetableInfo.getClassName());
                wednesday[2].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("4"))
            {
                wednesday[3].setText(myTimetableInfo.getClassName());
                wednesday[3].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("5"))
            {
                wednesday[4].setText(myTimetableInfo.getClassName());
                wednesday[4].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("6"))
            {
                wednesday[5].setText(myTimetableInfo.getClassName());
                wednesday[5].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("7"))
            {
                wednesday[6].setText(myTimetableInfo.getClassName());
                wednesday[6].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("8"))
            {
                wednesday[7].setText(myTimetableInfo.getClassName());
                wednesday[7].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("9"))
            {
                wednesday[8].setText(myTimetableInfo.getClassName());
                wednesday[8].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("wed") && time.equals("10"))
            {
                wednesday[9].setText(myTimetableInfo.getClassName());
                wednesday[9].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("1"))
            {
                thursday[0].setText(myTimetableInfo.getClassName());
                thursday[0].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("2"))
            {
                thursday[1].setText(myTimetableInfo.getClassName());
                thursday[1].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("3"))
            {
                thursday[2].setText(myTimetableInfo.getClassName());
                thursday[2].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("4"))
            {
                thursday[3].setText(myTimetableInfo.getClassName());
                thursday[3].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("5"))
            {
                thursday[4].setText(myTimetableInfo.getClassName());
                thursday[4].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("6"))
            {
                thursday[5].setText(myTimetableInfo.getClassName());
                thursday[5].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("7"))
            {
                thursday[6].setText(myTimetableInfo.getClassName());
                thursday[6].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("8"))
            {
                thursday[7].setText(myTimetableInfo.getClassName());
                thursday[7].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("9"))
            {
                thursday[8].setText(myTimetableInfo.getClassName());
                thursday[8].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("thu") && time.equals("10"))
            {
                thursday[9].setText(myTimetableInfo.getClassName());
                thursday[9].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }
            if(day.equals("fri") && time.equals("1"))
            {
                friday[0].setText(myTimetableInfo.getClassName());
                friday[0].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("2"))
            {
                friday[1].setText(myTimetableInfo.getClassName());
                friday[1].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("3"))
            {
                friday[2].setText(myTimetableInfo.getClassName());
                friday[2].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("4"))
            {
                friday[3].setText(myTimetableInfo.getClassName());
                friday[3].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("5"))
            {
                friday[4].setText(myTimetableInfo.getClassName());
                friday[4].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("6"))
            {
                friday[5].setText(myTimetableInfo.getClassName());
                friday[5].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("7"))
            {
                friday[6].setText(myTimetableInfo.getClassName());
                friday[6].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("8"))
            {
                friday[7].setText(myTimetableInfo.getClassName());
                friday[7].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("9"))
            {
                friday[8].setText(myTimetableInfo.getClassName());
                friday[8].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }

            if(day.equals("fri") && time.equals("10"))
            {
                friday[9].setText(myTimetableInfo.getClassName());
                friday[9].setBackgroundColor(getContext().getResources().getColor(R.color.bottomview_select));
            }




        }

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

    }

    @Override
    public void onFailureGetMyTimetableList() {

    }
}
