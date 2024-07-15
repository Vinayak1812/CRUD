package com.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	  @Autowired
	    private UserRepository userRepository;

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public User getUserById(Long id) {
	        return userRepository.findById(id).orElse(null);
	    }

	    public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    public User updateUser(Long id, User userDetails) {
	        User user = userRepository.findById(id).orElse(null);
	        if (user != null) {
	            user.setName(userDetails.getName());
	            user.setEmail(userDetails.getEmail());
	            user.setMobileNo(userDetails.getMobileNo());
	            return userRepository.save(user);
	        }
	        return null;
	    }

	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
}
