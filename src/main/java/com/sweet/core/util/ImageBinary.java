package com.sweet.core.util;



import com.sweet.modular.reportimage.mapper.ReportimageMapper;
import com.sweet.modular.reportimage.service.ReportimageService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;




public class ImageBinary {


    public static void main(String[] args) {
        String fileName = "D://upload//test.jpg";
        System.out.println(getImageBinary(fileName));
        saveImage(getImageBinary(fileName));
    }



    /*
     * 图片转换为二进制
     *
     * @param fileName
     *            本地图片路径
     * @return
     *       图片二进制流
     * */
    public static String getImageBinary(String fileName) {
        File f = new File(fileName);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return Base64.encodeBase64String(bytes);
            //return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将二进制转换为图片
     *
     * @param base64String
     *            图片二进制流
     *
     */
    public static void saveImage(String base64String) {
        try {
            byte[] bytes1 = Base64.decodeBase64(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File("D://upload//33.jpg");// 可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);// 不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
