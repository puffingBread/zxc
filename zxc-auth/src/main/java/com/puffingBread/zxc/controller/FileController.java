package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.model.RspVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Administrator on 2017/7/5.
 */
@RestController
public class FileController {
//    @Autowired
//    private FileService fileService;

    private static String filePath = "F:/ZFileTest/";

    @RequestMapping(value = "/operateData/upload", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    @ResponseBody
    public RspVo handleFileUpload(@RequestParam(value = "file") MultipartFile file) {

        RspVo rspVo = new RspVo();
        String fileName = file.getOriginalFilename();
        String fileUrl = filePath + fileName;
        if(!file.isEmpty()){
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(fileUrl)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                rspVo.setResultCode(404);
                rspVo.setResultMsg("上传失败,"+e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                rspVo.setResultCode(500);
                rspVo.setResultMsg("上传失败,"+e.getMessage());
            }
            rspVo.setResultMsg("上传成功");
            //读取文件内容
//            fileService.readFile(fileUrl);
        }else{
            rspVo.setResultMsg("上传文件失败，因为文件是空的！");
        }
        return rspVo;
    }

}
