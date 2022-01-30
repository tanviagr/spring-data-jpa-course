-- FUNCTION: public.proc_single_input(integer)

-- DROP FUNCTION IF EXISTS public.proc_single_input(integer);

CREATE OR REPLACE FUNCTION public.proc_single_input(
	empid integer)
    RETURNS integer
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE
	empage int;
BEGIN
SELECT age FROM public.employees
WHERE employee_id = empid
INTO empage;
RETURN empage;
END;
$BODY$;

ALTER FUNCTION public.proc_single_input(integer)
    OWNER TO tanviagrawal;
