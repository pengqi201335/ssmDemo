package pengqi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pengqi.commons.Utils.JsonUtils;
import pengqi.model.pojo.Paper;
import pengqi.model.service.JedisClient;
import pengqi.model.service.PaperService;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Redis缓存的控制器
 * create on 2019/1/19 by pengqi
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisCacheController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private JedisClient jedisClient;

    @RequestMapping(value = "/redisTest")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public String testRedis(int paperID){
        List<Paper> paper = null;
        try{
            String result = jedisClient.hget("paperTable",paperID+"");
            if(result!=null){
                //缓存中已经存有"论文表"的信息
                System.out.println("此数据由redis中查得：");
                //将字符串类型的查询结果转换成JSON数组类型
                JSONArray array = JSONArray.parseArray(result);
                //进一步地，将JSON数组类型的数据转换成对象列表
                paper = (List)array;
            }
            else {
                //缓存中还没有"论文表"的信息，即第一次查询
                System.out.println("此结果由数据库中查得：");
                //去数据库中查询结果
                Paper paper_ = paperService.queryPaperByID(paperID);
                paper = new ArrayList<>();
                paper.add(paper_);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            //将查询结果存入redis中
            //将对象列表转换成字符串类型，以便存入redis
            String cacheString  = JsonUtils.objectToJson(paper);
            //结果存入redis
            jedisClient.hset("paperTable",paperID+"",cacheString);
        }catch (Exception e){
            e.printStackTrace();
        }

        return JSON.toJSONString(paper);
    }
}
