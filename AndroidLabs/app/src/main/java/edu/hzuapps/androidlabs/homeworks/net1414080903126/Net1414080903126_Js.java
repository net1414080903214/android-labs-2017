package edu.hzuapps.androidlabs.homeworks.net1414080903126;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import edu.hzuapps.androidlabs.R;

public class Net1414080903126_Js extends AppCompatActivity {
    TextView show;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String a= parseJson((String) msg.obj);
            show.setText(a);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1414080903126__js);
        show= (TextView) findViewById(R.id.showjs);
        new Thread(){
            @Override
            public void run() {
                super.run();
                String a=a("https://raw.githubusercontent.com/IcyvE/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903126/1414080903126json.json"
                        );
                Message msg=handler.obtainMessage();
                msg.obj=a;
                handler.sendMessage(msg);
            }
        }.start();
    }

    public String a(String u) {
        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            StringBuilder sb = new StringBuilder();
            String a;
            int len;
            while ((len=is.read(b)) != -1) {
                a=new String(b,0,len);
                sb.append(a);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String parseJson(String data){
        StringBuilder sb=new StringBuilder();
        try {
            JSONArray jsonArray=new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);
                sb.append(object.getString("name"));
                sb.append("\n\n");
                sb.append(object.getString("date"));
                sb.append("\n\n");
                sb.append(object.getString("money"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

