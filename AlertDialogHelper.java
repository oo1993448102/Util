package com.hanyun.happyboat.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class AlertDialogHelper {
	
	private Context c;
	private View v;
	
	public AlertDialogHelper(Context c,View v){
		this.c = c;
		this.v = v;
	}
	
	public AlertDialog showBottomDialog(){
		final AlertDialog dialog = new AlertDialog.Builder(c).create();
		Window window = dialog.getWindow();
		window.setGravity(Gravity.BOTTOM);
		dialog.show();
		dialog.getWindow().setContentView(v);
		WindowManager windowManager = ((Activity)c).getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
		lp.width = (display.getWidth());
		dialog.getWindow().setAttributes(lp);
		return dialog;
	}

}
