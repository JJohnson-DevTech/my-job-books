-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'job_book';

DROP DATABASE job_book;

DROP USER job_book_owner;
DROP USER job_book_appuser;
