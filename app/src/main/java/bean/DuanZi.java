package bean;

import java.util.List;

/**
 * Created by GUODONG on 2017/11/29.
 */

public class DuanZi {


    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"人与人间的信任，就像是纸片，一旦破损，就不会再回到原来的样子。","createTime":"2017-11-28T22:52:41","imgUrls":null,"jid":105,"praiseNum":null,"shareNum":null,"uid":170,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/170.jpg","nickname":"wonderful","praiseNum":"null"}},{"commentNum":null,"content":"人与人间的信任，就像是纸片，一旦破损，就不会再回到原来的样子。","createTime":"2017-11-28T22:52:11","imgUrls":null,"jid":104,"praiseNum":null,"shareNum":null,"uid":170,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/170.jpg","nickname":"wonderful","praiseNum":"null"}},{"commentNum":null,"content":"%E6%88%91%E4%BB%AC%E4%B8%8D%E4%B8%80%E6%A0%B7%EF%BC%81","createTime":"2017-11-28T22:26:54","imgUrls":null,"jid":103,"praiseNum":null,"shareNum":null,"uid":114,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/114.jpg","nickname":"Bount","praiseNum":"null"}},{"commentNum":null,"content":"%E4%B9%B1%E7%A0%81","createTime":"2017-11-28T21:27:59","imgUrls":null,"jid":100,"praiseNum":null,"shareNum":null,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"李灿灿","praiseNum":"null"}},{"commentNum":null,"content":"%E4%B9%B1%E7%A0%81","createTime":"2017-11-28T21:27:59","imgUrls":null,"jid":99,"praiseNum":null,"shareNum":null,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"李灿灿","praiseNum":"null"}},{"commentNum":null,"content":"%E4%BD%A0%E5%A5%BD","createTime":"2017-11-28T21:27:18","imgUrls":null,"jid":98,"praiseNum":null,"shareNum":null,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"李灿灿","praiseNum":"null"}},{"commentNum":null,"content":"%E4%BD%A0%E5%A5%BD","createTime":"2017-11-28T21:27:16","imgUrls":null,"jid":97,"praiseNum":null,"shareNum":null,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"李灿灿","praiseNum":"null"}},{"commentNum":null,"content":"%E4%B9%B1%E7%A0%81%EF%BC%9F","createTime":"2017-11-28T21:07:50","imgUrls":null,"jid":96,"praiseNum":null,"shareNum":null,"uid":195,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/195.jpg","nickname":"梁佳宁","praiseNum":"null"}},{"commentNum":null,"content":"666666","createTime":"2017-11-28T21:05:24","imgUrls":null,"jid":95,"praiseNum":null,"shareNum":null,"uid":195,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/195.jpg","nickname":"梁佳宁","praiseNum":"null"}},{"commentNum":null,"content":"%E5%9B%A0%E4%B8%BA%E6%89%80%E6%9C%89%E6%8F%90%E6%AC%BE%E6%9C%BA%E4%B8%8A%E9%83%BD%E5%8D%B0%E7%9D%80%E5%AE%83%E5%90%8D%E5%AD%97%E7%9A%84%E7%BC%A9%E5%86%99","createTime":"2017-11-28T21:02:24","imgUrls":null,"jid":94,"praiseNum":null,"shareNum":null,"uid":195,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/195.jpg","nickname":"梁佳宁","praiseNum":"null"}}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : null
         * content : 人与人间的信任，就像是纸片，一旦破损，就不会再回到原来的样子。
         * createTime : 2017-11-28T22:52:41
         * imgUrls : null
         * jid : 105
         * praiseNum : null
         * shareNum : null
         * uid : 170
         * user : {"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/170.jpg","nickname":"wonderful","praiseNum":"null"}
         */

        public Object commentNum;
        public String content;
        public String createTime;
        public Object imgUrls;
        public int jid;
        public Object praiseNum;
        public Object shareNum;
        public int uid;
        public UserBean user;

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : null
             * icon : https://www.zhaoapi.cn/images/170.jpg
             * nickname : wonderful
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public String follow;
            public String icon;
            public String nickname;
            public String praiseNum;
        }
    }
}
