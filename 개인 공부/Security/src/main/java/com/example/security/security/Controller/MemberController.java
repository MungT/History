package com.example.security.security.Controller;

import com.example.security.security.Dto.MemberResponseDto;
import com.example.security.security.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me") // 로그인 한 본인 정보 불러오기
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {
        return ResponseEntity.ok(memberService.getMyInfo());
    }

    @GetMapping("/{nickname}") // 특정 유저 정보 불러오기
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable String nickname) {
        return ResponseEntity.ok(memberService.getMemberInfo(nickname));
    }
}