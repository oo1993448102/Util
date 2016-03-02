# Util
工具类
## AlertDialogHelper
    	View view = View.inflate(this, R.layout.popup_window_camera, null);
		AlertDialogHelper helper = new AlertDialogHelper(this, view);
		final AlertDialog dialog =  helper.showBottomDialog();
在下方全屏dialog

## CustomerTextWatcher
对EditText输入格式加限制（字母 数字）
