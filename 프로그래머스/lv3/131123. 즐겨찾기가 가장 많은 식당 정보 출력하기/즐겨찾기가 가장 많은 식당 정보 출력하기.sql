SELECT RI.FOOD_TYPE, RI.REST_ID, RI.REST_NAME, RI.FAVORITES 
FROM REST_INFO RI JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) SUB ON RI.FOOD_TYPE = SUB.FOOD_TYPE AND RI.FAVORITES = SUB.FAVORITES
ORDER BY FOOD_TYPE DESC
