package com.sh.lmg.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * JsonUtil的fastjson实现
 */
public class FastJsonUtil {

    public static String bean2Json(Object object) {
        return JSON.toJSONString(object);
    }

    public static <T> T json2Bean(String jsonString, TypeReference<T> typeReference) {
        return JSON.parseObject(jsonString, typeReference);
    }

}