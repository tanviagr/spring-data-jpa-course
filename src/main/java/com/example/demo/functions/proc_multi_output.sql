-- FUNCTION: public.proc_multi_output(integer)

-- DROP FUNCTION IF EXISTS public.proc_multi_output(integer);

CREATE OR REPLACE FUNCTION public.proc_multi_output(
	empid integer,
	OUT empage integer,
	OUT empdept text)
    RETURNS record
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
BEGIN
SELECT INTO empage, empdept
e.age, e.department
FROM employees e
WHERE e.employee_id = empid;
END
$BODY$;

ALTER FUNCTION public.proc_multi_output(integer)
    OWNER TO tanviagrawal;
