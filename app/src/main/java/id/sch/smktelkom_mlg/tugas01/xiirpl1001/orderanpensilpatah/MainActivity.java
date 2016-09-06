package id.sch.smktelkom_mlg.tugas01.xiirpl1001.orderanpensilpatah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText namaOrder, backgroundOrder;
    RadioButton RB1M, RB2M;
    CheckBox CBFB, CBRB, CBHC;
    Spinner jumlahOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaOrder = (EditText) findViewById(R.id.editTextNMorder);
        backgroundOrder = (EditText) findViewById(R.id.editTextJumlah);
        RB1M = (RadioButton) findViewById(R.id.radioButton1M);
        RB2M = (RadioButton) findViewById(R.id.radioButton2M);
        CBFB = (CheckBox) findViewById(R.id.checkBoxFB);
        CBRB = (CheckBox) findViewById(R.id.checkBoxRB);
        CBHC = (CheckBox) findViewById(R.id.checkBoxHC);
        jumlahOrder = (Spinner) findViewById(R.id.spinnerJumlah);


    }
}
