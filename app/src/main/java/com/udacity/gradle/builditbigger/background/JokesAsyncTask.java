package com.udacity.gradle.builditbigger.background;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokesAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String URL = "http://10.0.2.2:8080/_ah/api/";
    private static MyApi myApiService = null;

    private OnResponseListener listener = null;

    public interface OnResponseListener {
        void onResponseReceived(String jokeStr);
    }

    public JokesAsyncTask(OnResponseListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
        //return "";
    }

    @Override
    protected void onPostExecute(String s) {
        if(listener != null && !TextUtils.isEmpty(s)) {
            listener.onResponseReceived(s);
        }

    }
}
