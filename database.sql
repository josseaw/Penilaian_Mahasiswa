-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Bulan Mei 2020 pada 15.03
-- Versi server: 10.3.15-MariaDB
-- Versi PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas_sd`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('dosen', 'dosen'),
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penilaian_mahasiswa`
--

CREATE TABLE `penilaian_mahasiswa` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nim` varchar(50) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `istima` varchar(50) NOT NULL,
  `kalam` varchar(50) NOT NULL,
  `kitabah` varchar(50) NOT NULL,
  `qiroah` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penilaian_mahasiswa`
--

INSERT INTO `penilaian_mahasiswa` (`id`, `nama`, `nim`, `kelas`, `istima`, `kalam`, `kitabah`, `qiroah`) VALUES
(2, 'Muhammad Idris Latif', '19650112', 'ST 1', '80', '60', '90', '100'),
(4, 'Josse Andriyanto W', '19650117', 'ST 3', '90', '90', '90', '90'),
(5, 'M. Halvi Rahman', '19650128', 'ST 3', '80', '85', '80', '90');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `penilaian_mahasiswa`
--
ALTER TABLE `penilaian_mahasiswa`
  ADD PRIMARY KEY (`id`,`nim`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `penilaian_mahasiswa`
--
ALTER TABLE `penilaian_mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
