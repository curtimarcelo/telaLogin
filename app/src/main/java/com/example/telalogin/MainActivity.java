package com.example.telalogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private Button realizarLogin;
    private TextView forgotPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes da UI
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        realizarLogin = findViewById(R.id.login_button);
        forgotPasswordText = findViewById(R.id.forgot_password_text);

        // Definindo o listener para o botão de login
        realizarLogin.setOnClickListener(v -> realizarLogin());

        // Definindo o listener para o link de recuperação de senha
        forgotPasswordText.setOnClickListener(v -> openAlterarSenhaActivity());
    }

    private void realizarLogin() {
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        // Validação dos campos de login
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            // Aqui você pode adicionar a lógica de autenticação com servidor, etc.
            Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    public void openCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    // Método que abre a Activity para alteração de senha
    private void openAlterarSenhaActivity() {
        Intent intent = new Intent(this, AlterarSenhaActivity.class);
        startActivity(intent);
    }
}


