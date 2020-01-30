package inventsoft.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Init elements
    private TextView celsiusLabel;
    private Button convertButton;
    private EditText fahrenheitInput;

    private DecimalFormat df = new DecimalFormat("#.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define elements
        celsiusLabel = findViewById(R.id.celsiusLabel);
        convertButton = findViewById(R.id.convertButton);
        fahrenheitInput = findViewById(R.id.fahrenheitInput);

        fahrenheitInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId & EditorInfo.IME_MASK_ACTION) != 0) {
                    onClick();
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    }

    public String convertTemperature(double fahrenheit){
        return df.format((fahrenheit - 32) * (5. / 9)) + " C°";
    }

    public void onClick(View view){
        if (fahrenheitInput.getText().length() != 0) {
            double fahrenheitTemp = Double.parseDouble(fahrenheitInput.getText().toString());
            celsiusLabel.setText(convertTemperature(fahrenheitTemp));
        }
        else {
            celsiusLabel.setText("C°");
        }

    }

    public void onClick(){
        if (fahrenheitInput.getText().length() != 0) {
            double fahrenheitTemp = Double.parseDouble(fahrenheitInput.getText().toString());
            celsiusLabel.setText(convertTemperature(fahrenheitTemp));
        }
        else {
            celsiusLabel.setText("C°");
        }
    }
}
