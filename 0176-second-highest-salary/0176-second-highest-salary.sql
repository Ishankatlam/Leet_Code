# Write your MySQL query statement below

--  method 1  (292) ms 
-- select MAX(salary) as SecondHIghestSalary
-- from Employee 
-- where salary < (select max(salary) from Employee);


--  method 2 nth highest value 
-- select salary as SecondHighestSalary this causes for NULL nnot to be present 
-- select MAX(salary) as SecondHighestSalary
-- from (
--     select salary , dense_rank() over (order by salary desc) as salary_rank
--     from Employee
-- )rank_salaries
-- where salary_rank = 2 


-- method 3 
-- offset and limit functions 
-- select distinct Max(salary) as SecondHighestSalary
-- from Employee 
-- order by salary desc
-- limit 1 offset 1 

-- this leads as empty row not giving any null writing method 3 again 
select (
    select distinct salary
from Employee 
order by salary desc
limit 1 offset 1 
) as SecondHighestSalary