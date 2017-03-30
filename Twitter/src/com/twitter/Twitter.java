package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa Twitter je klasa koja sadrzi poruke koje su generisali korisnici.
 * @author Petar Jeremic
 *
 */
public class Twitter {
	/**
	 * Poruke koje su generisali korisnici.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Ova metoda vraca sve poruke koje se nalaze u objektu.
	 * @return sve poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	/**
	 * Pravi objekat klase TwitterPoruka i dodaje ga u listu poruka(na kraj).
	 * @param korisnik ime korisnika koji generise poruku
	 * @param poruka poruka koja je generisana
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Vraca odredjeni broj poruka koje sadrze neki tag.
	 * @param maxBroj maksimalan broj poruka koje funkcija vraca
	 * @param tag vrednost koju vracena poruka sadrzi
	 * @return odredjen broj poruka koje sadrze uneti tag
	 * @throws RuntimeException za vrednosti taga:
	 * <ul>
	 * <li>NULL</li>
	 * <li>Prazan String</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
