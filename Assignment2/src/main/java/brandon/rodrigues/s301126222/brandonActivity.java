package brandon.rodrigues.s301126222;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import android.os.Bundle;

public class brandonActivity extends AppCompatActivity {
private Button enterBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBttn = (Button)  findViewById(R.id.brandon_MMbutton);
        enterBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rodriguesActivityHomes();
            }
        });
    }

    public void rodriguesActivityHomes(){

        Intent intentHomes = new Intent(this, rodriguesActivityHomes.class);
        startActivity(intentHomes);
    }
}
// Brandon Aaron Rodrigues 301126222 SEC.02