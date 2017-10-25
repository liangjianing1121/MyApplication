package presenter;

import java.io.IOException;
import java.util.List;

import bean.Shop;
import model.ShopModel;
import okhttp3.Call;
import view.ShopView;

/**
 * Created by DELL on 2017/10/25.
 */

public class ShopPresenter implements ShopModel.onShop {


    private ShopModel shopModel;
    private ShopView shopView;

    public ShopPresenter(ShopView shopView) {
        this.shopView = shopView;
        shopModel=new ShopModel();
        shopModel.setOnShop(this);
    }

    public void requestShop(){
        shopModel.getShop();

    }


    @Override
    public void onShopSuccess(List<Shop.DataBean> data) {
        shopView.onShopSuccess(data);
    }

    @Override
    public void onShopFailure(String msg) {
        shopView.onShopFailure(msg);

    }

    @Override
    public void onFailue(Call call, IOException e) {
        shopView.onFailue(call,e);

    }
}
