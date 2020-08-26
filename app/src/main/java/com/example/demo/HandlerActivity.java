package com.example.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**使用Handler来实现Android多线程
 * @author Ting听
 * @version 1.0
 * @date 2020-08-25 10:28
 */
public class HandlerActivity extends AppCompatActivity {
	ImageView imageView;	//新建一个ImageView
	int currentIds = 0;		//设置当前的图片的id
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_handler.xml文件定义的界面布局
		setContentView(R.layout.activity_handler);
		imageView = findViewById(R.id.handlerView);

		//定义周期性显示的图片ID
		final int [] imageIds = new int[]{
				R.drawable.p0,
				R.drawable.p1,
				R.drawable.p2,
				R.drawable.p3,
				R.drawable.p4,
				R.drawable.p5,
				R.drawable.p6,
				R.drawable.p7,
				R.drawable.p8,
				R.drawable.p9,
		};

		final Handler handler = new Handler(){
			@Override
			public void handleMessage(@NonNull Message msg) {
				if(msg.what==0x123){
					//动态修改UI界面显示的图片
					imageView.setImageResource(imageIds[currentIds++%imageIds.length]);
				};
			}
		};

		//定义一个定时器，让该定时器周期性地执行指定任务
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				//发送空消息
				handler.sendEmptyMessage(0x123);
			}
		},0,1200);//延迟为0，时间持续1.2秒
	}


}
