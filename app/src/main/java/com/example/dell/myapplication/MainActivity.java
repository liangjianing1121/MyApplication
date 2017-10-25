package com.example.dell.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.List;

import adapter.MyAdapter;
import bean.Shop;
import okhttp3.Call;
import presenter.ShopPresenter;
import view.ShopView;

public class MainActivity extends AppCompatActivity implements ShopView {

    private RecyclerView rv;
    private CheckBox allselect;
    private TextView tv_price;
    private float price = 0;
    private float sumprice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        ShopPresenter presenter=new ShopPresenter(this);
        presenter.requestShop();
}
    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        allselect = (CheckBox) findViewById(R.id.allselect);
        tv_price = (TextView) findViewById(R.id.tv_price);
    }

    @Override
    public void onShopSuccess(final List<Shop.DataBean> data) {
        if(this!=null)
        {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rv.setLayoutManager(linearLayoutManager);
                    final MyAdapter adapter=new MyAdapter(MainActivity.this,data);
                    rv.setAdapter(adapter);


                    adapter.setOnzong(new MyAdapter.onzong() {
                        @Override
                        public void onshangjia() {
                            boolean flag=true;
                            for (Shop.DataBean dataBean : data) {
                                for (Shop.DataBean.ListBean listBean : dataBean.list) {
                                    if(listBean.isselect==false)
                                    {
                                        flag=false;
                                    }
                                }
                            }
                            allselect.setChecked(flag);

                        }

                        @Override
                        public void onshangpin() {
                            boolean flag=true;
                            for (Shop.DataBean dataBean : data) {
                                for (Shop.DataBean.ListBean listBean : dataBean.list) {
                                    if(listBean.isselect==false)
                                    {
                                      flag=false;
                                    }
                                }
                            }
                            allselect.setChecked(flag);
                        }
                    });

                    allselect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            float price=0;
                            for (Shop.DataBean dataBean : data) {
                                for (Shop.DataBean.ListBean listBean : dataBean.list) {
                                    price+=listBean.bargainPrice*listBean.num;
                                    if(allselect.isChecked())
                                    {
                                        listBean.isselect=true;
                                    }
                                    else
                                    {
                                        listBean.isselect=false;

                                    }
                                }
                            }

                            tv_price.setText(price+"");
                            adapter.notifyDataSetChanged();

                        }
                    });
                    adapter.setGetSumprice(new MyAdapter.getSumprice() {
                        @Override
                        public void onSumprice() {
                            float price=0;
                            for (Shop.DataBean dataBean : data) {
                                for (Shop.DataBean.ListBean listBean : dataBean.list) {
                                    if(listBean.isselect==true)
                                    {
                                        price+=listBean.bargainPrice*listBean.num;
                                    }

                                }
                            }
                            tv_price.setText(price+"");
                        }
                    });

                }
            });
        }
    }

    @Override
    public void onShopFailure(String msg) {

    }

    @Override
    public void onFailue(Call call, IOException e) {

    }
}
