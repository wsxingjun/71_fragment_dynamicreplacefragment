package it.oztaking.com.a71_fragment_dynamicreplacefragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.获得横竖屏

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        int width = wm.getDefaultDisplay().getWidth();

        //2.获得管理者
        FragmentManager manager = getFragmentManager();
        //3.获得管理的事务
        FragmentTransaction transaction = manager.beginTransaction();

        //4.根据横竖屏进行替换
        if (width > height ){
            //横屏
            transaction.replace(android.R.id.content, new fragment1());
        }else {
            //竖屏
            transaction.replace(android.R.id.content,new fragment2());
        }

        //5.提交
        transaction.commit();

    }
}
