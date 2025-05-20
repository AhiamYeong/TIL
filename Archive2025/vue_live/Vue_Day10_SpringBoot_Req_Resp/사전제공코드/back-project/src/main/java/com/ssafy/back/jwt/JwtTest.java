package com.ssafy.back.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTest {
public static void main(String[] args) throws InterruptedException {

		String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
		// 비밀키 : 문자열 -> 끙챠끙챠 -> 비밀키 만들기 
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
		
		// 진짜 JWT 만들기 본인 만들기 나름이네 잔뜩잔뜩? 
		
		Map<String, String> headers = new HashMap<>();
		// header에 여러 정보 넣고 싶으면 걍 맵으로 ㄱㄱ
		headers.put("typ", "JWT");
		
		String token = Jwts.builder() // jwt 만들 수 있는 빌더 객체
		.header() // builder 중 header 만드는 객체 (builderheader) - 잘 안바꿈 
		.add("name", "yu")
		.add(headers).and() // and: jwtbuilder로 돌아감 
		.subject("jwt class") // sub: 토큰 주제 (보통 유저ID)
		.expiration(new Date(System.currentTimeMillis() + 3000)) // 만료 시간 - 현재 시점 기준 3초만큼 유효
		.signWith(secretKey) // 서명 완료 - 이미 key 만들어줬으니까 냅다 넣은거 (보안 핵심)
		.compact(); // token 드뎌 완성

		// 이정도면 필요한 것만 모음
		/*
		String token = Jwts.builder()
			    .subject("user123")
			    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30분
			    .signWith(secretKey)
			    .compact();
		 */

		
		System.out.println(token);
		
		/////////// 1 토큰 생성 완료 //////////////////

		Thread.sleep(4000);
		
		/////////// 2 토큰 유효성 검사 ////////////////
		// 데이터 끄내서 써보기 - 개빡센데?
		Jws<Claims> jwsClaims = Jwts.parser().verifyWith(secretKey).build()
				.parseSignedClaims(token); // token 파싱 & 서명 검증 & 객체 꺼내기 
		
		System.out.println(jwsClaims.getHeader());
		System.out.println(jwsClaims.getPayload());
		
		// 만료 시 refresh token 넘겨보기 > 완전 만료 시 다 튕기고 로그인 화면으로 ㄱㄱ 
	}
}
