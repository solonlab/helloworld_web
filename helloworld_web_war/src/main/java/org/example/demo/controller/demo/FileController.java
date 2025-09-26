package org.example.demo.controller.demo;

import org.example.demo.controller.BaseController;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.solon.boot.web.MimeType;
import org.noear.solon.core.handle.DownloadedFile;
import org.noear.solon.core.handle.UploadedFile;
import org.noear.solon.core.util.ResourceUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 了解文件上传或下载
 * */
@Mapping("file")
@Controller
public class FileController extends BaseController {
    //文件上传
    @Post
    @Mapping("/upload")
    public String upload(UploadedFile file) {
        //file.transferTo(new File("/demo/user/logo.jpg")); 把它转为本地文件
        return file.getName();
    }

    //文件下载（即输出文件）
    @Get
    @Mapping("/down")
    public DownloadedFile down() throws IOException {
        URL file = ResourceUtil.getResource("WEB-INF/static/index.html");
        String fileName = "index.html";
        return new DownloadedFile(MimeType.TEXT_HTML_VALUE, file.openStream(), fileName);
    }

    //文件下载（即输出文件）
    @Get
    @Mapping("/down2")
    public File down2() {
        return new File("/demo/user/logo.jpg");
    }
}
