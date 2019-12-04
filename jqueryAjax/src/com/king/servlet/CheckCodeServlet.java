package com.king.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        //输出到页面上
        ImageIO.write(bi,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}