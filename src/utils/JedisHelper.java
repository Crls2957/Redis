package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接数据库数工具类
 */
public class JedisHelper {

    private static Jedis jedis;//非切片连接
    private static JedisPool jedisPool; //非切片连接池
    private static String host="127.0.0.1";//主机地址
    private static int port=6379;//端口号

    //初始化连接对象，配置参数
    public static void InitJedis(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(5);//最大空闲连接数
        jedisPoolConfig.setMaxWaitMillis(10000);//最大等待连接时间
        jedisPoolConfig.setTestOnBorrow(false);//空闲时检查连接有效性，默认为false

        jedisPool=new JedisPool(jedisPoolConfig,host,port);
    }

    //获取连接对象
    public static Jedis getJedis(){
        InitJedis();
        try{
            jedis=jedisPool.getResource();//获取连接对象
            return jedis;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //关闭连接
    public static void close(Jedis jedis,JedisPool jedisPool){
        if(jedis!=null){
            jedis.close();
        }
        if (jedisPool!=null){
            jedisPool.close();
        }
    }

    /*//测试连接
    public static void main(String [] args){
        System.err.println(JedisHelper.getJedis());
    }*/
}
