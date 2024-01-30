SELECT MCDP_CD as "진료과코드" , COUNT(*) as "5월예약건수"
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = 2022 and MONTH(APNT_YMD) = 5
GROUP BY MCDP_CD
order by COUNT(*) ASC, MCDP_CD ASC