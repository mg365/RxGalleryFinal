package cn.finalteam.rxgalleryfinal.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import com.zhy.base.fileprovider.FileProvider7;

import java.io.File;

/**
 * Desction:文件工具类
 * Author:dujinyang
 */
public class FileUtils {

    /**
     * 验证是否是图片路径
     */
    public static int existImageDir(String dir) {
        return dir.trim().lastIndexOf(".");
    }

    public static Uri fromFile(Activity activity, File file) {

        Uri imageUri = null;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            imageUri = Uri.fromFile(file);
        } else {
            //兼容android7.0 使用共享文件的形式
            ContentValues contentValues = new ContentValues(1);
            contentValues.put(MediaStore.Images.Media.DATA, file.getAbsolutePath());

            imageUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        return imageUri;
    }

    public static Uri fromFile7(Activity activity, File file) {
        return  FileProvider7.getUriForFile(activity, file);
    }
}
