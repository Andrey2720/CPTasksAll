PGDMP  9                    |            postgres    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    5    postgres    DATABASE     |   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    4810                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            �           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16499    group_tb    TABLE     `   CREATE TABLE public.group_tb (
    id integer NOT NULL,
    groupname character varying(255)
);
    DROP TABLE public.group_tb;
       public         heap    postgres    false            �            1259    16498    group_tb_id_seq    SEQUENCE     �   CREATE SEQUENCE public.group_tb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.group_tb_id_seq;
       public          postgres    false    217            �           0    0    group_tb_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.group_tb_id_seq OWNED BY public.group_tb.id;
          public          postgres    false    216            �            1259    16556    task    TABLE     �   CREATE TABLE public.task (
    id integer NOT NULL,
    description text,
    files character varying(255),
    status integer,
    weekday date,
    user_id integer
);
    DROP TABLE public.task;
       public         heap    postgres    false            �            1259    16555    task_id_seq    SEQUENCE     �   CREATE SEQUENCE public.task_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.task_id_seq;
       public          postgres    false    221            �           0    0    task_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.task_id_seq OWNED BY public.task.id;
          public          postgres    false    220            �            1259    16506    user_tb    TABLE       CREATE TABLE public.user_tb (
    id integer NOT NULL,
    name character varying(255),
    surname character varying(255),
    patronymic character varying(255),
    email character varying(255),
    role character varying(255),
    group_tb_id integer
);
    DROP TABLE public.user_tb;
       public         heap    postgres    false            �            1259    16505    user_tb_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_tb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.user_tb_id_seq;
       public          postgres    false    219            �           0    0    user_tb_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.user_tb_id_seq OWNED BY public.user_tb.id;
          public          postgres    false    218            %           2604    16502    group_tb id    DEFAULT     j   ALTER TABLE ONLY public.group_tb ALTER COLUMN id SET DEFAULT nextval('public.group_tb_id_seq'::regclass);
 :   ALTER TABLE public.group_tb ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217            '           2604    16559    task id    DEFAULT     b   ALTER TABLE ONLY public.task ALTER COLUMN id SET DEFAULT nextval('public.task_id_seq'::regclass);
 6   ALTER TABLE public.task ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            &           2604    16509 
   user_tb id    DEFAULT     h   ALTER TABLE ONLY public.user_tb ALTER COLUMN id SET DEFAULT nextval('public.user_tb_id_seq'::regclass);
 9   ALTER TABLE public.user_tb ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219            �          0    16499    group_tb 
   TABLE DATA           1   COPY public.group_tb (id, groupname) FROM stdin;
    public          postgres    false    217   �       �          0    16556    task 
   TABLE DATA           P   COPY public.task (id, description, files, status, weekday, user_id) FROM stdin;
    public          postgres    false    221   �       �          0    16506    user_tb 
   TABLE DATA           Z   COPY public.user_tb (id, name, surname, patronymic, email, role, group_tb_id) FROM stdin;
    public          postgres    false    219          �           0    0    group_tb_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.group_tb_id_seq', 3, true);
          public          postgres    false    216            �           0    0    task_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.task_id_seq', 1, false);
          public          postgres    false    220            �           0    0    user_tb_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.user_tb_id_seq', 5, true);
          public          postgres    false    218            )           2606    16504    group_tb group_tb_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.group_tb
    ADD CONSTRAINT group_tb_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.group_tb DROP CONSTRAINT group_tb_pkey;
       public            postgres    false    217            -           2606    16563    task task_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.task DROP CONSTRAINT task_pkey;
       public            postgres    false    221            +           2606    16513    user_tb user_tb_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.user_tb
    ADD CONSTRAINT user_tb_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.user_tb DROP CONSTRAINT user_tb_pkey;
       public            postgres    false    219            /           2606    16564    task task_user_id_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.user_tb(id);
 @   ALTER TABLE ONLY public.task DROP CONSTRAINT task_user_id_fkey;
       public          postgres    false    221    4651    219            .           2606    16514     user_tb user_tb_group_tb_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_tb
    ADD CONSTRAINT user_tb_group_tb_id_fkey FOREIGN KEY (group_tb_id) REFERENCES public.group_tb(id);
 J   ALTER TABLE ONLY public.user_tb DROP CONSTRAINT user_tb_group_tb_id_fkey;
       public          postgres    false    219    4649    217            �   %   x�3估�b�����p�!����`����� P      �      x������ � �      �   �   x�3�0���[.6\�za'煉6\츰�������e�^�n�L�K)J��OJ,���,�/3200p�M���+*弰�ہ�7\�xa�Ŧ��v\��i�e�b�!�M�X�2�k�!�9��b���� �{2     