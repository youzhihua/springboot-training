package training.springboot.file.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 文件上传
     * @param multipartFile
     * @return
     */
    @PostMapping(value = "/upload")
    public boolean uploadFile(MultipartFile multipartFile){
        String root = "D:\\数据\\";
        //加时间戳防止重名
        String filename = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        //创建目标文件位置
        File file = new File(root+filename);
        //写入文件
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 文件下载
     */
    @GetMapping(value = "/download")
    public void downloadFile(HttpServletResponse response) throws IOException {
        //设置编码
        response.setCharacterEncoding("UTF-8");
        //设置资源的MIME类型
        response.setContentType("application/x-jpg;charset=UTF-8");
        //设置现在文件的文件名（使用URLEncode，防止中文乱码）
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("示例图片.jpg","UTF-8"));

        //读写文件
        FileInputStream fileInputStream = new FileInputStream("D://1.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = bufferedInputStream.read(buffer);

        while(len != -1){
            out.write(buffer);
            len =bufferedInputStream.read(buffer);
        }

        //关闭流
        bufferedInputStream.close();
        fileInputStream.close();
        out.close();
    }
}
