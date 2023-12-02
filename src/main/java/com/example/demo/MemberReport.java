package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.example.demo.Member;
@Entity
public class MemberReport extends Report{

    @Autowired
    private MemberRepository memberRepository;
    
    @Column(length = 25)
    private String memberName;
    @Column(length = 9)
    private String memberNumber;
    @Column(length = 25)
    private String memberStreetAddress;
    @Column(length = 14)
    private String memberCity;
    @Column(length = 2)
    private String memberState;
    @Column(length = 5)
    private String memberZipCode;

    private Member member;
    private ServiceRecord serviceRecord;
    private ServiceRecord[] serviceRecords;

    public MemberReport(String memberName, String memberNumber, String memberStreetAddress, String memberCity,
            String memberState, String memberZipCode, ServiceRecord serviceRecord) {
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.memberStreetAddress = memberStreetAddress;
        this.memberCity = memberCity;
        this.memberState = memberState;
        this.memberZipCode = memberZipCode;
        this.serviceRecord = serviceRecord;
    }

    public MemberReport(String memberNumber, ServiceRecord[] serviceRecords) {
        member = memberRepository.findByMemberNumber(memberNumber);
        this.memberName = member.memberName;
        this.memberNumber = memberNumber;
        this.memberStreetAddress = member.memberStreetAddress;
        this.memberCity = member.memberCity;
        this.memberState = member.memberState;
        this.memberZipCode = member.memberZipCode;
        this.serviceRecords = serviceRecords;
    }
}
