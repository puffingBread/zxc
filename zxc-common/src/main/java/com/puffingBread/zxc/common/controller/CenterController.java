package com.puffingBread.zxc.common.controller;

import com.puffingBread.zxc.common.json.Json;
import com.puffingBread.zxc.common.utils.BlankUtil;
import com.puffingBread.zxc.common.utils.DateTime;
import com.puffingBread.zxc.common.utils.HttpUtil;
import com.puffingBread.zxc.common.utils.Pair;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 基础控制器
 * Created by cliang on 16/6/8.
 */
@Controller
public class CenterController {
    private static Log logger = LogFactory.getLog(CenterController.class);
    // 默认每页行数　
    private final static int PAGE_SIZE = 10;

    protected static int getStart(int pn) {
        if (pn <= 0) {
            return 0;
        }
        return (pn - 1) * PAGE_SIZE;
    }

    protected static int getStart(int pn, int size) {
        if (pn <= 0 || size <= 0) {
            return 0;
        }
        return (pn - 1) * size;
    }

    /**
     * 截取分页
     *
     * @param listPage
     * @param pn
     * @param <T>
     * @return
     */
    protected <T> List<T> listPage(List<T> listPage, int pn) {
        if (pn <= 0) {
            pn = 1;
        }

        int start = getStart(pn);
        int size = start + PAGE_SIZE;

        if (start >= listPage.size()) {
            return new ArrayList<T>();
        }

        if (size > listPage.size()) {
            size = listPage.size();
        }

        return listPage.subList(start, size);
    }

    /**
     * 获取输入流
     *
     * @param request
     * @return
     */
    protected String getJsonString(HttpServletRequest request) {
        String jsonString = HttpUtil.getBufferStream(request);
        String uri = request.getRequestURI();
//        if(uri.equals("/api/admin/vs/pwd") || uri.equals("/api/admin/vs/reg")
//                || uri.equals("/api/admin/vs/login")){
//            return jsonString;
//        }
//        logger.info("uri:" + uri + ",request body content:" + jsonString);
        return jsonString;
    }


    /**
     * 输入流转为对象
     *
     * @param request
     * @param clazz
     * @return
     */
    protected <T> T getObject(HttpServletRequest request, Class<T> clazz) {
        String jsonString = this.getJsonString(request);
        return StringUtils.isBlank(jsonString) ? null : Json.toObject(jsonString, clazz);
    }

    /**
     * 转为对象
     *
     * @param request
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T getObject(HttpServletRequest request, String key, Class<T> clazz) {
        JSONObject jsonObject = JSONObject.fromObject(this.getJsonString(request));
        Object obj = jsonObject.get(key);
        return obj == null ? null : Json.toObject(String.valueOf(obj), clazz);
    }

    /**
     * @param jsonString
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T getObject(String jsonString, String key, Class<T> clazz) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Object obj = jsonObject.get(key);
        return obj == null ? null : Json.toObject(String.valueOf(obj), clazz);
    }
    /**
     * 输入流转对象数组
     *
     * @param request
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<T> getListObject(HttpServletRequest request, Class<T> clazz) {
        String jsonString = this.getJsonString(request);
        return StringUtils.isBlank(jsonString) ? new ArrayList<T>() : Json.toList(jsonString, clazz);
    }

    /**
     * @param request
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<T> getListObject(HttpServletRequest request, String key, Class<T> clazz) {
        JSONObject jsonObject = JSONObject.fromObject(this.getJsonString(request));
        Object obj = jsonObject.get(key);
        return Json.toList(String.valueOf(obj), clazz);
    }

    protected <T> List<T> getListObject(String jsonString, String key, Class<T> clazz) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Object obj = jsonObject.get(key);
        return Json.toList(String.valueOf(obj), clazz);
    }


    /**
     * 输入流转为Map
     *
     * @param request
     * @return
     */
    protected Map<String, Object> getMap(HttpServletRequest request) {
        String jsonString = this.getJsonString(request);
        return StringUtils.isBlank(jsonString) ? new HashMap<String, Object>() : Json.toHashedMap(jsonString);
    }

    /**
     * 返回错误信息
     *
     * @param result
     * @param code
     * @param message
     * @return
     */
    protected void error(HttpServletResponse response, Map<String, Object> result,
                         Code code, String message) {
        result.put("code", code.code());
        result.put("message", message);
        result.put("now", DateTime.getCurrTime());
        this.response(response, result);
    }

    /**
     * 返回错误信息
     *
     * @param result
     * @param message
     * @return
     */
    protected void error(HttpServletResponse response, Map<String, Object> result, String message) {
        result.put("code", Code.ERROR.code());
        result.put("message", message);
        result.put("now", DateTime.getCurrTime());
        this.response(response, result);
    }

