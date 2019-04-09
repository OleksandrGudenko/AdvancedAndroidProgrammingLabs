package advanced.android.lab4_1_volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static VolleySingleton mInsatance;
    private RequestQueue mRequestQueue;

    private VolleySingleton(Context context) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInsatance == null) {
            mInsatance = new VolleySingleton(context);
        }
        return mInsatance;
    }

    public RequestQueue getmRequestQueue() {
        return mRequestQueue;
    }
}
