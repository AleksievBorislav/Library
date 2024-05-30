CREATE TABLE IF NOT EXISTS public.book
(
    bookid bigint NOT NULL,
    title character varying(60) NOT NULL,
    pagecount integer NOT NULL,
    readerscount integer NOT NULL,
    price numeric NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (bookid),
    CONSTRAINT book_title_key UNIQUE (title)
)