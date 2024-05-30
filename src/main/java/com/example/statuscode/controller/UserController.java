package com.example.statuscode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.statuscode.model.User;
import com.example.statuscode.serviceI.UserInterface;

@RestController
public class UserController {

	@Autowired
	UserInterface ui;

	@PostMapping("/postData")
	public ResponseEntity<String> postData(@RequestBody User user) {
		
		ui.saveData(user);
		return new ResponseEntity<>("Post the data", HttpStatus.ACCEPTED);
	}

	@GetMapping("/getData")
	public ResponseEntity<List<User>> getAllData() {
		List<User> list = (List<User>) ui.getAllData();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/getData/{uid}")
	public ResponseEntity<User> getSingleRecordById(@PathVariable int uid) {
		User byId = ui.getById(uid);
		if (byId == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(byId, HttpStatus.OK);
		}
	}

	@PutMapping("/postData/{uid}")
	public ResponseEntity<User> updateUserByID(@PathVariable int uid, @RequestBody User updateDetails) {
		User updatedUser = ui.updateUser(uid, updateDetails);
		if (updatedUser == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		}
	}

	@DeleteMapping("/postData/{uid}")
	public ResponseEntity<String> deleteUserById(@PathVariable int uid) {
		boolean isDeleted = ui.deleteId(uid);
		if (!isDeleted) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
		}
	}
}
