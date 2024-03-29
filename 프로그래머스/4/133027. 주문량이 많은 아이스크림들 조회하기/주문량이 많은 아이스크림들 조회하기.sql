WITH sum_total AS (
    SELECT *
    FROM first_half
    
    UNION ALL
    
    SELECT *
    FROM july
)

SELECT flavor
FROM sum_total
GROUP BY flavor
ORDER BY sum(total_order) DESC
LIMIT 3;