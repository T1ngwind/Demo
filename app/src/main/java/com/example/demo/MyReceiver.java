package com.example.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;


import static com.example.demo.BroadcastReceiverActivity.textViewShow;

/**自定义一个BroadcastReceiver类。当网络状态发生改变时，Toast显示，并使TextView的值发生改变历时两秒，随后恢复原样。
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 14:2
 */
public class MyReceiver extends BroadcastReceiver {

	//重写onReceive()方法。在先打印一个Toast提示的同时，新建一个线程用于显示网络发生变化时的状态提示，持续时间两秒。
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast toast = Toast.makeText(context,null,Toast.LENGTH_SHORT);
		toast.setText("网络状态发生变化");
		toast.show();
		//显示状态发生改变
		textViewShow.setText("网络状态发生变化");

		//新建一个线程用于显示网络发生变化时的状态提示，持续时间两秒
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//线程延迟2秒，为了显示状态发生改变
					Thread.sleep(2000);
				}catch(Exception e){
				}finally{
					textViewShow.setText("网络状态发生改变了吗？");
				}
			}
		}).start();
	}
}
