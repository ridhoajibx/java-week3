package com.glints.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glints.onlinestore.model.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	
}
