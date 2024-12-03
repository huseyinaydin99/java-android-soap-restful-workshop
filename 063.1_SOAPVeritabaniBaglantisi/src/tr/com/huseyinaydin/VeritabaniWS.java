package tr.com.huseyinaydin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android, WebServis, SOAP.
 *
 */

public class VeritabaniWS {

	Connection con = null;

	public void veritabaninaBaglantiKur() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/huseyin_aydin_db", "root", "toor");

			if (!con.isClosed()) {
				System.out.println("Baglandik");

			} else {
				System.out.println("Baglanamadik");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String personelVerileriniGetir() {
		veritabaninaBaglantiKur();
		String sonuc = "";

		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM PERSONEL");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				sonuc = sonuc + "& " + resultSet.getInt("id") + "-" + resultSet.getString("adi") + " "
						+ resultSet.getString("soyadi") + " " + resultSet.getString("email");

				System.out.println(sonuc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sonuc;
	}

	public String uyeGirisKontroluYap(String uyeKullaniciAdiParametre, String uyeParolaParametre) {
		veritabaninaBaglantiKur();
		String sonuc = "";
		System.out.println("uyeGirisKontroluYap metodu çalıştı.");
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM PERSONEL WHERE username='"
					+ uyeKullaniciAdiParametre + "' and password='" + uyeParolaParametre + "'");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				sonuc = sonuc + "& " + resultSet.getInt("id") + "-" + resultSet.getString("adi") + " "
						+ resultSet.getString("soyadi") + " " + resultSet.getString("email");

				System.out.println(sonuc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sonuc;
	}
	
	public String uyeKayitEkle(String uyeKullaniciAdiParametre, String uyeParolaParametre) {
		veritabaninaBaglantiKur();
		String sonuc = "";
		System.out.println("uyeGirisKontroluYap metodu çalıştı.");
		int kayitsayisi = 0;
		try {
			PreparedStatement statement = con.prepareStatement("INSERT INTO PERSONEL(username, password) values('"+uyeKullaniciAdiParametre+"', '"+uyeParolaParametre+"')");
			kayitsayisi = statement.executeUpdate();
			System.out.println(kayitsayisi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sonuc = kayitsayisi+"";
		return sonuc;
	}

	public static void main(String[] args) {
		VeritabaniWS veritabaniWS = new VeritabaniWS();
		veritabaniWS.personelVerileriniGetir();
	}
}