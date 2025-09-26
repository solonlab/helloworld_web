package com.example.demo.controller.demo

import com.example.demo.controller.BaseController
import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Get
import org.noear.solon.annotation.Mapping
import org.noear.solon.annotation.Post
import org.noear.solon.boot.web.MimeType
import org.noear.solon.core.handle.DownloadedFile
import org.noear.solon.core.handle.UploadedFile
import org.noear.solon.core.util.ResourceUtil
import java.io.File
import java.io.IOException


/**
 * 了解文件上传或下载
 */
@Mapping("file")
@Controller
class FileController : BaseController() {
    //文件上传
    @Post
    @Mapping("/upload")
    fun upload(file: UploadedFile): String {
        //file.transferTo(new File("/demo/user/logo.jpg")); 把它转为本地文件
        return file.name
    }

    //文件下载（即输出文件）
    @Get
    @Mapping("/down")
    @Throws(IOException::class)
    fun down(): DownloadedFile {
        val file = ResourceUtil.getResource("WEB-INF/static/index.html")
        val fileName = "index.html"
        return DownloadedFile(MimeType.TEXT_HTML_VALUE, file.openStream(), fileName)
    }

    //文件下载（即输出文件）
    @Get
    @Mapping("/down2")
    fun down2(): File {
        return File("/demo/user/logo.jpg")
    }
}

