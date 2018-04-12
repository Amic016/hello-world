del log.txt
set PGPASSWORD=password
set PGCLIENTENCODING=utf8
for /f %%a in ('dir *.sql /b /on') do (
	psql -d ds1 -U username -f %%a 2>&1
) >> log.txt
