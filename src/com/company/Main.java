package com.company;

import java.io.*;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

          new Main().getPx3(414);
    }

    public void getPx(float width){
        String role = "\\s*\\d+\\s*px";
        System.out.println(role);
        Pattern pattern = Pattern.compile(role);
        Pattern pattern2;
        Matcher matcher2;
        StringBuffer newCss = new StringBuffer();
        DecimalFormat format = new DecimalFormat( "0.0000");
        float rpx = (float) (750.0/width);
        float tempNum;
        String text = ".iconfont.icon-huidaodingbu{\n" +
                "  display: none;\n" +
                "  position: fixed;\n" +
                "  bottom: 223px;\n" +
                "  right: 18px;\n" +
                "  width: 40px;\n" +
                "  height: 40px;\n" +
                "  background-color: white;\n" +
                "  border-radius: 27px;\n" +
                "  z-index: 2;\n" +
                "  text-align: center;\n" +
                "  font-size: 40px;\n" +
                "  box-shadow: 0px 0px 2px 0px black;\n" +
                "  color: orange;\n" +
                "}";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String px  =    matcher.group();

            System.out.println(px);

            pattern2 = Pattern.compile("\\d+");
            matcher2 = pattern2.matcher(px);
            matcher2.find();
            tempNum = Integer.parseInt(matcher2.group());
            tempNum *= rpx;
            tempNum = (float) Double.parseDouble(format.format(tempNum));

            matcher.appendReplacement(newCss,tempNum+"rpx ");
        }
            matcher.appendTail(newCss);

        System.out.println(newCss);
    }


    public void getPx2(float width) throws IOException {
        String role = "\\s*\\d+\\s*px";
//        System.out.println(role);
        Pattern pattern1 = Pattern.compile(role);
        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher matcher1;
        Matcher matcher2 = pattern2.matcher(" ");
        StringBuffer newCss = new StringBuffer();
        DecimalFormat format = new DecimalFormat( "0.0000");
        float rpx = (float) (750.0/width);
        float tempNum;


        BufferedReader reader = new BufferedReader(new FileReader("democss.txt"));
        String text = " ";
        matcher1 = pattern1.matcher(text);
        System.out.println("****************************************************************");
        while ((text = reader.readLine())!=null){
            matcher1.reset(text+"\n");
            while(matcher1.find()){
                String px  =    matcher1.group();
//
            System.out.println("提取数字前"+px);

            matcher2 = matcher2.reset(px);
            matcher2.find();
//            System.out.println("提取数字后"+matcher2.group());
            tempNum = Integer.parseInt(matcher2.group());
            tempNum *= rpx;
            tempNum = (float) Double.parseDouble(format.format(tempNum));
//
            matcher1.appendReplacement(newCss,tempNum+"rpx ");

            }
            matcher1.appendTail(newCss);
        }

//

        String finalCss = String.valueOf(newCss);
        BufferedWriter writer = new BufferedWriter(new FileWriter("demo2.css"));
//        while (writer.)
        String[] split = finalCss.split("\n");
        for (String s : split) {
            writer.write(s);
            writer.newLine();
        }
        writer.flush();
        reader.close();
        writer.close();
        System.out.println("****************************************************************");


//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()){
//            String px  =    matcher.group();
//
//            System.out.println(px);
//
//            pattern2 = Pattern.compile("\\d+");
//            matcher2 = pattern2.matcher(px);
//            matcher2.find();
//            tempNum = Integer.parseInt(matcher2.group());
//            tempNum *= rpx;
//            tempNum = (float) Double.parseDouble(format.format(tempNum));
//
//            matcher.appendReplacement(newCss,tempNum+"rpx ");
//        }
//        matcher.appendTail(newCss);
//
//        System.out.println(newCss);
    }


    public void getPx3(float width) throws IOException {
        String role = "\\s*\\d+\\s*px";
//        System.out.println(role);
        Pattern pattern1 = Pattern.compile(role);
        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher matcher1;
        Matcher matcher2 = pattern2.matcher(" ");
//        StringBuffer newCss = new StringBuffer();
        DecimalFormat format = new DecimalFormat( "0.0000");
        float rpx = (float) (750.0/width);
        float tempNum;


        BufferedReader reader = new BufferedReader(new FileReader("democss.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("demo.css"));
        String text = " ";
        matcher1 = pattern1.matcher(text);
        System.out.println("****************************************************************");
        while ((text = reader.readLine())!=null){
            StringBuffer newCss = new StringBuffer();

            matcher1.reset(text+"\n");
            while(matcher1.find()){
                String px  =    matcher1.group();
                System.out.println("提取数字前"+px);

                matcher2 = matcher2.reset(px);
                matcher2.find();
//            System.out.println("提取数字后"+matcher2.group());
                tempNum = Integer.parseInt(matcher2.group());
                tempNum *= rpx;
                tempNum = (float) Double.parseDouble(format.format(tempNum));
//
                matcher1.appendReplacement(newCss,tempNum+"rpx ");

            }
            matcher1.appendTail(newCss);
            writer.write(String.valueOf(newCss));
//            writer.newLine();
            writer.flush();

        }

        reader.close();
        writer.close();

    }


}


