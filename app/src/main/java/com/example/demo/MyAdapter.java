package com.example.demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ting听
 * @version 1.0
 * @date 2020-08-14 20:23
 * @description https://www.jianshu.com/p/5ad99a1170ab
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
	//当前上下文对象
	Context context;
	//RecyclerView填充Item数据的List对象
	List<String> datas;

	public MyAdapter() {
		super();
	}

	public MyAdapter(Context context,List<String> datas){
		this.context = context;
		this.datas = datas;
	}

	/**
	 * 设置回调接口
	 */
	public interface OnItemClickListener {
		void onItemClick(View view, int position);
	}
	/**
	 * 设置长按回调接口
	 */
	public interface OnItemLongClickListener {
		boolean onItemLongClick(View view, int position);
	}

	/**
	 * 事件回调监听
	 */
	private OnItemClickListener onItemClickListener;
	private OnItemLongClickListener onItemLongClickListener;
	/**
	 * 设置回调监听
	 *
	 * @param listener
	 */
	public void setOnItemClickListener(OnItemClickListener listener) {
		this.onItemClickListener = listener;
	}

	public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
		this.onItemLongClickListener = onItemLongClickListener;
	}




	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v;
		if(viewType==0){
			v = View.inflate(context,R.layout.item1,null);
		}else{
			v = View.inflate(context,R.layout.item2,null);

		}
		final MyViewHolder myViewHolder = new MyViewHolder(v);


		return myViewHolder;
	}

	//绑定数据
	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
		holder.textView.setText(datas.get(position));
		//将position保存在itemView的Tag中，以便点击时进行获取
		holder.itemView.setTag(position);

		/*//1.在Adapter里面直接对控件做点击事件
		holder.textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast toast = Toast.makeText(context,null,Toast.LENGTH_SHORT);
				toast.setText(holder.textView.getText()+"被点击了");
				toast.show();

			}
		});*/

		//2.写接口，在Activity或Fragment上实现接口中定义的方法
		holder.textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(onItemClickListener != null){
					onItemClickListener.onItemClick(view,position);
				}

			}
		});
		//通过接口回调响应长按事件
		holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				if(onItemLongClickListener != null){
					return onItemLongClickListener.onItemLongClick(view,position);
				}
				return false;
			}
		});



	}


	/**
	 * @Description:getItemViewType
	 * 	获取要素item的位置，返回不同的值，用于界面显示
	 * */
	@Override
	public int getItemViewType(int position) {
		if(position%2==0){
			return 0;
		}else{
			return 2;
		}
	}


	/**@description:getItemCount
	 * 		返回Item的数量
	 * */
	@Override
	public int getItemCount() {
		return datas.size();
	}



	/**
	 * @description:MyViewHolder类
	 *   继承RecyclerView.ViewHolder抽象类的自定义MyViewHolder
	 *
	 * */
	class MyViewHolder extends RecyclerView.ViewHolder{
		TextView textView;
		public MyViewHolder(View itemView){
			super(itemView);
			textView = itemView.findViewById(R.id.item);
		}
	}









}
