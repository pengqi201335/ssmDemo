package pengqi.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pengqi.commons.Utils.JsonUtils;
import pengqi.model.pojo.Paper;
import pengqi.model.service.JedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

/**
 * Redis缓存业务接口的实现类
 * create on 2019/1/19 by pengqi
 */
@Service
public class JedisClientImp implements JedisClient {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 添加String类型的键值对
     *
     * @param key   键
     * @param value 值
     * @return 操作是否成功
     */
    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.set(key,value);
        jedis.close();
        return str;
    }

    /**
     * 根据键查询对应的值
     *
     * @param key 键
     * @return 值
     */
    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get(key);
        jedis.close();
        return str;
    }

    /**
     * 添加hash类型的数据
     *
     * @param hkey  hash表名
     * @param key   hash表中的某个键
     * @param value hash表中的某个值
     * @return 成功与否
     */
    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.hset(hkey,key,value);
        jedis.close();
        return result;
    }

    /**
     * 获取hash表中某个键对应的值
     *
     * @param hkey hash表名
     * @param key  hash表中的某个键
     * @return 该键对应的值
     */
    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.hget(hkey,key);
        jedis.close();
        return str;
    }

    /**
     * 自增1
     *
     * @param key 键
     * @return 自增之后的值
     */
    @Override
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    /**
     * 为某个键设置超时失效时间
     *
     * @param key     键
     * @param seconds 超时失效时间
     * @return 是否设置成功
     */
    @Override
    public long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.expire(key,seconds);
        jedis.close();
        return result;
    }

    /**
     * 返回某个键的超时失效时间
     *
     * @param key 键
     * @return 超时失效时间
     */
    @Override
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    /**
     * 删除某个键
     *
     * @param key 键
     * @return 删除是否成功，1：成功 | 0：失败
     */
    @Override
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.del(key);
        jedis.close();
        return result;
    }

    /**
     * 删除hash表中的某个键值对
     *
     * @param hkey hash表名
     * @param key  hash表中的某个键
     * @return 删除是否成功，1：成功 | 0：失败
     */
    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.hdel(hkey,key);
        jedis.close();
        return result;
    }

    /**
     * 添加有序集合，用于对所有论文排序
     *
     * @param key   有序集合名
     * @param score 要添加的元素分数
     * @param paper 论文对象
     * @return 是否添加成功
     */
    @Override
    public long zadd(String key, double score, Paper paper) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.zadd(key,score, JsonUtils.objectToJson(paper));
        jedis.close();
        return result;
    }

    /**
     * 向有序集合中添加一个列表
     *
     * @param key       集合名
     * @param paperList 列表
     * @return 是否添加成功
     */
    @Override
    public long zaddList(String key, List<Paper> paperList) {
//        Jedis jedis = jedisPool.getResource();
//        Long result = null;
//        for (Paper paper:paperList) {
//            result = jedis.zadd(key,)
//        }
        return 0;
    }

    /**
     * 获取所有集合中所有的元素
     *
     * @param key   集合名
     * @param start 开始位置
     * @param end   终点位置
     * @return 该集合
     */
    @Override
    public Set<String> zgetAll(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        Set<String> stringSet = jedis.zrange(key,start,end);
        jedis.close();
        return stringSet;
    }

    /**
     * 获取榜单最后一名的元素
     *
     * @param key   集合名
     * @param start 开始位置
     * @param end   终止位置
     * @return 该集合
     */
    @Override
    public Set<String> zgetTopLast(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        Set<String> topLastPaper = jedis.zrange(key,start,end);
        System.out.println("paperSet:"+topLastPaper);
        jedis.close();
        return topLastPaper;
    }
}
