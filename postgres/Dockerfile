FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 123456
ENV POSTGRES_DB atividade
COPY create.sql /docker-entrypoint-initdb.d
COPY insert.sql /docker-entrypoint-initdb.d
