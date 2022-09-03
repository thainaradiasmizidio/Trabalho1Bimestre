package br.com.up.trabalho1bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout inputLayoutphone;
    private TextInputLayout inputLayoutmesages;

    private TextInputEditText inputEditTextPhone;
    private TextInputEditText inputEditTextMesages;

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputLayoutphone = findViewById(R.id.input_layout_phone);
        inputLayoutmesages = findViewById(R.id.input_layout_mesages);

        inputEditTextPhone = findViewById(R.id.input_text_phone);
        inputEditTextMesages = findViewById(R.id.input_text_mesages);

        buttonEnviar = findViewById(R.id.button_enviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = inputEditTextPhone.getText().toString();
                String mesages = inputEditTextMesages.getText().toString();

                Uri number = Uri.parse("https://wa.me/" + phone + "?text=" + mesages);
                Intent callIntent = new Intent(Intent.ACTION_VIEW, number);
                startActivity(callIntent);
            }

        });
    }
}