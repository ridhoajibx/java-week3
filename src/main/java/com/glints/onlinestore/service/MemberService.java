package com.glints.onlinestore.service;

import java.util.List;

import com.glints.onlinestore.exception.BadRequestException;
import com.glints.onlinestore.model.Member;
import com.glints.onlinestore.payload.MemberPayload;

public interface MemberService {
	public List<Member> read();
	public Member create(MemberPayload memberPayload);
	public Member update(Integer id, MemberPayload memberPayload) throws BadRequestException;
	public String delete(Integer id);
	public Member readById(Integer id);
}
