# Util
工具类
## AlertDialogHelper
    	View view = View.inflate(this, R.layout.popup_window_camera, null);
		AlertDialogHelper helper = new AlertDialogHelper(this, view);
		final AlertDialog dialog =  helper.showBottomDialog();
在下方全屏dialog

[AlertDialogHelper](https://github.com/oo1993448102/Util/blob/master/AlertDialogHelper.java)

## CustomerTextWatcher
对EditText输入格式加限制（字母 数字）

[CustomerTextWatcher](https://github.com/oo1993448102/Util/blob/master/CustomerTextWatcher.java)

##LogUtil
控制不同开发阶段log显示

[LogUtil](https://github.com/oo1993448102/Util/blob/master/LogUtil.java)

##MyGifView
播放gif

[MyGifView](https://github.com/oo1993448102/Util/blob/master/MyGifView.java)

##ToastUtil
只有一个显示 控制测试和正式发布阶段是否弹toast

[ToastUtil](https://github.com/oo1993448102/Util/blob/master/ToastUtil.java)

##ZoomTouchListener
imageview 拖拽 缩放 

支持双击缩放（有个bug 方形图片双击缩小）

[ZoomTouchListener](https://github.com/oo1993448102/Util/blob/master/ZoomTouchListener.java)
