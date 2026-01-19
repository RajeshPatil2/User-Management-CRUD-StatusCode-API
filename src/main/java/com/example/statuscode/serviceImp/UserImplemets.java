package com.example.statuscode.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.statuscode.model.User;
import com.example.statuscode.repository.UserRepository;
import com.example.statuscode.serviceI.UserInterface;

@Service
public class UserImplemets implements UserInterface {

	@Autowired
	UserRepository ur;

	@Override
	public void saveData(User user) {
		ur.save(user);
	}

	@Override
	public Iterable<User> getAllData() {
		return ur.findAll();
	}

	
	@Override
	public User getById(int uid) {
		Optional<User> byId = ur.findById(uid);
		if(byId.isPresent())
		{
			User user = byId.get();
			return user;
		}else {
			//raise custom exception
			
		return byId.get();
			//return byId.orElse(null);
		}
		
	}

	@Override
	public User updateUser(int uid, User updateDetails) {
		Optional<User> optionalUser = ur.findById(uid);

		if (!optionalUser.isPresent()) {
			return null;
		} else {
			updateDetails.setUid(uid); 
			ur.save(updateDetails);
			return updateDetails;
		}
	}

	@Override
	public boolean deleteId(int uid) {
		Optional<User> op = ur.findById(uid);
		if (!op.isPresent()) {
			return false;
		} else {
			ur.deleteById(uid);
			return true;
		}
	}
}
