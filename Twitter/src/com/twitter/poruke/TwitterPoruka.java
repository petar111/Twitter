package com.twitter.poruke;
/**
 * Klasa TwitterPoruka koja generise poruku i pokazuje
 * koji korisnik je generisao tu poruku.
 * @author Petar Jeremic
 *
 */
public class TwitterPoruka {
	
	/**
	 * Ime korisnika koji generise poruku.
	 */
	private String korisnik;
	/**
	 * Poruka koju je korisnik generisao.
	 */
	private String poruka;
	
	/**
	 * Vraca ime korisnika kao String
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Daje ime korisniku.
	 * @param korisnik ime korisnika
	 * @throws RuntimeException za vrednosti:
	 * <ul>
	 * <li>NULL</li>
	 * <li>Prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Vraca poruku koja se salje.
	 * @return poruka koja se salje
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Generise poruku koja se salje.
	 * @param poruka poruka koja se salje
	 * @throws RuntimeException za vrednosti:
	 * <ul>
	 * <li>NULL</li>
	 * <li>Prazan String</li>
	 * <li>String koji sadrzi vise od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.equals("") || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Vraca informacije o objektu odredjenom formatu.
	 * @return KORISNIK: ###  PORUKA: ###
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}