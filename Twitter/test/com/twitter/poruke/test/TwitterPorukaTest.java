package com.twitter.poruke.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {
	TwitterPoruka t;
	
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Kica");
		assertEquals("Kica", t.getKorisnik());
	}
	
	@Test(expected=java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		t.setKorisnik(null);
	}
	
	@Test(expected=java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString (){
		t.setKorisnik("");
	}
	 
	@Test
	public void testSetPoruka() {
		t.setPoruka("Hello world.");
		assertEquals("Hello world.", t.getPoruka());
	}
	
	@Test(expected=java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		t.setPoruka(null);
	}
	
	@Test(expected=java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString (){
		t.setPoruka("");
	}
	
	@Test(expected=java.lang.RuntimeException.class)
	public void testSetPorukaViseOd140() {
		t.setPoruka("Step now in front of the door and come in"
				+ ", you have now just entered in the sorceror's den,"
				+ " this is a volontary thing nobody is forcing you in,"
				+ " but if you leave you may never see your porches again."
				+ " He startet laugh saying this must be a joke,"
				+ " line up with the others cus my wrath is easily provoked,"
				+ " i said no this is not a joke,"
				+ "well, if this is ture, can you demonstrate us things that you can do?"
				+ "well, i noticed how you metamorphosize,"
				+ "i mastered the ability to morph when i was 5...");
	}

	@Test
	public void testToString() {
		t.setKorisnik("JA");
		t.setPoruka("HAHA");
		String provera = t.toString();
		assertEquals("KORISNIK:" + t.getKorisnik() + " PORUKA:" + t.getPoruka(), provera);
	}

}
