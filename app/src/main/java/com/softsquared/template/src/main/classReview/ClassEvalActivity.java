package com.softsquared.template.src.main.classReview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.classReview.interfaces.ClassEvalActivityView;
import com.softsquared.template.src.main.classReview.models.AboutClassInfo;
import com.softsquared.template.src.main.classReview.models.AboutClassResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewCommentInfo;
import com.softsquared.template.src.main.classReview.models.ClassReviewCommentResponse;
import com.softsquared.template.src.main.classReview.models.ClassReviewInfo;
import com.softsquared.template.src.main.classReview.models.ClassReviewResponse;
import com.softsquared.template.src.main.community.entire.MyClassReviewAdapter;
import com.softsquared.template.src.main.community.entire.models.ClassCommentInfo;

import org.w3c.dom.Text;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ClassEvalActivity extends BaseActivity implements ClassEvalActivityView {

    private ClassEvalService classEvalService;
    private ClassEvalAdapter classEvalAdapter;
    private GridLayoutManager gridLayoutManager;
    private int classIdx = 0;
    private TextView className,classSemester,classCode,classProfessor,classGrade,classPoint,
            classTablePeople,reviewHw,reviewRate,reviewTest,classType,classTime,classPeople,
            reviewTeam,reviewAtt,reviewStar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_info_layout);

        Intent intent = getIntent();
        if(intent == null)
            Log.e("intent없음", "NoticeActivity::onCreate() intent is null");
        else
        {
            classIdx = intent.getIntExtra("classIdx", 0);
            Log.e("Eval intent값", "classIdx : " + classIdx);
        }

        classEvalService = new ClassEvalService(this);
        setView();
        classEvalService.getAboutClass(classIdx);
        classEvalService.getClassReview(classIdx);


        setClassCommentReview();
    }

    private void setClassCommentReview()
    {
        int column = 1;
        classEvalAdapter = new ClassEvalAdapter(this);
        RecyclerView classEvalRecyclerview = findViewById(R.id.class_info_review_recyclerview);
        classEvalRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        gridLayoutManager = new GridLayoutManager(this, column);
        classEvalRecyclerview.setLayoutManager(gridLayoutManager);
        classEvalRecyclerview.setAdapter(classEvalAdapter);
        classEvalService.getClassReviewComment(classIdx);
    }

    private void setView()
    {
        className = findViewById(R.id.class_info_className);
         classSemester = findViewById(R.id.class_info_semester_tv);
         classCode = findViewById(R.id.class_info_code_tv);
         classProfessor = findViewById(R.id.class_info_professor_tv);
         classType = findViewById(R.id.class_info_type_tv);
         classGrade = findViewById(R.id.class_info_grade_tv);
         classTime = findViewById(R.id.class_info_time_tv);
         classPoint = findViewById(R.id.class_info_point_tv);
         classPeople = findViewById(R.id.class_info_people_tv);
         classTablePeople = findViewById(R.id.class_info_table_people_tv);
         reviewStar = findViewById(R.id.class_info_review_star_tv);
         reviewHw = findViewById(R.id.class_info_review_hw_tv);
         reviewTeam = findViewById(R.id.class_info_review_team_tv);
         reviewRate = findViewById(R.id.class_info_review_rate_tv);
         reviewAtt = findViewById(R.id.class_info_review_att_tv);
         reviewTest = findViewById(R.id.class_info_review_test_tv);

    }





    @Override
    public void onSuccessGetAboutClass(AboutClassInfo aboutClassInfo) {
        className.setText(aboutClassInfo.getClassName());
        classSemester.setText(aboutClassInfo.getClassSemester());
        classCode.setText(String.valueOf(aboutClassInfo.getClassCode()));
        classProfessor.setText(aboutClassInfo.getProfessor());
        classType.setText(aboutClassInfo.getClassType());
        classGrade.setText(aboutClassInfo.getClassGrade());
//        classTime
        classPoint.setText(String.valueOf(aboutClassInfo.getClassPoint()));
        classPeople.setText(String.valueOf(aboutClassInfo.getClassPeople()));
        classTablePeople.setText(String.valueOf(aboutClassInfo.getTimeTablePeople()));

    }

    @Override
    public void onFailureGetAboutClass() {

    }

    @Override
    public void onSuccessGetClassReview(ClassReviewInfo classReviewInfo) {
        reviewStar.setText(String.valueOf(classReviewInfo.getClassStar()));
        reviewHw.setText(classReviewInfo.getSelectHw());
        reviewTeam.setText(classReviewInfo.getSelectTeam());
        reviewRate.setText(classReviewInfo.getSelectRate());
        reviewAtt.setText(classReviewInfo.getSelectAtt());
        reviewTest.setText(classReviewInfo.getSelectTest());
    }

    @Override
    public void onFailureGetClassReview() {

    }

    @Override
    public void onSuccessGetClassComment(ClassReviewCommentResponse classReviewCommentResponse) {
        classEvalAdapter.clear();
        for(ClassReviewCommentInfo classReviewCommentInfo : classReviewCommentResponse.getResult())
        {
            classEvalAdapter.add(classReviewCommentInfo);
        }
        classEvalAdapter.notifyDataSetChanged();

    }

    @Override
    public void onFailureGetClassComment() {

    }
}
