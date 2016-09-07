package id.sch.smktelkom_mlg.tugas01.xiirpl1001.orderanpensilpatah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText namaOrder, backgroundOrder;
    TextView hasil;
    RadioButton RB1M, RB2M;
    RadioGroup RG;
    CheckBox CBFB, CBRB, CBHC;
    Spinner jumlahOrder;
    Button buttonOK;

    boolean requestBackground = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaOrder = (EditText) findViewById(R.id.editTextNMorder);
        backgroundOrder = (EditText) findViewById(R.id.editTextJumlah);
        hasil = (TextView) findViewById(R.id.textViewHasil);
        RB1M = (RadioButton) findViewById(R.id.radioButton1M);
        RB2M = (RadioButton) findViewById(R.id.radioButton2M);
        RG = (RadioGroup) findViewById(R.id.RGdeadline);
        CBFB = (CheckBox) findViewById(R.id.checkBoxFB);
        CBRB = (CheckBox) findViewById(R.id.checkBoxRB);
        CBHC = (CheckBox) findViewById(R.id.checkBoxHC);
        jumlahOrder = (Spinner) findViewById(R.id.spinnerJumlah);
        buttonOK = (Button) findViewById(R.id.buttonOK);

        CBRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    backgroundOrder.setVisibility(View.VISIBLE);
                    requestBackground = true;
                } else {
                    backgroundOrder.setVisibility(View.GONE);
                    requestBackground = false;
                }
            }
        });

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button OK KLIK!
                doKlik();
            }
        });
    }

    private void doKlik() {
        int harga = 0;
        int jum = (Integer) jumlahOrder.getSelectedItem();

        harga += 50000 * jum;

        StringBuilder builder = new StringBuilder();
        builder.append("Nama Pemesan : ").append(namaOrder.getText()).append("\n");

        String deadline = null;
        if (RB1M.isChecked()) {
            deadline = RB1M.getText().toString();
            harga -= 10000;
        } else if (RB2M.isChecked()) {
            deadline = RB2M.getText().toString();
            harga += 0;
        }
        builder.append("Deadline     : ").append(deadline).append("\n");

        builder.append("Orderan      : ").append(namaOrder.getText()).append("\n");
        if (CBFB.isChecked()) {
            builder.append("\t Full Body").append("\n");
            harga += 25000 * jum;
        }
        if (CBRB.isChecked()) {
            builder.append("\t Background Request : ").append(backgroundOrder.getText()).append("\n");
            harga += 25000;
        }
        if (CBHC.isChecked()) {
            builder.append("\t Hardcopy").append("\n");
            harga += 45000;
        }

        builder.append("Jumlah Order : ").append(jum).append("\n");

        builder.append("Harga        : ").append(harga).append("\n");
    }
}
