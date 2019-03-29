package main;

import dao.SetOperImpl;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.JedisHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static Jedis jedis;
    private static JedisPool jedisPool;

    public static void main(String [] args){
        jedis= JedisHelper.getJedis();
        Boolean flag=true;
        Scanner scanner=new Scanner(System.in);
        while(flag){
            System.out.println("1.操作Set集合");
            System.out.println("2.查看所有键值");
            System.out.println("3.查看键值类型");
            System.out.println("0.退出");
            System.out.println("请选择操作：");
            int num=scanner.nextInt();
            SetOperImpl setOper=new SetOperImpl();
            if(num==0)
                break;
            switch (num){
                case 1:
                    boolean setFlag=true;
                    while (setFlag){
                        System.out.println("1.向set集合中添加单个数据");
                        System.out.println("2.向set集合中添加多个数据");
                        System.out.println("3.移除指定单个元素");
                        System.out.println("4.移除指定的多个元素");
                        System.out.println("5.随机移除元素");
                        System.out.println("6.查看指定set集合元素");
                        System.out.println("0.返回上一级");
                        System.out.println("请选择操作：");
                        int numSet=scanner.nextInt();
                        if(numSet==0)
                            break;
                        switch (numSet){
                            case 1:
                                System.out.println("请输入键值:");
                                String keyAdd=scanner.next();
                                System.out.println("请输入元素值:");
                                String value=scanner.next();
                                setOper.sadd(jedis,keyAdd,value);
                                break;
                            case 2:
                                System.out.println("请输入键值:");
                                String keyAdds=scanner.next();
                                System.out.println("请输入需要输入元素个数：");
                                int size=scanner.nextInt();
                                List<String> list=new ArrayList<>();
                                System.out.println("请输入元素值:");
                                for(int i=0;i<size;i++){
                                    String addsValue=scanner.nextLine();
                                    list.add(addsValue);
                                }
                                setOper.sadds(jedis,keyAdds,list);
                                break;
                            case 3:
                                System.out.println("请输入键值:");
                                String keySrem=scanner.nextLine();
                                System.out.println("请输入指定移除的元素值:");
                                String valueSrem=scanner.nextLine();
                                setOper.ssrem(jedis,keySrem,valueSrem);
                                break;
                            case 4:
                                System.out.println("请输入键值:");
                                String keySrems=scanner.next();
                                System.out.println("请输入指定移除元素个数：");
                                int sizeSrems=scanner.nextInt();
                                List<String> listSrem=new ArrayList<>();
                                System.out.println("请输入元素值:");
                                for(int i=0;i<sizeSrems;i++){
                                    String addsValue=scanner.nextLine();
                                    listSrem.add(addsValue);
                                }
                                setOper.sadds(jedis,keySrems,listSrem);
                                break;
                            case 5:
                                System.out.println("请输入键值:");
                                String keyPop=scanner.nextLine();
                                setOper.spop(jedis,keyPop);
                                break;
                            case 6:
                                System.out.println("请输入键值:");
                                String keyShow=scanner.nextLine();
                                setOper.sshow(jedis,keyShow);
                                break;
                            default:
                                System.out.println("输入有误！");
                                break;
                        }
                    }
                case 2:
                    setOper.showKeys(jedis);
                    break;
                case 3:
                    setOper.showType(jedis);
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
        }
        JedisHelper.close(jedis,jedisPool);
    }
}
