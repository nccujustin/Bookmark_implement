package dao;

import Bookmark.DataStore;
import entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
