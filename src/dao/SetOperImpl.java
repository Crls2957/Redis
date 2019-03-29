package dao;

import redis.clients.jedis.Jedis;
import utils.JedisHelper;

import java.util.List;
import java.util.Set;

public class SetOperImpl extends BaseOper implements SetOper {
    @Override
    public void showType(Jedis jedis) {
        super.showType(jedis);
    }

    public SetOperImpl() {
        super();
    }

    @Override
    public void showKeys(Jedis jedis) {
        super.showKeys(jedis);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //随机移除元素
    @Override
    public void spop(Jedis jedis, String key) {
        jedis.spop(key);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //添加单个元素
    @Override
    public void sadd(Jedis jedis, String key, String value) {
        jedis.sadd(key,value);
    }

    //添加多个元素
    @Override
    public void sadds(Jedis jedis, String key, List<String> list) {
        for (String value:list){
            jedis.sadd(key,value);
        }
    }

    //展示指定集合的元素
    @Override
    public void sshow(Jedis jedis, String key) {
        Set<String> strings=jedis.smembers(key);
        for(String string:strings){
            System.out.println(string);
        }
    }

    //移除指定集合的指定单个元素
    @Override
    public void ssrem(Jedis jedis, String key, String sremValue) {
        jedis.srem(key,sremValue);
    }

    //移除指定集合指定多个元素

    @Override
    public void ssrems(Jedis jedis, String key, List<String> list) {
        for (String value:list){
            jedis.srem(key,value);
        }
    }

    /*public static void main(String [] args){
        Jedis jedis= JedisHelper.getJedis();
        SetOperImpl setOper=new SetOperImpl();
        setOper.showKeys(jedis);
    }*/
}
