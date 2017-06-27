package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * ʵ�֡��鿴���¿��Ƴء���ť���¼���
 * ����һ��List������ݿ������п��Ƶ�id��name��level������ʾ����
 * 
 * �б���ʾ���ݵķ�����listview�����SimpleAdapter��
 */
import edu.hzuapps.androidlabs.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.*;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Visitdatabases;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Accessdata;

public class Net1414080903104lookActivity extends ActionBarActivity {
	List<Accessdata> U=new ArrayList<Accessdata>();//���ڴ�Ŵ����ݿ��ȡ�õ��Ŀ�������
	Visitdatabases Visit;//����һ��Visitdatabases�����Ա������ݿ⴫�����ݻ��ߴ����ݿ��ڻ�ȡ����
	ListView listView;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookactivity_net1414080903104);
        listView = (ListView) this.findViewById(R.id.listView);
        Visit=new Visitdatabases(this);
        U=Visit.queryAll();
        
        show();
    }

	private void show() {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();  
		Accessdata g = new Accessdata();//����װ����List<Accessdata> U�ڵĵ���Accessdata g
		for(int i = 0;i < U.size();i++){
			g=U.get(i);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", g.getId());  
            map.put("name", g.getName());  
            map.put("level", g.getLevel());  
            data.add(map);  
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_net1414080903104,  new String[] { "id", "name", "level" }, new int[] {  R.id.id, R.id.name, R.id.level }); 
		/*SimpleAdapter�Ĳ���˵��
		 * ��һ������ ��ʾ��������androidӦ�ó���ӿڣ����������е��������Ҫ
		 * �ڶ���������ʾ����һ��Map(String ,Object)�б�ѡ��
		 * ������������ʾ���沼�ֵ�id  ��ʾ���ļ���Ϊ�б�������
		 * ���ĸ�������ʾ��Map�������Щkey��Ӧvalue�������б���
		 * �����������ʾ��������� Map����key��Ӧ����Դһ���������� ˳���ж�Ӧ��ϵ
		 * ע�����map�������key�����Ҳ��� ������ı���Ҫ����Դ���  ��Ϊ �Ҳ���keyҲ�᷵��null ��ʵ���൱�ڸ���һ��null��Դ
		 * ����ĳ�������� new String[] { "name", "head", "desc","name" } new int[] {R.id.name,R.id.head,R.id.desc,R.id.head}
		 * ���head������ᱻname��Դ����
		 * */
        listView.setAdapter(adapter); 
	}
    
}
