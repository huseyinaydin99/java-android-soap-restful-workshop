<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<title>ÜYE SAYFASI</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<div class="container">
			<h2>RESTful Giriş Formu</h2>
			<form action="rest/uye/giris" method="post">
				<div class="form-group">
					<label for="kullaniciAdi">KULLANICI ADI:</label>
					<input type="text" class="form-control" id="kullaniciAdi" name="kullaniciAdi" placeholder="Kullanıcı adı giriniz.">
				</div>
				<div class="form-group">
					<label for="parolasi">PAROLASI:</label>
					<input type="password" class="form-control" id="parolasi" name="parolasi" placeholder="Parolanızı giriniz.">
				</div>
				<button type="submit" class="btn btn-default">Giriş</button>
			</form>
		</div>
		
		<hr />
		
		<div class="container">
			<h2>RESTful Kayıt Formu</h2>
			<form action="rest/uye/ekle" method="post">
				<div class="form-group">
					<label for="kullaniciAdi">KULLANICI ADI:</label>
					<input type="text" class="form-control" id="kullaniciAdi" name="kullaniciAdi" placeholder="Kullanıcı adı giriniz.">
				</div>
				<div class="form-group">
					<label for="parolasi">PAROLASI:</label>
					<input type="password" class="form-control" id="parolasi" name="parolasi" placeholder="Parolanızı giriniz.">
				</div>
				<button type="submit" class="btn btn-default">Giriş</button>
			</form>
		</div>
	</body>

</html>
