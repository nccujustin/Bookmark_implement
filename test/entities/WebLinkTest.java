package entities;

import static org.junit.Assert.*;

import org.junit.Test;

import manager.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test 1
		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For porn in url - isKidFriendlyEligible() return false", isKidFriendlyEligible);
		
		// Test 2
		
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For porn in title - isKidFriendlyEligible() return false", isKidFriendlyEligible);
		
		// Test 3
		
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For adult in host - isKidFriendlyEligible() return false", isKidFriendlyEligible);

		
		// Test 4
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in url but not host part- isKidFriendlyEligible() return true", isKidFriendlyEligible);

		
		// Test 5
		
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in title - isKidFriendlyEligible() return true", isKidFriendlyEligible);

	}

}
