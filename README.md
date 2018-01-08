Steps to Build Application

Download the source code from git repository and extract it.

Build it using "mvn install" command in terminal. Now a war file gets generated.

Steps to run Application

Enter http://localhost:8080 in browser.

Tomcat Home page will be displayed.(if any port issues found tan change the port numbers in server.xml file)

Upload the war file of the application in the specified location.

Now after uploading war file , project gets dislayed in the projects list.

Run the application.

Tables:
1. # Table, Create Table
users, CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `createdOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `emailId` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1

 2.# Table, Create Table
events, CREATE TABLE `events` (
  `eventId` int(11) NOT NULL AUTO_INCREMENT,
  `eventName` varchar(45) NOT NULL,
  `eventDescription` varchar(45) NOT NULL,
  `eventImage` varchar(45) NOT NULL,
  `fromDate` date NOT NULL,
  `toDate` date NOT NULL,
  `category_id` int(6) NOT NULL,
  `emailId` varchar(300) NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `fk_events_1_idx` (`category_id`),
  CONSTRAINT `fk_events_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1

3.categories, CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(45) NOT NULL,
  `categoryDesc` varchar(45) NOT NULL,
  `categoryLogo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1

Execution Flow:

1.Test the apis in the post man

2.http://localhost:8080/events/getAllCategories

3.http://localhost:8080/events/getAllUsers

4.http://localhost:8080/events/getAllEvents

5.http://localhost:8080/events/auth ---for login

6.http://localhost:8080/events/upcomming

7.http://localhost:8080/events/addevents --- post method for adding events

8.http://localhost:8080/events/getCategoryById/{id}
