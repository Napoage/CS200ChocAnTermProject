package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
    List<Member> findAllMembers();

    Member findMemberByMemberNumber(String memberNumber);
    void deleteMemberByMemberNumber(String memberNumber);

    List<Member> findMemberByMemberName(String memberName);
    void deleteMemberByMemberName(String memberName);

    List<Member> findMemberByMemberAddress(String memberAddress);
    void deleteMemberByMemberAddress(String memberAddress);

    List<Member> findMemberByMemberCity(String memberCity);
    void deleteMemberByMemberCity(String memberCity);

    List<Member> findMemberByMemberState(String memberState);
    void deleteMemberByMemberState(String memberState);

    List<Member> findMemberByMemberZip(String memberZip);
    void deleteMemberByMemberZip(String memberZip);

    List<Member> findMemberByMemberStatus(String memberStatus);
    void deleteMemberByMemberStatus(String memberStatus);

}