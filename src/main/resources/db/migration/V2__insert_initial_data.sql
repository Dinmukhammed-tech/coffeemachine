INSERT INTO public.recipe ( name)
VALUES ( 'espresso'),
       ('americano'),
       ('cappuchino')
ON CONFLICT (name) DO NOTHING;
delete from public.recipe;
select * from public.recipe;
