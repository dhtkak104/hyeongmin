package com.mvc2.define;

public class ResultCode {

	public static final int SUCCESS = 200;				// 조회(GET) 결과 정상
	public static final int CREATED = 201;				// 새로운 Resource가 생성 (POST)
	public static final int ACCEPTED = 202;				// 요청 정상수신 코드이며, 비동기 작업 요청에 대한 상태코드로 적절
	public static final int NO_CONTENT = 204;			// Resource 수정/삭제 정상처리 (Response Body가 없는 상태코드)			
	public static final int BAD_REQUEST = 400;			// Request Parameter 불충분/부적합
	public static final int UNAUTHORIZED = 401;			// 인증되지 않은 비로그인 상태 (사용자가 누군지 모르는 상태)
	public static final int FORBIDDEN = 403;			// 로그인은 했지만 권한이 없는 상태
	public static final int NOT_FOUND = 404;			// Resource가 존재하지 않음	
	public static final int CONFLICT = 409;				// Request Parameter가 적합하지만 내부정책과 충돌하여 처리 불가능
	public static final int PAYLOAD_TOO_LARGE = 413;	// Request Parameter 수량/용량이 기준치 초과
	public static final int INTERNAL_SERVER_ERROR = 500;// 서버 오류
	
}
