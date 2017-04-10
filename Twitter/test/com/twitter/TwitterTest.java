package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	private Twitter tt;
	@Before
	public void setUp() throws Exception {
		tt = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tt = null;
	}

	@Test
	public void testVratiSvePorukePrazna() {
		LinkedList<TwitterPoruka> expected = new LinkedList<TwitterPoruka>();
		LinkedList<TwitterPoruka> provera = tt.vratiSvePoruke();
		assertEquals(expected, provera);
	}

	@Test
	public void testUnesi() {
		tt.unesi("Miki", "KKK");
		LinkedList<TwitterPoruka> expected = new LinkedList<TwitterPoruka>();
		TwitterPoruka tp = new  TwitterPoruka();
		tp.setKorisnik("Miki");
		tp.setPoruka("KKK");
		expected.addLast(tp);
		assertEquals(expected, tt.vratiSvePoruke());
	}
	
	@Test
	public void testVratiSvePoruke(){
		LinkedList<TwitterPoruka> expected = new LinkedList<TwitterPoruka>();
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Lala");
		tp1.setPoruka("Lala joined.");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Mika");
		tp2.setPoruka("Mika joined.");
		TwitterPoruka tp3 = new TwitterPoruka();
		tp3.setKorisnik("Laza");
		tp3.setPoruka("Laza joined.");
		TwitterPoruka tp4 = new TwitterPoruka();
		tp4.setKorisnik("Misa");
		tp4.setPoruka("Misa joined.");
		expected.addLast(tp1);
		expected.addLast(tp2);
		expected.addLast(tp3);
		expected.addLast(tp4);
		
		tt.unesi("Lala", "Lala joined.");
		tt.unesi("Mika", "Mika joined.");
		tt.unesi("Laza", "Laza joined.");
		tt.unesi("Misa", "Misa joined.");
		LinkedList<TwitterPoruka> provera = tt.vratiSvePoruke();
		assertEquals(expected, provera);
	}

	@Test
	public void testVratiPoruke() {
		TwitterPoruka[] expected = new TwitterPoruka[10];
		TwitterPoruka tp1 =  new TwitterPoruka();
		tp1.setKorisnik("Miki");
		tp1.setPoruka("Mala moja.");
		TwitterPoruka tp2 =  new TwitterPoruka();
		tp2.setKorisnik("Kosta");
		tp2.setPoruka("Dome moj.");
		expected[0] = tp1;
		expected[1] = tp2;
		
		tt.unesi("Miki", "Mala moja.");
		tt.unesi("Kosta", "Dome moj.");
		tt.unesi("Masa", "Lela Vranjanka");
		TwitterPoruka provera[] = tt.vratiPoruke(10, "moj");
		assertArrayEquals(expected, provera);
		
		
	}
	@Test(expected=java.lang.RuntimeException.class)
	public void testVratiPorukeNullTag(){
		tt.vratiPoruke(20, null);
	}
	@Test(expected=java.lang.RuntimeException.class)
	public void testVratiPorukePrazanTag(){
		tt.vratiPoruke(20, "");
	}

}
