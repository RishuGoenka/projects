package com.zycus.dao;

import java.util.List;

import com.zycus.model.UserEntity;

public interface UserEntityDAO {

	public abstract void save(UserEntity userObject);

	public abstract UserEntity getUserByID(int id);

	public abstract List<UserEntity> getAllUsers();

	public abstract void update(UserEntity userObject);

	public abstract UserEntity getUserByEmail(String emailString);

	public abstract boolean isEmailAvailable(String email);

}