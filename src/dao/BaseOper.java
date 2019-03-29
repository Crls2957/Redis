package dao;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * 操作的通用方法
 */
public abstract class BaseOper {

    public BaseOper(){}
    //查看所有的key
    public void showKeys(Jedis jedis) {
        Set<String> keysSet=jedis.keys("*");
        for(String s:keysSet){
            System.out.println(s);
        }
    }
    //查看所有key类型
    public void showType(Jedis jedis){

    }

}
