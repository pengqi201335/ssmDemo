package pengqi.model.service;

import pengqi.model.pojo.Paper;

import java.util.List;
import java.util.Set;

/**
 * Redis缓存业务接口
 * create on 2019/1/19 by pengqi
 */
public interface JedisClient {
    /**
     * 添加String类型的键值对
     * @param key 键
     * @param value 值
     * @return 操作是否成功
     */
    String set(String key,String value);

    /**
     * 根据键查询对应的值
     * @param key 键
     * @return 值
     */
    String get(String key);

    /**
     * 添加hash类型的数据
     * @param hkey hash表名
     * @param key hash表中的某个键
     * @param value hash表中的某个值
     * @return 成功与否
     */
    long hset(String hkey,String key,String value);

    /**
     * 获取hash表中某个键对应的值
     * @param hkey hash表名
     * @param key hash表中的某个键
     * @return 该键对应的值
     */
    String hget(String hkey,String key);

    /**
     * 自增1
     * @param key 键
     * @return 自增之后的值
     */
    long incr(String key);

    /**
     * 为某个键设置超时失效时间
     * @param key 键
     * @param seconds 超时失效时间
     * @return 是否设置成功
     */
    long expire(String key,int seconds);

    /**
     * 返回某个键的超时失效时间
     * @param key 键
     * @return 超时失效时间
     */
    long ttl(String key);

    /**
     * 删除某个键
     * @param key 键
     * @return 删除是否成功，1：成功 | 0：失败
     */
    long del(String key);

    /**
     * 删除hash表中的某个键值对
     * @param hkey hash表名
     * @param key hash表中的某个键
     * @return 删除是否成功，1：成功 | 0：失败
     */
    long hdel(String hkey,String key);

    /**
     * 添加有序集合，用于对所有论文排序
     * @param key 有序集合名
     * @param score 要添加的元素分数
     * @param paper 论文对象
     * @return 是否添加成功
     */
    long zadd(String key, double score, Paper paper);

    /**
     * 向有序集合中添加一个列表
     * @param key 集合名
     * @param paperList 列表
     * @return 是否添加成功
     */
    long zaddList(String key, List<Paper> paperList);

    /**
     * 获取所有集合中所有的元素
     * @param key 集合名
     * @param start 开始位置
     * @param end 终点位置
     * @return 该集合
     */
    Set<String> zgetAll(String key,long start,long end);

    /**
     * 获取榜单最后一名的元素
     * @param key 集合名
     * @param start 开始位置
     * @param end 终止位置
     * @return 该集合
     */
    Set<String> zgetTopLast(String key,long start,long end);
}
