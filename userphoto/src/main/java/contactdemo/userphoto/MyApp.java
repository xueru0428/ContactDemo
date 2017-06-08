package contactdemo.userphoto;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by XUERU on 2017/6/8.
 */

public class MyApp extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //初始化Fresco
        Fresco.initialize(this);
    }

    public static Context getInstance() {
        return context;
    }
}
