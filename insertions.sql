START TRANSACTION;
USE carrent;

INSERT INTO Employee(`IRS Number`, `Social Security Number`, `Driver License`, `First Name`, `Last Name`, `Street`, `Street Number`, `Postal Code`, `City`)
VALUES
(992047, 234136, 'ADG2143', 'GEORGE', 'GEORGAKIS', 'LEMONION', 133, 12352, 'VRILISIA'),
(123857, 129347, 'ORL1295', 'XENOFON', 'XENIOS', 'PARALIAS', 12, 98421, 'PERISTERI'),
(129017, 387201, 'LSL2211', 'VASILIS', 'FOTIS', 'PAPADIAMANTI', 23, 92103, 'VIRONAS'),
(231042, 326483, 'ORW4829', 'IAKOVOS', 'PAPADOPOULOS', 'LEONTOU', 99, 34029, 'AGIOS NIKOLAOS'),
(958302, 947820, 'QLE0392', 'LORDOS', 'VIRONAS', 'KOLOKOTRONI', 29, 84720, 'PAGKRATI'),
(940281, 958372, 'EOW1048', 'MITSOS', 'NIKOLAKIS', 'SAPOUNI', 99, 92384, 'MELISIA'),
(845281, 756538, 'IFM3918', 'NIKOS', 'KAZANTZAKIS', 'PERIANDROU', 21, 12385, 'KIPSELI'),
(756922, 937201, 'LSI1827', 'ABU', 'LA BI', 'ALAUKE', 1957, 99932, 'DUBAI'),
(103672, 919443, 'LSA1295', 'BILL', 'GATES', 'ASTONV', 1, 10284, 'NEW YORK'),
(917479, 337199, 'EYW9201', 'PANOS', 'GALLIS', 'DRAKOU', 20, 43108, 'ATHINA'),
(291659, 299170, 'QWO1948', 'XENOS', 'MARVELOS', 'IOUDA', 10, 58201, 'EKALI'),
(578420, 013874, 'MCX2198', 'PARIS', 'AXILLEIOS', 'AGIAS ELENIS', 20, 20104, 'OLUMPOS'),
(192837, 309101, 'XLK1309', 'PUROS', 'DIMAS', 'DIMOULI', 120, 12085, 'THESSALONIKI'),
(298741, 049421, 'ACC2019', 'NIKOS', 'OIKONOMAKIS', 'AXIOS', 92, 23915, 'SPARTI'),
(203942, 091345, 'XXZ1293', 'MITSOS', 'TAKIS', 'AGAMEMNONOS', 12 , 95838, 'PATRA'),
(950102, 857329, 'NCX3918', 'PALAIOS', 'MAXITIS', 'PATRON', 16, 102958, 'AXINOS'),
(123412, 234131, 'ADG2333', 'HARRY', 'PALAIOS', 'KOPIC', 133, 12352, 'VRILISIA'),
(653221, 123612, 'ORL4595', 'SNAPE', 'NIKOS', 'KSEROS', 12, 98421, 'MELISIA'),
(543652, 100000, 'LSL5211', 'BATMAN', 'GALLIS', 'KEROS', 23, 92103, 'MELISIA'),
(742123, 200000, 'ORW4629', 'SUPERMAN', 'BI', 'LOLEN', 99, 34029, 'AGIOS NIKOLAOS'),
(656411, 300000, 'QLE0492', 'BATEMAN', 'AXILLEIOS', 'LORSTRE', 29, 84720, 'THESSALONIKI'),
(234541, 400000, 'EOW1148', 'BALE', 'DIMAS', 'STEROS', 99, 92384, 'MELISIA'),
(431345, 500000, 'IFM3418', 'CHRISTIAN', 'NIKOLAKIS', 'POPOTAS', 21, 12385, 'NEW YORK'),
(123471, 600000, 'LSI1627', 'LORDAKA', 'LA BI', '28S', 1957, 99932, 'DUBAI'),
(123402, 700000, 'LSA1195', 'CHUBAKA', 'GATES', 'OXIS', 1, 10284, 'KIPSELI'),
(135135, 800000, 'EYW9601', 'LILPUMP', 'GALLIS', 'PREPEI', 20, 43108, 'VIRONAS'),
(653215, 110000, 'QWO1648', 'LILPEEP', 'VIRONAS', 'STREVLOU', 10, 58201, 'EKALI'),
(517211, 220000, 'MCX2298', 'KENDRICK', 'OIKONOMAKIS', 'PURANXAS', 20, 20104, 'OLUMPOS'),
(134711, 330000, 'XLK1609', 'LAMARAS', 'MARVELOS', 'AGIAS ELENIS', 120, 12085, 'PAGKRATI'),
(145642, 400004, 'ACC2219', 'PARALAS', 'AXILLEIOS', 'AXIOS', 92, 23915, 'SPARTI'),
(133461, 550000, 'XXZ1693', 'TELIOS', 'MAXITIS', 'PATRON', 12 , 95838, 'PATRA'),
(321354, 660000, 'NCX3118', 'TELOOOS', 'TAKIS', 'AGAMEMNONOS', 16, 102958, 'AXINOS');

