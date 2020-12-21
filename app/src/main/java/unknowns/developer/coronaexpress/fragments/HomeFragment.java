package unknowns.developer.coronaexpress.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import unknowns.developer.coronaexpress.MainActivity;
import unknowns.developer.coronaexpress.R;
import unknowns.developer.coronaexpress.model.HttpHandler;

import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private TextView txt_bd_infected, txt_bd_cured, txt_bd_dead,
                    txt_world_infected, txt_world_cured, txt_world_dead,
                    txt_latest_news_body, txt_health_survey;

    private String str_bd_infected, str_bd_cured, str_bd_dead,
            str_world_infected, str_world_cured, str_world_dead,
            str_latest_news_body, str_health_survey;

    private ImageView img_stat_home,img_news_home;

    private String URL_BD, URL_WORLD;
    private JSONObject jsonObjBd, jsonObjWorld;

    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG,"Launched :D");

        View view = inflater.inflate(R.layout.fragment_home, null);

        txt_bd_infected = view.findViewById(R.id.bd_infected_text_view);
        txt_bd_cured = view.findViewById(R.id.bd_cured_text_view);
        txt_bd_dead = view.findViewById(R.id.bd_dead_text_view);
        txt_world_infected = view.findViewById(R.id.world_infected_text_view);
        txt_world_cured = view.findViewById(R.id.world_cured_text_view);
        txt_world_dead = view.findViewById(R.id.world_dead_text_view);

        txt_latest_news_body =  view.findViewById(R.id.latest_news_body_text);
        txt_health_survey =  view.findViewById(R.id.health_survey_body_text);

        img_news_home = view.findViewById(R.id.bg_news_home);

        txt_bd_infected.setText("....");
        txt_bd_dead.setText("....");
        txt_bd_cured.setText("....");
        txt_world_infected.setText("....");
        txt_world_dead.setText("....");
        txt_world_cured.setText("....");

        URL_BD = "https://corona.lmao.ninja/v2/countries/BD";
        URL_WORLD = "https://corona.lmao.ninja/v2/all?yesterday=false";

        img_stat_home = view.findViewById(R.id.bg_stat_home);
        img_stat_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragment(3);
            }
        });

        img_news_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragment(2);
            }
        });

        txt_health_survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragment(4);
            }
        });

        sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences("SAVED_DATA",Context.MODE_PRIVATE);

        if(((MainActivity) Objects.requireNonNull(getActivity())).CheckInternetConnection()){
            new DataCollector().execute();
        }else{
            if(sharedPreferences.getAll().containsKey("dataBD") && sharedPreferences.getAll().containsKey("dataWORLD")){
                try {
                    jsonObjBd = new JSONObject(sharedPreferences.getString("dataBD",null));
                    jsonObjWorld = new JSONObject(sharedPreferences.getString("dataWORLD",null));

                    ShowDataOnUi(jsonObjBd,jsonObjWorld);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return view;
    }

    private class DataCollector extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            Log.d(TAG,"Asynk Task Started");

            txt_bd_infected.setText("....");
            txt_world_cured.setText("....");

        }

        @Override
        protected Void doInBackground(Void... voids) {

            HttpHandler httpHandler = new HttpHandler();

            String jsonStringBD = httpHandler.makeServiceCall(URL_BD);
            String jsonStringWorld = httpHandler.makeServiceCall(URL_WORLD);

            try {
                jsonObjBd = new JSONObject(jsonStringBD);
                jsonObjWorld = new JSONObject(jsonStringWorld);
            } catch (Exception e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ShowDataOnUi(jsonObjBd,jsonObjWorld);

            if(!sharedPreferences.getAll().containsKey("dataBD")){
                if(!Objects.equals(sharedPreferences.getString("dataBD", null), jsonObjBd.toString())){
                    sharedPreferences.edit().putString("dataBD",jsonObjBd.toString()).apply();
                }
            }else{
                sharedPreferences.edit().putString("dataBD",jsonObjBd.toString()).apply();
            }
            if(!sharedPreferences.getAll().containsKey("dataWORLD")){
                if(!Objects.equals(sharedPreferences.getString("dataWORLD", null), jsonObjWorld.toString())){
                    sharedPreferences.edit().putString("dataWORLD",jsonObjWorld.toString()).apply();
                }
            }else{
                sharedPreferences.edit().putString("dataWORLD",jsonObjWorld.toString()).apply();
            }
        }
    }

    private void ShowDataOnUi(JSONObject jsonObjBd, JSONObject jsonObjWorld) {
        try {
            str_bd_dead = jsonObjBd.getString("deaths");
            str_bd_cured = jsonObjBd.getString("recovered");
            str_bd_infected = jsonObjBd.getString("cases");
            str_world_dead = jsonObjWorld.getString("deaths");
            str_world_cured = jsonObjWorld.getString("recovered");
            str_world_infected = jsonObjWorld.getString("cases");

            txt_bd_infected.setText(str_bd_infected);
            txt_bd_dead.setText(str_bd_dead);
            txt_bd_cured.setText(str_bd_cured);
            txt_world_infected.setText(str_world_infected);
            txt_world_dead.setText(str_world_dead);
            txt_world_cured.setText(str_world_cured);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
