package com.example.demo;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**用于显示常用UI控件
 * @author 			Ting听
 * @version 		1.0
 * @date 			2020-08-14 12:59
 */
public class UIWedgetActivity extends AppCompatActivity {
	/**
	 * @description:成员变量
	 * 		textView
	 * 		editText
	 * 		button
	 * 		radioButton1
	 * 		radioGroup
	 * 		checkBox1
	 * 		seekBar
	 * 		listView
	 * 		recyclerView
	 *
	 * 		arrayList
	 * 	*/

	TextView textView;			//新建一个TextView控件
	EditText editText;			//新建一个EditText控件
	Button button;				//新建一个Button控件
	RadioButton radioButton1;	//新建一个RadioButton控件
	RadioGroup radioGroup;		//新建一个RadioGroup控件
	CheckBox checkBox1;			//新建一个CheckBox控件
	SeekBar seekBar;			//新建一个SeekBar控件
	ListView listView;			//新建一个ListView控件
	RecyclerView recyclerView;	//新建一个RecyclerView控件

	List<String> arrayList;		//新建一个List数组



	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_uiwedget.xml文件定义的界面布局
		setContentView(R.layout.activity_uiwedget);

		textView 		= findViewById(R.id.textview);		//绑定控件
		editText 		= findViewById(R.id.edittext);		//绑定控件
		button  		= findViewById(R.id.button);		//绑定控件
		radioButton1 	= findViewById(R.id.radiobutton1);	//绑定控件
		radioGroup		= findViewById(R.id.radiogroup);	//绑定控件
		checkBox1  		= findViewById(R.id.checkbox1);		//绑定控件
		seekBar 		= findViewById(R.id.seekbar);		//绑定控件
		listView		= findViewById(R.id.listview);		//绑定控件
		recyclerView 	= findViewById(R.id.recyclerview);	//绑定控件


		/**
		 * @description:TextView
		 * 	为TextView组件textView绑定事件监听机制，更改该组件的文字描述
		 * */
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				textView.setText("更改了TextView的值");
			}
		});

		/**
		 * @description:Button
		 * 为Button控件button绑定事件监听
		 * */
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast toast = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				toast.setText("按钮button被点击了");
				toast.show();
			}
		});

		/**
		 * @description:RadioButton
		 * 为RadioButton控件radioButton1绑定事件监听
		 * */
		radioButton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast toast1 = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				toast1.setText("你选择了女性");
				toast1.show();
			}
		});

		/**
		 * @description:RadioGroup
		 * 为RadioGroup控件radiogroup绑定事件监听，根据选择的按钮显示不同的Toast。
		 * */
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup radioGroup, int i) {
				Toast toast2 = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				toast2.setText("你选择了"+(i==R.id.radiobutton2?"是":"否"));
				toast2.show();
			}
		});

		/**
		 * @description:CheckBox
		 * 为CheckBox控件checkbox绑定事件监听，通过Toast显示不同的信息。
		 * */
		checkBox1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast toast3 = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				if(checkBox1.isChecked()){
					toast3.setText("你选中了"+checkBox1.getText());
				}else{
					toast3.setText("你取消选中"+checkBox1.getText());
				}
				toast3.show();
			}
		});

		/**
		 * @description:SeekBar
		 * 为SeekBar控件seekBar绑定事件监听，通过Toast显示出seekBar的刻度值。
		 * */
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
				Toast toast4 = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				toast4.setText("当前滑动条的刻度为"+i);
				toast4.show();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});


		/**
		 * @description:ListView
		 * 	将String数组包装成ArrayAdapter，并为ListView控件listView设置适配器Adapter。
		 * 	并且设置要素点击事件监听，通过Toast将被点击的item的名称打印出来
		 * */
		String[] str_arr = new String[]{"贾宝玉","林黛玉","薛宝钗","香菱","秦可卿","贾雨村"};
		//将数组包装成ArrayAdapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,str_arr);
		//为ListView设置Adapter
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Toast toast5 = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				toast5.setText("你选择了ListView中的"+listView.getItemAtPosition(i));
				toast5.show();
			}
		});


		/**
		 * @description:RecyclerView
		 *		使用线性布局管理器
		 *
		 * */
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UIWedgetActivity.this,RecyclerView.HORIZONTAL,false);
		//设置recyclerView为线性布局管理器
		recyclerView.setLayoutManager(linearLayoutManager);
		arrayList = new ArrayList<String>();

		for(int i=0;i<20;i++){
			arrayList.add("item"+i);
		}
		MyAdapter adapter2 = new MyAdapter(this,arrayList);
		recyclerView.setAdapter(adapter2);
		//点击事件
		adapter2.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Toast toast = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				toast.setText(arrayList.get(position)+"被点击了");
				toast.show();
				/*Toast.makeText(RecyclerViewActivity.this,datas.get(position)+"被点击了",
						Toast.LENGTH_SHORT).show();*/
			}
		});
		//长按事件
		adapter2.setOnItemLongClickListener(new MyAdapter.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(View view, int position) {
				Toast toast = Toast.makeText(UIWedgetActivity.this,null,Toast.LENGTH_SHORT);
				toast.setText(arrayList.get(position)+"被长按了");
				toast.show();
				/*Toast.makeText(RecyclerViewActivity.this,datas.get(position)+"被长按了",
						Toast.LENGTH_SHORT).show();*/
				return true;
			}
		});



	}
}
