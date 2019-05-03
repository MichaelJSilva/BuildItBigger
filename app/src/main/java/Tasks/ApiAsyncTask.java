package Tasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.androidjokelib.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import interfaces.AsyncTaskDelegate;

public class ApiAsyncTask extends AsyncTask<Context,AsyncTaskDelegate,String> {

    final static String TASK_EXCEPTION_TAG = "Exception";

    private static MyApi jokeapiService = null;
    public AsyncTaskDelegate delegate;
    private Context mContext;
    private String chosenJoke;

    public ApiAsyncTask(Context context, AsyncTaskDelegate asyncTaskDelegate) {
        this.mContext = context;
        this.delegate = asyncTaskDelegate;
    }

    public String getChosenJoke() {
        return chosenJoke;
    }

    public void setChosenJoke(String chosenJoke,AsyncTaskDelegate delegate) {
        this.chosenJoke = chosenJoke;
        this.delegate = delegate;
    }

    @Override
    protected void onPostExecute(String s) {

        delegate.afterPost(s);

    }

    @Override
    protected String doInBackground(Context... contexts) {

        if (jokeapiService == null){

            MyApi.Builder apiBuilder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null)
                    .setRootUrl("https://builditbiggeer.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            jokeapiService = apiBuilder.build();
        }


        //context = contexts[0];

        try {
            chosenJoke = jokeapiService.getJoke().execute().getData();
            return chosenJoke;
        } catch (IOException e) {
            Log.d(TASK_EXCEPTION_TAG,e.getMessage());
            return chosenJoke = "";
        }


    }


}
