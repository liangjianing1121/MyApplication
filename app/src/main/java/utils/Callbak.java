package utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by DELL on 2017/10/25.
 */

public interface Callbak {
    void onSuccess(Call call, Response response);
    void onFailure(Call call, IOException e);
}
