-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 23, 2011 at 04:51 PM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `travel`
--

-- --------------------------------------------------------

--
-- Table structure for table `deal`
--

CREATE TABLE IF NOT EXISTS `deal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dealPrice` double NOT NULL,
  `exclusions` longtext,
  `imageUrls` tinyblob,
  `inclusions` longtext,
  `longDescription` longtext,
  `name` varchar(255) DEFAULT NULL,
  `shortDescription` longtext,
  `dealAnalytics_id` bigint(20) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `oldPrice` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK20708C3F880590` (`hotel_id`),
  KEY `FK20708CFA324CEC` (`dealAnalytics_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `deal`
--

INSERT INTO `deal` (`id`, `dealPrice`, `exclusions`, `imageUrls`, `inclusions`, `longDescription`, `name`, `shortDescription`, `dealAnalytics_id`, `hotel_id`, `oldPrice`) VALUES
(1, 8000, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a740026696d616765732f6465616c2f4865726974616765204a61697075725f6a61697075722e6a706778, '', 'Pink Pearl Hotel is the ideal address in the pink city of Rajasthan. Just 15 minutes away from the city center with excellent views, Business and recreational facilities with finest hospitality and services.An oysteric landscape so nicely with the hospitality & services provided, the Pink Pearl Hotel begins to symbolize the cloudy comfort in the island of joy. Personalization & perfection at its best, the hotel boasts of a real life heavenly feel in relaxed environ, multi-cuisine facilities, dancing zones, bars, discotheques  all splushed musically within the green locales. Residing in the Pink City, the Pink Pearl Hotel is a beauty in itself, promising to charge you up in the scenic Pink Pearl Hotel & the Fun-city. Pink Pearl The Fun City, located 16 kms from the city center on Jaipur Ajmer highway (NH. No. 08), an ideal spot for Family outings, picnics, for Corporate Meets, Birthday Bashes, wedding Receptions, functions & for quiet family get-togethers, it is one of Indias largest integrated Amusement Parks.The first amusement center of India having Water Park, Go Karting, the world''s best virtual reality games, Laser games, Discotheque, Skating rink, Treasure Island & unending fun, invites you to bask at it''s beaches, create giant splashes, Wobble up & down Aqua Tubes, or Zoom down slides. Let the thrill of the rides increase your pulse rate and send adrenalin racing through your system.The major attractions at Pink Pearl  The Fun City include Water slides, Aqua Disco, Wave Pool, Kiddies Pool, Lazy River, Go Karting, Rock climbing, Mini Golf, Skill Games, Merry go Round, Boating, Bumper Boats, 42 virtual reality games, Pool Tables, Air Hockey, Skating Rink, Sweet Factory, Dragon Train, Merry Columbus, Paratrooper etc. The first floor hall houses kiddies rides dedicated to the sole & exclusive entertainment of small children in the age group of 01 to 08 years.', 'Heritage Jaipur', 'Pink Pearl Hotel is the ideal address in the pink city of Rajasthan. Just 15 minutes away from the city center with excellent views, Business and recreational facilities with finest hospitality and services.An oysteric landscape so nicely with the hospitality & services provided, the Pink Pearl Hotel begins to symbolize the cloudy comfort in the island of joy. Personalization & perfection at its best, the hotel boasts of a real life heavenly feel in relaxed environ, multi-cuisine facilities, dancing zones, bars, discotheques  all splushed musically within the green locales.', 1, 1, 10000),
(2, 9999, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a740026696d616765732f6465616c2f42656175746966756c2048696c6c735f74696d6265722e6a706778, '', 'Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.', 'Beautiful Hills', 'Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.', 2, 2, 15000),
(3, 4500, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a740021696d616765732f6465616c2f54616d7061204261795f6d616e6970616c2e6a706778, '', 'Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.', 'Tampa Bay', 'Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.Phoolchatti Resorts Rishikesh lie at the scenic confluence of the Ganga and Hem rivers in the Himalayan foothills above Rishikesh. Located along an ancient pilgrimage route into the headwaters of the Ganga just 7 kms from luxmanjhula.', 3, 1, 5000),
(4, 1299, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74002b696d616765732f6465616c2f4d6170706c65204c656973757265205265736f72745f68617761692e6a706778, '', 'The Resort set amidst seven acres of pristine greens offer you luxurious accommodation and a great overall experience during your stay here in the Tiger Country. Corbett Leisure Resort offers 15 elegantly appointed rooms to ensure that your stay here is taken well care of  the rooms as well as the rest of the resort are well-equipped with all modern facilities to ensure that you have a luxurious experience of Corbett and take back cherished memories of your vacation in the Jim Corbett National Park.\r\nThe Corbett Leisure Resort promises you a grand holiday experience like no other. To this end, the resort is equipped with a swimming pool, a multi-cuisine restaurant, a lounge bar, a garden caf and a travel and safari desk.', 'Mapple Leisure Resort', 'The Resort set amidst seven acres of pristine greens offer you luxurious accommodation and a great overall experience during your stay here in the Tiger Country. Corbett Leisure Resort offers 15 elegantly appointed rooms to ensure that your stay here is taken well care of  the rooms as well as the rest of the resort are well-equipped with all modern facilities to ensure that you have a luxurious experience of Corbett and take back cherished memories of your vacation in the Jim Corbett National Park.', 4, 1, 3499),
(5, 1199, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a740039696d616765732f6465616c2f4d6170706c6520546865205269766572204372657363656e74205265736f72745f68696d616368616c2e6a706778, '', 'Manali, a 46 rooms hotel, where we will pamper you with pure vegetarian fare, as you appreciate nature in all its pristine glory. We believe in Blending hospitality with nature'' for you.\r\nThe resort offers 46 rooms having peace and tranquility in hues of soft blue, peach or pistachio. The rooms have LCD television, mini bar, tea/coffee maker, bath tubs/cubicles, electronic safe and 24 hours room service.\r\nThe deluxe rooms are equipped with all modern amenities.\r\nTwo bedroom cottages are also available offering a kitchenette, a living room and an independent terrace to enjoy the offering of mother nature.', 'Mapple The River Crescent Resort', 'Manali, a 46 rooms hotel, where we will pamper you with pure vegetarian fare, as you appreciate nature in all its pristine glory. We believe in Blending hospitality with nature'' for you.\r\nThe resort offers 46 rooms having peace and tranquility in hues of soft blue, peach or pistachio. The rooms have LCD television, mini bar, tea/coffee maker, bath tubs/cubicles, electronic safe and 24 hours room service.', 5, 1, 2320),
(6, 1499, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74002b696d616765732f6465616c2f416e6e616d616c616920496e7465726e6174696f6e616c5f6c65682e6a706778, '', 'Hotel Annamalai International Pondicherry was established in 2001. Located in the heart of the city. Its a Centralized air conditioned with atrium lobby, 70 well appointed rooms, Multi-cuisine restaurant and Vegetarian restaurant with exclusive vegetarian kitchen. The Court of Bacchus (BAR). 4 conference halls and business center. Swimming pool in terrace Open to sky is exclusively for resident guests.\r\nWe are number one in Pondicherry, Indias key industrial & commercial city. Wide range of accommodation with 3 Annamalai Suites, 3 King suites, 6 Executives Rooms and 58 Standard Rooms with all modern amenities and comfort to match with international standards. All the rooms are provided with Safety Locker & Bath tubs. The Swimming Pool amidst of Rock garden with Paddling Pool promises sheer exhilaration. Moonshine dinners and Pool Side Parties at man-made rock setting Roof Top make your evening come live and crackle with excitement.', 'Annamalai International', 'Hotel Annamalai International Pondicherry was established in 2001. Located in the heart of the city. Its a Centralized air conditioned with atrium lobby, 70 well appointed rooms, Multi-cuisine restaurant and Vegetarian restaurant with exclusive vegetarian kitchen. The Court of Bacchus (BAR). 4 conference halls and business center. Swimming pool in terrace Open to sky is exclusively for resident guests.', 6, 1, 1900),
(7, 3700, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74002c696d616765732f6465616c2f526f6e696c204265616368205265736f72745f6d6173736f727569652e6a706778, '', 'Ronil Beach resort is known for its ambiance and food. The resort is located in a lush green surrounding and is a 5 minute walking distance from the beach. In this sun-soaking time-warp, you will find fulfillment of every need - 126 well-appointed rooms with satellite TV (106 standard rooms and 20 deluxe rooms), restaurant, an air-conditioned coffee shop, conference room with business facilities, two fresh water swimming pools, a sun deck and a choice of cuisine. All embraced in a friendly ambiance, with even friendlier service.Ronil Beach resort is known for its ambiance and food. The resort is located in a lush green surrounding and is a 5 minute walking distance from the beach. In this sun-soaking time-warp, you will find fulfillment of every need - 126 well-appointed rooms with satellite TV (106 standard rooms and 20 deluxe rooms), restaurant, an air-conditioned coffee shop, conference room with business facilities, two fresh water swimming pools, a sun deck and a choice of cuisine. All embraced in a friendly ambiance, with even friendlier service.', 'Ronil Beach Resort', 'Ronil Beach resort is known for its ambiance and food. The resort is located in a lush green surrounding and is a 5 minute walking distance from the beach. In this sun-soaking time-warp, you will find fulfillment of every need - 126 well-appointed rooms with satellite TV (106 standard rooms and 20 deluxe rooms), restaurant, an air-conditioned coffee shop, conference room with business facilities, two fresh water swimming pools, a sun deck and a choice of cuisine. All embraced in a friendly ambiance, with even friendlier service.', 7, 1, 5599),
(8, 7899, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74002f696d616765732f6465616c2f486f74656c204164616d6f205468652056696c6c6167655f6d616e6970616c2e6a706778, '', 'Formerly known as Hotel Riviera, Adamo Village is situated amongst the green forest hills of Matheran where the muddy roads roll out a red carpet leading to a place famous for its hospitality which is befitting of the king''s royalty.\r\nA vast expanse of land with a lot of greenery and tranquility to give you that unpolluted feeling of relief and being far away from "HUSTLE & BUSTLE OF MUMBAI CITY". A place with a rustic ambiance to break the monotony of the CONCRETE JUNGLE. A hotel having all modern amenities of well refurbished rooms with EPABX telephones and Multi - Channels Cable T.V. System. A swimming pool and lots of amusement items to make your recreation a refreshing and fun-filled experience.', 'Hotel Adamo The Village', 'Formerly known as Hotel Riviera, Adamo Village is situated amongst the green forest hills of Matheran where the muddy roads roll out a red carpet leading to a place famous for its hospitality which is befitting of the king''s royalty.', 8, 1, 9999),
(9, 956, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74002b696d616765732f6465616c2f20486f74656c20486f6e65796d6f6f6e20496e6e5f7368696d6c612e6a706778, 'Stay for 01 Night and 02 Days in Well appointed room on twin sharing basis.:Free use of Hotel Amenities.:Rates are applicable on per person per night basis:Bookings are dependent on subject to availability with the hotel.:1.03% Taxes Extra.', 'Honeymoon comes once in the lifetime, start your married life in a special way. Revel in the luxury of Honeymoon Suit designed for pure indulgence with laced canopied round beds and mirrored ceiling. The Honeymoon Inn chain of hotels in Mussoorie, Manali, New Delhi and Shimla offers exclusive facilities and services to guests at affordable prices. The rooms are cosy and comfortable and offer all the amenities required for a memorable and pleasant stay. The staff is warm and welcoming ensuring that your every need is met during your stay at Honeymoon Inn. For an unforgettable and romantic honeymoon, Honeymoon Inn promises to make the special moments you spend with your loved one, incredibly memorable. The Honeymoon Inn Hotel in Mussoorie is located in the center of the famous Mall Road of this "Queen of Hill Stations".', ' Hotel Honeymoon Inn', 'Honeymoon comes once in the lifetime, start your married life in a special way. Revel in the luxury of Honeymoon Suit designed for pure indulgence with laced canopied round beds and mirrored ceiling. The Honeymoon Inn chain of hotels in Mussoorie, Manali, New Delhi and Shimla offers exclusive facilities and services to guests at affordable prices. ', 9, 2, 1900);

