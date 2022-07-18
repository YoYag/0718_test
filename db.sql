# DB 생성
DROP DATABASE IF EXISTS sbb;
CREATE DATABASE sbb;
USE sbb;

# article 테이블 생성
CREATE TABLE `article` (
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    create_date DATETIME NOT NULL,
    `subject` VARCHAR(200) NOT NULL,
    `content` TEXT NOT NULL
);

# article 데이터 생성
INSERT INTO `article`
SET create_date = NOW(),
`subject` = '질문 1',
`content` = '질문내용 1';

INSERT INTO `article`
SET create_date = NOW(),
`subject` = '질문 2',
`content` = '질문내용 2';

INSERT INTO `article`
SET create_date = NOW(),
`subject` = '질문 3',
`content` = '질문내용 3';

# reply 테이블 생성
CREATE TABLE reply (
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    create_date DATETIME NOT NULL,
    article_id BIGINT UNSIGNED NOT NULL
);

# reply 생성
INSERT INTO reply SET
create_date = NOW(),
content = '답변내용 1',
article_id = 1;

INSERT INTO reply SET
create_date = NOW(),
content = '답변내용 2',
article_id = 2;

INSERT INTO reply SET
create_date = NOW(),
content = '답변내용 3',
article_id = 3;

SELECT * FROM `article`;
SELECT * FROM `reply`;