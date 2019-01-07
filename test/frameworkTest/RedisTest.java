package frameworkTest;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {
    /**
     * 测试redis读写速度
     */
    @Test
    public void redisTester() {
        int i = 0;
        //try-with-resource语句，自动释放资源
        try(Jedis jedis = new Jedis("localhost",6379,100000);){
            long startTime = System.currentTimeMillis();    //开始时间
            while(true){
                long endTIme = System.currentTimeMillis();
                if((endTIme-startTime) > 1000){
                    break;
                }
                i++;
                jedis.set("test"+i,i+"");
            }
        }
        System.out.println("redis每秒操作"+i+"次");
    }
}
