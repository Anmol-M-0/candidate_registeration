package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.SignUpDTO;
import com.app.exceptions.UserException;
import com.app.pojos.User;
import static com.app.utils.UserUtils.*;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User validateLogin(String email, String password) {
		return userRepository.findOneByEmailAndPassword(email, password)
				.orElseThrow(() -> new UserException("invalid email or password"));
	}

	@Override
	public User addUser(SignUpDTO dto) {
		User user = null;
		try {
		user = userRepository.save(fetchUser(dto));
		}catch (IllegalArgumentException e) {
			System.out.println("error in adduser");
			throw new UserException("could not save user sign up info");
		}catch (Exception e) {
			System.out.println("error in adduser");
			throw new UserException("could not save user sign up info");
		}
		if(user == null) {
			throw new RuntimeException("an err occured");
		}
		return user;
	}
}
