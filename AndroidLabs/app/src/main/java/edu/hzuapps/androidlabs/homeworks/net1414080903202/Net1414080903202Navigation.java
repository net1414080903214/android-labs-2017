package edu.hzuapps.androidlabs.homeworks.net1414080903202;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1414080903202Navigation extends AppCompatActivity {

    Button btManage;
    Button btCheck;
    Button btTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903202_navigation);
        btManage =(Button) findViewById(R.id.manage);
        btCheck =(Button)  findViewById(R.id.check) ;
        btTest =(Button) findViewById(R.id.test);

        btManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903202Navigation.this, Net1414080903202manage.class);
                startActivity(intent);
            }
        });
        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903202Navigation.this, Net1414080903202Main_Check.class);
                startActivity(intent);
            }
        });
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1414080903202Navigation.this, Net1414080903202ShowJson.class);
                startActivity(intent);
            }
        });

    }
}
