package com.hanyun.happyboat.utils;

import com.hanyun.happyboat.HappyUrl;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

	private static Toast mToast;

	public static void show(Context context, String text) {
		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}

		mToast.show();

	}


	/**
	 * 测试用 在正式投入市场：fasle
	 * 
	 * @param context
	 * @param msg
	 */
	public static void showToastTest(Context context, String msg) {
		if (!HappyUrl.isShowTestToast) {
			show(context, msg);
		}
	}

}