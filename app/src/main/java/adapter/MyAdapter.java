package adapter;

import android.content.Context;
import android.graphics.YuvImage;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.dell.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import bean.Shop;

/**
 * Created by DELL on 2017/10/25.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context context;
    private List<Shop.DataBean> data;
    private onzong onzong;
    private getSumprice getSumprice;


    public MyAdapter(Context context, List<Shop.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        boolean  flag=true;
        for (Shop.DataBean.ListBean listBean : data.get(position).list) {
            if(listBean.isselect==false)
            {
                flag=false;
            }
        }
        holder.shopselect.setChecked(flag);
        holder.tv_title.setText(data.get(position).sellerName);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        holder.rv.setLayoutManager(linearLayoutManager);
        final MyAdapter2 adapter2=new MyAdapter2(context,data.get(position).list);
        holder.rv.setAdapter(adapter2);

        //点击商家商品全选
        holder.shopselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Shop.DataBean.ListBean listBean : data.get(position).list) {
                     if(holder.shopselect.isChecked())
                     {
                         listBean.isselect=true;
                     }
                     else
                     {
                         listBean.isselect=false;
                     }
                }
                adapter2.notifyDataSetChanged();
                onzong.onshangjia();
                getSumprice.onSumprice();
            }
        });


        //调用小adapter的接口实现商品全选 商家选中
        adapter2.setOngeshu(new MyAdapter2.ongeshu() {
            @Override
            public void geshu() {
                boolean  flag=true;
                for (Shop.DataBean.ListBean listBean : data.get(position).list) {
                    if(listBean.isselect==false)
                    {
                        flag=false;
                    }
                }
                holder.shopselect.setChecked(flag);
                onzong.onshangpin();
                getSumprice.onSumprice();
            }
        });
        adapter2.setGetsumprice(new MyAdapter2.getsumprice() {
            @Override
            public void onsumprice() {
                getSumprice.onSumprice();

            }
        });


    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_title;
        private final RecyclerView rv;
        private final CheckBox shopselect;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            rv = itemView.findViewById(R.id.rv);
            shopselect = itemView.findViewById(R.id.shopselect);
        }
    }

    public void setOnzong(MyAdapter.onzong onzong) {
        this.onzong = onzong;
    }

    public interface onzong{
        void onshangjia();
        void onshangpin();
    }


    public void setGetSumprice(MyAdapter.getSumprice getSumprice) {
        this.getSumprice = getSumprice;
    }

    public interface  getSumprice{
        void onSumprice();
    }



}
