package bean;

import java.util.List;

/**
 * Created by DELL on 2017/10/25.
 */

public class Shop {


    /**
     * msg : 请求成功
     * code : 0
     * data : [{"list":[{"bargainPrice":99,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg","num":1,"pid":45,"price":2999,"pscid":39,"selected":0,"sellerid":1,"subhead":"高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！","title":"一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机"}],"sellerName":"商家1","sellerid":"1"},{"list":[{"bargainPrice":399,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/1439822107.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t5887/201/859509257/69994/6bde9bf6/59224c24Ne854e14c.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5641/233/853609022/57374/5c73d281/59224c24N3324d5f4.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5641/233/853609022/57374/5c73d281/59224c24N3324d5f4.jpg!q70.jpg","num":1,"pid":82,"price":333,"pscid":85,"selected":0,"sellerid":3,"subhead":"满2件，总价打6.50折","title":"Gap男装 休闲舒适简约水洗五袋直筒长裤紧身牛仔裤941825 深灰色 33/32(175/84A)"}],"sellerName":"商家3","sellerid":"3"},{"list":[{"bargainPrice":111.99,"createtime":"2017-10-14T21:39:05","detailUrl":"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","num":1,"pid":1,"price":118,"pscid":1,"selected":1,"sellerid":17,"subhead":"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下","title":"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g"}],"sellerName":"商家17","sellerid":"17"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * list : [{"bargainPrice":99,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg","num":1,"pid":45,"price":2999,"pscid":39,"selected":0,"sellerid":1,"subhead":"高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！","title":"一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机"}]
         * sellerName : 商家1
         * sellerid : 1
         */

        public String sellerName;
        public String sellerid;
        public List<ListBean> list;
        public boolean allselect;

        public static class ListBean {
            /**
             * bargainPrice : 99.0
             * createtime : 2017-10-14T21:38:26
             * detailUrl : https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
             * images : https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg
             * num : 1
             * pid : 45
             * price : 2999.0
             * pscid : 39
             * selected : 0
             * sellerid : 1
             * subhead : 高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！
             * title : 一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机
             */

            public double bargainPrice;
            public String createtime;
            public String detailUrl;
            public String images;
            public int num;
            public int pid;
            public double price;
            public int pscid;
            public int selected;
            public int sellerid;
            public String subhead;
            public String title;
            public boolean isselect;


        }
    }
}
