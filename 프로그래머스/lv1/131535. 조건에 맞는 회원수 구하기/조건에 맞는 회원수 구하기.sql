SELECT COUNT(*) AS USERS FROM USER_INFO UI
WHERE UI.JOINED BETWEEN '2021-01-01' AND '2021-12-31'
AND UI.AGE BETWEEN 20 AND 29;