package com.softsquared.template.src.main.home;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.classReview.ClassEvalActivity;
import com.softsquared.template.src.main.community.entire.ClassReviewActivity;
import com.softsquared.template.src.main.home.models.RealtimeInfo;
import com.softsquared.template.src.main.home.models.ReviewInfo;
import com.softsquared.template.src.main.noticePost.NoticePostActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeReviewAdapter extends RecyclerView.Adapter<HomeReviewAdapter.ReviewViewholder> {

    private ArrayList<ReviewInfo> reviewInfoArrayList = new ArrayList<>();

    private HomeFragment homeFragment;

    public HomeReviewAdapter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public ReviewViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_class_comment, parent, false);
        return new HomeReviewAdapter.ReviewViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewholder holder, int position) {
        holder.setting(reviewInfoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return reviewInfoArrayList.size();
    }

    public void add(ReviewInfo reviewInfo) {reviewInfoArrayList.add(reviewInfo);}

    public void clear() {reviewInfoArrayList.clear();}


    public class ReviewViewholder extends RecyclerView.ViewHolder {
        private TextView reviewClassName;
        private TextView reviewProfessor;
        private TextView reviewContent;

        public ReviewViewholder(@NonNull View itemView) {
            super(itemView);
            reviewClassName = itemView.findViewById(R.id.class_comment_classname_tv);
            reviewProfessor = itemView.findViewById(R.id.class_comment_professor_tv);
            reviewContent = itemView.findViewById(R.id.class_comment_tv);
        }

        void setting(final ReviewInfo reviewInfo)
        {
            reviewClassName.setText(reviewInfo.getClassName());
            reviewProfessor.setText(reviewInfo.getProfessor());
            reviewContent.setText(reviewInfo.getClassCommentInf());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(itemView.getContext(), ClassEvalActivity.class);
                    intent.putExtra("classIdx", reviewInfo.getClassIdx());
                    Log.e("classIdx", "" +reviewInfo.getClassIdx());
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
