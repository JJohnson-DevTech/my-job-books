-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER job_book_owner
WITH PASSWORD 'jobbook';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO job_book_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO job_book_owner;

CREATE USER job_book_appuser
WITH PASSWORD 'jobbook';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO job_book_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO job_book_appuser;
