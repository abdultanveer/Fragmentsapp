package com.example.fragmentsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {//step 1
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//step 2
    }

    @Override
    public void onArticleSelected(String headlines) {//step 3a
        NewsArticleFragment articleFrag = (NewsArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);


        if (articleFrag != null) {//it means the app is on tablet

            articleFrag.updateArticleView(headlines);

        }
        }

    }

