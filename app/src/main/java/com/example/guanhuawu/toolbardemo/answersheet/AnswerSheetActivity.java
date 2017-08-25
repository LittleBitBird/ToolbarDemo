package com.example.guanhuawu.toolbardemo.answersheet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.guanhuawu.toolbardemo.R;

import butterknife.ButterKnife;

public class AnswerSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet);
        ButterKnife.bind(this);
    }
}
