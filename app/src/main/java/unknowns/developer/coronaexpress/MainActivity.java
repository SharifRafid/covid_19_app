package unknowns.developer.coronaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import unknowns.developer.coronaexpress.adapters.ViewPagerAdapter;
import unknowns.developer.coronaexpress.fragments.HomeFragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gc.materialdesign.widgets.SnackBar;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPager viewPagerMain;

    private ViewPagerAdapter viewPagerAdapter;

    private ImageView img_home_nav, img_stat_nav,
            img_news_nav, img_help_nav, img_corona_nav,
            img_tips_nav, img_settings_nav;

    private int dialog_state = 0;

    private float clickedSize, normalSize;

    private int code_permission = 1;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("APP_LAUNCH",MODE_PRIVATE);

        if(first_launch()){
            AlertDialog.Builder dia = new AlertDialog.Builder(this);
            dia.setTitle("Language | ভাষা");
            dia.setPositiveButton("English", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    sharedPreferences.edit().putString("lang","en").apply();
                    SnackBar snackBar = new SnackBar(MainActivity.this,"Language Changed, It'll take effect the next time you run the app");
                    snackBar.show();
                }
            });
            dia.setNegativeButton(" বাংলা", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    sharedPreferences.edit().putString("lang","bn").apply();
                    SnackBar snackBar = new SnackBar(MainActivity.this,"Language Changed, It'll take effect the next time you run the app");
                    snackBar.show();
                }
            });
        }

        CheckInternetConnection();

        nav_declaration_and_on_clicks();


    }

    private void nav_declaration_and_on_clicks() {
        img_home_nav = findViewById(R.id.home_button_nav);
        img_stat_nav = findViewById(R.id.stat_button_nav);
        img_news_nav = findViewById(R.id.news);
        img_help_nav = findViewById(R.id.help);
        img_corona_nav = findViewById(R.id.corona);
        img_tips_nav = findViewById(R.id.tips);
        img_settings_nav = findViewById(R.id.settings);

        viewPagerMain = findViewById(R.id.main_fragment_container);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),3);

        viewPagerMain.setAdapter(viewPagerAdapter);

        img_settings_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerMain.setCurrentItem(6);
            }
        });

        img_tips_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerMain.setCurrentItem(4);
            }
        });

        img_news_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerMain.setCurrentItem(2);
            }
        });

        img_home_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerMain.setCurrentItem(0);
            }
        });

        img_help_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerMain.setCurrentItem(1);
            }
        });

        img_stat_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerMain.setCurrentItem(3);
            }
        });

        img_corona_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerMain.setCurrentItem(5);
            }
        });


        Resources r = getResources();
        normalSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                40f,
                r.getDisplayMetrics()
        );

        clickedSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                50f,
                r.getDisplayMetrics()
        );

        viewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==6){
                    AllImageDefaultHeight();

                    img_settings_nav.requestLayout();
                    img_settings_nav.getLayoutParams().height= (int) clickedSize;
                    img_settings_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==4){
                    AllImageDefaultHeight();

                    img_tips_nav.requestLayout();
                    img_tips_nav.getLayoutParams().height= (int) clickedSize;
                    img_tips_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==2){
                    AllImageDefaultHeight();

                    img_news_nav.requestLayout();
                    img_news_nav.getLayoutParams().height= (int) clickedSize;
                    img_news_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==0){
                    AllImageDefaultHeight();

                    img_home_nav.requestLayout();
                    img_home_nav.getLayoutParams().height= (int) clickedSize;
                    img_home_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==1){
                    AllImageDefaultHeight();

                    img_help_nav.requestLayout();
                    img_help_nav.getLayoutParams().height= (int) clickedSize;
                    img_help_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==3){
                    AllImageDefaultHeight();

                    img_stat_nav.requestLayout();
                    img_stat_nav.getLayoutParams().height= (int) clickedSize;
                    img_stat_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==5){
                    AllImageDefaultHeight();

                    img_corona_nav.requestLayout();
                    img_corona_nav.getLayoutParams().height= (int) clickedSize;
                    img_corona_nav.getLayoutParams().width= (int) clickedSize;
                }
            }

            @Override
            public void onPageSelected(int position) {
                if(position==6){
                    AllImageDefaultHeight();

                    img_settings_nav.requestLayout();
                    img_settings_nav.getLayoutParams().height= (int) clickedSize;
                    img_settings_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==4){
                    AllImageDefaultHeight();

                    img_tips_nav.requestLayout();
                    img_tips_nav.getLayoutParams().height= (int) clickedSize;
                    img_tips_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==2){
                    AllImageDefaultHeight();

                    img_news_nav.requestLayout();
                    img_news_nav.getLayoutParams().height= (int) clickedSize;
                    img_news_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==0){
                    AllImageDefaultHeight();

                    img_home_nav.requestLayout();
                    img_home_nav.getLayoutParams().height= (int) clickedSize;
                    img_home_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==1){
                    AllImageDefaultHeight();

                    img_help_nav.requestLayout();
                    img_help_nav.getLayoutParams().height= (int) clickedSize;
                    img_help_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==3){
                    AllImageDefaultHeight();

                    img_stat_nav.requestLayout();
                    img_stat_nav.getLayoutParams().height= (int) clickedSize;
                    img_stat_nav.getLayoutParams().width= (int) clickedSize;
                }else if(position==5){
                    AllImageDefaultHeight();

                    img_corona_nav.requestLayout();
                    img_corona_nav.getLayoutParams().height= (int) clickedSize;
                    img_corona_nav.getLayoutParams().width= (int) clickedSize;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private boolean first_launch() {
        if(sharedPreferences.getAll().containsKey("state")){
            return false;
        }else{
            sharedPreferences.edit().putString("state","launched").apply();
            return true;
        }
    }

    private void AllImageDefaultHeight() {
        img_settings_nav.requestLayout();
        img_settings_nav.getLayoutParams().height= (int) normalSize;
        img_settings_nav.getLayoutParams().width= (int) normalSize;


        img_tips_nav.requestLayout();
        img_tips_nav.getLayoutParams().height= (int) normalSize;
        img_tips_nav.getLayoutParams().width= (int) normalSize;


        img_corona_nav.requestLayout();
        img_corona_nav.getLayoutParams().height= (int) normalSize;
        img_corona_nav.getLayoutParams().width= (int) normalSize;


        img_help_nav.requestLayout();
        img_help_nav.getLayoutParams().height= (int) normalSize;
        img_help_nav.getLayoutParams().width= (int) normalSize;


        img_news_nav.requestLayout();
        img_news_nav.getLayoutParams().height= (int) normalSize;
        img_news_nav.getLayoutParams().width= (int) normalSize;

        img_home_nav.requestLayout();
        img_home_nav.getLayoutParams().height= (int) normalSize;
        img_home_nav.getLayoutParams().width= (int) normalSize;

        img_stat_nav.requestLayout();
        img_stat_nav.getLayoutParams().height= (int) normalSize;
        img_stat_nav.getLayoutParams().width= (int) normalSize;
    }


    public Boolean CheckInternetConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo==null){
            if(dialog_state==0){
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle(getResources().getString(R.string.dialog_internet_connection_title));
                alert.setMessage(getResources().getString(R.string.dialog_internet_connection_body));
                alert.setPositiveButton(getResources().getString(R.string.dialog_internet_connection_exit), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert.setNeutralButton(getResources().getString(R.string.dialog_internet_connection_load_no_internet), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.create().show();
                dialog_state ++;
            }

            return false;
        }else{
            return true;
        }

    }

    public void makeCall(String phoneNumber){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            Intent callIntent = new Intent();
            callIntent.setAction(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(callIntent);
        }else{
            requestPermission();
        }
    }


    public void replaceFragment(int i) {
        viewPagerMain.setCurrentItem(i);
    }

    public void requestPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
            new AlertDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.dialog_permission_title))
                    .setMessage(getResources().getString(R.string.dialog_permission_body))
                    .setPositiveButton(getResources().getString(R.string.dialog_permission_ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[] {Manifest.permission.CALL_PHONE}, code_permission);
                        }
                    })
                    .setNegativeButton(getResources().getString(R.string.dialog_permission_no), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, code_permission);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == code_permission)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e(TAG,"Permission Granted");
            } else {
                Log.e(TAG,"Permission Denied");
            }
        }
    }
}
