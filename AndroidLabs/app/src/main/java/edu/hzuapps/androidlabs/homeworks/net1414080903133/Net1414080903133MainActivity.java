package edu.hzuapps.androidlabs.homeworks.net1414080903133;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.R;

public class Net1414080903133MainActivity extends AppCompatActivity {
    private EditText et_password;
    private Button btn_login;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903133_main);
        et_name=(EditText) findViewById(R.id.et_name);
        et_password=(EditText) findViewById(R.id.et_password);
        btn_login=(Button) findViewById(R.id.btn_login);
        String username=et_name.getText().toString();
        String password=et_password.getText().toString();

        Button btJson= (Button) findViewById(R.id.btn_json);
        btJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903133MainActivity.this,Net1414080903133ShowJsonActivity.class));
            }
        });

    }
}

