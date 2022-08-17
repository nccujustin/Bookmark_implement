package Bookmark;

import entities.Bookmark;
import entities.User;
import manager.BookmarkManager;
import manager.UserManager;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		// TODO Auto-generated method stub
		System.out.println("1. loading data...");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		/*
		 * printUserData(); printBookmarkData();
		 */
	}

	private static void printUserData() {
		// TODO Auto-generated method stub
		for (User user : users) {
			System.out.println(user);
		}

	}

	private static void printBookmarkData() {
		// TODO Auto-generated method stub
		for (Bookmark[] bookmarklist : bookmarks) {
			for (Bookmark bookmark : bookmarklist) {
				System.out.println(bookmark);
			}
		}
	}

	private static void start() {
		// TODO Auto-generated method stub
		// System.out.println("\n2. Bookmarking...");
		for (User user : users) {
			View.browse(user, bookmarks);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		loadData();
		start();

	}

}
