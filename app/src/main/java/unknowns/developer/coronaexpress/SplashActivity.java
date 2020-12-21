package unknowns.developer.coronaexpress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;

import java.util.Locale;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("lang",MODE_PRIVATE);

        if(sharedPreferences.getAll().containsKey("lang")){
            if(Objects.equals(sharedPreferences.getString("lang", null), "bn")){
                Locale myLocale = new Locale("bn");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = myLocale;
                res.updateConfiguration(conf, dm);
                Intent refresh = new Intent(this, MainActivity.class);
                finish();
                startActivity(refresh);
            }else{
                Intent refresh = new Intent(this, MainActivity.class);
                finish();
                startActivity(refresh);
            }
        }else{

            Intent refresh = new Intent(this, MainActivity.class);
            finish();
            startActivity(refresh);
        }

    }
}