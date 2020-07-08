package com.softsquared.template.src.main.community.entire;

import android.os.Bundle;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.community.entire.interfaces.ClassReviewActivityView;
import com.softsquared.template.src.main.community.entire.models.ClassCommentInfo;
import com.softsquared.template.src.main.community.entire.models.ClassCommentResponse;
import com.softsquared.template.src.main.community.entire.models.MyClassInfo;
import com.softsquared.template.src.main.community.entire.models.MyClassResponse;
import com.softsquared.template.src.main.notice.NoticeAdapter;
import com.softsquared.template.src.main.notice.models.NoticeInfo;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ClassReviewActivity extends BaseActivity implements ClassReviewActivityView {

    private ClassReviewService classReviewService;
    private ClassCommentAdapter classCommentAdapter;
    private MyClassReviewAdapter myClassReviewAdapter;
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_review_layout);

        classReviewService = new ClassReviewService(this);

        setMyClass();
        setClassComment();
    }

    private void setMyClass()
    {
        int column = 1;
        myClassReviewAdapter = new MyClassReviewAdapter(this);
        RecyclerView myClassRecyclerview = findViewById(R.id.class_review_myclass_recyclerview);
        gridLayoutManager = new GridLayoutManager(this, column);
        myClassRecyclerview.setLayoutManager(gridLayoutManager);
        myClassRecyclerview.setAdapter(myClassReviewAdapter);
        classReviewService.getMyClass();


    }

    private void setClassComment()
    {
        int column = 1;
        classCommentAdapter = new ClassCommentAdapter(this);
        RecyclerView classCommentRecyclerview = findViewById(R.id.class_review_myclass_recent_recyclerview);
        gridLayoutManager = new GridLayoutManager(this, column);
        classCommentRecyclerview.setLayoutManager(gridLayoutManager);
        classCommentRecyclerview.setAdapter(classCommentAdapter);
        classReviewService.getClassComment();


    }



    @Override
    public void onSuccessGetMyClass(MyClassResponse myClassResponse) {
        myClassReviewAdapter.clear();
        for(MyClassInfo myClassInfo : myClassResponse.getResult())
        {
            myClassReviewAdapter.add(myClassInfo);
        }
        myClassReviewAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetMyClass() {

    }

    @Override
    public void onSuccessGetComment(ClassCommentResponse classCommentResponse) {
        classCommentAdapter.clear();
        for(ClassCommentInfo classCommentInfo : classCommentResponse.getResult())
        {
            classCommentAdapter.add(classCommentInfo);
        }
        classCommentAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetComment() {

    }
}
