package com.example.security.security.Controller;

import com.example.security.security.Dto.MemberRequestDto;
import com.example.security.security.Dto.MemberResponseDto;
import com.example.security.security.Dto.TokenDto;
import com.example.security.security.Dto.TokenRequestDto;
import com.example.security.security.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        if(memberRequestDto == null) {
            return signup(null);
        }
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

     //로그인
//    @PostMapping("/login")
//    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
//        return ResponseEntity.ok(authService.login(memberRequestDto));
//    }

    @PostMapping("/login")  // 로그인
    public ResponseEntity<?> login(@RequestBody MemberRequestDto memberRequestDto) {
        // Access token 생성
        String token = authService.login(memberRequestDto).getAccessToken();
        // 헤더 문구 작성
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer : " + token);
        // 바디, 헤더, Status 순으로 작성
        return new ResponseEntity<>(authService.login(memberRequestDto),httpHeaders, HttpStatus.FOUND);
    }

    @GetMapping("/logout") // 로그아웃
    public String logout(@RequestBody TokenRequestDto tokenRequestDto) {
        authService.logout(tokenRequestDto);
        return "/auth/login";
    }

    // 토큰 재발급
    @PostMapping("/reissue") // 토큰 재발급
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}