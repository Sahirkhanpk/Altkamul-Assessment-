package com.example.altkamulassesignment.api;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Muhammad Hassan on 4/24/2017.
 */

public class ApiClient {


    @NonNull

    //*** code changed ***
    //public static final String mBaseUrl = "api.farmtohome.com.pk/";
   // public static final String mBaseUrl = "http://farmtohome.bakhaberkissan.com/api/";
  // 1  public static final String mBaseUrl = "https://api.farmtohome.com.pk/v2/";
   // public static final String mBaseUrl = "http://test.farmtohome.com.pk/";
    //public static String mBaseUrl = "http://farm2home.peyzaar.com/";
    //public static String mBaseUrl = "http://peyzaar.com/index.php/rest/V1/";
    public static final String mBaseUrl =  "http://api.nytimes.com";

    @Nullable
    private static Retrofit retrofit = null;
    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

   /* int cacheSize = 10 * 1024*1024;
    Cache cache = new Cache(getCacheDir(),cacheSize);
    OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache).build();

    @Nullable
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://api.farmtohome.com.pk/v2/")
            .client(okHttpClient )
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
*/
    @Nullable
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(mBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(new OkHttpClient.Builder()
                            .connectTimeout(1, TimeUnit.MINUTES)
                            .readTimeout(1, TimeUnit.MINUTES)
                            .writeTimeout(1, TimeUnit.MINUTES).build()).build();
        }
        return retrofit;
    }


   /* private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }*/
}
