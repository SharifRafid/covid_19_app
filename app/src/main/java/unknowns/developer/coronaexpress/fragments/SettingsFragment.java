package unknowns.developer.coronaexpress.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.gc.materialdesign.widgets.SnackBar;

import java.util.Objects;

import unknowns.developer.coronaexpress.MainActivity;
import unknowns.developer.coronaexpress.R;


public class SettingsFragment extends Fragment {

    private Switch swt_bn_lang, swt_en_lang;
    private SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_settings, container, false);

        swt_bn_lang = view.findViewById(R.id.switch_bng_lang);
        swt_en_lang = view.findViewById(R.id.switch_eng_lang);

        sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences("lang", Context.MODE_PRIVATE);

        if(sharedPreferences.getAll().containsKey("lang")){
            if(sharedPreferences.getString("lang",null).equals("bn")){
                swt_en_lang.setChecked(false);
                swt_bn_lang.setChecked(true);
            }else{
                swt_en_lang.setChecked(true);
                swt_bn_lang.setChecked(false);
            }
        }else{
            swt_en_lang.setChecked(true);
            swt_bn_lang.setChecked(false);

        }

        swt_en_lang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    swt_bn_lang.setChecked(false);
                    sharedPreferences.edit().putString("lang","en").apply();
                    SnackBar snackBar = new SnackBar(getActivity(),"Language Changed, It'll take effect the next time you run the app");
                    snackBar.show();
                }else{
                    swt_bn_lang.setChecked(true);
                    sharedPreferences.edit().putString("lang","bn").apply();
                    SnackBar snackBar = new SnackBar(getActivity(),"Language Changed, It'll take effect the next time you run the app");
                    snackBar.show();
                }
            }
        });
        swt_bn_lang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    swt_en_lang.setChecked(false);
                    sharedPreferences.edit().putString("lang","bn").apply();
                }else{
                    swt_en_lang.setChecked(true);
                    sharedPreferences.edit().putString("lang","en").apply();
                }
            }
        });

        return view;

    }
}
