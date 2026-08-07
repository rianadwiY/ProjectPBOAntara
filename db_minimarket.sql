-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 30 Jul 2026 pada 23.58
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_minimarket`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `kode_barang` varchar(20) DEFAULT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `harga` decimal(10,2) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `kode_barang`, `nama_barang`, `kategori`, `harga`, `stok`) VALUES
(1, 'BRG001', 'Indomie Goreng', 'Makanan', 3500.00, 192),
(16, 'BRG002', 'jus', 'mknn', 11111.00, 0),
(17, 'BRG003', 'fanta', 'minuman', 7000.00, 45),
(18, 'BRG004', 'Susu', 'Minuman', 19000.00, 31),
(25, 'MKN001', 'tempe', 'Makanan', 1000.00, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detail`, `id_transaksi`, `id_barang`, `jumlah`, `harga`, `subtotal`) VALUES
(1, 3, 1, 2, 3500.00, 7000.00),
(2, 4, 1, 1, 3500.00, 3500.00),
(3, 5, 1, 1, 3500.00, 3500.00),
(4, 6, 1, 1, 3500.00, 3500.00),
(5, 42, 17, 3, 7000.00, 21000.00),
(6, 43, 17, 2, 7000.00, 14000.00),
(7, 44, 18, 3, 19000.00, 57000.00),
(8, 45, 16, 1, 11111.00, 11111.00),
(9, 46, 25, 1, 1000.00, 1000.00),
(10, 47, 25, 4, 1000.00, 4000.00);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kasir`
--

CREATE TABLE `kasir` (
  `id_kasir` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kasir`
--

INSERT INTO `kasir` (`id_kasir`, `nama`, `username`, `password`) VALUES
(1, 'Administrator', 'admin', 'admin123'),
(2, 'ukasyah', 'Ukasyah', '1414'),
(3, 'riana', 'riana', '16116'),
(7, 'rifky', 'rifky', '999'),
(9, 'gerber', 'ber', '111');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `tanggal` datetime DEFAULT current_timestamp(),
  `id_kasir` int(11) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `bayar` decimal(10,2) NOT NULL,
  `kembalian` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal`, `id_kasir`, `total`, `bayar`, `kembalian`) VALUES
(1, '2026-07-29 20:49:59', 1, 3500.00, 10000.00, 6500.00),
(2, '2026-07-29 20:51:41', 1, 7000.00, 10000.00, 3000.00),
(3, '2026-07-29 21:12:17', 1, 7000.00, 10000.00, 3000.00),
(4, '2026-07-30 03:39:37', 1, 3500.00, 10000.00, 6500.00),
(5, '2026-07-30 15:26:50', 1, 3500.00, 10000.00, 6500.00),
(6, '2026-07-30 15:29:02', 1, 3500.00, 18900.00, 15400.00),
(7, '2026-07-30 19:55:21', 1, 14000.00, 20000.00, 6000.00),
(8, '2026-07-30 19:55:28', 1, 14000.00, 20000.00, 6000.00),
(9, '2026-07-30 19:55:32', 1, 14000.00, 20000.00, 6000.00),
(10, '2026-07-30 19:55:45', 1, 14000.00, 20000.00, 6000.00),
(11, '2026-07-30 19:55:57', 1, 14000.00, 20000.00, 6000.00),
(12, '2026-07-30 19:56:01', 1, 14000.00, 20000.00, 6000.00),
(13, '2026-07-30 19:56:02', 1, 14000.00, 20000.00, 6000.00),
(14, '2026-07-30 19:56:30', 1, 14000.00, 20000.00, 6000.00),
(15, '2026-07-30 19:57:29', 1, 14000.00, 20000.00, 6000.00),
(16, '2026-07-30 19:57:32', 1, 14000.00, 20000.00, 6000.00),
(17, '2026-07-30 19:57:33', 1, 14000.00, 20000.00, 6000.00),
(18, '2026-07-30 19:57:34', 1, 14000.00, 20000.00, 6000.00),
(19, '2026-07-30 19:57:35', 1, 14000.00, 20000.00, 6000.00),
(20, '2026-07-30 19:57:35', 1, 14000.00, 20000.00, 6000.00),
(21, '2026-07-30 19:58:04', 1, 14000.00, 20000.00, 6000.00),
(22, '2026-07-30 19:58:04', 1, 14000.00, 20000.00, 6000.00),
(23, '2026-07-30 19:58:44', 1, 14000.00, 20000.00, 6000.00),
(24, '2026-07-30 20:01:02', 1, 14000.00, 20000.00, 6000.00),
(25, '2026-07-30 20:05:54', 1, 11111.00, 30000.00, 18889.00),
(26, '2026-07-30 20:08:19', 1, 11111.00, 30000.00, 18889.00),
(27, '2026-07-30 20:10:37', 1, 14000.00, 20000.00, 6000.00),
(28, '2026-07-30 20:23:27', 1, 11111.00, 30000.00, 18889.00),
(29, '2026-07-30 20:23:31', 1, 11111.00, 30000.00, 18889.00),
(30, '2026-07-30 20:23:34', 1, 11111.00, 30000.00, 18889.00),
(31, '2026-07-30 20:23:36', 1, 11111.00, 30000.00, 18889.00),
(32, '2026-07-30 20:23:36', 1, 11111.00, 30000.00, 18889.00),
(33, '2026-07-30 20:23:37', 1, 11111.00, 30000.00, 18889.00),
(34, '2026-07-30 20:23:38', 1, 11111.00, 30000.00, 18889.00),
(35, '2026-07-30 20:23:38', 1, 11111.00, 30000.00, 18889.00),
(36, '2026-07-30 20:23:39', 1, 11111.00, 30000.00, 18889.00),
(37, '2026-07-30 20:23:39', 1, 11111.00, 30000.00, 18889.00),
(38, '2026-07-30 20:23:43', 1, 11111.00, 30000.00, 18889.00),
(39, '2026-07-30 20:25:00', 1, 21000.00, 30000.00, 9000.00),
(40, '2026-07-30 20:26:09', 1, 21000.00, 30000.00, 9000.00),
(41, '2026-07-30 20:28:42', 1, 21000.00, 30000.00, 9000.00),
(42, '2026-07-30 20:54:46', 1, 21000.00, 30000.00, 9000.00),
(43, '2026-07-30 20:56:37', 1, 14000.00, 20000.00, 6000.00),
(44, '2026-07-30 21:08:25', 1, 57000.00, 100000.00, 43000.00),
(45, '2026-07-30 21:09:23', 1, 11111.00, 30000.00, 18889.00),
(46, '2026-07-30 23:04:58', 1, 1000.00, 2000.00, 1000.00),
(47, '2026-07-30 23:07:34', 1, 4000.00, 10000.00, 6000.00);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `fk_detail_transaksi` (`id_transaksi`),
  ADD KEY `fk_detail_barang` (`id_barang`);

--
-- Indeks untuk tabel `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id_kasir`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_transaksi_kasir` (`id_kasir`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id_kasir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `fk_detail_barang` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `fk_detail_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_transaksi_kasir` FOREIGN KEY (`id_kasir`) REFERENCES `kasir` (`id_kasir`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
