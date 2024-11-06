DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE TRACK CASCADE CONSTRAINTS;
DROP TABLE NOTE CASCADE CONSTRAINTS;
DROP TABLE SCORE CASCADE CONSTRAINTS;
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE TRACK_SEQ;
DROP SEQUENCE NOTE_SEQ;
DROP SEQUENCE SCORE_SEQ;

create table MEMBER
(
    MEMBER_NO NUMBER primary key,
    MEMBER_ID VARCHAR2(20) UNIQUE,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    NAME      VARCHAR2(20) NOT NULL,
    EMAIL     VARCHAR2(30) NOT NULL
);

create table TRACK
(
    TRACK_NO         NUMBER primary key,
    TRACK_TITLEIMAGE VARCHAR2(100) NOT NULL,
    TRACK_MENUIMAGE  VARCHAR2(100) NOT NULL,
    TRACK_GAMEIMAGE  VARCHAR2(100) NOT NULL,
    TRACK_STARTMUSIC VARCHAR2(100) NOT NULL,
    TRACK_GAMEMUSIC  VARCHAR2(100) NOT NULL,
    TRACK_TITLENAME  VARCHAR2(100) NOT NULL,
    TRACK_TIME       NUMBER        NOT NULL
);

create table NOTE
(
    NOTE_NO   NUMBER primary key,
    TRACK_NO  NUMBER,
    NOTE_TIME NUMBER       NOT NULL,
    NOTE_TYPE VARCHAR2(20) NOT NULL,
    FOREIGN KEY (TRACK_NO) REFERENCES TRACK
);

create table SCORE
(
    SCORE_NO     NUMBER primary key,
    MEMBER_NO    NUMBER,
    TRACK_NO     NUMBER,
    SCORE_RESULT NUMBER       NOT NULL,
    COMBO        NUMBER       NOT NULL,
    HIGH_SCORE   NUMBER       NOT NULL,
    HIGH_COMBO   NUMBER       NOT NULL,
    DIFFICULTY   VARCHAR2(20) NOT NULL,
    FOREIGN KEY (MEMBER_NO) REFERENCES MEMBER,
    FOREIGN KEY (TRACK_NO) REFERENCES TRACK
);

create SEQUENCE MEMBER_SEQ
    start with 1
    increment by 1
    nocache
    nocycle;

create SEQUENCE TRACK_SEQ
    start with 1
    increment by 1
    nocache
    nocycle;

create SEQUENCE NOTE_SEQ
    start with 1
    increment by 1
    nocache
    nocycle;

create SEQUENCE SCORE_SEQ
    start with 1
    increment by 1
    nocache
    nocycle;

insert into MEMBER
values (member_seq.nextval, 'test', 'test1234', '테스트', 'test@test.gg');
insert into MEMBER
values (member_seq.nextval, 'user1', 'user1234', '유저1', 'user1@test.gg');
insert into MEMBER
values (member_seq.nextval, 'user2', 'user1234', '유저2', 'user2@test.gg');
insert into MEMBER
values (member_seq.nextval, 'user3', 'user1234', '유저3', 'user3@test.gg');

insert into TRACK
values (track_seq.nextval, 'information title.png', 'information.png', 'information ingame.png',
        'information selected.mp3', 'information.mp3', 'information', 187000);
insert into TRACK
values (track_seq.nextval, 'sunset road title.png', 'sunset road.png', 'sunset road ingame.png',
        'sunset road selected.mp3', 'sunset road.mp3', 'sunset road', 184000);
insert into TRACK
values (track_seq.nextval, 'tokyo cafe title.png', 'tokyo cafe.png', 'tokyo cafe ingame.png',
        'tokyo cafe selected.mp3', 'tokyo cafe.mp3', 'tokyo cafe', 153000);

insert into NOTE
values (note_seq.nextval, 1, 2460, 'space');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 2, 'space');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 4, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 6, 'd');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 8, 'f');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 10, 'j');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 12, 'k');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 14, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 16, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 18, 'k');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 20, 'j');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 22, 'd');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 24, 'f');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 26, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 28, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 30, 'j');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 32, 'space');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 34, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 36, 'k');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 38, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 40, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 42, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 44, 'f');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 46, 'space');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 48, 'd');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 50, 'd');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 52, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 54, 'j');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 56, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 58, 'space');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 60, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 62, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 64, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 66, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 68, 'f');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 70, 'space');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 72, 'd');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 74, 'd');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 76, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 78, 'j');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 80, 's');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 82, 'space');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 84, 'l');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 86, 'j');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 88, 'k');
insert into NOTE
values (note_seq.nextval, 1, 2460 + 2000 * 90, 'l');

insert into NOTE
values (note_seq.nextval, 2, 2460, 'space');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 2, 'space');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 4, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 6, 'd');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 8, 'f');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 10, 'j');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 12, 'k');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 14, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 16, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 18, 'k');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 20, 'j');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 22, 'd');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 24, 'f');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 26, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 28, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 30, 'j');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 32, 'space');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 34, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 36, 'k');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 38, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 40, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 42, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 44, 'f');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 46, 'space');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 48, 'd');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 50, 'd');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 52, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 54, 'j');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 56, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 58, 'space');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 60, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 62, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 64, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 66, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 68, 'f');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 70, 'space');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 72, 'd');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 74, 'd');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 76, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 78, 'j');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 80, 's');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 82, 'space');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 84, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 86, 'j');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 88, 'k');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 90, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 92, 'l');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 94, 'k');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 96, 'j');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 98, 'k');
insert into NOTE
values (note_seq.nextval, 2, 2460 + 2000 * 100, 'j');

insert into NOTE
values (note_seq.nextval, 3, 2460, 'space');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 2, 'space');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 4, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 6, 'd');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 8, 'f');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 10, 'j');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 12, 'k');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 14, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 16, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 18, 'k');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 20, 'j');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 22, 'd');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 24, 'f');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 26, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 28, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 30, 'j');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 32, 'space');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 34, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 36, 'k');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 38, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 40, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 42, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 44, 'f');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 46, 'space');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 48, 'd');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 50, 'd');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 52, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 54, 'j');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 56, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 58, 'space');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 60, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 62, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 64, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 66, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 68, 'f');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 70, 'space');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 72, 'd');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 74, 'd');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 76, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 78, 'j');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 80, 's');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 82, 'space');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 84, 'l');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 86, 'j');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 88, 'k');
insert into NOTE
values (note_seq.nextval, 3, 2460 + 1500 * 90, 'l');

commit;