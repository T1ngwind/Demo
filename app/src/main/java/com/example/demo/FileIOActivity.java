package com.example.demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**Android数据存储之FileIO
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 10:59
 */
public class FileIOActivity extends AppCompatActivity {

	private static final String FILE_NAME = "File.txt";
	//读出框
	EditText Read;
	//写入框
	EditText Write;
	//读出按钮
	Button readOut;
	//写入按钮
	Button writeIn;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_fileio.xml文件定义的界面布局
		setContentView(R.layout.activity_fileio);


		Read  	 = findViewById(R.id.txt_read);
		Read.setKeyListener(null);
		Write   = findViewById(R.id.txt_write);
		readOut = findViewById(R.id.readOut);
		writeIn = findViewById(R.id.writeIn);

		//写入到文件中
		writeIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(TextUtils.isEmpty(Write.getText().toString().trim())){
					Toast.makeText(FileIOActivity.this,"请输入内容",Toast.LENGTH_SHORT).show();
				}else{
					//将写入框中的内容写入文件
					write(Write.getText().toString());
					Write.setText("");
				}
			}
		});

		//读出文件中的内容
		readOut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//将文件中的内容读出到read框
				Read.setText(read());
			}
		});
	}
	public void write(String toString) {
		try {
			//以追加方式打开文件输出流
			FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
			//将FileOutputStream包装成PrintStream
			PrintStream ps = new PrintStream(fos);
			//输出文件内容
			ps.println(toString);
			//关闭文件输出流
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public String read() {
		try {
			//打开文件输入流
			FileInputStream fis = openFileInput(FILE_NAME);
			byte[] buff = new byte[1024];
			int hasRead = 0;
			StringBuilder sb = new StringBuilder();
			//读取文件内容
			while((hasRead=fis.read(buff))>0){
				sb.append(new String(buff,0,hasRead));
			}
			//关闭文件输入流
			fis.close();
			return sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


}

