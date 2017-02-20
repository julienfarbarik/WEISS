package com.example.uru.weiss;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by Uru on 1/25/2017.
 */

public class routerPing implements Callable<String>  {
    private Context context;
    public routerPing(Context context){
        this.context = context;
    }
    public String findRouter(Context context) throws IOException{
//        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo nInfo = cm.getActiveNetworkInfo();

//        return cm.getActiveNetwork().getByName(cm.getActiveNetworkInfo().getExtraInfo()).getHostAddress();


        WifiManager wm = (WifiManager)context.getSystemService(context.WIFI_SERVICE);

        return wm.getDhcpInfo().toString();

//        List<String> commandList = new ArrayList<>();
//        commandList.add("ipconfig");
//        ProcessBuilder pb = new ProcessBuilder();
//        Process process = pb.start();
//        BufferedReader stdInput = new BufferedReader(
//                new InputStreamReader(
//                        process.getInputStream()
//                )
//        );
//        String Line = null;
//        String IPString = "";
//        while ((Line = stdInput.readLine()) != null){
//            IPString += Line;
//        }
//
//        return IPString; //returns string of router's ip address
    }

    public int pingRouter(){
        return 0;   //returns the time (ms)
    }

    @Override
    public String call() throws IOException{
        return findRouter(context);
    }
}
