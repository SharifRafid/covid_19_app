package unknowns.developer.coronaexpress.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

import unknowns.developer.coronaexpress.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<String> arrayList;
    private HashMap<String, List<String>> hashmap_text;
    private HashMap<String, int[]> hashmap_imgs;

    public ExpandableListAdapter(Context context, ArrayList<String> arrayList, HashMap<String, List<String>> hashmap_text, HashMap<String, int[]> hashmap_imgs) {
        this.context = context;
        this.arrayList = arrayList;
        this.hashmap_text = hashmap_text;
        this.hashmap_imgs = hashmap_imgs;
    }

    @Override
    public int getGroupCount() {
        return arrayList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashmap_text.get(arrayList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return arrayList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return hashmap_text.get(arrayList.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(i);
        if(view==null){
            LayoutInflater inflat = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflat.inflate(R.layout.expandable_list_group,viewGroup,false);
        }

        TextView textView = view.findViewById(R.id.titleTextView);

        textView.setText(headerTitle);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_list_item,viewGroup,false);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        textView.setText(hashmap_text.get(arrayList.get(i)).get(i1));

        imageView.setImageResource(hashmap_imgs.get(arrayList.get(i))[i1]);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
