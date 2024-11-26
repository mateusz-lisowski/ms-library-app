package com.github.mateusz_lisowski.member.member;

import com.github.mateusz_lisowski.member.member.schemas.MemberCrateRequest;
import com.github.mateusz_lisowski.member.member.schemas.MemberResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberMapper {

    public Member toMember(MemberCrateRequest request) {
        return Member.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .build();
    }

    public MemberResponse toMemberResponse(Member member) {
        return new MemberResponse(member.getId(), member.getFirstname(), member.getLastname());
    }

}
