package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.background.JokesAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Test class to test the async task working.
 *
 * Ref:- https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void testJokeAsyncTask() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        new JokesAsyncTask(new JokesAsyncTask.OnResponseListener() {
            @Override
            public void onResponseReceived(String jokeStr) {
                assertNotNull(jokeStr);
                assertThat(jokeStr, is(any(String.class)));
                assertThat(jokeStr, is(not(isEmptyOrNullString())));
                countDownLatch.countDown();
            }
        }).execute();
        countDownLatch.await();
    }
}
