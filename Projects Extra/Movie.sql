CREATE TABLE User(
  user_id INT(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(30) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(32) NOT NULL,
  user_role varchar(20) NOT NULL,
  PRIMARY KEY (user_id)
);


CREATE TABLE movie (
  movieid int NOT NULL AUTO_INCREMENT,
  detailid int NOT NULL,
  catagoryid int NOT NULL,
  PRIMARY KEY (movieid),
  FOREIGN KEY (detailid) REFERENCES mdetail(detailid),
  FOREIGN KEY (catagoryid) REFERENCES catagory(catagoryid)
);

CREATE TABLE catagory(
 catagoryid int NOT NULL AUTO_INCREMENT,
 catagory varchar(20),
 PRIMARY KEY (catagoryid)
);

CREATE TABLE mdetail (
  detailid int NOT NULL AUTO_INCREMENT,
  moviename varchar(255) NOT NULL,
  cost int NOT NULL,
  PRIMARY KEY (detailid)
);


CREATE TABLE bookinghistory (
  historyid int NOT NULL AUTO_INCREMENT,
  userid int NOT NULL,
  movieid int NOT NULL,
  startduration datetime NOT NULL,
  endduration datetime NOT NULL,
  PRIMARY KEY (historyid),
  FOREIGN KEY (userid) REFERENCES user(userid),
  FOREIGN KEY (movieid) REFERENCES mdetail(detailid)
);

