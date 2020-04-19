CREATE SEQUENCE P2user_id_maker
MINVALUE 1
START WITH 1
INCREMENT BY 1; 

CREATE SEQUENCE neighb_id_maker
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE review_id_maker
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE TABLE P2user (
    user_id NUMBER (10) PRIMARY KEY,
    roleof VARCHAR2(10), 
    user_id NUMBER (10) PRIMARY KEY, 
    username VARCHAR2(100) NOT NULL, 
    pword VARCHAR2(100) NOT NULL, 
    email VARCHAR2(100), 
    fname VARCHAR2(100), 
    lname VARCHAR2 (100), 
    neighborhood VARCHAR2 (250), 
    rating NUMBER (10), 
    rating NUMBER (3), 
    allowemail NUMBER(1) DEFAULT 0
);

CREATE TABLE neighborhood(
    neighb_id NUMBER (10) PRIMARY KEY, 
    neighb_name VARCHAR2(100), 
    neighb_rating NUMBER(3), 
    neighb_loc VARCHAR2 (100), 
    popsqm NUMBER(10),
    avgprice NUMBER(10),
    hospital NUMBER(10),
    pow NUMBER(10),
    education NUMBER(10), 
    grocery NUMBER(10), 
    transit NUMBER(10),
    airports NUMBER(10),
    hotels NUMBER(10),
    pubsrv NUMBER(10),
    crmrate NUMBER(3),
    povrate NUMBER(3),
    homrate NUMBER(3)
);

CREATE TABLE review(
    rev_id NUMBER(10) PRIMARY KEY, 
    user_id NUMBER(10), 
    neighb_id NUMBER(10),
    dateof DATE DEFAULT SYSDATE, 
    tup NUMBER(10), 
    tdown NUMBER(10),
    info VARCHAR2(4000),
    CONSTRAINT fk_rev_user FOREIGN KEY (user_id) REFERENCES P2user(user_id),
    CONSTRAINT fk_rev_neighb FOREIGN KEY (neighb_id) REFERENCES neighborhood(neighb_id)
);

CREATE TABLE recommendations(
    rec_id NUMBER(20),
    neighb_name VARCHAR2 (200), 
    neighb_loc VARCHAR2(200)
);

CREATE TABLE comments(
    cmnt_id NUMBER(10),
    rev_id NUMBER(10),
    cmnt VARCHAR2 (2500)
); 

CREATE TABLE categories(
    rev_id NUMBER(10),
    cleanliness NUMBER (10) DEFAULT -1, 
    qlife NUMBER(10) DEFAULT -1, 
    safety NUMBER(10) DEFAULT -1, 
    ammenities NUMBER(10) DEFAULT -1, 
    essentials NUMBER(10) DEFAULT -1, 
    CONSTRAINT fk_cat_rev FOREIGN KEY (rev_id) REFERENCES review(rev_id)
);

SELECT * FROM P2user; 
SELECT * FROM neighborhood; 
SELECT * FROM review;
SELECT * FROM recommendations; 
SELECT * FROM comments; 

DELETE FROM P2user where user_id = 79;
DELETE FROM review WHERE rev_id = 76;
DELETE FROM comments WHERE cmnt_id > 101;
DELETE FROM neighborhood where neighb_id > 104;

DROP TABLE categories; 
DROP TABLE review; 
DROP TABLE neighborhood;
DROP TABLE P2User; 
DROP TABLE recommendations;
DROP TABLE comments;

commit; 