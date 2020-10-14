package brandon.rodrigues.s301126222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class rodriguesActivityApartment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodrigues_apartment);

        Button checkoutBttn = (Button) findViewById(R.id.brandon_AptCheckout);
        final CheckBox box1 = (CheckBox) findViewById(R.id.brandon_CheckBoxA1);
        final  CheckBox box2 = (CheckBox) findViewById(R.id.brandon_CheckBoxA2);
        final CheckBox box3 = (CheckBox) findViewById(R.id.brandon_CheckBoxA3);
        final CheckBox box4 = (CheckBox) findViewById(R.id.brandon_CheckBoxA4);

      //  final Set<String> selectedHomes = new HashSet<String>();

        checkoutBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;
                SharedPreferences myPreference = getSharedPreferences("myRentalHomes", 0);
                SharedPreferences.Editor prefEditor = myPreference.edit();
                List<String> list = new ArrayList<>();

                if(box1.isChecked()){
                    prefEditor.putString("mySelectedHomes1", getResources().getString(R.string.apt1));
                    count++;

                    prefEditor.apply();
                }
                if(box2.isChecked()){
                    prefEditor.putString("mySelectedHomes2", getResources().getString(R.string.apt2));
                    prefEditor.apply();
                    count++;
                }
                if(box3.isChecked()){
                    prefEditor.putString("mySelectedHomes3", getResources().getString(R.string.apt3));
                    count++;

                    prefEditor.apply();
                }
                if(box4.isChecked()){
                    prefEditor.putString("mySelectedHomes4", getResources().getString(R.string.apt4));
                    prefEditor.apply();
                    count++;
                }

                prefEditor.putInt("myHomeCount", count);
                prefEditor.apply();

                if(!box1.isChecked() && !box2.isChecked() && !box3.isChecked() && !box4.isChecked()){
                    Toast.makeText(rodriguesActivityApartment.this, "No homes were selected!", Toast.LENGTH_LONG).show();
                }else{
                    rodriguesActivityCheckout();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homesmenu, menu);
        return true;
    }

    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.brandon_DetachedMenu:
                rodriguesActivityDetached();
                break;

            case R.id.brandon_SemiMenu:
                rodriguesActivitySemi();
                break;

            case R.id.brandon_CondoMenu:
                rodriguesActivityCondo();
                break;

            case R.id.brandon_THMenu:
               rodriguesActivityTownHouse();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void rodriguesActivityCheckout(){

        Intent intentHomes = new Intent(this, rodriguesActivityCheckout.class);
        startActivity(intentHomes);
    }

    public void rodriguesActivityCondo(){

        Intent intentCondo = new Intent(this, rodriguesActivityCondo.class);
        startActivity(intentCondo);
    }

    public void rodriguesActivityDetached(){

        Intent intentDetached = new Intent(this, rodriguesActivityDetached.class);
        startActivity(intentDetached);
    }

    public void rodriguesActivitySemi(){

        Intent intentSemi = new Intent(this, rodriguesActivityDetached.class);
        startActivity(intentSemi);
    }
    public void rodriguesActivityTownHouse(){

        Intent intentTownHouse = new Intent(this, rodriguesActivityDetached.class);
        startActivity(intentTownHouse);
    }
}