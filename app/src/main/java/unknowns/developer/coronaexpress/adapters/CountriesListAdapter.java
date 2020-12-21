package unknowns.developer.coronaexpress.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import unknowns.developer.coronaexpress.R;

public class CountriesListAdapter extends BaseAdapter {

    Context context;
    JSONArray jsonArray;

    public CountriesListAdapter(Context context, JSONArray jsonArray) {
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @Override
    public int getCount() {
        return jsonArray.length();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.countries_list_layout,viewGroup,false);

        TextView txt_infected = view.findViewById(R.id.bd_infected_text_view);
        TextView txt_cured = view.findViewById(R.id.bd_cured_text_view);
        TextView txt_dead = view.findViewById(R.id.bd_dead_text_view);

        TextView txt_country_name = view.findViewById(R.id.bd_text_stat_heading);

        try {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            txt_infected.setText(jsonObject.getString("cases"));
            txt_dead.setText(jsonObject.getString("deaths"));
            txt_cured.setText(jsonObject.getString("recovered"));

            txt_country_name.setText(jsonObject.getString("country"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return view;
    }
}
