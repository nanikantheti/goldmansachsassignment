package com.goldmansachs.assignment.assignmet.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseBinaryString {

	public int binaryReversal(String str) {
		Integer intValue = 0;
		String binaryString = null;
		String padded = null;
		String reverseBinaryStrig = null;
		int decimalValue = 0;
		try {
			if (str != null) {
				intValue = Integer.parseInt(str);
				if (intValue > 0) {
					binaryString = Integer.toBinaryString(intValue);
					padded = String.format("%8s", binaryString).replace(' ', '0');
					StringBuffer buffer = new StringBuffer(padded);
					reverseBinaryStrig = buffer.reverse().toString();
					decimalValue = Integer.parseInt(reverseBinaryStrig, 2);

				}
			}
		} catch (Exception ne) {
			ne.printStackTrace();
		}
		return decimalValue;
	}

}
