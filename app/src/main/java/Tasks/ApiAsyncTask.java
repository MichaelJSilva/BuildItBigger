package Tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import interfaces.AsyncTaskDelegate;

public class ApiAsyncTask extends AsyncTask<Context,AsyncTaskDelegate,String> {

    private static MyApi jokeapiService = null;
    private Context context;

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
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


        context = contexts[0];

        try {
            //return jokeapiService.getJoke
            return jokeapiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }


    }


}
