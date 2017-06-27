package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * �������⣺
 * 1��api��ʹ��  ��url��ʹ��
 * 2��Ҫ��handler �ο���http://blog.csdn.net/superjunjin/article/details/7540064
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import edu.hzuapps.androidlabs.R;

public class Net1414080903104obtainjsonActivity extends ActionBarActivity {
	private static final int UPDATE_UI = 1;  
	private static final int ERROR = 2; 

	private static String jsonData;//���ڴ�Ż�ȡ�õ���json����
	private Sentence sentence;//���ڴ�Ž���json�õ�������
	private TextView tv;//������ʾjson����
	private TextView tv1;
	private TextView tv2;
	private Handler handler=new Handler(){  
        // ��������Ϣʱ����  
        @Override  
        public void handleMessage(Message msg) {  
            if (msg.what == UPDATE_UI) {  
                // ��ȡ��Ϣ����  
            	String ou=(String) msg.obj;
            	System.out.println(ou);
            	try {
					sentence=parseJsonByOrgJson(ou);
					tv.setText(sentence.getName());
					tv1.setText(sentence.getTime());
					tv2.setText(sentence.getOffer());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            } else if (msg.what == ERROR) {  
                // ToastҲ������UI�ĸ���  
                Toast.makeText(getApplicationContext(), "��ȡʧ�ܣ�", 0).show();  
            }  
        }  ;
    }; 
	

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obtainjson_net1414080903104);
        tv=(TextView)findViewById(R.id.jsoninfo);
        tv1=(TextView)findViewById(R.id.jsoninfo1);
        tv2=(TextView)findViewById(R.id.jsoninfo2);
        new Thread(){
        	public void run() {
        		try {
        			getJsonData();

        		}catch (Exception e) {
        			e.printStackTrace();
        			System.out.println("worry!");
       		}
            }
        }.start();
	}
	/**
     * ���������������ݣ�����ʹ��HttpURLConnection
     */
    public void getJsonData() {
    	 URL url = null;
			//String jsonData1 = ""; //������������ص�json�ַ������� 
			InputStreamReader in = null; //��ȡ�����ݣ���������
			try {
			    url = new URL("https://raw.githubusercontent.com/1414080903104/android-labs-2017/master/AndroidLabs/app/src/main/java/edu/hzuapps/androidlabs/homeworks/net1414080903104/jsoninfornation.json");
			    //����ط���url���ԣ���Ҫ��ȡ��github��api�ӿڡ�
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");  
                // ���ó�ʱʱ��  
                conn.setConnectTimeout(10000);  
                int code = conn.getResponseCode();  
                if (code == 200) {  
			    //��һ������������õ�������
			    in = new InputStreamReader(conn.getInputStream());
			 // Ϊ���봴��BufferedReader
	            BufferedReader br = new BufferedReader(in);
	            String inputLine = null;
	            while (((inputLine = br.readLine()) != null)) {
	                jsonData += inputLine;
	            }
	            in.close(); // �ر�InputStreamReader
	           // System.out.println(jsonData);
			 // �������߳�һ����Ϣ�����Ҹ���ui�����ݣ�bitmap  
                Message msg = new Message();  
                // ��Ϣ�Ĵ��ţ���һ��int����  
                msg.what = UPDATE_UI;  
                // Ҫ���ݵ���Ϣ����  
                msg.obj = jsonData;  
                // ����handler������Ϣ  
                handler.sendMessage(msg);  
            } else {  
                Message msg = new Message();  
                msg.what = ERROR;  
                handler.sendMessage(msg);  
            }  
			} catch (Exception ex) {
			    ex.printStackTrace();
			    Message msg = new Message();  
                msg.what = ERROR;  
                handler.sendMessage(msg);  
			}
			
    }
    /**
     * ͨ��org.json����json
     */
    public static Sentence parseJsonByOrgJson(String jsonStr) throws JSONException{
    	// ʹ�ø÷�������˼·��������������JsonObject����������JsonArray
        // ��һ���Ǵ�����
        JSONObject jsonObj = new JSONObject(jsonStr.replaceAll("null", ""));
        //��֪��ΪɶHttpURLConnection���������ȡ����json���ݣ�ǰ�����null��ͷ������ȡ�������ݸ�ʽΪ��null["xxx":"xxx"]
        //����������replaceALLȥ��null���ɽ����ɹ�
        
        // �½�Sentence����
        Sentence sen = new Sentence();
        sen.setName(jsonObj.getString("name")); 
        sen.setTime(jsonObj.getString("time") ); 
        sen.setOffer(jsonObj.getString("offer") );
        

        return sen;  
    }

}
