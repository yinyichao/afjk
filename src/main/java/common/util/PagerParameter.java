package common.util;

import common.model.Pager;

import java.util.HashMap;
import java.util.Map;

public class PagerParameter {
    public static <T> Pager<T> parameter(Pager<T> pager,Integer pageNo,String code,String key){
        key = DecoderUtil.decode(key);
        if (pageNo == null) pageNo = 1;
        pager.setPageNo(pageNo);
        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("key", key);
        pager.setParams(params);
        return pager;
    }
    public static <T> Pager<T> parameter(Pager<T> pager,Integer pageNo){
        if (pageNo == null) pageNo = 1;
        pager.setPageNo(pageNo);
        return pager;
    }
    public static <T> Pager<T> addStatus(Pager<T> pager,Integer status){
        Map<String, Object> params = pager.getParams();
        params.put("status", status);
        pager.setParams(params);
        return pager;
    }
}
