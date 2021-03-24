package com.goldmansachs.assignment.assignmet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldmansachs.assignment.assignmet.entity.PalindromeStringEntity;
import com.goldmansachs.assignment.assignmet.repo.PalindromeRepo;

@Service
public class PalindromeService {

	@Autowired
	private PalindromeRepo palindromeRepo;;

	public String savePalindromeString(String palindromeString) {

		String longestPaliSubString = null;
		try {
			longestPaliSubString = findLongestPalindromicSubstring(palindromeString, palindromeString.length() - 1);
			PalindromeStringEntity palindromeEntity = new PalindromeStringEntity();
			palindromeEntity.setId(1);
			palindromeEntity.setPalindromeString(longestPaliSubString);
			palindromeRepo.save(palindromeEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return longestPaliSubString;
	}

	public String getLongestPalidromeString() {
		String longestPaliSubString = null;
		List<PalindromeStringEntity> palindromString = palindromeRepo.findAll();
		if (!palindromString.isEmpty() && palindromString != null) {
			longestPaliSubString = palindromString.get(0).getPalindromeString();
		}
		return longestPaliSubString;
	}

	public  String findLongestPalindromicSubstring(String str, int len) {
		// `max_str` stores the maximum length palindromic substring
		// found so far

		String max_str = "", curr_str;

		// `max_length` stores the maximum length of palindromic
		// substring found so far

		int max_length = 0, curr_length;

		// consider every character of the given string as a midpoint and expand
		// in both directions to find maximum length palindrome

		for (int i = 0; i < len; i++) {
			// find the longest odd length palindrome with `str[i]` as a midpoint

			curr_str = expand(str, i, i);
			curr_length = curr_str.length();

			// update maximum length palindromic substring if odd length
			// palindrome has a greater length

			if (curr_length > max_length) {
				max_length = curr_length;
				max_str = curr_str;
			}

			// Find the longest even length palindrome with str[i] and
			// str[i+1] as midpoints. Note that an even length palindrome
			// has two midpoints.

			curr_str = expand(str, i, i + 1);
			curr_length = curr_str.length();

			// update maximum length palindromic substring if even length
			// palindrome has a greater length

			if (curr_length > max_length) {
				max_length = curr_length;
				max_str = curr_str;
			}
		}

		return max_str;
	}

	private String expand(String str, int low, int high) {
		int len = str.length();

		// expand in both directions
		while (low >= 0 && high < len && (str.charAt(low) == str.charAt(high))) {
			low--;
			high++;
		}

		// return palindromic substring
		return str.substring(low + 1, high);
	}

}
