package unknowns.developer.coronaexpress.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

import unknowns.developer.coronaexpress.MainActivity;
import unknowns.developer.coronaexpress.R;
import unknowns.developer.coronaexpress.adapters.CountriesListAdapter;
import unknowns.developer.coronaexpress.model.HttpHandler;

public class StatisticsFragment extends Fragment {

    private String URL_ALL;

    private ListView listViewMain;
    private ProgressBar progressBar;
    private LinearLayout listViewContainer;
    private SearchView searchView;

    private JSONArray json;

    private SharedPreferences sharedPreferences;

    private JSONArray filteredList;

    private Boolean searched = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        URL_ALL = "https://corona.lmao.ninja/v2/countries?yesterday=false";

        listViewMain = view.findViewById(R.id.listViewMain);
        progressBar = view.findViewById(R.id.progress_circular);
        listViewContainer = view.findViewById(R.id.listviewContainer);
        searchView = view.findViewById(R.id.searchView);

        listViewContainer.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences("SAVED_DATA_LIST",Context.MODE_PRIVATE);

        if(((MainActivity) Objects.requireNonNull(getActivity())).CheckInternetConnection()){
            new DataCollection().execute();
        }else{
            if(sharedPreferences.getAll().containsKey("dataCountries")){
                try {
                    json = new JSONArray(sharedPreferences.getString("dataCountries",null));
                    ShowDataOnUi(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.isEmpty()){
                    searched = false;
                }else{
                    searched = true;
                }

                filteredList = new JSONArray();
                for(int i = 0; i < json.length(); i++){
                    try {
                        if(json.get(i).toString().toLowerCase().contains(s.toLowerCase())){
                            filteredList.put(json.get(i));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                ShowDataOnUi(filteredList);
                return true;
            }
        });


        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getContext());

                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final View dialogview = inflater.inflate(R.layout.country_details_dialog_custom,null);

                TextView txt_total_cases = dialogview.findViewById(R.id.total_cases_text_view);
                TextView txt_today_cases = dialogview.findViewById(R.id.today_cases_text_view);
                TextView txt_deaths = dialogview.findViewById(R.id.deaths_text_view);
                TextView txt_today_deaths = dialogview.findViewById(R.id.today_deaths_text_view);
                TextView txt_recoverd = dialogview.findViewById(R.id.recovered_text_view);
                TextView txt_active_cases = dialogview.findViewById(R.id.active_text_view);
                TextView txt_critical = dialogview.findViewById(R.id.critical_text_view);
                TextView txt_tests = dialogview.findViewById(R.id.tests_text_view);
                TextView txt_cases_mill = dialogview.findViewById(R.id.cases_mil_text_view);
                TextView txt_tests_mill = dialogview.findViewById(R.id.tests_mill_text_view);
                TextView txt_deaths_mill = dialogview.findViewById(R.id.deaths_mill_text_view);

                ImageView flag = dialogview.findViewById(R.id.imageViewCountryFlag);
                TextView txt_country_name = dialogview.findViewById(R.id.bd_text_stat_heading);

                try {
                    JSONObject jsonObject;
                    if(searched){
                        jsonObject = filteredList.getJSONObject(i);
                    }else{
                        jsonObject = json.getJSONObject(i);
                    }

                    txt_total_cases.setText(jsonObject.getString("cases"));
                    txt_today_cases.setText(jsonObject.getString("todayCases"));
                    txt_deaths.setText(jsonObject.getString("deaths"));
                    txt_today_deaths.setText(jsonObject.getString("todayDeaths"));
                    txt_recoverd.setText(jsonObject.getString("recovered"));
                    txt_active_cases.setText(jsonObject.getString("active"));
                    txt_critical.setText(jsonObject.getString("critical"));
                    txt_tests.setText(jsonObject.getString("tests"));
                    txt_cases_mill.setText(jsonObject.getString("casesPerOneMillion"));
                    txt_tests_mill.setText(jsonObject.getString("testsPerOneMillion"));
                    txt_deaths_mill.setText(jsonObject.getString("deathsPerOneMillion"));

                    txt_country_name.setText(jsonObject.getString("country"));

                    alertdialog.setView(dialogview);
                    alertdialog.create().show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        return view;
    }

    private class DataCollection extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            listViewContainer.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();
            try {
                json = new JSONArray(httpHandler.makeServiceCall(URL_ALL));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(!sharedPreferences.getAll().containsKey("dataCountries")){
                if(!Objects.equals(sharedPreferences.getString("dataCountries", null), json.toString())){
                    sharedPreferences.edit().putString("dataCountries",json.toString()).apply();
                }
            }else{
                sharedPreferences.edit().putString("dataCountries",json.toString()).apply();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            ShowDataOnUi(json);
        }
    }

    private void ShowDataOnUi(JSONArray json) {
        listViewContainer.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        CountriesListAdapter countriesListAdapter = new CountriesListAdapter(getContext(),json);
        listViewMain.setAdapter(countriesListAdapter);
    }
}
