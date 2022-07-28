package com.varxyz.jvx331.auth.service;

import com.varxyz.jvx331.auth.domain.AuthUser;

public interface AuthUserService {

	/**
	 * 전달된 email을 가진 등록 회원 조회
	 * 
	 * @param email
	 * @return
	 */
	AuthUser getAuthUser(String email);

	/**
	 * 등록된 고객인지 확인
	 */
	boolean isValidUser(String email, String passwd);

}
