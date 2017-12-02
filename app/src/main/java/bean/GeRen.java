package bean;

/**
 * Created by GUODONG on 2017/11/28.
 */

public class GeRen {


    /**
     * msg : 获取用户信息成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-28T19:55:42","email":null,"fans":0,"follow":0,"gender":0,"icon":"https://www.zhaoapi.cn/images/86.jpg","latitude":null,"longitude":null,"mobile":"15011411273","money":0,"nickname":"GUODONG","password":"111111","praiseNum":null,"token":"C4BF90E97420953ECE276A0D1287AFC0","uid":86,"userId":null,"username":"15011411273"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-11-28T19:55:42
         * email : null
         * fans : 0
         * follow : 0
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/86.jpg
         * latitude : null
         * longitude : null
         * mobile : 15011411273
         * money : 0
         * nickname : GUODONG
         * password : 111111
         * praiseNum : null
         * token : C4BF90E97420953ECE276A0D1287AFC0
         * uid : 86
         * userId : null
         * username : 15011411273
         */

        public Object age;
        public Object appkey;
        public Object appsecret;
        public String createtime;
        public Object email;
        public int fans;
        public int follow;
        public int gender;
        public String icon;
        public Object latitude;
        public Object longitude;
        public String mobile;
        public int money;
        public String nickname;
        public String password;
        public Object praiseNum;
        public String token;
        public int uid;
        public Object userId;
        public String username;
    }
}
