package com.softsquared.template.src.main.classReview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.classReview.models.ClassReviewCommentInfo;
import com.softsquared.template.src.main.classReview.models.ClassReviewCommentResponse;
import com.softsquared.template.src.main.community.entire.ClassCommentAdapter;
import com.softsquared.template.src.main.community.entire.models.ClassCommentInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassEvalAdapter extends RecyclerView.Adapter<ClassEvalAdapter.EvalViewholder> {

    private ArrayList<ClassReviewCommentInfo> classReviewCommentInfoArrayList = new ArrayList<>();

    private ClassEvalActivity classEvalActivity;

    public ClassEvalAdapter(ClassEvalActivity classEvalActivity) {
        this.classEvalActivity = classEvalActivity;
    }

    @NonNull
    @Override
    public EvalViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_info_review, parent, false);
        return new ClassEvalAdapter.EvalViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EvalViewholder holder, int position) {
        holder.bind(classReviewCommentInfoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return classReviewCommentInfoArrayList.size();
    }

    public void add(ClassReviewCommentInfo classReviewCommentInfo) {classReviewCommentInfoArrayList.add(classReviewCommentInfo);}

    public void clear() {classReviewCommentInfoArrayList.clear();}

    public class EvalViewholder extends RecyclerView.ViewHolder {

        private TextView classInfoReviewWriter;
        private TextView classInfoReviewContents;

        public EvalViewholder(@NonNull View itemView) {
            super(itemView);
            classInfoReviewWriter = itemView.findViewById(R.id.class_info_review_writer_tv);
            classInfoReviewContents = itemView.findViewById(R.id.class_info_review_contents_tv);
        }

        void bind(ClassReviewCommentInfo classReviewCommentInfo)
        {
            classInfoReviewWriter.setText(classReviewCommentInfo.getClassStudent());
            classInfoReviewContents.setText(classReviewCommentInfo.getClassCommentInf());
        }
    }
}
