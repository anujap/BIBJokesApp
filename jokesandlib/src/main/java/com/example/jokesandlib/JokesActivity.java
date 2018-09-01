package com.example.jokesandlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    public static final String JOKE_KEY_EXTRA = "joke_key";

    private TextView tvDisplayJoke;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title_joke);

        setUpActionBar();

        tvDisplayJoke = (TextView) findViewById(R.id.tv_joke);

        if(getIntent() != null) {
            String jokeStr = getIntent().getStringExtra(JOKE_KEY_EXTRA);
            if(!TextUtils.isEmpty(jokeStr))
                tvDisplayJoke.setText(jokeStr);
            else
                tvDisplayJoke.setText(R.string.error_joke);
        }
    }

    /**
     * function called to set up action bar
     */
    private void setUpActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
