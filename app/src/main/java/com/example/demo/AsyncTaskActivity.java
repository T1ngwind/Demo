package com.example.demo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class AsyncTaskActivity extends AppCompatActivity {

	private ImageView imageView;
	private Button button;
	//图片的网络地址
	private String image_path = "http://pic4.nipic.com/20090828/2366808_092035042961_2.jpg";
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynctask);
		imageView = (ImageView) findViewById(R.id.AsyncTaskImageView);
		button = (Button) findViewById(R.id.AsyncTaskButton);
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在下载，请稍后...");
		button.setOnClickListener(new View.OnClickListener() {
			//Android3以后不允许在UI主线程访问网络
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new MyTask().execute(image_path);
				Log.i("Ting","开始执行AsyncTask");
			}
		});
	}
	/*
	 * 第一个参数:表示要执行的任务的参数,一般传递一个路径
	 * 第二个参数:进度的刻度
	 * 第三个参数:任务执行的返回结果
	 */
	public class MyTask extends AsyncTask<String, Void, Bitmap>{

		//任务执行之前的操作
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog.show();
		}
		//完成下载或耗时任务操作
		@Override
		protected Bitmap doInBackground(String... params) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(params[0]);
			Bitmap bitmap = null;
			try {
				HttpResponse httpResponse = httpClient.execute(httpGet);
				//返回的状态码为200表示操作成功
				if(httpResponse.getStatusLine().getStatusCode() == 200){
					//获取实体类
					HttpEntity httpEntity = httpResponse.getEntity();
					//将实体类转换成字节数组
					byte[] data = EntityUtils.toByteArray(httpEntity);
					bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}
		//主要更新UI操作
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			imageView.setImageBitmap(result);
			dialog.dismiss();
		}
	}
}


