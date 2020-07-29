package com.ssafy.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/api/sns")
public class SNSController {
	static final String clientId = "px2gRec1H_fbAwS22rLW";	// 애플리케이션 클라이언트 아이디값";
	static final String naverClientSecret = "iQmYgJMpWR";	// 애플리케이션 클라이언트 시크릿값
	static final String tokenSecret = "HS256";				// 암호화 방식
	static String access_token;								// 접근 토큰
	static String refresh_token;							// 갱신 토큰
	static String JWT_token;

	/* 
	 * 네이버 아이디로 로그인
	 * 네이버 아이디로 로그인 인증 요청 => Front
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String naverCallback(@RequestParam(value = "code") String code, @RequestParam(value = "state") String state)
			throws Exception {
		System.out.println("로그인 시도");

		String naverLoginURL; // 접근 토큰 발급 요청 URL
		naverLoginURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		naverLoginURL += "client_id=" + clientId;
		naverLoginURL += "&client_secret=" + naverClientSecret;
		naverLoginURL += "&code=" + code;
		naverLoginURL += "&state=" + state;
		System.out.println("네이버 아이디 로그인 URL >> " + naverLoginURL);
		
		try { // 접근 토큰 발급 요청
			URL url = new URL(naverLoginURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;

			if (responseCode == 200) br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			else br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
			if (responseCode == 200) { // 성공적으로 토큰을 가져온다면
				
				// JSON In Java API
				JSONTokener tokener = new JSONTokener(response.toString());
				JSONObject accessObject = new JSONObject(tokener);
				access_token = accessObject.getString("access_token");
				System.out.println("access_token >> " + access_token);
				
				tokener = new JSONTokener(getUserInfo(access_token).toString());
				JSONObject userInfoObject = new JSONObject(tokener).getJSONObject("response");
				
				int id = userInfoObject.getInt("id");
				String name = userInfoObject.getString("name");
				String email = userInfoObject.getString("email");
				
				JWT_token = createJWTToken(id, name, email);
			}
		} catch (Exception e) {
			System.out.println("여기");
			e.printStackTrace();
		}
		return "redirect:http://localhost:8081?token=" + JWT_token;
	}

	/* 
	 * 네이버 프로필 가져오기 
	 * 요청 헤더 예) Authorization: Bearer + access_token
	*/
	private String getUserInfo(String access_token) {
		String header = "Bearer " + access_token; // Bearer 다음에 공백 추가(네이버 요구 형식)
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			
			if (responseCode == 200) br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			else br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
			return response.toString();
		} catch (Exception e) {
			System.err.println(e);
			return "Err";
		}
	}

	/* 네이버 프로필 데이터 암호화 */
	private String createJWTToken(int id, String name, String email) {
		String token = null;

		try {
			// 토큰 유효 기간
			Long EXPIRATION_TIME = 1000L * 60L * 10L;
			Date issuedAt = new Date();
			Date notBefore = new Date(issuedAt.getTime());
			Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);

			// 토큰 암호화
			Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
			token = JWT.create().withIssuer("auth0").withSubject(name).withAudience("ssafy").withClaim("id", id)
					.withClaim("email", email).withClaim("name", name).withNotBefore(notBefore).withExpiresAt(expiresAt).sign(algorithm);
		} catch (Exception e) {
			System.err.println("err: " + e);
		}
		return token;
	}
	
	/*
	 * 네이버 로그아웃
	 * 접근 토큰 삭제
	*/
	@PostMapping("/logout")
	public String logout() throws Exception {
		System.out.println("네이버 로그아웃 시도");
		
		// 접근 토큰 삭제 URL
		String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=";
		apiURL += clientId + "&client_secret=";
		apiURL += naverClientSecret + "&access_token=";
		apiURL += access_token + "&service_provider=NAVER";
		
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;

		if (responseCode == 200) { // 정상 호출
			System.out.println("Access Token Delete Success");
			access_token=null;
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		
		System.out.println(response.toString());
		
		return "redirect:http://localhost:8081";
	}
}
