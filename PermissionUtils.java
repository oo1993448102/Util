package com.hanyun.happyboat.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

/**
 * Created by EchoZhou on 2016/7/4.
 */

public class PermissionUtils {

    private CheckPremissionListener listener;

    public PermissionUtils(CheckPremissionListener listener) {
        this.listener = listener;
    }

    public void checkPremission(Object c, int requestCode, String... permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermissionWrapper(c, permission)) {
                requestPremission(c, permission, requestCode);
            } else {
                if (listener != null) {
                    listener.onSuccess();
                }
            }
        } else {
            if (listener != null) {
                listener.onSuccess();
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private  boolean checkSelfPermissionWrapper(Object cxt, String... permissions) {
        for (String permission : permissions) {
            if (cxt instanceof Activity) {
                Activity activity = (Activity) cxt;
                if( ActivityCompat.checkSelfPermission(activity,
                        permission) == PackageManager.PERMISSION_DENIED){
                 return true;
                }
            } else if (cxt instanceof Fragment) {
                Fragment fragment = (Fragment) cxt;
                if( fragment.getActivity().checkSelfPermission(permission) == PackageManager.PERMISSION_DENIED)
                    return true;
            } else {
                throw new RuntimeException("cxt is not a activity or fragment");
            }
        }
        return false;
    }

    private void requestPremission(Object c, String[] permission, int requestCode) {
        if (c instanceof Activity) {
            Activity activity = (Activity) c;
            ActivityCompat.requestPermissions(activity, permission, requestCode);
        } else if (c instanceof Fragment) {
            Fragment fragment = (Fragment) c;
            fragment.requestPermissions(permission, requestCode);
        } else {
            throw new RuntimeException("cxt is not a activity or fragment");
        }
    }

    public interface CheckPremissionListener {
        void onSuccess();

        void onFailure();
    }

    public void setCheckPremissionListener(CheckPremissionListener listener) {
        this.listener = listener;
    }

}
