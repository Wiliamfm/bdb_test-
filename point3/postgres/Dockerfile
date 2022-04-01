FROM postgres
ENV POSTGRES_PASSWORD=1234 
ENV POSTGRES_DB=bdb_test 
COPY init.sql /docker-entrypoint-initdb.d/
COPY inserts.sql /docker-entrypoint-initdb.d/