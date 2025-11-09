# Aplikasi GUI Multithread dengan JDBC
Tugas Pemrograman Berorientasi Objek (PBO)
Implementasi Thread dan Database (JDBC) dengan GUI menggunakan Java

## 👤 Identitas

| Nama | Andra Aufarisque Djayadi |
| --- | --- |
| NIM | F1D02310036 |

## Deskripsi
Program ini merupakan simulasi sederhana pengelolaan data pengguna (user) menggunakan Java GUI (Swing) dengan dukungan:
* **Thread** - Setiap proses insert dan load data dijalankan di thread terpisah.
* **JDBC** - koneksi langsung ke database MySQL menggunakan JDBC Driver.
* **GUI** - form input nama dan email serta tombol untuk menampilkan data dari database.

# Persiapan Database

## 1. Jalankan XAMPP

Pastikan MySQL sudah aktif dari kontrol panel XAMPP.

## 2. Buat database dan Tabel

Masuk ke phpMyAdmin atau gunakan terminal MySQL, lalu jalankan perintah berikut:
```sql
CREATE DATABASE thread_db;
USE thread_db;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100)
);
```