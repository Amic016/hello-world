del log.txt
set PGPASSWORD=password
set PGCLIENTENCODING=utf8
for /f %%a in ('dir *.sql /b /on') do (
	psql -d databasename -U username -f %%a 2>&1
) >> log.txt
