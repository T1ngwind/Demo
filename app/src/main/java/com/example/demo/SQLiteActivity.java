package com.example.demo;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**Android数据存储之SQLite
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 11:06
 */
public class SQLiteActivity extends AppCompatActivity {

	EditText text_1;	//新建一个EditText用于输入信息
	EditText text_2;	//新建一个EditText用于输入信息
	ListView listView;	//新建一个ListView用于显示输入的信息对
	Button add;			//新建一个按钮

	SQLiteDatabase sqLiteDatabase;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_sqlite.xml文件定义的界面布局
		setContentView(R.layout.activity_sqlite);

		//创建或打开数据库（此处需要使用绝对路径）
		sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/SQLite.db3",null);

		text_1 		= findViewById(R.id.text_1);		//绑定控件
		text_2		= findViewById(R.id.text_2);		//绑定控件
		add   		= findViewById(R.id.add);			//绑定控件
		listView 	= findViewById(R.id.show);			//绑定控件

		//设置事件点击监听机制
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//获取用户输入
				String et_text_1 = text_1.getText().toString().trim();
				String et_text_2 = text_2.getText().toString().trim();
				try{
					//插入数据
					insertData(sqLiteDatabase,et_text_1,et_text_2);
					Cursor cursor = sqLiteDatabase.rawQuery("select * from news_inf",null);
					inflateList(cursor);
				}catch(SQLException se){
					//执行DDL创建数据表
					sqLiteDatabase.execSQL("create table news_inf(_id integer"
							+ " primary key autoincrement,"
							+ " news_input1 varchar(50),"
							+ " news_input2 varchar(255))");
					//执行insert语句插入数据
					insertData(sqLiteDatabase,et_text_1,et_text_2);
					//执行查询
					Cursor cursor = sqLiteDatabase.rawQuery("select * from news_inf",null);
					inflateList(cursor);
				}
			}
		});

	}


	/**insertData:插入数据
	 *
	 * @param  sqLiteDatabase 数据库
	 * @param input1 String	第一个输入值
	 * @param input2 String 第二个输入值
	 *  @return	void
	 * */
	public void insertData(SQLiteDatabase sqLiteDatabase,String input1,String input2){
		//执行插入语句
		sqLiteDatabase.execSQL("insert into news_inf values(null,?,?)",new String[]{input1,input2});
	}

	/**inflateList:插入数据
	 *
	 * @param  cursor 游标，是每行的集合
	 * @return	void 没有返回值
	 * */
	public void inflateList(Cursor cursor){

		//填充SimpleCursorAdapter
		SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(
				SQLiteActivity.this,
				R.layout.activity_line,cursor,
				new String[]{"news_input1","news_input2"},
				new int[]{R.id.my_title,R.id.my_content},
				CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		//显示数据
		listView.setAdapter(simpleCursorAdapter);


	}

	public void onDestory(){
		super.onDestroy();
		//退出程序时关闭SQLiteDatabase
		if(sqLiteDatabase!=null&&sqLiteDatabase.isOpen()){
			sqLiteDatabase.close();
		}
	}

}
