package com.example.guanhuawu.toolbardemo.answersheet;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.guanhuawu.toolbardemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guanhua.wu on 2017/8/9.
 */

public class AnswerSheetItemView<T extends AnswerSheetItemMessage> extends LinearLayout {
    @BindView(R.id.txt_answersheet_circle_item)
    TextView txtAnswerSheetCircleItem;
    @BindView(R.id.txt_answersheet_real_score)
    TextView txtAnswerSheetRealScores;
    @BindView(R.id.txt_answersheet_total_score)
    TextView txtAnswerSheetTotalScores;
    @BindView(R.id.iv_answersheet_comment)
    ImageView ivAnswerSheetComment;
    T date;

    public AnswerSheetItemView(Context context) {
        this(context, null);
    }

    public AnswerSheetItemView(T date, Context context) {
        this(context);
        this.date = date;
        initView(this.date);
    }

    public AnswerSheetItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnswerSheetItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.homework_answer_sheet_item_view, this, true);
        ButterKnife.bind(this);
    }

    public void initView(T t) {
        if (t != null && t instanceof AnswerSheetItem) {
            setItemNo(t.getItemNo());
            setScoreText(t.getRealScoreText(), getResources().getString(R.string.total_score, t.getTotalScoreText()));
            setItemBackground(t.getItemBackground());
            isCommentVisible(t.getIsCommentVisible());
        }
    }

    public void setItemNo(String itemNo) {
        this.txtAnswerSheetCircleItem.setText(itemNo);
    }

    public void setScoreText(String realScore, String totalScore) {
        if (realScore != null && realScore.length() > 0)
            txtAnswerSheetRealScores.setVisibility(VISIBLE);
        txtAnswerSheetRealScores.setText(realScore);
        if (totalScore != null && totalScore.length() > 0)
            txtAnswerSheetTotalScores.setVisibility(VISIBLE);
        txtAnswerSheetTotalScores.setText(totalScore);
    }

    public void setItemBackground(@DrawableRes int backgroundStyle) {
        this.txtAnswerSheetCircleItem
                .setBackground(ContextCompat.getDrawable(getContext(), backgroundStyle));
    }

    public void isCommentVisible(Boolean visible) {
        if (visible) {
            ivAnswerSheetComment.setVisibility(VISIBLE);
        } else {
            ivAnswerSheetComment.setVisibility(GONE);
        }
    }
}
