::
:: Script Arret/Relance conteneur MySQL 8.3.0
::
@echo OFF
set OPTION=%1
if %OPTION%. == start. (
	docker run -d --rm --name mysql -v C:\Users\bertr\Documents\h3hitema\M1\JEE\Datas\MySQL:/var/lib/mysql -e MYSQL_ROOT_PASSWORD="Hitema&2024" -p 3307:3306 mysql:8.3.0
) else if %OPTION%. == stop. (
	docker stop mysql
) else (
	@echo %0% [start^|stop]
)
