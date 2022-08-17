package entities;

import static org.junit.Assert.*;

import org.junit.Test;

import constants.MovieGenre;
import manager.BookmarkManager;

public class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test 1
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse("For Horror genre - isKidFriendlyEligible() return false", isKidFriendlyEligible);

		// Test 2
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse("For Thrillers genre - isKidFriendlyEligible() return false", isKidFriendlyEligible);
	}

}
