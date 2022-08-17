package com.example.security.security.Dto;

import com.example.security.security.jwt.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto{
    private Long id;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static MemberResponseDto of(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setId(member.getId());
        memberResponseDto.setNickname(member.getNickname());
        // Timestamped는 Dto에선 이렇게 직접 넣어줘야 함
        memberResponseDto.setCreatedAt(member.getCreatedAt());
        memberResponseDto.setModifiedAt(member.getModifiedAt());
        return memberResponseDto;
    }
}