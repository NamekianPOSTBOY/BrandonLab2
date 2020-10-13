package brandon.rodrigues.s301126222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import brandon.rodrigues.s301126222.rodriguesHome;
import android.widget.AdapterView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class rodriguesActivityHomes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodrigues_homes);

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
        Intent intentApartment = new Intent(this, rodriguesActivityApartment.class);
        Intent intentDetached = new Intent(this, rodriguesActivityDetached.class);
        Intent intentSemi = new Intent(this, rodriguesActivitySemi.class);
        Intent intentCondo = new Intent(this, rodriguesActivityCondo.class);
        Intent intentTownHouse = new Intent(this, rodriguesActivityTownHouse.class);

        switch (item.getItemId()) {
            case R.id.brandon_ApartmentMenu:
                Toast.makeText(this, "You selected the Apartment option!", Toast.LENGTH_LONG).show();
                startActivity(intentApartment);
                break;

            case R.id.brandon_DetachedMenu:
                Toast.makeText(this, "You selected the Detached option!", Toast.LENGTH_LONG).show();
                startActivity(intentDetached);
                break;

            case R.id.brandon_SemiMenu:
                Toast.makeText(this, "You selected the Semi option!", Toast.LENGTH_LONG).show();
                startActivity(intentSemi);
                break;

            case R.id.brandon_CondoMenu:
                Toast.makeText(this, "You selected the Condo Option!", Toast.LENGTH_SHORT).show();
                startActivity(intentCondo);

                break;
            case R.id.brandon_THMenu:
                Toast.makeText(this, "You selected the Town House option!", Toast.LENGTH_LONG).show();
                startActivity(intentTownHouse);

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;

      }
    }
