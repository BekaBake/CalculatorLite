package kg.itrun.calculatorlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numberOne;
    EditText numberTwo;
    TextView operandTv;
    TextView resultTv;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = findViewById(R.id.num_one);
        numberTwo = findViewById(R.id.num_two);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        resultTv = findViewById(R.id.result);
        operandTv = findViewById(R.id.operand);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseData("+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseData("-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseData("*");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseData("/");
            }
        });
    }

    private void parseData(String operand) {
        String oneString = numberOne.getText().toString();
        String twoString = numberTwo.getText().toString();

        if (!oneString.isEmpty() && !twoString.isEmpty()) {
            float one = Float.parseFloat(oneString);
            float two = Float.parseFloat(twoString);
            calculate(one, two, operand);
        }
    }

    private void calculate(float one, float two, String operand) {
        operandTv.setText(operand);
        float result = 0;
        switch (operand) {
            case "+":
                result = one + two;
                break;
            case "-":
                result = one - two;
                break;
            case "*":
                result = one * two;
                break;
            case "/":
                result = one / two;
                break;
        }
        resultTv.setText(result + "");
    }
}