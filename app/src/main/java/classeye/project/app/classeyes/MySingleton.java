package classeye.project.app.classeyes;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.net.ContentHandler;

public class MySingleton {

    public static MySingleton mInstance;
    public RequestQueue requestQueue;
    public static Context contex;

    public MySingleton(Context contex) {
        this.contex = contex;
        requestQueue=getRequestQueue();

    }

    public RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(contex.getApplicationContext());

        }
        return requestQueue;
    }

    public static synchronized  MySingleton getInstance(Context contex){
        if (mInstance==null){
            mInstance=new MySingleton(contex);
        }
        return mInstance;
    }
    public void addToRequestQue(Request request){
        requestQueue.add(request);
    }

}
