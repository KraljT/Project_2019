        package com.example.stuff_14;

        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.stuff_14.Home.Home_Activity;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    ProgressBar progressBar;
    EditText editTextEmail, editTextPassword;
    Button button;
    TextView login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        button = findViewById(R.id.buttonLogin);
        login = findViewById(R.id.textViewSignup);


        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.buttonLogin).setOnClickListener(this);
        findViewById(R.id.textViewSignup).setOnClickListener(this);
    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,"Enter password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), Home_Activity.class));
                } else {
                    Toast.makeText(MainActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();



                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view ==  button)
        {
            registerUser();
        }
        if(view == login)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), Login_Activity.class));
        }
    }

}
