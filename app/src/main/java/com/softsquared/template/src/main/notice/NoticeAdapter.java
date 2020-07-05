package com.softsquared.template.src.main.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.main.home.HomeFragment;
import com.softsquared.template.src.main.home.HomeRealtimeAdapter;
import com.softsquared.template.src.main.home.models.RealtimeInfo;
import com.softsquared.template.src.main.notice.models.NoticeInfo;

import org.w3c.dom.Text;
import static com.softsquared.template.src.ApplicationClass.DATE_FORMAT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewholder> {

    private ArrayList<NoticeInfo> noticeInfoArrayList = new ArrayList<>();


    public NoticeAdapter(NoticeActivity noticeActivity) {
        this.noticeActivity = noticeActivity;
    }

    private NoticeActivity noticeActivity;


    @NonNull
    @Override
    public NoticeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        return new NoticeAdapter.NoticeViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewholder holder, int position) {
        holder.setting(noticeInfoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return noticeInfoArrayList.size();
    }

    public void add(NoticeInfo noticeInfo) {noticeInfoArrayList.add(noticeInfo);}

    public void clear() {noticeInfoArrayList.clear();}

    public class NoticeViewholder extends RecyclerView.ViewHolder {
        private TextView contentTitle;
        private TextView contentArticle;
        private TextView contentWriter;
        private TextView contentDate;
        private TextView contentComment;
        private TextView contentGood;


        public NoticeViewholder(@NonNull View itemView) {
            super(itemView);
            contentTitle = itemView.findViewById(R.id.content_article_title_tv);
            contentArticle = itemView.findViewById(R.id.content_article_contents_tv);
            contentWriter = itemView.findViewById(R.id.content_article_writer_tv);
            contentDate = itemView.findViewById(R.id.content_article_date_tv);
            contentComment = itemView.findViewById(R.id.content_article_comment_tv);
            contentGood = itemView.findViewById(R.id.content_article_good_tv);
        }

        public void setting(NoticeInfo noticeInfo)
        {
            contentTitle.setText(noticeInfo.getContentTitle());
            contentArticle.setText(noticeInfo.getContentInf());
            contentWriter.setText(noticeInfo.getContentWriter());

            String dateFormat = DATE_FORMAT.format(noticeInfo.getWriteDay());

            contentDate.setText(dateFormat);
            contentComment.setText(String.valueOf(noticeInfo.getCountComment()));
            contentGood.setText(String.valueOf(noticeInfo.getCountLike()));
        }
    }
}
