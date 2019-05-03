package Tasks;

import android.os.Looper;
import android.util.Log;

import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import interfaces.AsyncTaskDelegate;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.*;

public class ApiAsyncTaskTest implements AsyncTaskDelegate {

    String joke;

    @Test
    public void doInBackground() throws ExecutionException, InterruptedException {


        ApiAsyncTask apiAsyncTask = new ApiAsyncTask(getContext(),this);

        joke = apiAsyncTask.execute().get();

        assertTrue("Joke loaded : " + joke, !joke.equals(""));


    }

    @Override
    public void afterPost(String result) {
        Log.d("Result : ",result);

    }
}