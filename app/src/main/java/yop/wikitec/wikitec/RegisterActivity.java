package yop.wikitec.wikitec;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

        private EditText txt_Pass;
        private ProgressBar pBar_Pass;
        private TextView lbl_PassLevel;
        private Button btn_register;
        private EditText txt_Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txt_Pass = this.findViewById(R.id.txt_Password);
        pBar_Pass = this.findViewById(R.id.pBar_Password);
        txt_Email = this.findViewById(R.id.txt_Email);
        lbl_PassLevel = this.findViewById(R.id.lbl_PassLevel);
        btn_register = this.findViewById(R.id.btn_regis);

        txt_Pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int passwordLevel = 0;
                if(s.length() >= 6){
                    passwordLevel++;
                    if(containsUpperLetter(s) && containsLowerLetter(s)){
                        passwordLevel++;
                    }
                    if(containsNumber(s)){
                        passwordLevel++;
                    }
                    if(s.length() >= 10) passwordLevel++;
                }
                updatePasswordBar(passwordLevel);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), home.class);
                startActivity(intent);
                finish();
            }
        });



    }
    protected void updatePasswordBar(int passLvl){
        if(passLvl == 0){
            pBar_Pass.setProgress(0);
            pBar_Pass.getProgressDrawable()
                    .setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
            lbl_PassLevel.setText("Nivel");
        }
        else if(passLvl == 1){
            pBar_Pass.setProgress(25);
            pBar_Pass.getProgressDrawable()
                    .setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
            lbl_PassLevel.setText("Mala");
        }
        else if (passLvl == 2){
            pBar_Pass.setProgress(50);
            pBar_Pass.getProgressDrawable()
                    .setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
            lbl_PassLevel.setText("Regular");
        }
        else if (passLvl == 3){
            pBar_Pass.setProgress(75);
            pBar_Pass.getProgressDrawable()
                    .setColorFilter(Color.rgb(0,128,255), PorterDuff.Mode.MULTIPLY);
            lbl_PassLevel.setText("Buena");
        }
        else if(passLvl >= 4){
            pBar_Pass.setProgress(100);
            pBar_Pass.getProgressDrawable()
                    .setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
            lbl_PassLevel.setText("Excelente");
        }
    }
    private boolean validatePassword(){
        String regex = "[a-zA-Z0-9@#$!%^&+=.]{6,}";
        String p = txt_Pass.getText().toString();
        if(!p.matches(regex)){
            Toast.makeText(this, "La contraseña debe tener letras, números, caracteres especiales y mínimo 6 caracteres.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validateEmail(){
        String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String fn = txt_Email.getText().toString();
        if(!fn.matches(regex)){
            Toast.makeText(this, "Correo electrónico inválido.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean containsUpperLetter(CharSequence s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') return true;
        }
        return false;
    }
    private boolean containsLowerLetter(CharSequence s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') return true;
        }
        return false;
    }
    private boolean containsNumber(CharSequence s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') return true;
        }
        return false;
    }
}

