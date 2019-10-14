package com.ja.mlproject.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCsv {
	public ArrayList<String> readIndex(String filepath) {
		String line = "";
		
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(filepath));
			Charset.forName("UTF-8");
			
			line = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> list = Arrays.asList(line.split(","));
		ArrayList<String> index = new ArrayList<String>(list);
		
		return index;
	}
}
