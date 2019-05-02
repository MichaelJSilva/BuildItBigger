import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.free.MainActivityFragment;

import org.junit.Test;
import org.junit.runner.RunWith;

import Tasks.ApiAsyncTask;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ApiAsyncTaskTest {


    @Test
    public void doInBackground() throws InterruptedException {
        MainActivity activity = new MainActivity();

        ApiAsyncTask task;

        task = (ApiAsyncTask) new ApiAsyncTask().execute(activity);

        Thread.sleep(5000);

        assertTrue(task.joke != null && !task.joke.equals(""));



    }
}