package com.softsquared.template.src.main.timetable;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.community.CommunityPinAdapter;
import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.noticePost.NoticePostActivity;
import com.softsquared.template.src.main.timetable.models.TimetableInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TimetableAdpater extends RecyclerView.Adapter<TimetableAdpater.TimetableViewholder> {

    private ArrayList<TimetableInfo> timetableInfoArrayList = new ArrayList<>();

    private TimetableFragment timetableFragment;
    private ClassActivity classActivity;
    private TimetableService timetableService;

    public TimetableAdpater(ClassActivity classActivity) {
        this.classActivity = classActivity;
    }


    @NonNull
    @Override
    public TimetableViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_selected, parent, false);

        timetableService = new TimetableService(classActivity);
        return new TimetableAdpater.TimetableViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TimetableViewholder holder, int position) {
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
        ConstraintLayout classAddBtn;
        ConstraintLayout classGoReviewBtn;

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
            classAddBtn = itemView.findViewById(R.id.class_select_add_btn);
            classGoReviewBtn = itemView.findViewById(R.id.class_select_go_to_review_btn);
        }

        void bind(final TimetableInfo timetableInfo)
        {
            classNameTv.setText(timetableInfo.getClassName());
            classProfessorTv.setText(timetableInfo.getProfessor());
            classGradeTv.setText(timetableInfo.getClassGrade());
            classTypeTv.setText(timetableInfo.getClassType());
            classPointTv.setText(timetableInfo.getClassPoint());
            classCodeTv.setText(String.valueOf(timetableInfo.getClassCode()));
            classTimetablePeopleTv.setText(String.valueOf(timetableInfo.getTimeTablePeople()));
            classPeopleTv.setText(String.valueOf(timetableInfo.getClassPeople()));
            classAddBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(itemView.getContext(), TimetableFragment.class);
//                    intent.putExtra("classIdx", timetableInfo.getClassIdx());
//                    Log.e("classIdx", "" +timetableInfo.getClassIdx());
//                    itemView.getContext().startActivity(intent);
                    timetableService.postAddTimetable(1, timetableInfo.getClassIdx());
                }
            });

        }
    }
}
