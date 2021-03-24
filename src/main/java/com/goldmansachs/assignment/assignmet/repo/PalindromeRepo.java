package com.goldmansachs.assignment.assignmet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldmansachs.assignment.assignmet.entity.PalindromeStringEntity;


@Repository
public interface PalindromeRepo   extends  JpaRepository<PalindromeStringEntity, Integer>{
	
}