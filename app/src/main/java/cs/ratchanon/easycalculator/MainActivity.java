package cs.ratchanon.easycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btnCalculate;
    private TextInputLayout tiplFirstNumber, tiplSecondNumber;
    private RadioGroup rdogOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matchView();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String strFirstNumber = tiplFirstNumber.getEditText().getText().toString();
               String strSecondNumber = tiplSecondNumber.getEditText().getText().toString();

               if(strFirstNumber.isEmpty() || strSecondNumber.isEmpty()) {
                   tvResult.setText("กรุณากรอกข้อมูลให้ครบก่อน!กดปุมคำนวณ");
               }else{
                  int id = rdogOperator.getCheckedRadioButtonId();
                  float first = Float.parseFloat(strFirstNumber);
                  float second = Float.parseFloat(strSecondNumber);
                  float result = 0;
                  if(id == R.id.rdo_plus) {
                      result = first + second;
                  }else if(id == R.id.rdo_multiply){
                      result = first*second;
                  }else if(id == R.id.rdo_divide){
                      result = first/second;
                  }else if(id == R.id.rdo_minus){
                      result = first-second;
                  }
                  if(result==(int)result) {
                      tvResult.setText(String.format("%.0f",result));
                  }else {
                      tvResult.setText(String.valueOf(result));
                  }
               }
            }
        });
    }

    private void matchView() {
       btnCalculate = findViewById(R.id.btn_calculate);
       tvResult = findViewById(R.id.tv_result);
       tiplFirstNumber = findViewById(R.id.tipl_first_number);
       tiplSecondNumber = findViewById(R.id.tipl_second_number);
       rdogOperator = findViewById(R.id.rdog_operator);
    }
}