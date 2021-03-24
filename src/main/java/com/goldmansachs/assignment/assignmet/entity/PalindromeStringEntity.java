package com.goldmansachs.assignment.assignmet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palindrome")
public class PalindromeStringEntity {

	@Id
	private int id;

	@Column(name = "palindrome_String")
	private String palindromeString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPalindromeString() {
		return palindromeString;
	}

	public void setPalindromeString(String palindromeString) {
		this.palindromeString = palindromeString;
	}

}
