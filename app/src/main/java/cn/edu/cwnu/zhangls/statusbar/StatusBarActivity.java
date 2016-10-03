package cn.edu.cwnu.zhangls.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
        /**
         * 如果在布局文件中使用了fitSystemWindows="true"属性，则
         * 在java代码中设置透明状态栏和隐藏ActionBar或者ToolBar无效
         * 方法：
         *     getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
         *     getSupportActionBar().hide()
         * 原因：
         *     fitSystemWindows简单描述：
         *     这个一个boolean值的内部属性，让view可以根据系统窗口(如status bar)来调整自己的布局，
         *     如果值为true,就会调整view的paingding属性来给system windows留出空间....
         *     fitSystemWindows实际效果：
         *     当status bar为透明或半透明时(4.4以上),系统会设置view的paddingTop值为一个适合的值
         *     (status bar的高度)让view的内容不被上拉到状态栏，当在不占据status bar的情况下
         *     (4.4以下)会设置paddingTop值为0(因为没有占据status bar所以不用留出空间)。
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}