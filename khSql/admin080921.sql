---사용자 계정 생성
-- CREATE USER USERNAME IDENTIFIED BY PW
CREATE USER BYUNDUCK IDENTIFIED BY QUSEJRDLRNLDUDNJ;
GRANT CONNECT TO BYUNDUCK;
GRANT SELECT ON KH.EMPLOYEE TO BYUNDUCK;
GRANT RESOURCE TO BYUNDUCK;