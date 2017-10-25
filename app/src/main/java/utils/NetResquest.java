package utils;

import java.io.IOException;
import java.util.Map;

import lanjieqi.LogInterceptor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by DELL on 2017/10/25.
 */

public class NetResquest {


    public static void Call(String url, Map<String,String> params, final Callbak callbak){
        OkHttpClient client=new OkHttpClient.Builder().build();

        FormBody.Builder builder =new FormBody.Builder();

        RequestBody build = builder.build();
        Request request=new Request.Builder().url(url).post(build).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callbak.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callbak.onSuccess(call,response);

            }
        });


    }
}
