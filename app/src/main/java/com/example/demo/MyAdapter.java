package com.example.demo;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ListView;

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
public class MyAdapter extends RecyclerView.Adapter {
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

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return null;
	}


	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

	}


	@Override
	public int getItemViewType(int position) {
		return super.getItemViewType(position);
	}


	@Override
	public void setHasStableIds(boolean hasStableIds) {
		super.setHasStableIds(hasStableIds);
	}


	@Override
	public long getItemId(int position) {
		return super.getItemId(position);
	}


	@Override
	public int getItemCount() {
		return 0;
	}


	@Override
	public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
		super.onViewRecycled(holder);
	}


	@Override
	public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder holder) {
		return super.onFailedToRecycleView(holder);
	}


	@Override
	public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
		super.onViewAttachedToWindow(holder);
	}


	@Override
	public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
		super.onViewDetachedFromWindow(holder);
	}


	@Override
	public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
		super.registerAdapterDataObserver(observer);
	}

	/**
	 * Unregister an observer currently listening for data changes.
	 *
	 * <p>The unregistered observer will no longer receive events about changes
	 * to the adapter.</p>
	 *
	 * @param observer Observer to unregister
	 * @see #registerAdapterDataObserver(RecyclerView.AdapterDataObserver)
	 */
	@Override
	public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver observer) {
		super.unregisterAdapterDataObserver(observer);
	}


	@Override
	public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
	}


	@Override
	public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
		super.onDetachedFromRecyclerView(recyclerView);
	}


	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List payloads) {
		super.onBindViewHolder(holder, position, payloads);
	}
}
