package com.example.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**注册界面，用于实现轻量级数据存储SharedPreferences
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 18:54
 */
public class RegisterActivity extends AppCompatActivity {

	String register_username;
	String register_password;

	EditText Register_username1;
	EditText Register_password1;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_register.xml文件定义的界面布局
		setContentView(R.layout.activity_register);

		Register_username1 = findViewById(R.id.Register_username);
		Register_password1 = findViewById(R.id.Register_password);

		Button Confirm = findViewById(R.id.confirm);


		Confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				register_username = Register_username1.getText().toString().trim();
				register_password = Register_password1.getText().toString().trim();
				User user = new User(register_username, register_password);
				Toast toast = Toast.makeText(RegisterActivity.this,null,Toast.LENGTH_SHORT);
				if (TextUtils.isEmpty(register_username)) {
					toast.setText("请输入用户名");
//					return;
				} else if (TextUtils.isEmpty(register_password)) {
					toast.setText("请输入密码");
//					return;
				} else if (isExistUserName(register_username)) {
					toast.setText("用户名已存在");
//					return;
				} else {
					toast.setText("注册成功");

					//把账号、密码和账号标识保存到sp里面
					//保存账号和密码到SharedPreferences中
					saveRegisterInfo(register_username, register_password);

					Bundle data = new Bundle();
					data.putSerializable("user", user);
					Intent intent = new Intent(RegisterActivity.this, SharedPreferencesActivity.class);
					intent.putExtras(data);
					startActivity(intent);
				}
				toast.show();

			}
		});
	}



	// 从SharedPreferences中读取输入的用户名，判断SharedPreferences中是否有此用户名
	public boolean isExistUserName(String userName){

		boolean has_userName=false;//表示是否有用户名
		//mode_private SharedPreferences sp = getSharedPreferences( );
		// "loginInfo", MODE_PRIVATE
		SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
		//获取密码
		String spPsw=sp.getString(userName, "");//传入用户名获取密码	//通过sp.getString传值用户名获取到密码

		//如果密码不为空则确实保存过这个用户名
		//TextUtils类是系统自带的一个工具类
		//是否为空字符 TextUtils.isEmpty(CharSequence str)
		if(!TextUtils.isEmpty(spPsw)) { //判断这个密码是否为空
			has_userName=true;//该用户是否保存了这一个密码
		}
		return has_userName;


	}




	public void saveRegisterInfo(String register_username,String register_password){
		//loginInfo表示文件名, mode_private SharedPreferences sp = getSharedPreferences( );
		SharedPreferences sp  = getSharedPreferences("loginInfo",MODE_PRIVATE);
		//获取编辑器
		SharedPreferences.Editor editor = sp.edit();//获取编辑器
		//以用户名为key，密码为value保存在SharedPreferences中
		//key,value,如键值对，editor.putString(用户名，密码）;
		editor.putString(register_username,register_password);
		//提交修改 editor.commit();
		editor.commit();
	}


}
