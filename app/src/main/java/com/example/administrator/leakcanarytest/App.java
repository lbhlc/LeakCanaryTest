package com.example.administrator.leakcanarytest;
import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author libohan
 *         邮箱:76681287@qq.com
 *         create on 2017/11/15.
 */

public class App extends Application {
    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 该方法中只能检测activity中的内存泄漏
         */
        if (LeakCanary.isInAnalyzerProcess(this))
        {
            return;
        }
        refWatcher=LeakCanary.install(this);

    }

    /**
     * 该方法可以检测fragment中的内存泄漏
     * @param context 上下文
     * @return 返回一个refwatcher对象
     */
    public static RefWatcher getRefWatcher(Context context)
    {
        App app= (App) context.getApplicationContext();

        return app.refWatcher;

    }
}
