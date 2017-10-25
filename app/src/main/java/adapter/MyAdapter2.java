package adapter;

import android.content.Context;
import android.media.tv.TvContentRating;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.myapplication.R;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import bean.Shop;
import okhttp3.Call;
import presenter.ShopPresenter;
import view.AmountView;
import view.ShopView;

/**
 * Created by DELL on 2017/10/25.
 */

public class MyAdapter2  extends  RecyclerView.Adapter<MyAdapter2.ViewHolder>  {

    private Context context;
    private List<Shop.DataBean.ListBean> data;
    private ongeshu ongeshu;
    private getsumprice getsumprice;


    public MyAdapter2(Context context, List<Shop.DataBean.ListBean> data ) {
        this.context = context;
        this.data = data;

        //presenter = new ShopPresenter(MyAdapter2.this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item2, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mAmountView.setGoods_storage(50, data.get(position).num);
        holder.tv_name.setText(data.get(position).title);
        holder.tv_price.setText("￥" + data.get(position).bargainPrice);
        String images = data.get(position).images;
        String[] img = images.split("\\|");
        Glide.with(context).load(img[0]).into(holder.iv);
        //自定义控件的点击事件
        holder.mAmountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                data.get(position).num=amount;
                getsumprice.onsumprice();

            }
        });
        //给cb设置初始值
        boolean isselect = data.get(position).isselect;
        if(isselect)
        {
            holder.checkBox.setChecked(true);
            ongeshu.geshu();
            getsumprice.onsumprice();
        }
        else
        {
            holder.checkBox.setChecked(false);
        }

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                   data.get(position).isselect=true;
                }
                else
                {
                    data.get(position).isselect=false;
                }
                ongeshu.geshu();
                getsumprice.onsumprice();
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_price;
        private final CheckBox checkBox;
        private final ImageView iv;
        private final AmountView mAmountView;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            checkBox = itemView.findViewById(R.id.checkBox);
            iv = itemView.findViewById(R.id.iv);
            mAmountView = itemView.findViewById(R.id.amount_view);
        }
    }

    public void setOngeshu(MyAdapter2.ongeshu ongeshu) {
        this.ongeshu = ongeshu;
    }

    public interface ongeshu{
       void geshu();
   }


    public void setGetsumprice(MyAdapter2.getsumprice getsumprice) {
        this.getsumprice = getsumprice;
    }

    public interface getsumprice{
       void onsumprice();
   }

}
