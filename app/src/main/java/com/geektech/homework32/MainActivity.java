package com.geektech.homework32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email,subject,text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.et_email);
        subject = findViewById(R.id.et_subject);
        text = findViewById(R.id.et_text);
        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmail = email.getText().toString();
                String getSubject = subject.getText().toString();
                String getText = text.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{getEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, getSubject);
                intent.putExtra(Intent.EXTRA_TEXT, getText);
                startActivity(intent);
            }
        });
    }
}