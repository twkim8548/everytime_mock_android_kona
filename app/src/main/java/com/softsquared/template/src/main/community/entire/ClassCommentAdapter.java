package com.softsquared.template.src.main.community.entire;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.classReview.ClassEvalActivity;
import com.softsquared.template.src.main.community.CommunityPinAdapter;
import com.softsquared.template.src.main.community.entire.models.ClassCommentInfo;
import com.softsquared.template.src.main.community.models.PinInfo;
import com.softsquared.template.src.main.timetable.ClassActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassCommentAdapter extends RecyclerView.Adapter<ClassCommentAdapter.CommentViewholder> {
    private ArrayList<ClassCommentInfo> classCommentInfoArrayList = new ArrayList<>();


    public ClassCommentAdapter(ClassReviewActivity classReviewActivity) {
        this.classReviewActivity = classReviewActivity;
    }

    private ClassReviewActivity classReviewActivity;


    @NonNull
    @Override
    public ClassCommentAdapter.CommentViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_review_comment, parent, false);
        return new ClassCommentAdapter.CommentViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassCommentAdapter.CommentViewholder holder, int position) {
        holder.bind(classCommentInfoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return classCommentInfoArrayList.size();
    }

    public void add(ClassCommentInfo classCommentInfo) {classCommentInfoArrayList.add(classCommentInfo);}

    public void clear() {classCommentInfoArrayList.clear();}

    public class CommentViewholder extends RecyclerView.ViewHolder {
        private TextView commentName;
        private TextView commentProfessor;
        private TextView commentWriter;
        private TextView commentInf;

        public CommentViewholder(@NonNull View itemView) {
            super(itemView);
            commentName = itemView.findViewById(R.id.class_review_comment_classname_tv);
            commentProfessor = itemView.findViewById(R.id.class_review_comment_professor_tv);
            commentWriter = itemView.findViewById(R.id.class_review_comment_writer_tv);
            commentInf = itemView.findViewById(R.id.class_review_comment_info_tv);
        }

        void bind(final ClassCommentInfo classCommentInfo)
        {
            commentName.setText(classCommentInfo.getClassName());
            commentProfessor.setText(classCommentInfo.getProfessor());
            commentWriter.setText(classCommentInfo.getClassStudent());
            commentInf.setText(classCommentInfo.getClassCommentInf());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(itemView.getContext(), ClassEvalActivity.class);
                    intent.putExtra("classIdx", classCommentInfo.getClassIdx());
                    Log.e("comment classIdx", "" +classCommentInfo.getClassIdx());
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
