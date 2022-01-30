-- FUNCTION: public.get_total_employees()

-- DROP FUNCTION IF EXISTS public.get_total_employees();

CREATE OR REPLACE FUNCTION public.get_total_employees(
	)
    RETURNS integer
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE total_employees integer;
BEGIN
	select count(*) from employees
	into total_employees;
	return total_employees;
END
$BODY$;

ALTER FUNCTION public.get_total_employees()
    OWNER TO tanviagrawal;