/*public class AsyncTaskActivity extends AppCompatActivity {
	private ImageView imageView ;
	private Button button ;
	private ProgressDialog dialog ;
	//来自网络的图片
//	private String image_path = "http://imgsrc.baidu.com/forum/pic/item/7c1ed21b0ef41bd51a5ac36451da81cb39db3d10.jpg" ;
	private String image_path = "http://b.hiphotos.baidu.com/image/pic/item/b8389b504fc2d562acd3bf97e41190ef77c66cf4.jpg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynctask);

		//添加弹出的对话框
		dialog = new ProgressDialog(this) ;
		dialog.setTitle("提示") ;
		dialog.setMessage("正在下载图片，请稍后···") ;
		//将进度条设置为水平风格，让其能够显示具体的进度值
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL) ;
		dialog.setCancelable(false) ; //用了这个方法之后，直到图片下载完成，进度条才会消失（即使在这之前点击了屏幕）

		imageView = (ImageView)findViewById(R.id.AsyncTaskImageView) ;
		button = (Button)findViewById(R.id.AsyncTaskButton) ;
		//使用AsyncTask来实现Android多线程
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//点击按钮时，执行异步任务的操作
				new DownTask().execute(image_path) ;
			}
		});

	}
	*//*
	 * 异步任务执行网络下载图片
	 * *//*
	public class DownTask extends AsyncTask<String, Integer, byte[]> {
		//上面的方法中，第一个参数：网络图片的路径，第二个参数的包装类：进度的刻度，第三个参数：任务执行的返回结果
		@Override
		//在界面上显示进度条
		protected void onPreExecute() {
			dialog.show() ;
		};

		protected byte[] doInBackground(String... params) {  //三个点，代表可变参数
			//使用网络链接类HttpClient类完成对网络数据的提取，即完成对图片的下载功能
			HttpClient httpClient = new DefaultHttpClient() ;
			HttpGet httpget = new HttpGet(params[0]) ;
			byte[] result = null ;
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream() ;
			InputStream inputStream = null ;

			try {
				HttpResponse httpResponse = httpClient.execute(httpget) ;
				if(httpResponse.getStatusLine().getStatusCode()==200){

					HttpEntity httpEntiry = httpResponse.getEntity();
					inputStream = httpEntiry.getContent();
					//    先要获得文件的总长度
					long file_length = httpResponse.getEntity().getContentLength() ;
					int len = 0 ;
					//    每次读取1024个字节
					byte[] data = new byte[1024] ;
					//    每次读取后累加的长度
					int total_length = 0 ;
					while ((len = inputStream.read(data))!=-1) {
						//    每读一次，就将total_length累加起来
						total_length+=len ;
						//    得到当前图片下载的进度
						int progress_value = (int) ((total_length / (float)file_length)*100);
						//    时刻将当前进度更新给onProgressUpdate方法
						publishProgress(progress_value) ;
						outputStream.write(data, 0, len);
					}
					//    边读边写到ByteArrayOutputStream当中
					result = outputStream.toByteArray();
					//bitmap = BitmapFactory.decodeByteArray(result, 0, result.length) ;
				}
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				httpClient.getConnectionManager().shutdown();
			}
			return result;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			//    更新ProgressDialog的进度条
			dialog.setProgress(values[0]);
		}

		//主要是更新UI
		@Override
		protected void onPostExecute(byte[] result) {
			super.onPostExecute(result);
			//    将doInBackground方法返回的byte[]解码成要给Bitmap
			Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length) ;
			//    更新我们的ImageView控件
			imageView.setImageBitmap(bitmap) ;//更新UI
			//    使ProgressDialog框消失
			dialog.dismiss() ;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}*//*
package com.example.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpCookie;


*/
/**使用AsyncTask来实现Android多线程
 * @author Ting听
 * @version 1.0
 * @date 2020-08-25 10:30
 * 参考：https://www.cnblogs.com/dawei/archive/2011/04/18/2019903.html
 *//*

public class AsyncTaskActivity extends AppCompatActivity {


	EditText editText;			//新建一个EditText
	ProgressBar progressBar;	//新建一个ProgressBar
	TextView textView;			//新建一个TextView
	Button button;				//新建一个Button


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_asynctask.xml文件定义的界面布局
		setContentView(R.layout.activity_asynctask);


		//绑定控件
		editText 	= findViewById(R.id.AsyncTaskEditText);
		progressBar = findViewById(R.id.AsyncTask_progress_horizontal);
		textView 	= findViewById(R.id.AsyncTaskTextView);
		button 		= findViewById(R.id.AsyncTaskButton);


		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(editText.getText().toString()!=null&&!editText.getText().equals("")) {
					new MyTask().execute(editText.getText().toString().trim());
					Log.i("Ting","开始执行AsyncTask");
				}
			}
		});
	}


	class MyTask extends AsyncTask<String,Integer,String>{
		@Override
		protected void onPostExecute(String s) {
			super.onPostExecute(s);
			textView.setText(s);
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
//			super.onProgressUpdate();
			progressBar.setProgress(values[0]);
		}


		@Override
		protected String doInBackground(String... strings) {

			try{
				HttpClient client = new DefaultHttpClient();
				// params[0]代表连接的url
				HttpGet get = new HttpGet(strings[0]);
				HttpResponse response = client.execute(get);
				HttpEntity entity = response.getEntity();
				long length = entity.getContentLength();
				InputStream is = entity.getContent();
				String s = null;
				if(is != null) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buf = new byte[128];
					int ch = -1;
					int count = 0;
					while((ch = is.read(buf)) != -1) {
						baos.write(buf, 0, ch);
						count += ch;
						if(length > 0) {
							// 如果知道响应的长度，调用publishProgress（）更新进度
							publishProgress((int) ((count / (float) length) * 100));
						}
						// 让线程休眠100ms
						Thread.sleep(100);
					}
					s = new String(baos.toByteArray());              }
				// 返回结果
				return s;
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}


	}

}

*/
