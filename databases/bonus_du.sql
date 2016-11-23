WITH lower_price AS (
    SELECT c2.Krcma, c2.Alkohol
    FROM capuje c, capuje c2
    WHERE c.Alkohol=c2.Alkohol AND c.Cena < c2.Cena
),
lowest_price AS (
    SELECT c.Krcma, c.Alkohol
    FROM capuje c
    WHERE NOT EXISTS(SELECT * FROM lower_price lp
                     WHERE lp.Alkohol=c.Alkohol AND lp.Krcma=c.Krcma)
),
failed_drunkard AS (
    SELECT DISTINCT n.Pijan
    FROM navstivil n, navstivil n2, vypil v, vypil v2, lowest_price lp
    WHERE n.Pijan=n2.Pijan AND n.Id < n2.Id AND n.Id=v.Id AND
          n2.Id=v2.Id AND v.Alkohol=v2.Alkohol AND lp.Alkohol=v.Alkohol AND
          lp.Krcma != n2.Krcma
),
failed_pub AS (
    SELECT DISTINCT n.Krcma
    FROM navstivil n, failed_drunkard fd
    WHERE n.Pijan=fd.Pijan
)
SELECT DISTINCT n.Krcma
FROM navstivil n
WHERE NOT EXISTS(SELECT * FROM failed_pub f WHERE f.Krcma=n.Krcma);
