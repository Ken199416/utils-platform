package app.controller;

import app.config.HttpConnectionManager;
import app.entity.ResponseBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/QRCode")
public class QRCodeController {
    private static Logger logger = LoggerFactory.getLogger(QRCodeController.class);

    @Autowired
    private HttpConnectionManager httpConnectionManager;
    @GetMapping("/getBuyLessonCode")
    public ResponseBean getBuyLessonCode(String goodsCode, String env){
        String url = null;
        if (StringUtils.equals(env,"test")){
            url = "https://api.qrserver.com/v1/create-qr-code/?size=250x250&data=https://www.confucius.mobi/qw_goods/view/goodsDetail?goodsCode=" + goodsCode;
        }else {
            url = "https://api.qrserver.com/v1/create-qr-code/?size=250x250&data=https://www.iquanwai.com/qw_goods/view/goodsDetail?goodsCode=" + goodsCode;
        }
        logger.info(url);
        HttpClient client = httpConnectionManager.getHttpClient();
        HttpGet get = new HttpGet(url);
        HttpResponse response = null;
        File file = new File(System.getProperty("user.dir")+"/QRCode/BuyLesson/" + env + goodsCode);
        try {
            file.createNewFile();
            response = client.execute(get);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            OutputStream outputStream = response
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseBean(10000,"cehsi",null);
    }
}

