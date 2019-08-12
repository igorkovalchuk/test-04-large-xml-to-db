
Time spent: 14.6 h

plus

additional time spent on batch procession details and PostgreSQL: 5.3h  


Notes:

* Ordinary Hibernate log can't show does the batch processing work or not; for MySQL we can use either profileSQL=true in the URL or enable the general\_log in server.cnf; for PostgreSQL we should enable log_statement = 'all' in postgresql.conf to monitor the logs in /var/logs;


* In practice postgresql-9.6-main.log shows that INSERT batch size doesn't match the configuration parameters, it varies;


* The best size of batched INSERTs in PostgreSQL: [https://stackoverflow.com/q/49250849]


* Hibernate Batch Processing – Why you may not be using it. Even if you think you are: [https://abramsm.wordpress.com/2008/04/23/hibernate-batch-processing-why-you-may-not-be-using-it-even-if-you-think-you-are/]


* PgJDBC has some limitations regarding batches: [https://stackoverflow.com/a/20887293]


* [https://discourse.hibernate.org/t/hibernate-issuing-individual-insert-statements-even-though-batch-insert-is-enabled/2014/2]
