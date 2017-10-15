package com.cen.wehelp.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by redbird on 2017/7/2.
 */
public class ResponseJsonUtils {
    /**
     * 默认字符编码
     */
    private static String encoding = "UTF-8";

    /**
     * 返回JSON格式数据
     *
     * @param response
     * @param data 待返回的Java对象
     */
    public static void returnJson(HttpServletResponse response, String data) throws IOException{
        //设置编码格式
        response.setContentType("text/plain;charset=" + encoding);
        response.setCharacterEncoding(encoding);

        PrintWriter out = null;
        out = response.getWriter();
        out.write(data);
        out.flush();
    }
}
