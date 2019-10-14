package com.ja.mlproject.util;

import java.util.Random;

public class RandKey {
	private int size;
	private boolean lowerCheck;
	
	public String getKey(int size, boolean lowerCheck) {
		this.size = size;
		this.lowerCheck = lowerCheck;
		return init();
	}
	
	private String init() {
		Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        
        int num = 0;
        
        // 전체 key의 길이가 size와 같을 때까지 난수 생성
        do {
            num = ran.nextInt(75) + 48;
            
            if((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char)num);
            }else {
                continue;
            }
        } while (sb.length() < size);
        
        // 소문자로 변경?
        if(lowerCheck) {
            return sb.toString().toLowerCase();
        }
        
        return sb.toString();
	}
}
