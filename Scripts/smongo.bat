::
:: Script Arret/Relance conteneur MariaDB
::
@echo OFF
set OPTION=%1
if %OPTION%. == start. (
	docker run -p27018:27017 --rm --name mongodb -d ^
    			-e MONGO_INITDB_ROOT_USERNAME=java1 ^
    			-e MONGO_INITDB_ROOT_PASSWORD=java1 mongo
) else if %OPTION%. == stop. (
	docker stop mongodb
) else (
	@echo %0% [start^|stop]
)
