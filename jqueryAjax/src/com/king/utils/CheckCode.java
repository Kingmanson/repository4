package com.king.utils;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class CheckCode {
    @Test
    public void generateCode() throws IOException {
        //创建图片对象
        int width = 100;
        int height = 60;
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //对图片进行美化
        Graphics pen = bi.getGraphics();
        //背景色
        pen.setColor(Color.pink);
        pen.fillRect(0,0,width,height);
        //边框
        pen.setColor(Color.black);
        pen.drawRect(0,0,width-1,height-1);
        //书写内容
        pen.setFont(new Font("楷体",Font.PLAIN,30));
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        for(int i=1;i<5;i++){
            int n = r.nextInt(chars.length());
            String var = chars.charAt(n)+"";
            pen.drawString(var,width/5*i-10,height/2+10);
        }

        //输出
        ImageIO.write(bi,"jpg",new FileOutputStream("D://code.jpg"));

    }
}
