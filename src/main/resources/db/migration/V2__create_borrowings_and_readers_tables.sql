CREATE TABLE IF NOT EXISTS public.reader
(
    readerid bigint NOT NULL,
    name character varying(60) COLLATE pg_catalog."default" NOT NULL,
    age smallint,
    bookcount integer DEFAULT 0,
    CONSTRAINT reader_pkey PRIMARY KEY (readerid)
);


CREATE TABLE IF NOT EXISTS public.borrowings
(
    readerid bigint NOT NULL,
    bookid bigint NOT NULL,
    borrowedtime timestamp without time zone NOT NULL,
    CONSTRAINT borrowings_pkey PRIMARY KEY (readerid, bookid, borrowedtime),
    CONSTRAINT borrowings_bookid_fkey FOREIGN KEY (bookid)
        REFERENCES public.book (bookid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT borrowings_readerid_fkey FOREIGN KEY (readerid)
        REFERENCES public.reader (readerid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)