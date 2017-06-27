package edu.hzuapps.androidlabs.net1414080903109;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.maminjian.R;

public class Net1414080903109MainActivity extends AppCompatActivity {

    Button btAdd;
    Button btList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903109_main);
        btAdd= (Button) findViewById(R.id.bt_to_add);
        btList= (Button) findViewById(R.id.bt_to_list);
        btJson=(Button)findViewById(R.id.bt_to_json);

        /*�����ť��ת����ӽ��յĽ���*/
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903109MainActivity.this,Net1414080903109AddActivity.class));
            }
        });
        /*�����ť��ת����ʾ�����б�Ľ���*/
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903109MainActivity.this,Net1414080903109ListActivity.class));
            }
        });
        /*�����ť��ת������Json�ļ��������*/
        btJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Net1414080903109MainActivity.this,Net1414080903109_ParseJsonActivity.class));
            }
        });
    }
}
