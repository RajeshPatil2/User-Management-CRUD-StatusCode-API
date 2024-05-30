package com.example.statuscode.serviceI;

import com.example.statuscode.model.User;

public interface UserInterface {

	void saveData(User user);

	Iterable<User> getAllData();

	User getById(int uid);

	User updateUser(int uid, User updateDetails);

	boolean deleteId(int uid);
}
