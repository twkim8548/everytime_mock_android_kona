package com.softsquared.template.src.main.community.entire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.community.entire.models.ClassCommentInfo;
import com.softsquared.template.src.main.community.entire.models.MyClassInfo;
import com.softsquared.template.src.main.timetable.ClassActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyClassReviewAdapter extends RecyclerView.Adapter<MyClassReviewAdapter.MyClassViewholder> {

    private ArrayList<MyClassInfo> myClassInfoArrayList = new ArrayList<>();


    public MyClassReviewAdapter(ClassReviewActivity classReviewActivity) {
        this.classReviewActivity = classReviewActivity;
    }

    private ClassReviewActivity classReviewActivity;

    @NonNull
    @Override
    public MyClassViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myclass, parent, false);
        return new MyClassReviewAdapter.MyClassViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyClassViewholder holder, int position) {
        holder.bind(myClassInfoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return myClassInfoArrayList.size();
    }

    public void add(MyClassInfo myClassInfo) {myClassInfoArrayList.add(myClassInfo);}

    public void clear() {myClassInfoArrayList.clear();}

    public class MyClassViewholder extends RecyclerView.ViewHolder {

        private TextView myClassName;
        private TextView myClassProfessor;

        public MyClassViewholder(@NonNull View itemView) {
            super(itemView);

            myClassName = itemView.findViewById(R.id.myclass_class_name_tv);
            myClassProfessor = itemView.findViewById(R.id.myclass_professor_tv);
        }

        void bind(MyClassInfo myClassInfo)
        {
            myClassName.setText(myClassInfo.getClassName());
            myClassProfessor.setText(myClassInfo.getProfessor());
        }
    }
}
