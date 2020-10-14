package brandon.rodrigues.s301126222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class rodriguesActivityCheckout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodrigues_checkout);

        Button paymentButton = (Button) findViewById(R.id.brandonPaymentBtn);

        final RadioButton debit = (RadioButton) findViewById(R.id.brandonDebit);
        final RadioButton credit = (RadioButton) findViewById(R.id.brandonCredit);

        SharedPreferences selectedHomes = getSharedPreferences("myRentalHomes", MODE_PRIVATE);
        int myInt = selectedHomes.getInt("myHomeCount",  0);
        RadioGroup homeRadioGroup = (RadioGroup) findViewById(R.id.brandonUserSelectedHomesRadio);

        for(int i = 1; i <= myInt; i++){

            LinearLayout.LayoutParams layoutParams = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
            );

            RadioButton homeRadioButton = new RadioButton(this);
            homeRadioButton.setId(View.generateViewId());
            homeRadioButton.setText(selectedHomes.getString("mySelectedHomes1",""));
            homeRadioGroup.addView(homeRadioButton, layoutParams);
            homeRadioButton.setChecked(true);
        }


        TextView tView = (TextView)findViewById(R.id.brandonUserSelectedHomesTitle);
        tView.setText("Please work" );

        TextView tView2 = (TextView)findViewById(R.id.brandonPaymentChoicesTitle);
        tView2.setText("Butt" );
        SharedPreferences myPaymentPref = getSharedPreferences("myPayMethod", 0);
        final SharedPreferences.Editor prefPayment = myPaymentPref.edit();

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(debit.isChecked())
                {
                    prefPayment.putInt("D", 1 );
                    prefPayment.apply();
                }
                if(credit.isChecked()){
                    prefPayment.putInt("D", 2 );
                    prefPayment.apply();
                }
                if(!debit.isChecked() && !credit.isChecked()){
                    Toast.makeText(rodriguesActivityCheckout.this, "No payment was selected!", Toast.LENGTH_LONG).show();
                }else{
                    rodriguesActivityPayment();
                }

            }
        });
    }


  //  public void OnCheckedChanged(RadioGroup group, int checkedID){
//if(checkedID == -1){

//}
    //}
    public void rodriguesActivityPayment(){
        Intent intentPay = new Intent(this, rodriguesActivityPayment.class);
        startActivity(intentPay);
    }

}