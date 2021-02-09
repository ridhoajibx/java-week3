package com.glints.onlinestore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glints.onlinestore.exception.BadRequestException;
import com.glints.onlinestore.model.Member;
import com.glints.onlinestore.payload.MemberPayload;
import com.glints.onlinestore.repository.MemberRepo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepo memberRepo;

	@Override
	public List<Member> read() {
		List<Member> members = memberRepo.findAll();
		return members;
	}

	@Override
	public Member create(MemberPayload memberPayload){
		Member member = new Member(
				memberPayload.getFirstname(), 
				memberPayload.getSurname(),
				memberPayload.getAddress(),
				memberPayload.getContact(),
				memberPayload.getExpires()
				);
		member = memberRepo.save(member);
		return member;
	}

	@Override
	public Member update(Integer id, MemberPayload memberPayload) throws BadRequestException {
		Member member = memberRepo.findById(id).orElseThrow(()-> new BadRequestException("Book Category with id " + id + " not found!"));
		member.setFirstname(memberPayload.getFirstname());
		member.setSurname(memberPayload.getSurname());
		member.setAddress(memberPayload.getAddress());
		member.setContact(memberPayload.getContact());
		member.setExpires(memberPayload.getExpires());
		member.setUpdatedTime(new Date());
		member = memberRepo.save(member);
		return member;
	}

	@Override
	public String delete(Integer id) {
		memberRepo.deleteById(id);
		return "Member with data id: " + id + " has been deleted!";
	}

	@Override
	public Member readById(Integer id) {
		Member member = memberRepo.findById(id).orElse(null);
		return member;
	}
	
}
