package entities;

import java.util.Arrays;

import com.sun.xml.internal.ws.util.StringUtils;

import constants.BookGenre;
import constants.MovieGenre;
import share.Shareable;

public class Book extends Bookmark implements Shareable {
	private long id;
	private String title;
	private int publicationYear;
	private String publisher;
	private String[] authors;
	private String genre;
	private double amazonRating;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publicationYear=" + publicationYear + ", publisher="
				+ publisher + ", authors=" + Arrays.toString(authors) + ", genre=" + genre + ", amazonRating="
				+ amazonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}		
		return true;
	
	}

	@Override
	public String getItemData() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
			builder.append("<type>Book</type>");
			builder.append("<title>").append(getTitle()).append("</title>");
			builder.append("<authors>").append(authors).append("</authors>");
			builder.append("<publisher>").append(publisher).append("</publisher>");
			builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
			builder.append("<genre>").append(genre).append("</genre>");
			builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");

		builder.append("</item>");
		return builder.toString();
		
	}
}
