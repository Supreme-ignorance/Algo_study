-- 코드를 입력하세요
SELECT outs.ANIMAL_ID
       ,outs.NAME
FROM ANIMAL_OUTS outs
left outer join ANIMAL_INS ins
    on outs.ANIMAL_ID = ins.ANIMAL_ID
WHERE ins.ANIMAL_ID is NULL