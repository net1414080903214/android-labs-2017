package edu.hzuapps.androidlabs.homeworks.net1414080903130;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.hzuapps.androidlabs.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Net1414080903130JsonActivity extends AppCompatActivity {
    private String grade;
    private String name;
    private String number;
    private TextView GithubResponse;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903130_json);
        handler = new Handler();
        GithubResponse = (TextView) findViewById(R.id.response_info);
        sendRequest();
    }

    private void sendRequest() {
        new Thread(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("https://raw.githubusercontent.com/14YuQingBin/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903130/yqb.json").build();//目标地址
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    ParseJson(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.post(runnableUi);
            }
        }.start();
    }

    /*解析json文件*/
    private void ParseJson(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                grade = jsonObject.getString("grade");
                name = jsonObject.getString("name");
                number = jsonObject.getString("number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*更新UI*/
    Runnable runnableUi = new Runnable() {
        public void run() {
            GithubResponse.setText("班级: " + grade + "\n" + "\n" + "姓名: " + name + "\n" + "\n" + "学号: " + number + "\n" + "\n");//显示解析结果
        }
    };
}