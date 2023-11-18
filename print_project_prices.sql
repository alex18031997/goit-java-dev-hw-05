SELECT
    C.name AS NAME,
    (EXTRACT(MONTH FROM P.FINISH_DATE) - EXTRACT(MONTH FROM P.START_DATE)) * W.SALARY AS PRICE
FROM
    project_worker PW
        JOIN
    worker W ON PW.WORKER_ID = W.ID
        JOIN
    project P ON PW.PROJECT_ID = P.ID
        JOIN
    client C ON P.CLIENT_ID = C.id;