-- --------------------------------------------------------

--
-- Table structure for table `dealanalytics`
--

CREATE TABLE IF NOT EXISTS `dealanalytics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `boughtCount` int(11) NOT NULL,
  `dateAdded` datetime DEFAULT NULL,
  `dateDeleted` datetime DEFAULT NULL,
  `expired` bit(1) NOT NULL,
  `featured` bit(1) NOT NULL,
  `slider` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `dealanalytics`
--

INSERT INTO `dealanalytics` (`id`, `boughtCount`, `dateAdded`, `dateDeleted`, `expired`, `featured`, `slider`) VALUES
(1, 5, '2011-08-21 01:44:53', NULL, b'0', b'1', b'1'),
(2, 0, '2011-08-21 01:45:45', NULL, b'0', b'1', b'1'),
(3, 5, '2011-08-21 01:46:58', NULL, b'0', b'0', b'1'),
(4, 0, '2011-08-21 01:48:30', NULL, b'0', b'1', b'1'),
(5, 1, '2011-08-21 01:50:10', NULL, b'0', b'1', b'1'),
(6, 5, '2011-08-21 01:52:09', NULL, b'0', b'1', b'1'),
(7, 0, '2011-08-21 01:53:52', NULL, b'0', b'1', b'1'),
(8, 5, '2011-08-21 01:55:12', NULL, b'0', b'0', b'1'),
(9, 1, '2011-08-23 21:46:40', NULL, b'0', b'0', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `dealcategory`
--

CREATE TABLE IF NOT EXISTS `dealcategory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dealType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `dealcategory`
--

