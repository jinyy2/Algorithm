package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2441_별찍기4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=N;i>0;i--) {
			for(int j=0;j<N-i;j++) {
				sb.append(" ");
			}
			for(int j=0;j<i;j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}

}
