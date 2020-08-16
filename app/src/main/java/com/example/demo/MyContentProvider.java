package com.example.demo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;

/**自定义一个ContentProvider类。通过在Logcat中打印log的形式，实现增、删、改、查中的查功能。
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 15:10
 */
public class MyContentProvider extends ContentProvider {

	@Override
	public boolean onCreate() {
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
		if(uri.getAuthority().contains("com.example.demo.provider")){
			Log.i("Ting demo","MyContentProvider query");
		}
		return null;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {

		return super.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues contentValues) {
		return null;
	}

	@Override
	public int delete(Uri uri, String s, String[] strings) {
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
		return 0;
	}
}
