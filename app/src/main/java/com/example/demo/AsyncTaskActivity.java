package com.example.demo;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**使用AsyncTask来实现Android多线程
 * @author Ting听
 * @version 1.0
 * @date 2020-08-25 10:30
 */
public class AsyncTaskActivity extends AppCompatActivity {
	//新建一个TextView
	private TextView text1;
	protected void onCreate(Bundle saveInstanceSate) {
		super.onCreate(saveInstanceSate);
		//使用activity_asynctask.xml文件定义的界面布局
		setContentView(R.layout.activity_asynctask);
		text1=findViewById(R.id.text1);//绑定控件
	}

	public void download(View view) throws MalformedURLException {
		//新建一个AsyncTask异步类的子类实例。
		DownTask downTask=new DownTask(this);

		//调用execute()方法开始执行异步操作
		downTask.execute(new URL("https://www.baidu.com/"));
	}

	//AsyncTask<Params,Progress,Result>
	//Params:启动后台执行任务输入的参数  Progress：后台任务完成的进度值的类型   Result：后台执行任务完成后返回的结果类型
	class DownTask extends AsyncTask<URL,Integer,String> {
		//URL：为启动后台执行任务输入的参数   Integer：后台任务完成的进度值的类型  String：后台执行任务完成后返回的结果类型

		//新建一个进度条控件
		ProgressDialog dialog;
		//定义记录已经读取的行数
		int hasRead=0;
		//上下文
		Context mContext;

		public DownTask(Context mContext) {
			this.mContext = mContext;
		}

		//(完成后台下载）该方法后台线程将要完成任务，调用publishProgress方法更新任务执行进度
		@Override
		protected String doInBackground(URL... urls) {
			//不定长字符串
			StringBuilder sb=new StringBuilder();
			try{
				URLConnection conn=urls[0].openConnection();
				//将conn获取的inputStream包装为BufferedReader
				BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line=null;
				while ((line=reader.readLine())!=null){
					sb.append(line+"\n");
					hasRead++;

					//此方法更新任务的执行进度
					publishProgress(hasRead);
				}
				return sb.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		//（在完成下载后将网页的代码显示）在doInBackground(URL... urls)完成后，系统自动调用该方法，并将doInBackground(URL... urls)的返回值床底给这个方法
		protected void onPostExecute(String result){
			text1.setText(result);
			dialog.dismiss();
		}

		//(开始下载前显示一个进度条）该方法通常会完成一些初始化的准备工作，比如界面显示进度条，将在后台执行费时操作之前调用
		protected void onPreExecute(){
			dialog=new ProgressDialog(mContext);
			dialog.setTitle("任务正在进行");
			dialog.setMessage("任务正在进行中，敬请等待...");
			dialog.setCancelable(false);
			dialog.setMax(202);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setIndeterminate(false);
			dialog.show();
		}

		//(更新进度条）当调在doInBackground中调用publishProgress时，触发该方法
		protected void onProgressUpdate(Integer... values){
			text1.setText("已经读取到【"+values[0]+"】行！");
			dialog.setProgress(values[0]);
		}

	}
}
