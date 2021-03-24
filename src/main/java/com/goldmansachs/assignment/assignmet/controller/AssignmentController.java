package com.goldmansachs.assignment.assignmet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goldmansachs.assignment.assignmet.form.PalindromForm;
import com.goldmansachs.assignment.assignmet.service.PalindromeService;
import com.goldmansachs.assignment.assignmet.service.ReverseBinaryString;

@RestController
public class AssignmentController {

	@Autowired
	private PalindromeService palindromeService;

	@Autowired
	private ReverseBinaryString reverseBinary;

	@PostMapping("/palindrome")
	public ResponseEntity<String> savePalidrom(@RequestBody PalindromForm palindromForm) {
		String paliString = null;
		if (palindromForm.getPaliString() != null) {
			paliString = palindromeService.savePalindromeString(palindromForm.getPaliString());

		}
		return new ResponseEntity<String>(paliString, HttpStatus.CREATED);
	}

	@GetMapping("/palindrome")
	public ResponseEntity<String> retrivePalindrom() {
		return new ResponseEntity<String>(palindromeService.getLongestPalidromeString(), HttpStatus.OK);

	}

	@GetMapping("/reverseBinary")
	public ResponseEntity<Integer> reverseBinary(@RequestParam("binary") String binary) {
		return new ResponseEntity<Integer>(reverseBinary.binaryReversal(binary), HttpStatus.OK);

	}

}
