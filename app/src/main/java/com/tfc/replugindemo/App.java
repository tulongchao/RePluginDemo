package com.tfc.replugindemo;

import android.content.Context;
import android.os.Environment;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginApplication;
import com.qihoo360.replugin.RePluginConfig;
import com.qihoo360.replugin.model.PluginInfo;

import java.io.File;

/**
 * 功能概要描述：          <br/>
 * 功能详细描述：          <br/>
 * 作者： tufengchao         <br/>
 * 创建日期： 2017/7/6     <br/>
 * 修改人：               <br/>
 * 修改日期：             <br/>
 * 版本号：               <br/>
 * 版权所有：Copyright © 2015-2016 上海览益信息科技有限公司 http://www.lanyife.com
 */
public class App extends RePluginApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/app-debug.apk");
        if (file.exists()) {
            PluginInfo pluginInfo =  RePlugin.install(file.getPath());
            if(pluginInfo!=null){
                RePlugin.preload(pluginInfo);
            }
        }

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // ======= REPLUGIN =======
        //-------------- 开发的时候不验证签名 -----------
        RePluginConfig config = new RePluginConfig();
        config.setVerifySign(!BuildConfig.DEBUG);
        RePlugin.App.attachBaseContext(this, config);
        // ========================
        // ======= REPLUGIN =======
        RePlugin.App.attachBaseContext(this);
        // ========================
    }

}
