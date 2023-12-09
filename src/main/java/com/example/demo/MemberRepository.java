package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.example.demo.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
    List<Member> findAll();

    Member findMemberByMemberID(String memberID);
    void deleteMemberByMemberID(String memberID);

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

    List<Member> findMemberByMemberStatus(boolean memberStatus);
    void deleteMemberByMemberStatus(boolean memberStatus);
}