package dao;

import Bookmark.DataStore;
import entities.Bookmark;
import entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		// TODO Auto-generated method stub
		DataStore.add(userBookmark);
	}

}
