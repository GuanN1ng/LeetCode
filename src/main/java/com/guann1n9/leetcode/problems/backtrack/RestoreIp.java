package com.guann1n9.leetcode.problems.backtrack;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class RestoreIp {

    static List<String> res = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        backtrack(0,s,new StringBuilder());
        return res;
    }


    public static void backtrack(int count,String s,StringBuilder builder){
        if(count == 4 && s.length() == 0){
            builder.deleteCharAt(builder.lastIndexOf("."));
            res.add(new String(builder));
            return;
        }

        //超长返回
        if(s.length() > (4-count) * 3){
            return;
        }

        for (int i = 1; i < 4; i++) {
            if(s.length() < i){
                break;
            }
            String num = s.substring(0, i);
            if(Integer.parseInt(num) > 255){
                continue;
            }
            String rest = s.substring(i);
            if(num.length()>1 && num.startsWith("0")){
                continue;
            }
            String temp = builder.toString();
            builder.append(num).append(".");
            backtrack(++count,rest,builder);
            builder = new StringBuilder(temp);
            --count;
        }

    }


    public static void main(String[] args) {

        String a = "25525511135";

        String b = "123";


        System.out.println(b.substring(3));

        System.out.println(JSON.toJSONString(restoreIpAddresses(a)));

    }
}
