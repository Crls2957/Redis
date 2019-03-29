package dao;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * 操作set集合的接口
 */
public interface SetOper {

    //向set集合中添加单个数据
    public void sadd(Jedis jedis,String key,String value);
    //向set集合中添加多个数据
    public void sadds(Jedis jedis,String key,List<String> list);
    //查看set集合数据
    public void sshow(Jedis jedis,String key);
    //移除指定单个元素
    public void ssrem(Jedis jedis,String key,String sremValue); //sremValue指定移除的元素
    //移除指定的多个元素
    public void ssrems(Jedis jedis,String key,List<String> list);
    //随机移除元素
    public void spop(Jedis jedis,String key);
}