    /**
     * 返回错误信息
     *
     * @param result
     * @return
     */
    protected void error(HttpServletResponse response, Map<String, Object> result) {
        result.put("code", Code.ERROR.code());
        result.put("message", "请求失败!");
        result.put("now", DateTime.getCurrTime());
        this.response(response, result);
    }

    /**
     * 返回成功信息
     *
     * @param result
     * @return
     */
    protected void success(HttpServletResponse response, Map<String, Object> result) {
        result.put("code", Code.SUCCESS.code());
        result.put("message", "ok");
        result.put("now", DateTime.getCurrTime());
        this.response(response, result);
    }

    /**
     * 构建Map
     *
     * @param result
     * @param key
     * @param object
     * @return
     */
    protected Map<String, Object> build(Map<String, Object> result, String key, Object object) {
        result.put(key, object);
        return result;
    }

    /**
     * 构建Map
     * @param result
     * @param key
     * @param listData
     * @param request
     * @return
     */
    protected <T> Map<String, Object> build(Map<String, Object> result, String key, List<T> listData,
                                            HttpServletRequest request) {
        Pair<List<T>, Integer> pair = this.listPage(listData, request);
        result.put("total", listData == null ? 0 : listData.size());
        result.put("pageCount", pair.getSecond());
        result.put(key, pair.getFirst());
        return result;
    }

    /**
     * 构建result
     *
     * @param result
     * @param key
     * @param listData
     * @param total
     * @param pageSize
     * @param <T>
     * @return
     */
    protected <T> Map<String, Object> build(Map<String, Object> result, String key,
                                            List<T> listData, int total, int pageSize) {
        result.put("total", total);
        result.put("pageSize", pageSize);

        if (total == 0) {
            result.put("pageCount", 0);
        } else {
            int count = total / pageSize;
            if (total % pageSize != 0) {
                count++;
            }
            result.put("pageCount", count);
        }

        result.put(key, listData);
        return result;
    }

    /**
     * 请求开始行数,每页行数
     *
     * @param request
     * @return
     */
    protected Pair<Integer, Integer> page(HttpServletRequest request) {
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        int page2 = 0;
        int pageSize2 = 0;

        try {
            page2 = Integer.parseInt(page);
            pageSize2 = Integer.parseInt(pageSize);
        } catch (Exception e) {
            page2 = 1;
            pageSize2 = 10;
        }

        page2 = page2 - 1;
        page2 = page2 < 0 ? 1 : page2;
        pageSize2 = pageSize2 < 0 ? 10 : pageSize2;
        return Pair.makePair(page2, pageSize2);
    }

    /**
     *
     * @param request
     * @return
     */
    protected Pair<Integer, Integer> page2(HttpServletRequest request) {
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        int page2 = 0;
        int pageSize2 = 0;

        try {
            page2 = Integer.parseInt(page);
            pageSize2 = Integer.parseInt(pageSize);
        } catch (Exception e) {
            page2 = 1;
            pageSize2 = 10;
        }

        page2 = page2 - 1;
        page2 = page2 < 0 ? 1 : page2;
        pageSize2 = pageSize2 < 0 ? 10 : pageSize2;
        int start = page2 * pageSize2;
        return Pair.makePair(start, pageSize2);
    }

    /**
     * 请求开始行数,结束行数
     *
     * @param request
     * @return
     */
    protected Pair<Integer, Integer> pageRow(HttpServletRequest request) {
        int start = 0;
        int size  = 0;
        Pair<Integer, Integer> page = this.page(request);
        start = page.getFirst() * page.getSecond();
        size += start + page.getSecond();
        return Pair.makePair(start, size);
    }


    private void response(HttpServletResponse response, Map<String, Object> result) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            response.setContentType("application/json;charset=utf-8");
            out.write(Json.toJsonString(result));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            out.close();
        }
    }

    /**
     * 截取分页
     *
     * @param listPage
     * @param request
     * @return
     */
    private <T> Pair<List<T>, Integer> listPage(List<T> listPage, HttpServletRequest request) {
        Pair<Integer, Integer> pair = this.page2(request);

        if (BlankUtil.isBlank(listPage)) {
            List<T> list = new ArrayList<T>();
            return Pair.makePair(list, 0);
        }

        int start = pair.getFirst();
        int pageSize = pair.getSecond();
        int count = 1;

        if (listPage.size() > pageSize) {
            count = listPage.size() / pageSize;
            if (count % pageSize != 0) {
                count ++;
            }
        }

        int size = start + pageSize;
        if (start >= listPage.size()) {
            List<T> listData = new ArrayList<T>();
            return Pair.makePair(listData, count);
        }

        if (size > listPage.size()) {
            size = listPage.size();
        }
        return Pair.makePair(listPage.subList(start, size), count);
    }
}
