package brandon.rodrigues.s301126222;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class rodriguesActivityPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodrigues_payment);

        final EditText textInputFullName = (EditText) findViewById(R.id.brandon_UserNameInput);
        final EditText textInputPayInfo = (EditText) findViewById(R.id.brandon_PaymentInput);
        final EditText textInputFavTeam = (EditText) findViewById(R.id.brandon_FavouriteTeamInput);
        final EditText textInputFavGame = (EditText) findViewById(R.id.brandon_FavouriteVGInput);

         final Pattern FULL_NAME =
                Pattern.compile(
                        "([a-zA-Z]+ )" +
                                "([a-zA-Z]+)"
                );
         final Pattern PAY_INFO =
                Pattern.compile(
                        "[0-9]+"
                );
         final Pattern SPORTS_TEAM =
                Pattern.compile(
                        "([a-zA-Z]+ )" +
                                "([a-zA-Z0-9']+)"
                );

         Button transactionBttn = (Button) findViewById(R.id.brandon_ButtonFinalScreen);

        transactionBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateName(textInputFullName);
                validateTeam(textInputFavTeam);
                validatePay(textInputPayInfo);
                validateGame(textInputFavGame);

                if(validateName(textInputFullName) && validatePay(textInputPayInfo) &&
                        validateTeam(textInputFavTeam) && validateGame(textInputFavGame)){
                    Toast.makeText(rodriguesActivityPayment.this, "Transaction complete!", Toast.LENGTH_LONG).show();
                }
            }

            private boolean validateName(EditText name) {

                String myName = name.getText().toString();
                if (myName.isEmpty()) {
                    name.setError("This field is empty.");
                    return false;
                } else if (!FULL_NAME.matcher(myName).matches()) {
                    name.setError("Please enter a valid name.");
                    return false;
                } else {
                    name.setError(null);
                    return true;
                }
            }

            private boolean validateGame(EditText name) {

                String myName = name.getText().toString();
                if (myName.isEmpty()) {
                    name.setError("This field is empty. Please enter a game name.");
                    return false;
                    } else {
                    name.setError(null);
                    return true;
                }
            }

            private boolean validatePay(EditText num) {

                String myNum = num.getText().toString();
                if (myNum.isEmpty()) {
                    num.setError("This field is empty.");
                    return false;
                } else if (!PAY_INFO.matcher(myNum).matches()) {
                    num.setError("Please enter valid pay information.");
                    return false;
                } else {
                    num.setError(null);
                    return true;
                }
            }

            private boolean validateTeam(EditText name) {

                String myName = name.getText().toString();
                if (myName.isEmpty()) {
                    name.setError("This field is empty.");
                    return false;
                } else if (!SPORTS_TEAM.matcher(myName).matches()) {
                    name.setError("Please enter a valid Team Name.");
                    return false;
                } else {
                    name.setError(null);
                    return true;
                }
            }
        });
    }
}
// Brandon Aaron Rodrigues 301126222 SEC.02
