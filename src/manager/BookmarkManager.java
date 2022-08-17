package manager;

import dao.BookmarkDao;
import entities.Book;
import entities.Bookmark;
import entities.Movie;
import entities.User;
import entities.UserBookmark;
import entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();

	private BookmarkManager() {}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre,
			double amazonRating) {

		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;

	}

	public Movie createMovie(long id, String profileUrl, int releaseYear, String[] casts, String[] directors,
			String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(casts);
		movie.setDirector(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;

	}

	public WebLink createWebLink(long id, String title, String url, String host) {

		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;

	}

	public Bookmark[][] getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		
		System.out.println("Kid friendly status: "+ kidFriendlyStatus+ ", Marked by: "+ user.getEmail() + ", "+ bookmark);
	}

	public static void share(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmark.setSharedBy(user);
		
		System.out.println("Data to be shared");
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		} else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());
		}
	}

}
