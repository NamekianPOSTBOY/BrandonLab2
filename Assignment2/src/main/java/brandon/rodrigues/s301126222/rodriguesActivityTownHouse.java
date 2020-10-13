package brandon.rodrigues.s301126222;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class rodriguesActivityTownHouse extends AppCompatActivity {

    CheckBox box1 = (CheckBox) findViewById(R.id.brandon_CheckBoxT1);
    CheckBox box2 = (CheckBox) findViewById(R.id.brandon_CheckBoxT2);
    CheckBox box3 = (CheckBox) findViewById(R.id.brandon_CheckBoxT3);
    CheckBox box4 = (CheckBox) findViewById(R.id.brandon_CheckBoxT4);
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodrigues_town_house);

        Button checkoutBttn = (Button) findViewById(R.id.brandon_TownHouseCheckout);

        checkoutBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myChosenHomes =
                        getSharedPreferences("userSelectedHomes", 0);
                SharedPreferences.Editor prefEditor = myChosenHomes.edit();
                if(box1.isChecked()){
                    prefEditor.putString("home1", context.getString(R.string.townhouse1));
                    prefEditor.apply();
                    //call intent only to show the next activity
                }else{
                    prefEditor.putString("home1", null);
                    prefEditor.apply();
                }
                if(box2.isChecked()){
                    prefEditor.putString("home2", context.getString(R.string.townhouse2));
                    prefEditor.apply();
                    //call intent only to show the next activity
                }else{
                    prefEditor.putString("home2", null);
                    prefEditor.apply();
                }
                if(box3.isChecked()){
                    prefEditor.putString("home3", context.getString(R.string.townhouse3));
                    prefEditor.apply();
                    //call intent only to show the next activity
                }else{
                    prefEditor.putString("home3", null);
                    prefEditor.apply();
                }
                if(box4.isChecked()){
                    prefEditor.putString("home4", context.getString(R.string.townhouse4));
                    prefEditor.apply();
                    //call intent only to show the next activity
                }else{
                    prefEditor.putString("home4", null);
                    prefEditor.apply();
                }

                if(!box1.isChecked() && !box2.isChecked() && !box3.isChecked() && !box4.isChecked()){
                    Toast.makeText(rodriguesActivityTownHouse.this, "No homes were selected!", Toast.LENGTH_LONG).show();
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

        Intent intentDetached = new Intent(this, rodriguesActivityDetached.class);
        Intent intentSemi = new Intent(this, rodriguesActivitySemi.class);
        Intent intentApartment = new Intent(this, rodriguesActivityApartment.class);
        Intent intentCondo = new Intent(this, rodriguesActivityCondo.class);

        switch (item.getItemId()) {

            case R.id.brandon_DetachedMenu:
                rodriguesActivityDetached();
                break;

            case R.id.brandon_SemiMenu:
                rodriguesActivitySemi();
                break;

            case R.id.brandon_ApartmentMenu:
                rodriguesActivityApartment();
                break;

            case R.id.brandon_CondoMenu:
               rodriguesActivityCondo();
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

    public void rodriguesActivityApartment(){

        Intent intentApartment = new Intent(this, rodriguesActivityApartment.class);
        startActivity(intentApartment);
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

    }