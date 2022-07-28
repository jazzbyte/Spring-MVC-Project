package com.varxyz.jvx331.auth.domain;

import org.springframework.context.annotation.Scope;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Scope("session")
public class AuthUser {
	private long uid;
	private String email;
	private String name;
	private String ssn;
	private String phone;
}
