package unknowns.developer.coronaexpress.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import unknowns.developer.coronaexpress.R;

public class CoronaFragment extends Fragment {

    private ArrayList<String> string_headers_list = new ArrayList<>();

    private HashMap<String, List<String>> hashMap_data_text = new HashMap<>();
    private HashMap<String, int[]> hashMap_data_img = new HashMap<>();

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_corona, container, false);

        string_headers_list.clear();
        hashMap_data_img.clear();
        hashMap_data_text.clear();

        expandableListView = view.findViewById(R.id.expandableList);

        string_headers_list.add(getResources().getString(R.string.what_is_corona_heading));
        string_headers_list.add(getResources().getString(R.string.what_is_covid19_heading));
        string_headers_list.add(getResources().getString(R.string.how_does_it_spread_heading));
        string_headers_list.add(getResources().getString(R.string.symptoms_of_covid19_heading));
        string_headers_list.add(getResources().getString(R.string.what_to_do_heading));


        List<String> listTips = new ArrayList<>();


        listTips.add(getResources().getString(R.string.what_is_corona_1));
        int[] imgList = new int[]{R.drawable.about_corona};
        hashMap_data_img.put(string_headers_list.get(0),imgList);
        hashMap_data_text.put(string_headers_list.get(0),listTips);

        List<String> listTips2 = new ArrayList<>();
        listTips2.add(getResources().getString(R.string.what_is_covid19_1));
        imgList = new int[]{R.drawable.about_corona_1};
        hashMap_data_img.put(string_headers_list.get(1),imgList);
        hashMap_data_text.put(string_headers_list.get(1),listTips2);

        List<String> listTips3 = new ArrayList<>();
        listTips3.add(getResources().getString(R.string.how_does_it_spread));
        imgList = new int[]{R.drawable.about_corona};
        hashMap_data_img.put(string_headers_list.get(2),imgList);
        hashMap_data_text.put(string_headers_list.get(2),listTips3);

        List<String> listTips4 = new ArrayList<>();
        listTips4.add(getResources().getString(R.string.symptoms_of_covid19));
        imgList = new int[]{R.drawable.about_corona_1};
        hashMap_data_img.put(string_headers_list.get(3),imgList);
        hashMap_data_text.put(string_headers_list.get(3),listTips4);

        List<String> listTips5 = new ArrayList<>();
        listTips5.add(getResources().getString(R.string.what_to_do));
        imgList = new int[]{R.drawable.about_corona};
        hashMap_data_img.put(string_headers_list.get(4),imgList);
        hashMap_data_text.put(string_headers_list.get(4),listTips5);


        expandableListAdapter = new unknowns.developer.coronaexpress.adapters.ExpandableListAdapter(getContext(),string_headers_list,hashMap_data_text,hashMap_data_img);

        expandableListView.setAdapter(expandableListAdapter);

        return view;
    }
}
