package pengqi.commons.Utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pengqi.model.pojo.Paper;

import java.util.ArrayList;
import java.util.List;

/**
 * 将对象转换成Json格式的工具类
 * create on 2019/1/19 by pengqi
 */
public class JsonUtils {
    /**
     * 将对象转换成JSON字符串类型
     * @param data 对象
     * @return 字符串
     */
    public static String objectToJson(Object data){
        return JSONArray.toJSONString(data);
    }

    /**
     * 将String转换成java对象
     * @param paperString 字符串
     * @return java对象
     */
    public static Paper jsonObjectToPaper(String paperString){
        return JSONObject.parseObject(paperString.toString(),Paper.class);
    }

    /**
     * 将一个字符串列表转换成一个java对象列表
     * @param paperStringList 字符串列表
     * @return java对象列表
     */
    public static List<Paper> jsonObjectListToPaper(JSONArray paperStringList){
        List<Paper> paperList = new ArrayList<>();
        for(Object element:paperStringList){
            Paper paper = JSONObject.parseObject(element.toString(),Paper.class);
            paperList.add(paper);
        }
        return paperList;
    }
}
