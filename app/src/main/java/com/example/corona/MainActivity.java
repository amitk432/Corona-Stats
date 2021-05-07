package com.example.corona;


import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // JSON link https://run.mocky.io/v3/57cf3062-96b6-4213-ae4a-f23e18db62cd

    private static String JSON_URL = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";

    List<ModelClass> dataList ;
    RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        dataList = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerView) ;



        GetData getData = new GetData();
        getData.execute();

    }

    public class GetData extends AsyncTask<String, String, String>{


        @Override
        protected String doInBackground(String... strings) {


            String current = "" ;
            try{
                URL url ;
                HttpURLConnection urlConnection = null ;

                try{
                    url = new URL(JSON_URL) ;
                    urlConnection = (HttpURLConnection) url.openConnection() ;


                    InputStream is = urlConnection.getInputStream() ;
                    InputStreamReader isr = new InputStreamReader(is) ;

                    int data = isr.read() ;
                    while(data != -1){

                        current += (char) data ;
                        data = isr.read( );

                    }

                    return current ;



                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return current ;
        }


        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s) ;
                JSONArray  jsonArray = jsonObject.getJSONArray("regionData") ;

                for(int i = 0 ; i< jsonArray.length() ; i++){

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i) ;


                    ModelClass model = new ModelClass() ;
                    model.setRegion(jsonObject1.getString("region"));
                    model.setActiveCases(jsonObject1.getString("activeCases"));
                    model.setNewInfected(jsonObject1.getString("newInfected"));
                    model.setRecovered(jsonObject1.getString("recovered"));
                    model.setNewRecovered(jsonObject1.getString("newRecovered"));
                    model.setDeceased(jsonObject1.getString("deceased"));
                    model.setNewDeceased(jsonObject1.getString("newDeceased"));
                    model.setTotalInfected(jsonObject1.getString("totalInfected"));

                    dataList.add(model) ;

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(dataList) ;

        }
    }

    private void PutDataIntoRecyclerView(List<ModelClass> dataList) {

        Adaptery adaptery = new Adaptery(this, dataList) ;

        recyclerView.setAdapter(adaptery) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;
        recyclerView.bringToFront();

    }

}
