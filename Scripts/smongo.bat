::
:: Script Arret/Relance conteneur MariaDB
::
@echo OFF
set OPTION=%1
if %OPTION%. == start. (
	docker run -p27117:27017 --rm --name mongodb -d ^
    			-e MONGO_INITDB_ROOT_USERNAME=java1 ^
    			-e MONGO_INITDB_ROOT_PASSWORD=java1 ^
    			-v C:\Users\bertr\Documents\h3hitema\M1\JEE\Datas\MongoDB:/data/db mongo
) else if %OPTION%. == stop. (
	docker stop mongodb
) else (
	@echo %0% [start^|stop]
)
