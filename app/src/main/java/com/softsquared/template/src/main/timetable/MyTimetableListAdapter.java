package com.softsquared.template.src.main.timetable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.timetable.models.MyTimetableInfo;
import com.softsquared.template.src.main.timetable.models.MyTimetableListInfo;
import com.softsquared.template.src.main.timetable.models.TimetableInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyTimetableListAdapter extends RecyclerView.Adapter<MyTimetableListAdapter.MyTimetableViewholder> {

    private ArrayList<MyTimetableListInfo> myTimetableListInfoArrayList = new ArrayList<>();

    private MyTimetableListActivity myTimetableListActivity;

    public MyTimetableListAdapter(MyTimetableListActivity myTimetableListActivity) {
        this.myTimetableListActivity = myTimetableListActivity;
    }

    @NonNull
    @Override
    public MyTimetableViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timetable_my_list, parent, false);
        return new MyTimetableListAdapter.MyTimetableViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTimetableViewholder holder, int position) {
        holder.bind(myTimetableListInfoArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return myTimetableListInfoArrayList.size();
    }

    public void add(MyTimetableListInfo myTimetableListInfo) {myTimetableListInfoArrayList.add(myTimetableListInfo);}

    public void clear() {myTimetableListInfoArrayList.clear();}

    public class MyTimetableViewholder extends RecyclerView.ViewHolder {
        private TextView myTimetableName;
        private TextView myTimetableYear;

        public MyTimetableViewholder(@NonNull View itemView) {
            super(itemView);
            myTimetableName = itemView.findViewById(R.id.timetable_my_list_name);
            myTimetableYear = itemView.findViewById(R.id.timetable_my_list_year_tv);
        }

        void bind(MyTimetableListInfo myTimetableListInfo)
        {
            myTimetableName.setText(myTimetableListInfo.getTimeTableName());
            myTimetableYear.setText(myTimetableListInfo.getTimeTableYear());
        }
    }
}
