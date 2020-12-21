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

public class NewsFragment extends Fragment {

    private ArrayList<String> string_headers_list = new ArrayList<>();

    private HashMap<String, List<String>> hashMap_data_text = new HashMap<>();
    private HashMap<String, int[]> hashMap_data_img = new HashMap<>();

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        string_headers_list.clear();
        hashMap_data_img.clear();
        hashMap_data_text.clear();

        expandableListView = view.findViewById(R.id.expandableList);

        string_headers_list.add(getResources().getString(R.string.parenting_stay_aware_heading));
        string_headers_list.add(getResources().getString(R.string.parenting_keep_calm_heading));
        string_headers_list.add(getResources().getString(R.string.parenting_talking_cov_heading));
        string_headers_list.add(getResources().getString(R.string.child_aware_heading));
        string_headers_list.add(getResources().getString(R.string.parenting_safe_on_internet_heading));
        string_headers_list.add(getResources().getString(R.string.parenting_family_budgeting_heading));
        string_headers_list.add(getResources().getString(R.string.parenting_family_harmony_heading));
        string_headers_list.add(getResources().getString(R.string.parenting_learning_through_play_heading));
        string_headers_list.add(getResources().getString(R.string.parenting_when_we_get_angry_heading));


        List<String> listTips = new ArrayList<>();


        listTips.add(getResources().getString(R.string.parenting_stay_aware_body_1));
        listTips.add(getResources().getString(R.string.parenting_stay_aware_body_2));
        int[] imgList = new int[]{R.drawable.parenting_aware_pic_1,R.drawable.parenting_aware_pic_2};
        hashMap_data_img.put(string_headers_list.get(0),imgList);
        hashMap_data_text.put(string_headers_list.get(0),listTips);

        List<String> listTips2 = new ArrayList<>();
        listTips2.add(getResources().getString(R.string.parenting_keep_calm_body_1));
        listTips2.add(getResources().getString(R.string.parenting_keep_calm_body_2));
        imgList = new int[]{R.drawable.parenting_keep_calm_1,R.drawable.parenting_keep_calm_2};
        hashMap_data_img.put(string_headers_list.get(1),imgList);
        hashMap_data_text.put(string_headers_list.get(1),listTips2);

        List<String> listTips3 = new ArrayList<>();
        listTips3.add(getResources().getString(R.string.parenting_talking_cov_body_1));
        listTips3.add(getResources().getString(R.string.parenting_talking_cov_body_2));
        imgList = new int[]{R.drawable.parenting_talking_cov_1,R.drawable.parenting_talking_cov_2};
        hashMap_data_img.put(string_headers_list.get(2),imgList);
        hashMap_data_text.put(string_headers_list.get(2),listTips3);

        List<String> listTips4 = new ArrayList<>();
        listTips4.add(getResources().getString(R.string.child_aware_body_1));
        listTips4.add(getResources().getString(R.string.child_aware_body_2));
        imgList = new int[]{R.drawable.child_aware_pic_1, R.drawable.child_aware_pic_2};
        hashMap_data_img.put(string_headers_list.get(3),imgList);
        hashMap_data_text.put(string_headers_list.get(3),listTips4);

        List<String> listTips5 = new ArrayList<>();
        listTips5.add(getResources().getString(R.string.parenting_safe_on_internet_1));
        listTips5.add(getResources().getString(R.string.parenting_safe_on_internet_2));
        imgList = new int[]{R.drawable.parenting_safe_on_internet_1, R.drawable.parenting_safe_on_internet_2};
        hashMap_data_img.put(string_headers_list.get(4),imgList);
        hashMap_data_text.put(string_headers_list.get(4),listTips5);

        List<String> listTips6 = new ArrayList<>();
        listTips6.add(getResources().getString(R.string.parenting_family_budgeting_1));
        imgList = new int[]{R.drawable.parenting_family_budgeting_1};
        hashMap_data_img.put(string_headers_list.get(5),imgList);
        hashMap_data_text.put(string_headers_list.get(5),listTips6);

        List<String> listTips7 = new ArrayList<>();
        listTips7.add(getResources().getString(R.string.parenting_family_harmony_1));
        imgList = new int[]{R.drawable.parenting_family_harmony_1};
        hashMap_data_img.put(string_headers_list.get(6),imgList);
        hashMap_data_text.put(string_headers_list.get(6),listTips7);

        List<String> listTips8 = new ArrayList<>();
        listTips8.add(getResources().getString(R.string.parenting_learning_through_play_1));
        listTips8.add(getResources().getString(R.string.parenting_learning_through_play_2));
        imgList = new int[]{R.drawable.parenting_learning_through_play_1,R.drawable.parenting_learning_through_play_2};
        hashMap_data_img.put(string_headers_list.get(7),imgList);
        hashMap_data_text.put(string_headers_list.get(7),listTips8);

        List<String> listTips9 = new ArrayList<>();
        listTips9.add(getResources().getString(R.string.parenting_when_we_get_angry_1));
        listTips9.add(getResources().getString(R.string.parenting_when_we_get_angry_1));
        imgList = new int[]{R.drawable.parenting_when_we_get_angry_1,R.drawable.parenting_when_we_get_angry_2};
        hashMap_data_img.put(string_headers_list.get(8),imgList);
        hashMap_data_text.put(string_headers_list.get(8),listTips9);


        expandableListAdapter = new unknowns.developer.coronaexpress.adapters.ExpandableListAdapter(getContext(),string_headers_list,hashMap_data_text,hashMap_data_img);

        expandableListView.setAdapter(expandableListAdapter);

        return view;
    }
}
