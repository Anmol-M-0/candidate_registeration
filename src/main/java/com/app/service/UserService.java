package com.app.service;

import com.app.dto.SignUpDTO;
import com.app.pojos.User;

public interface UserService {
	User validateLogin(String email, String password);
	User addUser(SignUpDTO dto);
}
