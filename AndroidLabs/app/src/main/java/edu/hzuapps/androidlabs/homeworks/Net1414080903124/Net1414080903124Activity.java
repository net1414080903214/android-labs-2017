package edu.hzuapps.androidlabs.homeworks.net1414080903124;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import edu.hzuapps.androidlabs.R;

public class Net1414080903124Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903124);
    }
    public void click1(View view) {
        Intent intent = new Intent(this, Net1414080903124queryActivity.class);
        startActivity(intent);
    }
    public void click2(View view) {
        Intent intent = new Intent(this, Net1414080903124transferActivity.class);
        startActivity(intent);
    }
    public void click3(View view) {
        Intent intent = new Intent(this, Net1414080903124drawActivity.class);
        startActivity(intent);
    }
    public void click4(View view) {
        Intent intent = new Intent(this, Net1414080903124bangActivity.class);
        startActivity(intent);
    }
    public void click5(View view) {
        Intent intent = new Intent(this, Net1414080903124AnalysisJson.class);
        startActivity(intent);
    }

}