INSERT INTO Customer(`IRS Number`, `Social Security Number`, `Last Name`, `First Name`, `Driver License`, `First Registration`, `City`, `Postal Code`, `Street`, `Street Number`)
VALUES
(239401, 034920, 'Nikolas', 'Nikos', 'SKL1093', '2008-01-19 03:14:07', 'PITHON', 12958, 'PARMOS', 10),
(120957, 109274, 'Mitsakos', 'Mitsos', 'XM31093', '2011-04-29 03:13:07', 'VEROIA', 10942, 'PRAGAS',  15),
(239402, 019485, 'Mitsaras', 'Mitsos', 'OEN2910', '2013-05-10 14:22:22', 'ATHINA', 15772, 'AGIWN' , 35),
(293001, 939210, 'Takopoulos', 'Takis', 'XCM1002', '2001-02-02 11:22:55', 'THIVA', 29190, 'PILIOU', 7),
(102049, 942819, 'Kwnstantinou', 'Kwstas', 'XCM1020', '2002-02-05 22:46:55', 'PEIRAIAS', 94920, 'POS' ,11),
(194729, 918472, 'Giannaros', 'Giannis', 'EWI2919', '2039-12-05 04:11:25', 'KARDITSA', 23019 , 'KIRTOS', 30),
(950281, 958920, 'Maraki-Mario', 'Maria', 'LKS3929', '2006-12-05 04:11:25', 'LARISA', 848291, 'KAVOS',21),
(451280, 102891, 'Xaroula',  'Xara', 'LSD2031', '2001-12-05 15:11:25', 'TRIKALA', 203910, 'MENIOS', 12 ),
(120052, 483820, 'Sia',  'Anastasia', 'COC9391,', '2011-12-05 12:11:25', 'KALAMPAKA', 20935, 'PARADOXOS', 9),
(484939, 848180, 'Maraki-Mario', 'Maria', 'TRP1918', '2032-05-05 17:11:54', 'MORDOR', 09492, 'PERIERGON', 99),
(389294, 490301, 'Maraki-Mario', 'Maria', 'MRJ9238', '2005-06-05 13:11:25', 'GIANENNA', 12942, 'AEROLIMENA', 19),
(192040, 029330, 'Xaroula', 'Xara', 'MDM4920', '2001-05-05 14:11:25', 'GRIFFINDOR', 10518, 'PUROMAXIKON', 94),
(120094, 182381, 'Sia', 'Anastasia', 'DMT9138', '2002-04-05 23:11:25', 'SLITHERIN', 10945, 'PORWN', 19),
(103951, 203920, 'Maraki-Mario', 'Maria', 'KSH4901', '2003-08-05 12:11:25', 'HUFFLEPUFF', 99321, 'KALIOSAS', 12),
(593920, 293919, 'Xaroula', 'Xara', 'WED2391', '2004-09-05 17:11:25', 'PAFPOUF', 958281, 'WINGARDIUM', 15),
(234786, 021920, 'NIKOLAKIS', 'Nikos', 'SKL1493', '2016-01-19 03:15:07', 'PITHON', 23141, 'PARMOS', 18),
(876521, 143274, 'MITSARAS', 'Mitsos', 'XM31493', '2015-04-29 03:11:07', 'VEROIA', 12331, 'PRAGAS',  25),
(134785, 023185, 'ALAX', 'Mitsos', 'OEN2914', '2014-05-10 14:26:22', 'ATHINA', 234123, 'AGIWN' , 34),
(234842, 934530, 'MPANTOS', 'Takis', 'XCM1502', '2013-02-02 11:32:55', 'THIVA', 654321, 'PILIOU', 12),
(123472, 123443, 'DUYROS', 'Kwstas', 'XCM1520', '2012-02-05 22:36:55', 'PEIRAIAS', 12345, 'POS' ,113),
(123486, 876542, 'DAMON', 'Giannis', 'EWI2519', '2011-12-05 04:21:25', 'KARDITSA', 24564 , 'KIRTOS', 130),
(123875, 762356, 'MATT', 'Maria', 'LKS3925', '2008-12-05 04:14:25', 'LARISA', 87654, 'KAVOS',212),
(124876, 245987, 'SATIN',  'Xara', 'LSD2051', '2009-12-05 15:21:25', 'TRIKALA', 23416, 'MENIOS', 112 ),
(742457, 123631, 'SERION',  'Anastasia', 'VOC9391,', '2010-12-05 22:11:25', 'KALAMPAKA', 13134, 'PARADOXOS', 19),
(234632, 123478, 'MARIONEE', 'Maria', 'TRP4918', '2052-05-05 17:11:54', 'MORDOR', 12346, 'PERIERGON', 996),
(346764, 12632, 'MELANIE', 'Maria', 'MRJ9258', '2075-06-05 13:16:25', 'GIANENNA', 123461, 'AEROLIMENA', 149),
(346887, 66532, 'FIONA', 'Xara', 'MDM4921', '2051-05-05 14:15:25', 'GRIFFINDOR', 765316, 'PUROMAXIKON', 924),
(138876, 34365, 'PEGKU', 'Anastasia', 'DMT2138', '2012-04-05 23:12:25', 'SLITHERIN', 123472, 'PORWN', 191),
(765432, 234521, 'JOANA', 'Maria', 'KSH4941', '2033-08-05 12:13:25', 'HUFFLEPUFF', 123456, 'KALIOSAS', 125),
(234527, 534523, 'JANEEE', 'XARARA', 'DED2394', '2014-09-05 17:12:25', 'PAFPOUF', 873352, 'WINGARDIUM', 15);


