package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.common.utils.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 2017/6/17.
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = "excel文件";
        //填充projects数据
        List<Map<String, Object>> list = new ArrayList<>();
        String columnNames[] = {"ID", "名字", "年龄"};//列名
        String keys[] = {"id", "name", "age"};        //map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ServletOutputStream outputStream = null;

        ExcelUtil.exportExcel("", "", "", "", null, null, null);
//            ExcelUtil.createWorkBook(list, keys, columnNames).write(os);

//        byte[] content = os.toByteArray();
//        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new ByteArrayInputStream(os.toByteArray()));
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
}
