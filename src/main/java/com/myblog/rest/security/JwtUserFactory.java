package com.myblog.rest.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.myblog.rest.model.Authority;
import com.myblog.rest.model.User;
import com.myblog.rest.security.dto.JwtUser;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(user.getUsername(), user.getPassword(), mapToGrantedAuthorities(user.getAuthorities()),
				user.getEnabled());
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
				.collect(Collectors.toList());
	}
}
