package com.hanyun.happyboat.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class CustomerTextWatcher implements TextWatcher{
	 private EditText mEditText;

	    public CustomerTextWatcher(EditText e) {
	        mEditText = e;
	    }

	    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	    }

	    public void onTextChanged(CharSequence s, int start, int before, int count) {
	    	 String editable = mEditText.getText().toString();  
	          String str = stringFilter(editable.toString());
	          if(!editable.equals(str)){
	        	  mEditText.setText(str);
	              //设置新的光标所在位置  
	        	  mEditText.setSelection(str.length());
	          }
	    }

	    public void afterTextChanged(Editable s) {
	    }
	    
	    public static String stringFilter(String str)throws PatternSyntaxException{     
		      // 只允许字母、数字    
		      String   regEx  =  "[^a-zA-Z0-9]";                     
		      Pattern   p   =   Pattern.compile(regEx);     
		      Matcher   m   =   p.matcher(str);     
		      return   m.replaceAll("").trim();     
		  }

}