INSERT INTO `dealcategory` (`id`, `dealType`) VALUES
(1, 'Adventure'),
(4, 'Romantic'),
(3, 'Honeymoon'),
(2, 'Business'),
(5, 'Family'),
(6, 'Miscellaneous');

-- --------------------------------------------------------

--
-- Table structure for table `deal_dealcategory`
--

CREATE TABLE IF NOT EXISTS `deal_dealcategory` (
  `Deal_id` bigint(20) NOT NULL,
  `dealCategories_id` bigint(20) NOT NULL,
  KEY `FK30F9827DB03576EA` (`dealCategories_id`),
  KEY `FK30F9827D3D60E468` (`Deal_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deal_dealcategory`
--

INSERT INTO `deal_dealcategory` (`Deal_id`, `dealCategories_id`) VALUES
(1, 1),
(1, 2),
(2, 4),
(3, 1),
(3, 3),
(4, 1),
(5, 4),
(5, 5),
(6, 1),
(6, 2),
(8, 4),
(9, 4),
(9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `chain` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `countryCode` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `emails` tinyblob,
  `faxNumbers` tinyblob,
  `highRate` double NOT NULL,
  `imageUrls` tinyblob,
  `locality` varchar(255) DEFAULT NULL,
  `lowRate` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `overview` varchar(255) DEFAULT NULL,
  `phoneNumbers` tinyblob,
  `rateDisclaimer` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL,
  `ratingAgency` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `websites` tinyblob,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `address`, `chain`, `city`, `country`, `countryCode`, `currency`, `emails`, `faxNumbers`, `highRate`, `imageUrls`, `locality`, `lowRate`, `name`, `overview`, `phoneNumbers`, `rateDisclaimer`, `rating`, `ratingAgency`, `state`, `websites`, `zip`) VALUES
(1, '', '', 'Jaipur', 'India', '', NULL, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, 0, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74001c696d616765735c686f74656c5c43686f6b692d4468616e692e6a706778, '', 0, 'Chokhi Dhani', '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, NULL, 0, NULL, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, ''),
(2, '', '', 'Parwanoo', 'India', '', NULL, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, 0, 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a740025696d616765735c686f74656c5c74696d6265722d747261696c2d686569676874732e6a706778, '', 0, 'Timber Trail Heights', '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, NULL, 0, NULL, '', 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000177040000000a74000078, '');
