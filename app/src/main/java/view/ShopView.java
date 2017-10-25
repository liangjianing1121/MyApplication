package view;

import java.io.IOException;
import java.util.List;

import bean.Shop;
import okhttp3.Call;

/**
 * Created by DELL on 2017/10/25.
 */

public interface ShopView {
    void onShopSuccess(List<Shop.DataBean> data );
    void onShopFailure(String msg);
    void onFailue(Call call, IOException e);
}
