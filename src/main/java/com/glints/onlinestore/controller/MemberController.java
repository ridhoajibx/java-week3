package com.glints.onlinestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glints.onlinestore.model.Member;
import com.glints.onlinestore.payload.MemberPayload;
import com.glints.onlinestore.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/member")
	public ResponseEntity<List<Member>> read(){
		List<Member> members = memberService.read();
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}

	@PostMapping("/create-member")
	public ResponseEntity<Member> create(@RequestBody MemberPayload memberPayload){
		Member member = memberService.create(memberPayload);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}	
	
	@PostMapping("/update-member/{id}")
	public ResponseEntity<Member> update(@PathVariable("id") Integer id, @RequestBody MemberPayload memberPayload){
		Member member = memberService.update(id, memberPayload);
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-member/{id}")
	public String delete(@PathVariable("id") Integer id) {
		memberService.delete(id);
		return "Member with data id: " + id + " has been deleted!";
	}
	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> readById(@PathVariable("id") Integer id){
		Member member = memberService.readById(id);
		return new ResponseEntity<Member>(member, HttpStatus.OK); 
	}
	
}
