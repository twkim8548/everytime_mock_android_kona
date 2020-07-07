package com.softsquared.template.src.main.timetable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.community.CommunityPinAdapter;
import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.timetable.models.TimetableInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TimetableAdpater extends RecyclerView.Adapter<TimetableAdpater.TimetableViewholder> {

    private ArrayList<TimetableInfo> timetableInfoArrayList = new ArrayList<>();

    private TimetableFragment timetableFragment;
    private ClassActivity classActivity;

    public TimetableAdpater(ClassActivity classActivity) {
        this.classActivity = classActivity;
    }

    @NonNull
    @Override
    public TimetableViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_select, parent, false);
        return new TimetableAdpater.TimetableViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimetableViewholder holder, int position) {
        holder.bind(timetableInfoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return timetableInfoArrayList.size();
    }

    public void add(TimetableInfo timetableInfo) {timetableInfoArrayList.add(timetableInfo);}

    public void clear() {timetableInfoArrayList.clear();}

    public class TimetableViewholder extends RecyclerView.ViewHolder {

        private TextView classNameTv;
        private TextView classProfessorTv;
        private TextView classGradeTv;
        private TextView classTypeTv;
        private TextView classPointTv;
        private TextView classCodeTv;
        private TextView classTimetablePeopleTv;
        private TextView classPeopleTv;

        public TimetableViewholder(@NonNull View itemView) {
            super(itemView);
            classNameTv = itemView.findViewById(R.id.class_select_name_tv);
            classProfessorTv = itemView.findViewById(R.id.class_select_professor_tv);
            classGradeTv = itemView.findViewById(R.id.class_select_grade_tv);
            classTypeTv = itemView.findViewById(R.id.class_select_type_tv);
            classPointTv = itemView.findViewById(R.id.class_select_point_tv);
            classCodeTv = itemView.findViewById(R.id.class_select_code_tv);
            classTimetablePeopleTv = itemView.findViewById(R.id.class_select_kart_tv_num);
            classPeopleTv = itemView.findViewById(R.id.class_select_people_tv_num);
        }

        void bind(TimetableInfo timetableInfo)
        {
            classNameTv.setText(timetableInfo.getClassName());
            classProfessorTv.setText(timetableInfo.getProfessor());
            classGradeTv.setText(timetableInfo.getClassGrade());
            classTypeTv.setText(timetableInfo.getClassType());
            classPointTv.setText(timetableInfo.getClassPoint());
            classCodeTv.setText(String.valueOf(timetableInfo.getClassCode()));
            classTimetablePeopleTv.setText(String.valueOf(timetableInfo.getTimeTablePeople()));
            classPeopleTv.setText(String.valueOf(timetableInfo.getClassPeople()));
        }
    }
}
