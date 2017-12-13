create user jspboardTest identified by jspboardtest default tablespace pc01 temporary tablespace temp quota unlimited on pc01 quota 0m on system;
grant resource, connect to jspboardTest;