INSERT INTO Store(`Street`, `Street Number`, `Postal Code`, `City`)
VALUES
('PAPAGOU', 133, 16492, 'ZOGRAFOU'),
('KLIDON', 123, 50109, 'VRILISIA'),
('KIRON',12,949201, 'AXAIA'),
('PAPADIAMANIDI',53,12301, 'PURGOS'),
('GKALI',12,54291, 'ZAXARO'),
('MIGON',15,13273, 'POLES'),
('TRAVIS',99,12351, 'KATERINI'),
('SCOTT',54,76731, 'EKATERINESBURGH'),
('PERIPATOU',2,54132, 'MOSCOW'),
('VOLTARIS',5,12345, 'AGIS'),
('CARDI',62,54311, 'MITSON'),
('MINAS',6,34126, 'SPARTI'),
('PULWN',7,68535, 'ATHINA'),
('POLIS',27,12345, 'ATHINA'),
('TIRION',15,42345, 'ATHINA');

INSERT INTO `Phone Number`(`Store ID`, `Phone Number`)
VALUES
(1, 103941),
(2, 02938109),
(3, 049104014),
(4,123091032),
(5,1290301091),
(6,403940340),
(7, 039209),
(8,4910914),
(9,1209120),
(10,029310039),
(11,0192019),
(12,0192309120),
(13,03940293),
(14,09231093),
(15,0129310391);

INSERT INTO `Email Address`(`Store ID`, `Email_Address`)
VALUES
(1, 'alks@carrent.com'),
(2, 'asd@carrent.com'),
(3, 'asda@carrent.com'),
(4,'ksk@carrent.com'),
(5,'adskl@carrent.com'),
(6,'asa@carrent.com'),
(7, 'wqqq@carrent.com'),
(8,'aaaaaaaa@carrent.com'),
(9,'aaaa@carrent.com'),
(10,'lkas@carrent.com'),
(11,'vvv@carrent.com'),
(12,'cccc@carrent.com'),
(13,'xxxx@carrent.com'),
(14,'zzzz@carrent.com'),
(15,'bbbb@carrent.com');

