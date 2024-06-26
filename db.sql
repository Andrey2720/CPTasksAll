PGDMP                      |            postgres    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    5    postgres    DATABASE     |   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    4811                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            �           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16591    group_tb    TABLE     [   CREATE TABLE public.group_tb (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.group_tb;
       public         heap    postgres    false            �            1259    16590    group_tb_id_seq    SEQUENCE     �   CREATE SEQUENCE public.group_tb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.group_tb_id_seq;
       public          postgres    false    217            �           0    0    group_tb_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.group_tb_id_seq OWNED BY public.group_tb.id;
          public          postgres    false    216            �            1259    16612    tasks    TABLE     y  CREATE TABLE public.tasks (
    id integer NOT NULL,
    name character varying(255),
    description text,
    files character varying(255),
    status integer,
    creation_date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    date_start date,
    date_end date,
    time_start time without time zone,
    time_end time without time zone,
    user_tb_id integer
);
    DROP TABLE public.tasks;
       public         heap    postgres    false            �            1259    16611    tasks_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.tasks_id_seq;
       public          postgres    false    221            �           0    0    tasks_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;
          public          postgres    false    220            �            1259    16598    user_tb    TABLE       CREATE TABLE public.user_tb (
    id integer NOT NULL,
    name character varying(255),
    surename character varying(255),
    patronymic character varying(255),
    email character varying(255),
    role character varying(255),
    group_tb_id integer
);
    DROP TABLE public.user_tb;
       public         heap    postgres    false            �            1259    16597    user_tb_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_tb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.user_tb_id_seq;
       public          postgres    false    219            �           0    0    user_tb_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.user_tb_id_seq OWNED BY public.user_tb.id;
          public          postgres    false    218            %           2604    16594    group_tb id    DEFAULT     j   ALTER TABLE ONLY public.group_tb ALTER COLUMN id SET DEFAULT nextval('public.group_tb_id_seq'::regclass);
 :   ALTER TABLE public.group_tb ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217            '           2604    16615    tasks id    DEFAULT     d   ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);
 7   ALTER TABLE public.tasks ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            &           2604    16601 
   user_tb id    DEFAULT     h   ALTER TABLE ONLY public.user_tb ALTER COLUMN id SET DEFAULT nextval('public.user_tb_id_seq'::regclass);
 9   ALTER TABLE public.user_tb ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219            �          0    16591    group_tb 
   TABLE DATA           ,   COPY public.group_tb (id, name) FROM stdin;
    public          postgres    false    217   �       �          0    16612    tasks 
   TABLE DATA           �   COPY public.tasks (id, name, description, files, status, creation_date, date_start, date_end, time_start, time_end, user_tb_id) FROM stdin;
    public          postgres    false    221           �          0    16598    user_tb 
   TABLE DATA           [   COPY public.user_tb (id, name, surename, patronymic, email, role, group_tb_id) FROM stdin;
    public          postgres    false    219   %        �           0    0    group_tb_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.group_tb_id_seq', 1, false);
          public          postgres    false    216            �           0    0    tasks_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.tasks_id_seq', 1, false);
          public          postgres    false    220            �           0    0    user_tb_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.user_tb_id_seq', 1, false);
          public          postgres    false    218            *           2606    16596    group_tb group_tb_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.group_tb
    ADD CONSTRAINT group_tb_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.group_tb DROP CONSTRAINT group_tb_pkey;
       public            postgres    false    217            .           2606    16620    tasks tasks_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_pkey;
       public            postgres    false    221            ,           2606    16605    user_tb user_tb_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.user_tb
    ADD CONSTRAINT user_tb_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.user_tb DROP CONSTRAINT user_tb_pkey;
       public            postgres    false    219            0           2606    16621    tasks tasks_user_tb_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_user_tb_id_fkey FOREIGN KEY (user_tb_id) REFERENCES public.user_tb(id);
 E   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_user_tb_id_fkey;
       public          postgres    false    221    4652    219            /           2606    16606     user_tb user_tb_group_tb_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_tb
    ADD CONSTRAINT user_tb_group_tb_id_fkey FOREIGN KEY (group_tb_id) REFERENCES public.group_tb(id);
 J   ALTER TABLE ONLY public.user_tb DROP CONSTRAINT user_tb_group_tb_id_fkey;
       public          postgres    false    219    4650    217            �      x������ � �      �      x������ � �      �      x������ � �     