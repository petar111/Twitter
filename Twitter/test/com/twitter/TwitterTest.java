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
		if(expected.get(0).getKorisnik().equals(tt.vratiSvePoruke().get(0).getKorisnik()) && expected.get(0).getPoruka().equals(tt.vratiSvePoruke().get(0).getPoruka())){
			expected = tt.vratiSvePoruke();
		}
		assertEquals(expected, tt.vratiSvePoruke());
	}
	
	@Test
	public void testVratiSvePoruke(){
		TwitterPoruka tp[] = new TwitterPoruka[4];
		for(int i = 0; i < tp.length ; i++){
			tp[i] = new TwitterPoruka();
			tp[i].setKorisnik("A");
			tp[i].setPoruka("B");
		}
		tt.unesi("A", "B");
		tt.unesi("A", "B");
		tt.unesi("A", "B");
		tt.unesi("A", "B");
		LinkedList<TwitterPoruka> provera = tt.vratiSvePoruke();
		for(int i = 0; i < provera.size(); i++){
			if(provera.get(i).getKorisnik().equals(tp[i].getKorisnik()) && provera.get(i).getPoruka().equals(tp[i].getPoruka())){}else{
				fail();
			}
		}
	}

	@Test
	public void testVratiPoruke() {
		TwitterPoruka expected[] = new TwitterPoruka[2];
		tt.unesi("Miki", "Mala moja.");
		expected[0] = new TwitterPoruka();
		expected[0].setKorisnik("Miki");
		expected[0].setKorisnik("Mala moja.");
		tt.unesi("Kosta", "Dome moj.");
		expected[1] = new TwitterPoruka();
		expected[1].setKorisnik("Kosta");
		expected[1].setKorisnik("Dome moj.");
		tt.unesi("Masa", "Lela Vranjanka");
		TwitterPoruka provera[] = tt.vratiPoruke(10, "moj");
		for(int i = 0; i< provera.length && provera[i] != null ; i++){
			if(!(provera[i].getKorisnik().equals(expected[i].getKorisnik()) && provera[i].getPoruka().equals(expected[i].getPoruka())))
					fail();
		}
		
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