INSERT INTO Works(`IRS Number`, `Store ID`, `Start Date`, `Finish Date`, `Position`)
VALUES
(992047, 1, '2001-01-20', '2016-02-20', 'WORKER'),
(123857, 2, '2002-01-20', '0000-00-00', 'MANAGER'),
(129017, 3, '2003-01-20', '0000-00-00', 'MANAGER'),
(231042, 4, '2004-01-20', '0000-00-00', 'MANAGER'),
(958302, 5, '2005-01-20', '0000-00-00', 'MANAGER'),
(940281, 6, '2006-01-20', '0000-00-00', 'MANAGER'),
(845281, 7, '2007-01-20', '0000-00-00', 'MANAGER'),
(756922, 8, '2008-01-20', '0000-00-00', 'MANAGER'),
(103672, 9, '2009-01-20', '0000-00-00', 'MANAGER'),
(917479, 10, '2010-01-20', '0000-00-00', 'MANAGER'),
(291659, 11, '2011-01-20', '0000-00-00', 'MANAGER'),
(578420, 12, '2012-01-20', '0000-00-00', 'MANAGER'), 
(192837, 13, '2013-01-20', '0000-00-00', 'MANAGER'),
(298741, 14, '2014-01-20', '0000-00-00', 'MANAGER'),
(203942, 15, '2015-01-20', '0000-00-00', 'MANAGER'),
(950102, 1, '2016-01-20', '0000-00-00', 'MANAGER'),
(123412, 3, '2016-02-23', '0000-00-00', 'WORKER'),
(653221, 3, '2015-02-23', '0000-00-00', 'WORKER'),
(543652, 3, '2017-02-23', '0000-00-00', 'WORKER'),
(742123, 4, '2013-02-23', '0000-00-00', 'WORKER'),
(656411, 5, '2012-02-23', '0000-00-00', 'WORKER'),
(234541, 2, '2011-02-23', '0000-00-00', 'WORKER'),
(431345, 2, '2010-02-23', '0000-00-00', 'WORKER'),
(123471,10, '2009-02-23', '0000-00-00', 'WORKER'),
(123402, 11, '2008-02-23', '0000-00-00', 'WORKER'),
(135135, 12, '2007-02-23', '0000-00-00', 'WORKER'),
(653215, 13, '2006-02-23', '0000-00-00', 'WORKER'),
(517211, 13, '2005-02-23', '0000-00-00', 'WORKER'),
(134711, 3, '2004-02-23', '0000-00-00', 'WORKER'),
(145642, 3, '2003-02-23', '0000-00-00', 'WORKER'),
(133461, 3, '2002-02-23', '0000-00-00', 'WORKER'),
(321354, 10, '2001-02-23', '0000-00-00', 'WORKER');


