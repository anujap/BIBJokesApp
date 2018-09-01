package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jokesandlib.JokesActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.background.JokesAsyncTask;
import com.udacity.gradle.builditbigger.connectivity.ConnectivityChecker;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, JokesAsyncTask.OnResponseListener {

    private Button btnJoke;
    private ProgressBar progressBar;

    // async task
    private JokesAsyncTask jokesAsyncTask;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnJoke = (Button) view.findViewById(R.id.jokebtn);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        btnJoke.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.jokebtn) {
            if(ConnectivityChecker.isConnectivityAvailable(getActivity())) {
                progressBar.setVisibility(View.VISIBLE);

                // execute asynctask
                jokesAsyncTask = new JokesAsyncTask(this);
                jokesAsyncTask.execute();
            }
            else {
                Toast.makeText(getActivity(), R.string.connectivity_unavailable, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onResponseReceived(String jokeStr) {
        progressBar.setVisibility(View.GONE);
        Intent intent = new Intent(getActivity(), JokesActivity.class);
        intent.putExtra(JokesActivity.JOKE_KEY_EXTRA, jokeStr);
        startActivity(intent);
    }
}
