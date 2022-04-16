-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 27 fév. 2019 à 17:23
-- Version du serveur :  10.1.36-MariaDB
-- Version de PHP :  7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_produit`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `date` varchar(23) NOT NULL,
  `id` int(50) NOT NULL,
  `nom_produit` varchar(50) NOT NULL,
  `libellé` varchar(50) NOT NULL,
  `quantité_p` int(100) NOT NULL,
  `prix_p` double NOT NULL,
  `valeur_p` double NOT NULL,
  `quantité_v` int(100) NOT NULL,
  `prix_v` double NOT NULL,
  `valeur_v` double NOT NULL,
  `stock_total` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`date`, `id`, `nom_produit`, `libellé`, `quantité_p`, `prix_p`, `valeur_p`, `quantité_v`, `prix_v`, `valeur_v`, `stock_total`) VALUES
('30/01/2019', 1, 'stylo', 'Achat', 1000, 10, 10000, 0, 0, 0, '1000'),
('10/02/2019', 2, 'stylo', 'Achat', 200, 10, 2000, 0, 0, 0, '1200'),
('27/02/2019', 3, 'stylo', 'Vente', 0, 0, 0, 300, 15, 4500, '900');

-- --------------------------------------------------------

--
-- Structure de la table `bl`
--

CREATE TABLE `bl` (
  `date` varchar(23) NOT NULL,
  `mat_fiscal` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `fax` varchar(50) NOT NULL,
  `adresse` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bl`
--

INSERT INTO `bl` (`date`, `mat_fiscal`, `nom`, `tel`, `fax`, `adresse`) VALUES
('19/01/2019', '3', 'mm', '85', '75896', 'rte '),
('19/01/2019', '5', 'mm', '85', '75896', 'rte ');

-- --------------------------------------------------------

--
-- Structure de la table `bs`
--

CREATE TABLE `bs` (
  `date` varchar(23) NOT NULL,
  `mat_camion` int(11) NOT NULL,
  `cin_employe` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `fax` varchar(50) NOT NULL,
  `adresse` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bs`
--

INSERT INTO `bs` (`date`, `mat_camion`, `cin_employe`, `nom`, `tel`, `fax`, `adresse`) VALUES
('19/01/2019', 5, '1111111', 'hhhhhhhhh', '24542593', '8555555699', 'rteretrere'),
('19/01/2019', 55, '1111111', 'hhhhhhhhh', 'aaaaaa', '8555555699', 'rteretrere'),
('19/01/2019', 57, '1111111', 'hhhhhhhhh', '24542593', '8555555699', 'rteretrere');

-- --------------------------------------------------------

--
-- Structure de la table `chéques_entrants`
--

CREATE TABLE `chéques_entrants` (
  `date` varchar(23) NOT NULL,
  `id` int(11) NOT NULL,
  `mat_fiscale` varchar(50) NOT NULL,
  `RIB` varchar(50) DEFAULT NULL,
  `cheque_daté` varchar(50) DEFAULT NULL,
  `date_échéance` varchar(50) DEFAULT NULL,
  `montant` varchar(50) DEFAULT NULL,
  `bank` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chéques_entrants`
--

INSERT INTO `chéques_entrants` (`date`, `id`, `mat_fiscale`, `RIB`, `cheque_daté`, `date_échéance`, `montant`, `bank`) VALUES
('19/01/2019', 1, '1', '8523669', '12 janv', '28 fev', '10000', 'biat'),
('19/01/2019', 2, '3', '123680000', '15 janv', '5 fev', '20', 'zaytouna'),
('27/02/2019', 32, '3', '8523669', '13 janv', '28 fev', '10000', 'biat');

-- --------------------------------------------------------

--
-- Structure de la table `chéques_sortants`
--

CREATE TABLE `chéques_sortants` (
  `date` varchar(23) NOT NULL,
  `id` int(11) NOT NULL,
  `mat_fiscale` varchar(50) NOT NULL,
  `RIB` varchar(50) DEFAULT NULL,
  `cheque_daté` varchar(50) DEFAULT NULL,
  `date_échéance` varchar(50) DEFAULT NULL,
  `montant` varchar(50) DEFAULT NULL,
  `bank` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chéques_sortants`
--

INSERT INTO `chéques_sortants` (`date`, `id`, `mat_fiscale`, `RIB`, `cheque_daté`, `date_échéance`, `montant`, `bank`) VALUES
('19/01/2019', 1, '2', '123456789', '8068', '12/82', '1000', 'biat'),
('27/01/2019', 2, '20', '555555', '8888', '1200', '800', 'zaytouna');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `date` varchar(23) NOT NULL,
  `mat_fiscal` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `fax` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `adresse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`date`, `mat_fiscal`, `nom`, `tel`, `fax`, `mail`, `adresse`) VALUES
('20/01/2019', 1, 'd', 'e', 'r', 't', 'z'),
('20/01/2019', 44, 'd', 'e', 'r', 't', 'z'),
('20/01/2019', 55, 'd', 'e', 'r', 't', 'z'),
('19/01/2019', 412, 'fff', '85236', '78965412', 'ffffff', 'rte');

-- --------------------------------------------------------

--
-- Structure de la table `echeance`
--

CREATE TABLE `echeance` (
  `date` varchar(23) NOT NULL,
  `num_facture` varchar(50) NOT NULL,
  `num_chéque` int(50) UNSIGNED NOT NULL,
  `fournisseur` varchar(50) NOT NULL,
  `echéance` varchar(50) NOT NULL,
  `montant` varchar(50) NOT NULL,
  `reglée` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `echeance`
--

INSERT INTO `echeance` (`date`, `num_facture`, `num_chéque`, `fournisseur`, `echéance`, `montant`, `reglée`) VALUES
('23/01/2019', '2', 1, 'ooredoo', '31/05/2019', '50000', 'Oui'),
('23/01/2019', '-1', 2, 'ooredoo', '31/01/2019', '10000', 'Non'),
('23/01/2019', '2', 4, 'ooredoo', '10/02/2019', '10000', 'Non'),
('23/01/2019', '2', 15, 'ooredoo', '31/01/2019', '50000', 'Oui'),
('23/01/2019', '-1', 25, 'ooredoo', '15/02/2019', '10000', 'Non'),
('23/01/2019', '-1', 125, 'ooredoo', '01/03/2019', '10000', 'Non'),
('23/01/2019', '2', 615, 'ooredoo', '11/02/2019', '50000', 'Non'),
('23/01/2019', '2', 61544, 'orange', '21/02/2019', '50000', 'Non');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `date` varchar(23) NOT NULL,
  `mat_fiscal` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `fax` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`date`, `mat_fiscal`, `nom`, `tel`, `fax`, `adresse`) VALUES
('19/01/2019', 2, 'rania', '50664210', '74693545', 'rte gabes'),
('19/01/2019', 3, 'rania', '50664210', '74693545', 'rte gabes');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `date` varchar(23) NOT NULL,
  `id_pr` int(11) NOT NULL,
  `libellé` varchar(50) NOT NULL,
  `prix` varchar(50) NOT NULL,
  `caractéristique` varchar(50) NOT NULL,
  `fournisseur` varchar(50) NOT NULL,
  `stock` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`date`, `id_pr`, `libellé`, `prix`, `caractéristique`, `fournisseur`, `stock`) VALUES
