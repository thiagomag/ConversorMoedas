package com.thiago.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.txtDolar = findViewById(R.id.txt_dolar);
        this.mViewHolder.txtEuro = findViewById(R.id.txt_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.btn_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String value = this.mViewHolder.editValue.getText().toString();
            if ("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                double real = Double.parseDouble(value);

                this.mViewHolder.txtDolar.setText(String.format("%.2f", (real / 4)));
                this.mViewHolder.txtEuro.setText(String.format("%.2f", (real / 5)));
            }
        }
    }

    private void clearValues() {
        this.mViewHolder.txtDolar.setText("");
        this.mViewHolder.txtEuro.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView txtDolar;
        TextView txtEuro;
        Button buttonCalculate;


    }
}