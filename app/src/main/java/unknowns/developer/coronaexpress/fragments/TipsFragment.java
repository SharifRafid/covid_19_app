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

public class TipsFragment extends Fragment {

    private ArrayList<String> string_headers_list = new ArrayList<>();

    private HashMap<String, List<String>> hashMap_data_text = new HashMap<>();
    private HashMap<String, int[]> hashMap_data_img = new HashMap<>();

    private int[] imgList;


    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        string_headers_list.clear();
        hashMap_data_img.clear();
        hashMap_data_text.clear();

        expandableListView = view.findViewById(R.id.expandableList);

        string_headers_list.add(getResources().getString(R.string.how_to_put_on_a_mask_title));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_1_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_2_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_3_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_6_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_7_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_8_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_9_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_10_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_11_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_12_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_13_heading));
        string_headers_list.add(getResources().getString(R.string.shihab_text_j4_14_heading));



        List<String> listTips = new ArrayList<>();
        listTips.add(getString(R.string.how_to_put_on_a_mask_1));
        listTips.add(getString(R.string.how_to_put_on_a_mask_2));
        listTips.add(getString(R.string.how_to_put_on_a_mask_3));
        listTips.add(getString(R.string.how_to_put_on_a_mask_4));
        imgList = new int[]{R.drawable.mask_on_pic_1_4, R.drawable.mask_on_pic_2,
                R.drawable.mask_on_pic_3, R.drawable.mask_on_pic_1_4};
        hashMap_data_img.put(string_headers_list.get(0),imgList);
        hashMap_data_text.put(string_headers_list.get(0),listTips);

        List<String> listTips2 = new ArrayList<>();
        listTips2.add(getString(R.string.shihab_text_j4_1_1));
        listTips2.add(getString(R.string.shihab_text_j4_1_2));
        listTips2.add(getString(R.string.shihab_text_j4_1_3));
        imgList = new int[]{R.drawable.shihab_data_j4_1_1,R.drawable.shihab_data_j4_1_2,R.drawable.shihab_data_j4_1_3};
        hashMap_data_img.put(string_headers_list.get(1),imgList);
        hashMap_data_text.put(string_headers_list.get(1),listTips2);

        List<String> listTips3 = new ArrayList<>();
        listTips3.add(getString(R.string.shihab_text_j4_2_1));
        listTips3.add(getString(R.string.shihab_text_j4_2_2));
        listTips3.add(getString(R.string.shihab_text_j4_2_3));
        imgList = new int[]{
                R.drawable.shihab_data_j4_2_1,
                R.drawable.shihab_data_j4_2_2,
                R.drawable.shihab_data_j4_2_3};
        hashMap_data_img.put(string_headers_list.get(2),imgList);
        hashMap_data_text.put(string_headers_list.get(2),listTips3);

        List<String> listTips4 = new ArrayList<>();
        listTips4.add(getString(R.string.shihab_text_j4_3_1));
        listTips4.add(getString(R.string.shihab_text_j4_3_2));
        listTips4.add(getString(R.string.shihab_text_j4_3_3));
        imgList = new int[]{
                R.drawable.shihab_data_j4_3_1,
                R.drawable.shihab_data_j4_3_2,
                R.drawable.shihab_data_j4_3_3};
        hashMap_data_img.put(string_headers_list.get(3),imgList);
        hashMap_data_text.put(string_headers_list.get(3),listTips4);

        List<String> listTips5 = new ArrayList<>();
        listTips5.add(getString(R.string.shihab_text_j4_6_1));
        imgList = new int[]{
                R.drawable.about_corona};
        hashMap_data_img.put(string_headers_list.get(4),imgList);
        hashMap_data_text.put(string_headers_list.get(4),listTips5);

        List<String> listTips6 = new ArrayList<>();
        listTips6.add(getString(R.string.shihab_text_j4_7_1));
        listTips6.add(getString(R.string.shihab_text_j4_7_2));
        listTips6.add(getString(R.string.shihab_text_j4_7_3));
        imgList = new int[]{
                R.drawable.shihab_data_j4_7_1,
                R.drawable.shihab_data_j4_7_2,
                R.drawable.shihab_data_j4_7_3};
        hashMap_data_img.put(string_headers_list.get(5),imgList);
        hashMap_data_text.put(string_headers_list.get(5),listTips6);

        List<String> listTips7 = new ArrayList<>();
        listTips7.add(getString(R.string.shihab_text_j4_8_1));
        listTips7.add(getString(R.string.shihab_text_j4_8_2));
        imgList = new int[]{
                R.drawable.shihab_data_j4_8_1,
                R.drawable.shihab_data_j4_8_2};
        hashMap_data_img.put(string_headers_list.get(6),imgList);
        hashMap_data_text.put(string_headers_list.get(6),listTips7);

        List<String> listTips8 = new ArrayList<>();
        listTips8.add(getString(R.string.shihab_text_j4_9_1));
        listTips8.add(getString(R.string.shihab_text_j4_9_2));
        listTips8.add(getString(R.string.shihab_text_j4_9_3));
        listTips8.add(getString(R.string.shihab_text_j4_9_4));
        imgList = new int[]{
                R.drawable.shihab_data_j4_9_1,
                R.drawable.shihab_data_j4_9_2,
                R.drawable.shihab_data_j4_9_3,
                R.drawable.shihab_data_j4_9_4};
        hashMap_data_img.put(string_headers_list.get(7),imgList);
        hashMap_data_text.put(string_headers_list.get(7),listTips8);

        List<String> listTips9 = new ArrayList<>();
        listTips9.add(getString(R.string.shihab_text_j4_10_1));
        listTips9.add(getString(R.string.shihab_text_j4_10_2));
        listTips9.add(getString(R.string.shihab_text_j4_10_3));
        listTips9.add(getString(R.string.shihab_text_j4_10_4));
        listTips9.add(getString(R.string.shihab_text_j4_10_5));
        listTips9.add(getString(R.string.shihab_text_j4_10_6));
        imgList = new int[]{
                R.drawable.shihab_data_j4_10_1,
                R.drawable.shihab_data_j4_10_2,
                R.drawable.shihab_data_j4_10_3,
                R.drawable.shihab_data_j4_10_4,
                R.drawable.shihab_data_j4_10_5,
                R.drawable.shihab_data_j4_10_6};
        hashMap_data_img.put(string_headers_list.get(8),imgList);
        hashMap_data_text.put(string_headers_list.get(8),listTips9);

        List<String> listTips10 = new ArrayList<>();
        listTips10.add(getString(R.string.shihab_text_j4_11_1));
        listTips10.add(getString(R.string.shihab_text_j4_11_2));
        listTips10.add(getString(R.string.shihab_text_j4_11_3));
        listTips10.add(getString(R.string.shihab_text_j4_11_4));
        imgList = new int[]{
                R.drawable.shihab_data_j4_11_1,
                R.drawable.shihab_data_j4_11_2,
                R.drawable.shihab_data_j4_11_3,
                R.drawable.shihab_data_j4_11_4};
        hashMap_data_img.put(string_headers_list.get(9),imgList);
        hashMap_data_text.put(string_headers_list.get(9),listTips10);

        List<String> listTips11 = new ArrayList<>();
        listTips11.add(getString(R.string.shihab_text_j4_12_1));
        listTips11.add(getString(R.string.shihab_text_j4_12_2));
        listTips11.add(getString(R.string.shihab_text_j4_12_3));
        listTips11.add(getString(R.string.shihab_text_j4_12_4));
        imgList = new int[]{
                R.drawable.shihab_data_j4_12_1,
                R.drawable.shihab_data_j4_12_2,
                R.drawable.shihab_data_j4_12_3,
                R.drawable.shihab_data_j4_12_4};
        hashMap_data_img.put(string_headers_list.get(10),imgList);
        hashMap_data_text.put(string_headers_list.get(10),listTips11);

        List<String> listTips12 = new ArrayList<>();
        listTips12.add(getString(R.string.shihab_text_j4_13_1));
        listTips12.add(getString(R.string.shihab_text_j4_13_2));
        listTips12.add(getString(R.string.shihab_text_j4_13_3));
        listTips12.add(getString(R.string.shihab_text_j4_13_4));
        listTips12.add(getString(R.string.shihab_text_j4_13_5));
        listTips12.add(getString(R.string.shihab_text_j4_13_6));
        imgList = new int[]{
                R.drawable.shihab_data_j4_13_1,
                R.drawable.shihab_data_j4_13_2,
                R.drawable.shihab_data_j4_13_3,
                R.drawable.shihab_data_j4_13_4,
                R.drawable.shihab_data_j4_13_5,
                R.drawable.shihab_data_j4_13_6};
        hashMap_data_img.put(string_headers_list.get(11),imgList);
        hashMap_data_text.put(string_headers_list.get(11),listTips12);

        List<String> listTips13 = new ArrayList<>();
        listTips13.add(getString(R.string.shihab_text_j4_14_1));
        listTips13.add(getString(R.string.shihab_text_j4_14_2));
        listTips13.add(getString(R.string.shihab_text_j4_14_3));
        listTips13.add(getString(R.string.shihab_text_j4_14_4));
        listTips13.add(getString(R.string.shihab_text_j4_14_5));
        imgList = new int[]{
                R.drawable.shihab_data_j4_14_1,
                R.drawable.shihab_data_j4_14_2,
                R.drawable.shihab_data_j4_14_3,
                R.drawable.shihab_data_j4_14_4,
                R.drawable.shihab_data_j4_14_5};
        hashMap_data_img.put(string_headers_list.get(12),imgList);
        hashMap_data_text.put(string_headers_list.get(12),listTips13);



        expandableListAdapter = new unknowns.developer.coronaexpress.adapters.ExpandableListAdapter(getContext(),string_headers_list,hashMap_data_text,hashMap_data_img);

        expandableListView.setAdapter(expandableListAdapter);

        return view;
    }
}