('19/01/2019', 3, 'zaczecczea', 'zacaczeczae', 'zeacbtr,btrpitrb', 'btrbtrbr', 'btrbtrtb'),
('19/01/2019', 14, 'dggg', '20', 'bleu', 'kais', '30'),
('19/01/2019', 15, 'dggg', '20', 'bleu', 'kais', '30'),
('19/01/2019', 18, 'dggg', '20', 'bleu', 'ali', '30');

-- --------------------------------------------------------

--
-- Structure de la table `soustraitance`
--

CREATE TABLE `soustraitance` (
  `date` varchar(23) NOT NULL,
  `id` int(11) NOT NULL,
  `libele` varchar(50) NOT NULL,
  `prixunité` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `soustraitance`
--

INSERT INTO `soustraitance` (`date`, `id`, `libele`, `prixunité`) VALUES
('30/01/2019', 32, '555', '10'),
('21/01/2019', 35, 'hhh', '10');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `id_user`, `username`, `password`, `type`) VALUES
(2, 25, 'hafil', 'ismail', 'directeur'),
(3, 23, 'youssef', 'mamouni_alaoui', 'Cashier'),
(4, 22, 'admin', 'admin', 'Cashier');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `id` int(11) NOT NULL,
  `num_facture` int(11) NOT NULL,
  `code_produit` int(11) NOT NULL,
  `reference` varchar(55) NOT NULL,
  `prix_vente` int(11) NOT NULL,
  `stock_sortie` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id`, `num_facture`, `code_produit`, `reference`, `prix_vente`, `stock_sortie`, `subtotal`) VALUES
(3, 1, 568, 'REF2', 651, 1, 1080),
(4, 1, 568, 'REF2', 651, 2, 1302),
(5, 1, 568, 'REF2', 651, 2, 1302),
(6, 1, 5685, 'REF256', 651, 3, 1953),
(7, 2, 568, 'REF2', 651, 6, 3906),
(8, 2, 568, 'REF2', 651, 12, 7812),
(9, 1, 5685, 'REF256', 651, 10, 6510),
(10, 2, 2, 'REF2', 651, 100, 65100),
(11, 2, 2, 'REF2', 651, 100, 65100);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `bl`
--
ALTER TABLE `bl`
  ADD PRIMARY KEY (`mat_fiscal`);

--
-- Index pour la table `bs`
--
ALTER TABLE `bs`
  ADD PRIMARY KEY (`mat_camion`);

--
-- Index pour la table `chéques_entrants`
--
ALTER TABLE `chéques_entrants`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `chéques_sortants`
--
ALTER TABLE `chéques_sortants`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`mat_fiscal`);

--
-- Index pour la table `echeance`
--
ALTER TABLE `echeance`
  ADD PRIMARY KEY (`num_chéque`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`mat_fiscal`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_pr`);

--
-- Index pour la table `soustraitance`
--
ALTER TABLE `soustraitance`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `chéques_entrants`
--
ALTER TABLE `chéques_entrants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT pour la table `chéques_sortants`
--
ALTER TABLE `chéques_sortants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `soustraitance`
--
ALTER TABLE `soustraitance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
