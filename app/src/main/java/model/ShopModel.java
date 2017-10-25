package model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Shop;
import common.Api;
import okhttp3.Call;
import okhttp3.Response;
import utils.Callbak;
import utils.NetResquest;

/**
 * Created by DELL on 2017/10/25.
 */

public class ShopModel {
    private onShop onShop;
    public void getShop(){
        Map<String,String> params=new HashMap<>();
        NetResquest.Call(Api.url, params, new Callbak() {
            @Override
            public void onSuccess(Call call, Response response) {
                try {
                    String result = response.body().string();
                    Gson gson=new Gson();
                    Shop shop = gson.fromJson(result, Shop.class);
                    String code = shop.code;
                    String msg = shop.msg;
                    List<Shop.DataBean> data = shop.data;
                    if("0".equals(code))
                    {
                        onShop.onShopSuccess(data);
                    }
                    else
                    {
                        onShop.onShopFailure(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call call, IOException e) {
                onShop.onFailue(call,e);
            }
        });
    }


    public void setOnShop(ShopModel.onShop onShop) {
        this.onShop = onShop;
    }

    public interface onShop{
        void onShopSuccess(List<Shop.DataBean> data );
        void onShopFailure(String msg);
        void onFailue(Call call,IOException e);
    }


}
