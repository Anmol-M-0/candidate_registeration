package com.app.utils;

import com.app.dto.SignUpDTO;
import com.app.pojos.User;

public interface UserUtils {
	
	static User fetchUser(SignUpDTO dto) {
		System.out.println(dto);
		return new User(dto.getName(), dto.getEmail(), dto.getPassword(), dto.getPhoneNumber());
	}
}