INSERT INTO Vehicle(`License Plate`, Model, Type, Make, Year, Kilometers, `Cylinder Capacity`, `Horse Power`, Damages, Malfunctions, `Next Service`, `Insurance Exp Date`, `Last Service`, `Store ID`)
VALUES
('KAM1010', 'S320', 'PASSENGER CAR', 'MERCEDES', 2001, 100000, 3200, 300, 'TIPOTA', 'SIMPLEKTIS KOLLAEI', '2018-01-20', '2018-12-20', '2017-01-20', 1),
('TAM1010', 'CBR1000RR', 'MOTORCYCLE', 'HONDA', 2002, 40000, 1000, 250, 'SPASMENO FAIRING', 'TIPOTA', '2018-01-20', '2018-12-20', '2017-01-20', 2),
('PAM1010', 'TEARS', 'SPORT CAR', 'VOLVO', 2003, 130000, 4000, 230, 'TIPOTA', 'TIPOTA', '2018-01-20', '2018-12-20', '2017-01-20', 3),
('LAM1010', 'YPO', 'PASSENGER CAR', 'TESLA', 2004, 80000, 37000, 500, 'TIPOTA', 'PISO PORTA DEN ANOIGEI' , '2018-01-20', '2018-12-20', '2017-01-20', 4),
('ZAM1010', 'PUTHON', 'PASSENGER CAR', 'BMW', 2005, 10000, 2040, 240,'SPASMENOS PROFULAKTIRAS', 'TIPOTA', '2018-01-20', '2018-12-20', '2017-01-20', 5),
('CAM1010', 'S500', 'PASSENGER CAR', 'MERCEDES', 2006, 102000, 4999, 400, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 6),
('RAM1010', 'ENZO', 'SPORT CAR', 'FERRARI', 2007, 23000, 6900,  900, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 7),
('QAM1010', 'CAYENNE', 'PASSENGER CAR', 'PORSCHE', 2008, 80000, 46000, 200, 'PISO THESEIS XALASMENES', 'TIPOTA', '2018-01-20', '2018-12-20', '2017-01-20', 8),
('WAM1010', 'CARRERA GT', 'SPORT CAR', 'PORSCHE', 2009, 50000, 34000, 700, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 9),
('JAM1010', 'YFZ-R1', 'MOTORCYCLE', 'YAMAHA', 2010, 60000, 10000, 300, 'DE MPAINEI H 6I', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 10),
('GAM1010',	'FAZER', 'MOTORCYCLE', 'YAMAHA', 2011, 120000, 10000, 200,  'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 11),
('SAM1010', 'XC90', 'PASSENGER CAR', 'VOLVO', 2012, 67000, 2490,  200,  'TSXILA STO KATHISMA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 12),
('DAM1010', 'DB11', 'SPORT CAR', 'ASTON MARTIN', 2013, 9800, 54000, 1200, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 13),
('FAM1010',	'DB9', 'SPORT CAR', 'ASTON MARTIN', 2014,10000, 43000, 800, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 14),
('XAM1010', 'AGUSTA', 'MOTORCYCLE', 'MV', 2015, 12000,  10000, 290, 'GRATZOUNIA STI MANETA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2017-01-20', 15),
('KGM1010', 'COMPRESSOR', 'PASSENGER CAR', 'MERCEDES', 2001, 95000, 3200, 300, 'TIPOTA', 'SIMPLEKTIS KOLLAEI', '2018-01-20', '2018-12-20', '2017-01-20', 1),
('TGM1010', 'TRACER', 'MOTORCYCLE', 'YAMAHA', 2002, 50000, 1000, 250, 'SPASMENO FAIRING', 'TIPOTA', '2018-01-20', '2018-12-20', '2017-01-20', 1),
('PGM1010', 'SPORTSYS', 'SPORT CAR', 'YAMAHA', 2003, 111000, 4000, 230, 'TIPOTA', 'TIPOTA', '2018-01-20', '2018-12-20', '2017-01-20', 1),
('LGM1010', 'TS666', 'PASSENGER CAR', 'TESLA', 2004, 63000, 37000, 500, 'TIPOTA', 'PISO PORTA DEN ANOIGEI' , '2018-01-20', '2018-12-20', '2017-01-20', 3),
('ZGM1010', 'M3 600i', 'PASSENGER CAR', 'BMW', 2005, 13000, 2040, 240,'SPASMENOS PROFULAKTIRAS', 'TIPOTA', '2018-01-20', '2018-12-20', '2016-01-20', 3),
('CGM1010', 'SX40', 'PASSENGER CAR', 'MERCEDES', 2006, 90000, 4999, 400, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2012-01-20', 3),
('RGM1010', 'RIRI', 'SPORT CAR', 'PORSCHE', 2007, 23000, 3900,  900, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2014-01-20', 3),
('QGM1010', 'CARTEL', 'PASSENGER CAR', 'PORSCHE', 2008, 10000, 46000, 200, 'PISO THESEIS XALASMENES', 'TIPOTA', '2018-01-20', '2018-12-20', '2014-01-20', 8),
('WGM1010', 'PICOLO', 'SPORT CAR', 'MERCEDES', 2009, 80000, 34000, 700, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2014-01-20', 8),
('JGM1010', 'NINJA ZX13000R', 'MOTORCYCLE', 'KAWASAKI', 2010, 20000, 10000, 300, 'DE MPAINEI H 6I', 'TIPOTA',  '2018-01-20', '2018-12-20', '2014-01-20', 3),
('GGM1010',	'FAZER', 'MOTORCYCLE', 'MERCEDES', 2011, 720000, 10000, 200,  'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2012-01-20', 11),
('SGM1010', 'XC90', 'PASSENGER CAR', 'ASTON MARTIN', 2012, 65000, 2490,  200,  'TSXILA STO KATHISMA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2014-01-20', 3),
('DGM1010', 'DB11', 'SPORT CAR', 'ASTON MARTIN', 2013, 91000, 54000, 1200, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2013-01-20', 13),
('FGM1010',	'DB9', 'SPORT CAR', 'ASTON MARTIN', 2014,10000, 43000, 800, 'TIPOTA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2015-01-20', 15),
('XGM1010', 'AGUSTA', 'MOTORCYCLE', 'ASTON MARTIN', 2015, 12000,  10000, 290, 'GRATZOUNIA STI MANETA', 'TIPOTA',  '2018-01-20', '2018-12-20', '2015-01-20', 15);


INSERT INTO `Fuel Type`(`License Plate`, `Fuel Type`)
VALUES
('KAM1010', 'DIESEL'),
('TAM1010', 'GAS'),
('PAM1010', 'GAS'),
('LAM1010', 'GAS'),
('ZAM1010', 'DIESEL'),
('CAM1010', 'DIESEL'),
('RAM1010', 'GAS'),
('QAM1010', 'DIESEL'),
('WAM1010', 'GAS'),
('JAM1010', 'GAS'),
('GAM1010', 'GAS'),
('SAM1010', 'DIESEL'),
('DAM1010', 'GAS'),
('FAM1010', 'GAS'),
('XAM1010', 'GAS'),
('KGM1010', 'DIESEL'),
('TGM1010', 'GAS'),
('PGM1010', 'GAS'),
('LGM1010', 'GAS'),
('ZGM1010', 'DIESEL'),
('CGM1010', 'DIESEL'),
('RGM1010', 'GAS'),
('QGM1010', 'DIESEL'),
('WGM1010', 'GAS'),
('JGM1010', 'GAS'),
('GGM1010', 'GAS'),
('SGM1010', 'DIESEL'),
('DGM1010', 'GAS'),
('FGM1010', 'GAS'),
('XGM1010', 'GAS');

INSERT INTO Rents(`License Plate`, `Start Date`, `Start Location`, `Finish Location`, `Finish Date`, `Return State`, `Customer ID`, `IRS Number`)
VALUES 
('KAM1010', '2017-01-12', 'ZOGRAFOU', 'VRILISIA','2017-01-28', 'KAMIA ZIMIA',1,992047),
('TAM1010', '2016-01-12', 'VRILISIA', 'MOSCOW','2016-01-28', 'GRATZOUNISMENO',2,123857),
('PAM1010', '2015-01-12', 'AXAIA', 'ATHINA','2015-01-28', 'KAMIA ZIMIA',3,129017),
('LAM1010', '2014-01-12', 'PURGOS', 'AXAIA','2014-01-28', 'SPASMENI EXATMISI',4,231042),
('ZAM1010', '2013-01-12', 'ZAXARO', 'MITSON','2013-01-28', 'TIPOTA',5,958302),
('CAM1010', '2012-01-12', 'POLES', 'MITSON','2012-01-28', 'TIPOTA',6,940281),
('RAM1010', '2011-01-12', 'KATERINI', 'EKATERINESBURGH','2011-01-28', 'VAMMENI ZANTA',7,845281);

INSERT INTO `Payment Transaction`(`Start Date`, `License Plate`, `Payment Amount`, `Payment Method`)
VALUES 
('2017-01-12', 'KAM1010', 1000, 'Credit Card'),
('2016-01-12', 'TAM1010', 10000, 'Credit Card'),
('2015-01-12', 'PAM1010', 24500, 'Bank Transaction'),
('2014-01-12', 'LAM1010', 7800, 'Credit Card'),
('2013-01-12', 'ZAM1010', 1200, 'Credit Card'),
('2012-01-12', 'CAM1010', 5000, 'Cash'),
('2011-01-12', 'RAM1010', 5088, 'Credit Card');

INSERT INTO Reserves(`License Plate`, `Start Date`, `Start Location`, `Finish Location`, `Finish Date`, `Paid`, `Customer ID`)
VALUES 
('QAM1010', '2018-01-25', 'EKATERINESBURGH', 'AGIS','2018-02-28', TRUE, 8),
('WAM1010', '2018-02-03', 'MOSCOW', 'SPARTI','2018-02-28', FALSE, 9),
('JAM1010', '2018-02-01', 'AGIS', 'ATHINA','2018-02-11', TRUE, 10),
('GAM1010', '2018-03-25', 'MITSON', 'ATHINA','2018-05-01', TRUE, 11),
('SAM1010', '2018-02-25', 'SPARTI', 'SPARTI','2018-03-01', FALSE, 12),
('DAM1010', '2018-07-25', 'ATHINA', 'MOSCOW','2018-08-11', TRUE, 13),
('FAM1010', '2018-07-22', 'ATHINA', 'EKATERINESBURGH','2018-08-13', TRUE, 14),
('XAM1010', '2018-05-22', 'ATHINA', 'EKATERINESBURGH','2018-06-13', FALSE, 15);

COMMIT;