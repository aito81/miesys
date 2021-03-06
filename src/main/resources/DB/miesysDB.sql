PGDMP         "                x           miesysDB    12.1    12.1 �    1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            4           1262    18292    miesysDB    DATABASE     �   CREATE DATABASE "miesysDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Paraguay.1252' LC_CTYPE = 'Spanish_Paraguay.1252';
    DROP DATABASE "miesysDB";
                postgres    false            �            1259    18639    tenencia    TABLE     p   CREATE TABLE public.tenencia (
    tenencia integer NOT NULL,
    descripcion character varying(30) NOT NULL
);
    DROP TABLE public.tenencia;
       public         heap    postgres    false            �            1259    18637    Tenencia_tenencia_seq    SEQUENCE     �   CREATE SEQUENCE public."Tenencia_tenencia_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."Tenencia_tenencia_seq";
       public          postgres    false    245            5           0    0    Tenencia_tenencia_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public."Tenencia_tenencia_seq" OWNED BY public.tenencia.tenencia;
          public          postgres    false    244            �            1259    18677    barrio    TABLE     �   CREATE TABLE public.barrio (
    barrio integer NOT NULL,
    ciudad integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.barrio;
       public         heap    postgres    false            �            1259    18675    barrio_barrio_seq    SEQUENCE     �   CREATE SEQUENCE public.barrio_barrio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.barrio_barrio_seq;
       public          postgres    false    249            6           0    0    barrio_barrio_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.barrio_barrio_seq OWNED BY public.barrio.barrio;
          public          postgres    false    248            �            1259    18293    cabildo    TABLE     �   CREATE TABLE public.cabildo (
    cabildo integer NOT NULL,
    descripcion character varying NOT NULL,
    region integer NOT NULL
);
    DROP TABLE public.cabildo;
       public         heap    postgres    false            �            1259    18299    cabildo_id_cabildo_seq    SEQUENCE     �   CREATE SEQUENCE public.cabildo_id_cabildo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.cabildo_id_cabildo_seq;
       public          postgres    false    202            7           0    0    cabildo_id_cabildo_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.cabildo_id_cabildo_seq OWNED BY public.cabildo.cabildo;
          public          postgres    false    203            �            1259    18301    ciudad    TABLE     �   CREATE TABLE public.ciudad (
    ciudad integer NOT NULL,
    departamento integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.ciudad;
       public         heap    postgres    false            �            1259    18307    ciudad_id_ciudad_seq    SEQUENCE     �   CREATE SEQUENCE public.ciudad_id_ciudad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.ciudad_id_ciudad_seq;
       public          postgres    false    204            8           0    0    ciudad_id_ciudad_seq    SEQUENCE OWNED BY     J   ALTER SEQUENCE public.ciudad_id_ciudad_seq OWNED BY public.ciudad.ciudad;
          public          postgres    false    205            �            1259    18309    departamento    TABLE     t   CREATE TABLE public.departamento (
    departamento integer NOT NULL,
    descripcion character varying NOT NULL
);
     DROP TABLE public.departamento;
       public         heap    postgres    false            �            1259    18315    departamento_departamento_seq    SEQUENCE     �   CREATE SEQUENCE public.departamento_departamento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.departamento_departamento_seq;
       public          postgres    false    206            9           0    0    departamento_departamento_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.departamento_departamento_seq OWNED BY public.departamento.departamento;
          public          postgres    false    207            �            1259    18317 	   direccion    TABLE     �   CREATE TABLE public.direccion (
    direccion integer NOT NULL,
    persona integer NOT NULL,
    descripcion character varying NOT NULL,
    laboral boolean NOT NULL,
    barrio integer
);
    DROP TABLE public.direccion;
       public         heap    postgres    false            �            1259    18323    direccion_id_direccion_seq    SEQUENCE     �   CREATE SEQUENCE public.direccion_id_direccion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.direccion_id_direccion_seq;
       public          postgres    false    208            :           0    0    direccion_id_direccion_seq    SEQUENCE OWNED BY     V   ALTER SEQUENCE public.direccion_id_direccion_seq OWNED BY public.direccion.direccion;
          public          postgres    false    209            �            1259    18325    distrito    TABLE     �   CREATE TABLE public.distrito (
    distrito integer NOT NULL,
    cabildo integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.distrito;
       public         heap    postgres    false            �            1259    18331    distrito_id_distrito_seq    SEQUENCE     �   CREATE SEQUENCE public.distrito_id_distrito_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.distrito_id_distrito_seq;
       public          postgres    false    210            ;           0    0    distrito_id_distrito_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.distrito_id_distrito_seq OWNED BY public.distrito.distrito;
          public          postgres    false    211            �            1259    18333    division    TABLE     l   CREATE TABLE public.division (
    division integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.division;
       public         heap    postgres    false            �            1259    18339    division_id_division_seq    SEQUENCE     �   CREATE SEQUENCE public.division_id_division_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.division_id_division_seq;
       public          postgres    false    212            <           0    0    division_id_division_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.division_id_division_seq OWNED BY public.division.division;
          public          postgres    false    213            �            1259    18341    empresa    TABLE     j   CREATE TABLE public.empresa (
    empresa integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.empresa;
       public         heap    postgres    false            �            1259    18347    empresa_id_empresa_seq    SEQUENCE     �   CREATE SEQUENCE public.empresa_id_empresa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.empresa_id_empresa_seq;
       public          postgres    false    214            =           0    0    empresa_id_empresa_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.empresa_id_empresa_seq OWNED BY public.empresa.empresa;
          public          postgres    false    215            �            1259    18349    estado_civil    TABLE     t   CREATE TABLE public.estado_civil (
    estado_civil integer NOT NULL,
    descripcion character varying NOT NULL
);
     DROP TABLE public.estado_civil;
       public         heap    postgres    false            �            1259    18355     estado_civil_id_estado_civil_seq    SEQUENCE     �   CREATE SEQUENCE public.estado_civil_id_estado_civil_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.estado_civil_id_estado_civil_seq;
       public          postgres    false    216            >           0    0     estado_civil_id_estado_civil_seq    SEQUENCE OWNED BY     b   ALTER SEQUENCE public.estado_civil_id_estado_civil_seq OWNED BY public.estado_civil.estado_civil;
          public          postgres    false    217            �            1259    18357    estudio    TABLE     j   CREATE TABLE public.estudio (
    estudio integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.estudio;
       public         heap    postgres    false            �            1259    18363    estudio_estudio_seq    SEQUENCE     �   CREATE SEQUENCE public.estudio_estudio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.estudio_estudio_seq;
       public          postgres    false    218            ?           0    0    estudio_estudio_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.estudio_estudio_seq OWNED BY public.estudio.estudio;
          public          postgres    false    219            �            1259    18365    genero    TABLE     h   CREATE TABLE public.genero (
    genero integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.genero;
       public         heap    postgres    false            �            1259    18371    genero_genero_seq    SEQUENCE     �   CREATE SEQUENCE public.genero_genero_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.genero_genero_seq;
       public          postgres    false    220            @           0    0    genero_genero_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.genero_genero_seq OWNED BY public.genero.genero;
          public          postgres    false    221            �            1259    18373    han    TABLE     �   CREATE TABLE public.han (
    han integer NOT NULL,
    distrito integer NOT NULL,
    descripcion character varying NOT NULL,
    direccion character varying,
    cantidad_miembros integer,
    barrio integer
);
    DROP TABLE public.han;
       public         heap    postgres    false            �            1259    18379    han_id_han_seq    SEQUENCE     �   CREATE SEQUENCE public.han_id_han_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.han_id_han_seq;
       public          postgres    false    222            A           0    0    han_id_han_seq    SEQUENCE OWNED BY     >   ALTER SEQUENCE public.han_id_han_seq OWNED BY public.han.han;
          public          postgres    false    223            �            1259    18381    nacionalidad    TABLE     t   CREATE TABLE public.nacionalidad (
    nacionalidad integer NOT NULL,
    descripcion character varying NOT NULL
);
     DROP TABLE public.nacionalidad;
       public         heap    postgres    false            �            1259    18387     nacionalidad_id_nacionalidad_seq    SEQUENCE     �   CREATE SEQUENCE public.nacionalidad_id_nacionalidad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.nacionalidad_id_nacionalidad_seq;
       public          postgres    false    224            B           0    0     nacionalidad_id_nacionalidad_seq    SEQUENCE OWNED BY     b   ALTER SEQUENCE public.nacionalidad_id_nacionalidad_seq OWNED BY public.nacionalidad.nacionalidad;
          public          postgres    false    225            �            1259    18389 	   ocupacion    TABLE     n   CREATE TABLE public.ocupacion (
    ocupacion integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.ocupacion;
       public         heap    postgres    false            �            1259    18395    ocupacion_id_ocupacion_seq    SEQUENCE     �   CREATE SEQUENCE public.ocupacion_id_ocupacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.ocupacion_id_ocupacion_seq;
       public          postgres    false    226            C           0    0    ocupacion_id_ocupacion_seq    SEQUENCE OWNED BY     V   ALTER SEQUENCE public.ocupacion_id_ocupacion_seq OWNED BY public.ocupacion.ocupacion;
          public          postgres    false    227            �            1259    18397    perfil    TABLE     h   CREATE TABLE public.perfil (
    perfil integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.perfil;
       public         heap    postgres    false            �            1259    18403    perfil_perfil_seq    SEQUENCE     �   CREATE SEQUENCE public.perfil_perfil_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.perfil_perfil_seq;
       public          postgres    false    228            D           0    0    perfil_perfil_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.perfil_perfil_seq OWNED BY public.perfil.perfil;
          public          postgres    false    229            �            1259    18405    persona    TABLE     �  CREATE TABLE public.persona (
    persona integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    tipo_documento integer,
    numero_documento character varying,
    nacionalidad integer NOT NULL,
    estado_civil integer,
    cantidad_hijos integer,
    ocupacion integer,
    fecha_nacimiento date,
    empresa integer,
    fecha_inicio date,
    division integer,
    han integer,
    genero integer NOT NULL,
    miembro_con integer
);
    DROP TABLE public.persona;
       public         heap    postgres    false            �            1259    18411    persona_id_persona_seq    SEQUENCE     �   CREATE SEQUENCE public.persona_id_persona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.persona_id_persona_seq;
       public          postgres    false    230            E           0    0    persona_id_persona_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.persona_id_persona_seq OWNED BY public.persona.persona;
          public          postgres    false    231            �            1259    18413    recomendado    TABLE     �   CREATE TABLE public.recomendado (
    recomendado integer NOT NULL,
    persona integer NOT NULL,
    recomendador1 integer,
    recomendador2 integer
);
    DROP TABLE public.recomendado;
       public         heap    postgres    false            �            1259    18416    recomendado_id_recomendado_seq    SEQUENCE     �   CREATE SEQUENCE public.recomendado_id_recomendado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.recomendado_id_recomendado_seq;
       public          postgres    false    232            F           0    0    recomendado_id_recomendado_seq    SEQUENCE OWNED BY     ^   ALTER SEQUENCE public.recomendado_id_recomendado_seq OWNED BY public.recomendado.recomendado;
          public          postgres    false    233            �            1259    18656    region    TABLE     h   CREATE TABLE public.region (
    region integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public.region;
       public         heap    postgres    false            �            1259    18654    region_region_seq    SEQUENCE     �   CREATE SEQUENCE public.region_region_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.region_region_seq;
       public          postgres    false    247            G           0    0    region_region_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.region_region_seq OWNED BY public.region.region;
          public          postgres    false    246            �            1259    18418    reunion    TABLE     �   CREATE TABLE public.reunion (
    reunion integer NOT NULL,
    han integer NOT NULL,
    estudio integer,
    fecha date NOT NULL,
    persona integer,
    cantidad_participantes integer
);
    DROP TABLE public.reunion;
       public         heap    postgres    false            �            1259    18421    reunion_asistencia    TABLE     �   CREATE TABLE public.reunion_asistencia (
    reunion_asistencia integer NOT NULL,
    reunion integer NOT NULL,
    persona integer NOT NULL
);
 &   DROP TABLE public.reunion_asistencia;
       public         heap    postgres    false            �            1259    18424 )   reunion_asistencia_reunion_asistencia_seq    SEQUENCE     �   CREATE SEQUENCE public.reunion_asistencia_reunion_asistencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 @   DROP SEQUENCE public.reunion_asistencia_reunion_asistencia_seq;
       public          postgres    false    235            H           0    0 )   reunion_asistencia_reunion_asistencia_seq    SEQUENCE OWNED BY     w   ALTER SEQUENCE public.reunion_asistencia_reunion_asistencia_seq OWNED BY public.reunion_asistencia.reunion_asistencia;
          public          postgres    false    236            �            1259    18426    reunion_reunion_seq    SEQUENCE     �   CREATE SEQUENCE public.reunion_reunion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.reunion_reunion_seq;
       public          postgres    false    234            I           0    0    reunion_reunion_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.reunion_reunion_seq OWNED BY public.reunion.reunion;
          public          postgres    false    237            �            1259    18428    telefono    TABLE     �   CREATE TABLE public.telefono (
    telefono integer NOT NULL,
    descripcion character varying NOT NULL,
    laboral boolean NOT NULL,
    persona integer NOT NULL
);
    DROP TABLE public.telefono;
       public         heap    postgres    false            �            1259    18434    telefono_id_telefono_seq    SEQUENCE     �   CREATE SEQUENCE public.telefono_id_telefono_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.telefono_id_telefono_seq;
       public          postgres    false    238            J           0    0    telefono_id_telefono_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.telefono_id_telefono_seq OWNED BY public.telefono.telefono;
          public          postgres    false    239            �            1259    18436    tipo_documento    TABLE     x   CREATE TABLE public.tipo_documento (
    tipo_documento integer NOT NULL,
    descripcion character varying NOT NULL
);
 "   DROP TABLE public.tipo_documento;
       public         heap    postgres    false            �            1259    18442 $   tipo_documento_id_tipo_documento_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_documento_id_tipo_documento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.tipo_documento_id_tipo_documento_seq;
       public          postgres    false    240            K           0    0 $   tipo_documento_id_tipo_documento_seq    SEQUENCE OWNED BY     j   ALTER SEQUENCE public.tipo_documento_id_tipo_documento_seq OWNED BY public.tipo_documento.tipo_documento;
          public          postgres    false    241            �            1259    18444    usuario    TABLE     �   CREATE TABLE public.usuario (
    usuario integer NOT NULL,
    persona integer NOT NULL,
    perfil integer,
    descripcion character varying NOT NULL,
    clave character varying NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    18450    usuario_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.usuario_usuario_seq;
       public          postgres    false    242            L           0    0    usuario_usuario_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.usuario_usuario_seq OWNED BY public.usuario.usuario;
          public          postgres    false    243            4           2604    18680    barrio barrio    DEFAULT     n   ALTER TABLE ONLY public.barrio ALTER COLUMN barrio SET DEFAULT nextval('public.barrio_barrio_seq'::regclass);
 <   ALTER TABLE public.barrio ALTER COLUMN barrio DROP DEFAULT;
       public          postgres    false    248    249    249                       2604    18452    cabildo cabildo    DEFAULT     u   ALTER TABLE ONLY public.cabildo ALTER COLUMN cabildo SET DEFAULT nextval('public.cabildo_id_cabildo_seq'::regclass);
 >   ALTER TABLE public.cabildo ALTER COLUMN cabildo DROP DEFAULT;
       public          postgres    false    203    202                       2604    18453    ciudad ciudad    DEFAULT     q   ALTER TABLE ONLY public.ciudad ALTER COLUMN ciudad SET DEFAULT nextval('public.ciudad_id_ciudad_seq'::regclass);
 <   ALTER TABLE public.ciudad ALTER COLUMN ciudad DROP DEFAULT;
       public          postgres    false    205    204                       2604    18454    departamento departamento    DEFAULT     �   ALTER TABLE ONLY public.departamento ALTER COLUMN departamento SET DEFAULT nextval('public.departamento_departamento_seq'::regclass);
 H   ALTER TABLE public.departamento ALTER COLUMN departamento DROP DEFAULT;
       public          postgres    false    207    206                        2604    18455    direccion direccion    DEFAULT     }   ALTER TABLE ONLY public.direccion ALTER COLUMN direccion SET DEFAULT nextval('public.direccion_id_direccion_seq'::regclass);
 B   ALTER TABLE public.direccion ALTER COLUMN direccion DROP DEFAULT;
       public          postgres    false    209    208            !           2604    18456    distrito distrito    DEFAULT     y   ALTER TABLE ONLY public.distrito ALTER COLUMN distrito SET DEFAULT nextval('public.distrito_id_distrito_seq'::regclass);
 @   ALTER TABLE public.distrito ALTER COLUMN distrito DROP DEFAULT;
       public          postgres    false    211    210            "           2604    18457    division division    DEFAULT     y   ALTER TABLE ONLY public.division ALTER COLUMN division SET DEFAULT nextval('public.division_id_division_seq'::regclass);
 @   ALTER TABLE public.division ALTER COLUMN division DROP DEFAULT;
       public          postgres    false    213    212            #           2604    18458    empresa empresa    DEFAULT     u   ALTER TABLE ONLY public.empresa ALTER COLUMN empresa SET DEFAULT nextval('public.empresa_id_empresa_seq'::regclass);
 >   ALTER TABLE public.empresa ALTER COLUMN empresa DROP DEFAULT;
       public          postgres    false    215    214            $           2604    18459    estado_civil estado_civil    DEFAULT     �   ALTER TABLE ONLY public.estado_civil ALTER COLUMN estado_civil SET DEFAULT nextval('public.estado_civil_id_estado_civil_seq'::regclass);
 H   ALTER TABLE public.estado_civil ALTER COLUMN estado_civil DROP DEFAULT;
       public          postgres    false    217    216            %           2604    18460    estudio estudio    DEFAULT     r   ALTER TABLE ONLY public.estudio ALTER COLUMN estudio SET DEFAULT nextval('public.estudio_estudio_seq'::regclass);
 >   ALTER TABLE public.estudio ALTER COLUMN estudio DROP DEFAULT;
       public          postgres    false    219    218            &           2604    18461    genero genero    DEFAULT     n   ALTER TABLE ONLY public.genero ALTER COLUMN genero SET DEFAULT nextval('public.genero_genero_seq'::regclass);
 <   ALTER TABLE public.genero ALTER COLUMN genero DROP DEFAULT;
       public          postgres    false    221    220            '           2604    18462    han han    DEFAULT     e   ALTER TABLE ONLY public.han ALTER COLUMN han SET DEFAULT nextval('public.han_id_han_seq'::regclass);
 6   ALTER TABLE public.han ALTER COLUMN han DROP DEFAULT;
       public          postgres    false    223    222            (           2604    18463    nacionalidad nacionalidad    DEFAULT     �   ALTER TABLE ONLY public.nacionalidad ALTER COLUMN nacionalidad SET DEFAULT nextval('public.nacionalidad_id_nacionalidad_seq'::regclass);
 H   ALTER TABLE public.nacionalidad ALTER COLUMN nacionalidad DROP DEFAULT;
       public          postgres    false    225    224            )           2604    18464    ocupacion ocupacion    DEFAULT     }   ALTER TABLE ONLY public.ocupacion ALTER COLUMN ocupacion SET DEFAULT nextval('public.ocupacion_id_ocupacion_seq'::regclass);
 B   ALTER TABLE public.ocupacion ALTER COLUMN ocupacion DROP DEFAULT;
       public          postgres    false    227    226            *           2604    18465    perfil perfil    DEFAULT     n   ALTER TABLE ONLY public.perfil ALTER COLUMN perfil SET DEFAULT nextval('public.perfil_perfil_seq'::regclass);
 <   ALTER TABLE public.perfil ALTER COLUMN perfil DROP DEFAULT;
       public          postgres    false    229    228            +           2604    18466    persona persona    DEFAULT     u   ALTER TABLE ONLY public.persona ALTER COLUMN persona SET DEFAULT nextval('public.persona_id_persona_seq'::regclass);
 >   ALTER TABLE public.persona ALTER COLUMN persona DROP DEFAULT;
       public          postgres    false    231    230            ,           2604    18467    recomendado recomendado    DEFAULT     �   ALTER TABLE ONLY public.recomendado ALTER COLUMN recomendado SET DEFAULT nextval('public.recomendado_id_recomendado_seq'::regclass);
 F   ALTER TABLE public.recomendado ALTER COLUMN recomendado DROP DEFAULT;
       public          postgres    false    233    232            3           2604    18659    region region    DEFAULT     n   ALTER TABLE ONLY public.region ALTER COLUMN region SET DEFAULT nextval('public.region_region_seq'::regclass);
 <   ALTER TABLE public.region ALTER COLUMN region DROP DEFAULT;
       public          postgres    false    246    247    247            -           2604    18468    reunion reunion    DEFAULT     r   ALTER TABLE ONLY public.reunion ALTER COLUMN reunion SET DEFAULT nextval('public.reunion_reunion_seq'::regclass);
 >   ALTER TABLE public.reunion ALTER COLUMN reunion DROP DEFAULT;
       public          postgres    false    237    234            .           2604    18469 %   reunion_asistencia reunion_asistencia    DEFAULT     �   ALTER TABLE ONLY public.reunion_asistencia ALTER COLUMN reunion_asistencia SET DEFAULT nextval('public.reunion_asistencia_reunion_asistencia_seq'::regclass);
 T   ALTER TABLE public.reunion_asistencia ALTER COLUMN reunion_asistencia DROP DEFAULT;
       public          postgres    false    236    235            /           2604    18470    telefono telefono    DEFAULT     y   ALTER TABLE ONLY public.telefono ALTER COLUMN telefono SET DEFAULT nextval('public.telefono_id_telefono_seq'::regclass);
 @   ALTER TABLE public.telefono ALTER COLUMN telefono DROP DEFAULT;
       public          postgres    false    239    238            2           2604    18642    tenencia tenencia    DEFAULT     x   ALTER TABLE ONLY public.tenencia ALTER COLUMN tenencia SET DEFAULT nextval('public."Tenencia_tenencia_seq"'::regclass);
 @   ALTER TABLE public.tenencia ALTER COLUMN tenencia DROP DEFAULT;
       public          postgres    false    245    244    245            0           2604    18471    tipo_documento tipo_documento    DEFAULT     �   ALTER TABLE ONLY public.tipo_documento ALTER COLUMN tipo_documento SET DEFAULT nextval('public.tipo_documento_id_tipo_documento_seq'::regclass);
 L   ALTER TABLE public.tipo_documento ALTER COLUMN tipo_documento DROP DEFAULT;
       public          postgres    false    241    240            1           2604    18472    usuario usuario    DEFAULT     r   ALTER TABLE ONLY public.usuario ALTER COLUMN usuario SET DEFAULT nextval('public.usuario_usuario_seq'::regclass);
 >   ALTER TABLE public.usuario ALTER COLUMN usuario DROP DEFAULT;
       public          postgres    false    243    242            .          0    18677    barrio 
   TABLE DATA           =   COPY public.barrio (barrio, ciudad, descripcion) FROM stdin;
    public          postgres    false    249   q�       �          0    18293    cabildo 
   TABLE DATA           ?   COPY public.cabildo (cabildo, descripcion, region) FROM stdin;
    public          postgres    false    202   +�                0    18301    ciudad 
   TABLE DATA           C   COPY public.ciudad (ciudad, departamento, descripcion) FROM stdin;
    public          postgres    false    204   ��                0    18309    departamento 
   TABLE DATA           A   COPY public.departamento (departamento, descripcion) FROM stdin;
    public          postgres    false    206   ��                0    18317 	   direccion 
   TABLE DATA           U   COPY public.direccion (direccion, persona, descripcion, laboral, barrio) FROM stdin;
    public          postgres    false    208   ��                0    18325    distrito 
   TABLE DATA           B   COPY public.distrito (distrito, cabildo, descripcion) FROM stdin;
    public          postgres    false    210   ��      	          0    18333    division 
   TABLE DATA           9   COPY public.division (division, descripcion) FROM stdin;
    public          postgres    false    212   ��                0    18341    empresa 
   TABLE DATA           7   COPY public.empresa (empresa, descripcion) FROM stdin;
    public          postgres    false    214   �                0    18349    estado_civil 
   TABLE DATA           A   COPY public.estado_civil (estado_civil, descripcion) FROM stdin;
    public          postgres    false    216   P�                0    18357    estudio 
   TABLE DATA           7   COPY public.estudio (estudio, descripcion) FROM stdin;
    public          postgres    false    218   ��                0    18365    genero 
   TABLE DATA           5   COPY public.genero (genero, descripcion) FROM stdin;
    public          postgres    false    220   ��                0    18373    han 
   TABLE DATA           _   COPY public.han (han, distrito, descripcion, direccion, cantidad_miembros, barrio) FROM stdin;
    public          postgres    false    222   ��                0    18381    nacionalidad 
   TABLE DATA           A   COPY public.nacionalidad (nacionalidad, descripcion) FROM stdin;
    public          postgres    false    224   $�                0    18389 	   ocupacion 
   TABLE DATA           ;   COPY public.ocupacion (ocupacion, descripcion) FROM stdin;
    public          postgres    false    226   M�                0    18397    perfil 
   TABLE DATA           5   COPY public.perfil (perfil, descripcion) FROM stdin;
    public          postgres    false    228   ��                0    18405    persona 
   TABLE DATA           �   COPY public.persona (persona, nombre, apellido, tipo_documento, numero_documento, nacionalidad, estado_civil, cantidad_hijos, ocupacion, fecha_nacimiento, empresa, fecha_inicio, division, han, genero, miembro_con) FROM stdin;
    public          postgres    false    230   ��                0    18413    recomendado 
   TABLE DATA           Y   COPY public.recomendado (recomendado, persona, recomendador1, recomendador2) FROM stdin;
    public          postgres    false    232   ��      ,          0    18656    region 
   TABLE DATA           5   COPY public.region (region, descripcion) FROM stdin;
    public          postgres    false    247   ��                0    18418    reunion 
   TABLE DATA           `   COPY public.reunion (reunion, han, estudio, fecha, persona, cantidad_participantes) FROM stdin;
    public          postgres    false    234   �                 0    18421    reunion_asistencia 
   TABLE DATA           R   COPY public.reunion_asistencia (reunion_asistencia, reunion, persona) FROM stdin;
    public          postgres    false    235   $�      #          0    18428    telefono 
   TABLE DATA           K   COPY public.telefono (telefono, descripcion, laboral, persona) FROM stdin;
    public          postgres    false    238   A�      *          0    18639    tenencia 
   TABLE DATA           9   COPY public.tenencia (tenencia, descripcion) FROM stdin;
    public          postgres    false    245   ��      %          0    18436    tipo_documento 
   TABLE DATA           E   COPY public.tipo_documento (tipo_documento, descripcion) FROM stdin;
    public          postgres    false    240   ��      '          0    18444    usuario 
   TABLE DATA           O   COPY public.usuario (usuario, persona, perfil, descripcion, clave) FROM stdin;
    public          postgres    false    242   �      M           0    0    Tenencia_tenencia_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."Tenencia_tenencia_seq"', 4, true);
          public          postgres    false    244            N           0    0    barrio_barrio_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.barrio_barrio_seq', 1, false);
          public          postgres    false    248            O           0    0    cabildo_id_cabildo_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.cabildo_id_cabildo_seq', 13, true);
          public          postgres    false    203            P           0    0    ciudad_id_ciudad_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.ciudad_id_ciudad_seq', 1, false);
          public          postgres    false    205            Q           0    0    departamento_departamento_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.departamento_departamento_seq', 1, false);
          public          postgres    false    207            R           0    0    direccion_id_direccion_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.direccion_id_direccion_seq', 12, true);
          public          postgres    false    209            S           0    0    distrito_id_distrito_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.distrito_id_distrito_seq', 26, true);
          public          postgres    false    211            T           0    0    division_id_division_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.division_id_division_seq', 4, true);
          public          postgres    false    213            U           0    0    empresa_id_empresa_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.empresa_id_empresa_seq', 10, true);
          public          postgres    false    215            V           0    0     estado_civil_id_estado_civil_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.estado_civil_id_estado_civil_seq', 1, false);
          public          postgres    false    217            W           0    0    estudio_estudio_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.estudio_estudio_seq', 3, true);
          public          postgres    false    219            X           0    0    genero_genero_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.genero_genero_seq', 1, false);
          public          postgres    false    221            Y           0    0    han_id_han_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.han_id_han_seq', 59, true);
          public          postgres    false    223            Z           0    0     nacionalidad_id_nacionalidad_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.nacionalidad_id_nacionalidad_seq', 1, true);
          public          postgres    false    225            [           0    0    ocupacion_id_ocupacion_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.ocupacion_id_ocupacion_seq', 12, true);
          public          postgres    false    227            \           0    0    perfil_perfil_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.perfil_perfil_seq', 1, false);
          public          postgres    false    229            ]           0    0    persona_id_persona_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.persona_id_persona_seq', 11, true);
          public          postgres    false    231            ^           0    0    recomendado_id_recomendado_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.recomendado_id_recomendado_seq', 1, false);
          public          postgres    false    233            _           0    0    region_region_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.region_region_seq', 2, true);
          public          postgres    false    246            `           0    0 )   reunion_asistencia_reunion_asistencia_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.reunion_asistencia_reunion_asistencia_seq', 97, true);
          public          postgres    false    236            a           0    0    reunion_reunion_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.reunion_reunion_seq', 15, true);
          public          postgres    false    237            b           0    0    telefono_id_telefono_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.telefono_id_telefono_seq', 11, true);
          public          postgres    false    239            c           0    0 $   tipo_documento_id_tipo_documento_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.tipo_documento_id_tipo_documento_seq', 1, false);
          public          postgres    false    241            d           0    0    usuario_usuario_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.usuario_usuario_seq', 1, true);
          public          postgres    false    243            `           2606    18644    tenencia Tenencia_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tenencia
    ADD CONSTRAINT "Tenencia_pkey" PRIMARY KEY (tenencia);
 B   ALTER TABLE ONLY public.tenencia DROP CONSTRAINT "Tenencia_pkey";
       public            postgres    false    245            d           2606    18685    barrio barrio_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.barrio
    ADD CONSTRAINT barrio_pkey PRIMARY KEY (barrio);
 <   ALTER TABLE ONLY public.barrio DROP CONSTRAINT barrio_pkey;
       public            postgres    false    249            6           2606    18474    cabildo cabildo_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cabildo
    ADD CONSTRAINT cabildo_pkey PRIMARY KEY (cabildo);
 >   ALTER TABLE ONLY public.cabildo DROP CONSTRAINT cabildo_pkey;
       public            postgres    false    202            8           2606    18476    ciudad ciudad_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (ciudad);
 <   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT ciudad_pkey;
       public            postgres    false    204            :           2606    18478    departamento departamento_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (departamento);
 H   ALTER TABLE ONLY public.departamento DROP CONSTRAINT departamento_pkey;
       public            postgres    false    206            <           2606    18480    direccion direccion_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT direccion_pkey PRIMARY KEY (direccion);
 B   ALTER TABLE ONLY public.direccion DROP CONSTRAINT direccion_pkey;
       public            postgres    false    208            >           2606    18482    distrito distrito_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.distrito
    ADD CONSTRAINT distrito_pkey PRIMARY KEY (distrito);
 @   ALTER TABLE ONLY public.distrito DROP CONSTRAINT distrito_pkey;
       public            postgres    false    210            @           2606    18484    division division_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.division
    ADD CONSTRAINT division_pkey PRIMARY KEY (division);
 @   ALTER TABLE ONLY public.division DROP CONSTRAINT division_pkey;
       public            postgres    false    212            B           2606    18486    empresa empresa_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (empresa);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            postgres    false    214            D           2606    18488    estado_civil estado_civil_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT estado_civil_pkey PRIMARY KEY (estado_civil);
 H   ALTER TABLE ONLY public.estado_civil DROP CONSTRAINT estado_civil_pkey;
       public            postgres    false    216            F           2606    18490    estudio estudio_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.estudio
    ADD CONSTRAINT estudio_pkey PRIMARY KEY (estudio);
 >   ALTER TABLE ONLY public.estudio DROP CONSTRAINT estudio_pkey;
       public            postgres    false    218            H           2606    18492    genero genero_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (genero);
 <   ALTER TABLE ONLY public.genero DROP CONSTRAINT genero_pkey;
       public            postgres    false    220            J           2606    18494    han han_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY public.han
    ADD CONSTRAINT han_pkey PRIMARY KEY (han);
 6   ALTER TABLE ONLY public.han DROP CONSTRAINT han_pkey;
       public            postgres    false    222            L           2606    18496    nacionalidad nacionalidad_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.nacionalidad
    ADD CONSTRAINT nacionalidad_pkey PRIMARY KEY (nacionalidad);
 H   ALTER TABLE ONLY public.nacionalidad DROP CONSTRAINT nacionalidad_pkey;
       public            postgres    false    224            N           2606    18498    ocupacion ocupacion_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.ocupacion
    ADD CONSTRAINT ocupacion_pkey PRIMARY KEY (ocupacion);
 B   ALTER TABLE ONLY public.ocupacion DROP CONSTRAINT ocupacion_pkey;
       public            postgres    false    226            P           2606    18500    perfil perfil_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (perfil);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public            postgres    false    228            R           2606    18502    persona persona_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (persona);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    230            T           2606    18504    recomendado recomendado_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_pkey PRIMARY KEY (recomendado);
 F   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_pkey;
       public            postgres    false    232            b           2606    18664    region region_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.region
    ADD CONSTRAINT region_pkey PRIMARY KEY (region);
 <   ALTER TABLE ONLY public.region DROP CONSTRAINT region_pkey;
       public            postgres    false    247            X           2606    18506 *   reunion_asistencia reunion_asistencia_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.reunion_asistencia
    ADD CONSTRAINT reunion_asistencia_pkey PRIMARY KEY (reunion_asistencia);
 T   ALTER TABLE ONLY public.reunion_asistencia DROP CONSTRAINT reunion_asistencia_pkey;
       public            postgres    false    235            V           2606    18508    reunion reunion_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_pkey PRIMARY KEY (reunion);
 >   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_pkey;
       public            postgres    false    234            Z           2606    18510    telefono telefono_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.telefono
    ADD CONSTRAINT telefono_pkey PRIMARY KEY (telefono);
 @   ALTER TABLE ONLY public.telefono DROP CONSTRAINT telefono_pkey;
       public            postgres    false    238            \           2606    18512 "   tipo_documento tipo_documento_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_pkey PRIMARY KEY (tipo_documento);
 L   ALTER TABLE ONLY public.tipo_documento DROP CONSTRAINT tipo_documento_pkey;
       public            postgres    false    240            ^           2606    18514    usuario usuario_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    242            �           2606    18686    barrio barrio_ciudad_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.barrio
    ADD CONSTRAINT barrio_ciudad_fkey FOREIGN KEY (ciudad) REFERENCES public.ciudad(ciudad);
 C   ALTER TABLE ONLY public.barrio DROP CONSTRAINT barrio_ciudad_fkey;
       public          postgres    false    204    2872    249            e           2606    18665    cabildo cabildo_region_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cabildo
    ADD CONSTRAINT cabildo_region_fkey FOREIGN KEY (region) REFERENCES public.region(region) NOT VALID;
 E   ALTER TABLE ONLY public.cabildo DROP CONSTRAINT cabildo_region_fkey;
       public          postgres    false    247    202    2914            f           2606    18515    ciudad ciudad_departamento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_departamento_fkey FOREIGN KEY (departamento) REFERENCES public.departamento(departamento) NOT VALID;
 I   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT ciudad_departamento_fkey;
       public          postgres    false    2874    206    204            h           2606    18697    direccion direccion_barrio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT direccion_barrio_fkey FOREIGN KEY (barrio) REFERENCES public.barrio(barrio) NOT VALID;
 I   ALTER TABLE ONLY public.direccion DROP CONSTRAINT direccion_barrio_fkey;
       public          postgres    false    2916    208    249            g           2606    18525 #   direccion direccion_id_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT direccion_id_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 M   ALTER TABLE ONLY public.direccion DROP CONSTRAINT direccion_id_persona_fkey;
       public          postgres    false    230    2898    208            i           2606    18530 !   distrito distrito_id_cabildo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.distrito
    ADD CONSTRAINT distrito_id_cabildo_fkey FOREIGN KEY (cabildo) REFERENCES public.cabildo(cabildo) NOT VALID;
 K   ALTER TABLE ONLY public.distrito DROP CONSTRAINT distrito_id_cabildo_fkey;
       public          postgres    false    210    202    2870            k           2606    18692    han han_barrio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.han
    ADD CONSTRAINT han_barrio_fkey FOREIGN KEY (barrio) REFERENCES public.barrio(barrio) NOT VALID;
 =   ALTER TABLE ONLY public.han DROP CONSTRAINT han_barrio_fkey;
       public          postgres    false    222    2916    249            j           2606    18535    han han_id_distrito_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.han
    ADD CONSTRAINT han_id_distrito_fkey FOREIGN KEY (distrito) REFERENCES public.distrito(distrito) NOT VALID;
 B   ALTER TABLE ONLY public.han DROP CONSTRAINT han_id_distrito_fkey;
       public          postgres    false    2878    222    210            l           2606    18540    persona persona_division_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_division_fkey FOREIGN KEY (division) REFERENCES public.division(division) NOT VALID;
 G   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_division_fkey;
       public          postgres    false    212    230    2880            m           2606    18545    persona persona_empresa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_empresa_fkey FOREIGN KEY (empresa) REFERENCES public.empresa(empresa) NOT VALID;
 F   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_empresa_fkey;
       public          postgres    false    2882    230    214            n           2606    18550 !   persona persona_estado_civil_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_estado_civil_fkey FOREIGN KEY (estado_civil) REFERENCES public.estado_civil(estado_civil) NOT VALID;
 K   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_estado_civil_fkey;
       public          postgres    false    216    230    2884            o           2606    18555    persona persona_genero_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_genero_fkey FOREIGN KEY (genero) REFERENCES public.genero(genero) NOT VALID;
 E   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_genero_fkey;
       public          postgres    false    220    230    2888            p           2606    18560    persona persona_han_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_han_fkey FOREIGN KEY (han) REFERENCES public.han(han) NOT VALID;
 B   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_han_fkey;
       public          postgres    false    222    230    2890            t           2606    18645     persona persona_miembro_con_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_miembro_con_fkey FOREIGN KEY (miembro_con) REFERENCES public.tenencia(tenencia) NOT VALID;
 J   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_miembro_con_fkey;
       public          postgres    false    230    2912    245            q           2606    18565 !   persona persona_nacionalidad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_nacionalidad_fkey FOREIGN KEY (nacionalidad) REFERENCES public.nacionalidad(nacionalidad) NOT VALID;
 K   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_nacionalidad_fkey;
       public          postgres    false    2892    230    224            r           2606    18570    persona persona_ocupacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_ocupacion_fkey FOREIGN KEY (ocupacion) REFERENCES public.ocupacion(ocupacion) NOT VALID;
 H   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_ocupacion_fkey;
       public          postgres    false    2894    226    230            s           2606    18575 #   persona persona_tipo_documento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_tipo_documento_fkey FOREIGN KEY (tipo_documento) REFERENCES public.tipo_documento(tipo_documento) NOT VALID;
 M   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_tipo_documento_fkey;
       public          postgres    false    240    2908    230            u           2606    18580 '   recomendado recomendado_id_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_id_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 Q   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_id_persona_fkey;
       public          postgres    false    230    2898    232            v           2606    18585 -   recomendado recomendado_id_recomendador1_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_id_recomendador1_fkey FOREIGN KEY (recomendador1) REFERENCES public.persona(persona) NOT VALID;
 W   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_id_recomendador1_fkey;
       public          postgres    false    232    2898    230            w           2606    18590 -   recomendado recomendado_id_recomendador2_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_id_recomendador2_fkey FOREIGN KEY (recomendador2) REFERENCES public.persona(persona) NOT VALID;
 W   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_id_recomendador2_fkey;
       public          postgres    false    2898    232    230            {           2606    18595 2   reunion_asistencia reunion_asistencia_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion_asistencia
    ADD CONSTRAINT reunion_asistencia_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 \   ALTER TABLE ONLY public.reunion_asistencia DROP CONSTRAINT reunion_asistencia_persona_fkey;
       public          postgres    false    230    2898    235            |           2606    18600 2   reunion_asistencia reunion_asistencia_reunion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion_asistencia
    ADD CONSTRAINT reunion_asistencia_reunion_fkey FOREIGN KEY (reunion) REFERENCES public.reunion(reunion) NOT VALID;
 \   ALTER TABLE ONLY public.reunion_asistencia DROP CONSTRAINT reunion_asistencia_reunion_fkey;
       public          postgres    false    2902    235    234            x           2606    18605    reunion reunion_estudio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_estudio_fkey FOREIGN KEY (estudio) REFERENCES public.estudio(estudio) NOT VALID;
 F   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_estudio_fkey;
       public          postgres    false    2886    218    234            y           2606    18610    reunion reunion_han_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_han_fkey FOREIGN KEY (han) REFERENCES public.han(han) NOT VALID;
 B   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_han_fkey;
       public          postgres    false    2890    222    234            z           2606    18615    reunion reunion_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 F   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_persona_fkey;
       public          postgres    false    2898    230    234            }           2606    18620    telefono telefono_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.telefono
    ADD CONSTRAINT telefono_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 H   ALTER TABLE ONLY public.telefono DROP CONSTRAINT telefono_persona_fkey;
       public          postgres    false    2898    238    230            ~           2606    18625    usuario usuario_perfil_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_perfil_fkey FOREIGN KEY (perfil) REFERENCES public.perfil(perfil) NOT VALID;
 E   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_perfil_fkey;
       public          postgres    false    228    2896    242                       2606    18630    usuario usuario_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 F   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_persona_fkey;
       public          postgres    false    230    2898    242            .      x���˒$�r-6����59�m �aTVtUTef$�Qd��^QG2�ty�(RfW3����@?�	���k9� "�7ig��N"�p �c��f:��m^�������O��o��$�{r���������������:�Ƨ���p��q7��6R6��6^���ԥ�l���s�=y���*/�O=����z�RS���?Ǘ���ܾ����d���˸���p��OF�yNW���u�]�'���i�|�'!i{��<���fi���p�N�|P����n��|7]���v���e�|N���d�h��k8���U8{����|9�'<h-	���z�^nOօߟ�0f��,��v��t��<�>����d[���i�7u��O����>YO>t�n�O����ys�oON[����!���n�Wt��?��x~r.}D�ٜ��'W��j�=9m����6r����$�v���|��ON���0�к:h�v��I���H�"�N_B4$���*Q����o��S���AE䩚���*Y7�	�3�y�ͪ�⋨�~Ou���-�hW�I�������o�rTtiTS�_��$"><5�����P`Q�ƒԭq��M�Mϧ�exj�H��}j�<�����o��?��i�����?�M����y4�$�×��K�[����S����㰗�ͬ�*ǫ0!z4�N��rp��}\���o�}Ȁ9�7��&%
�8��Om�4���(�ڢ���1��/2S\Fm�'��)��./��3p�U�%��L������r��T��zӦ��s�9��͛��S^W��Vn��N"��!��4�VV��h��u�A�·���2��$\��W������������.��-�g�#��]k�t��o©oH�v�ߒ���)�w�-ʈ��=~��3�G;�N8���j��������q:� ��zK��x��7��,o�L�O�c��,}�I?���)hi �-��=�ǧ�����2p=�v��i>Ks|����WF����FR��x���d��L�Rt�R�Z��?�����BRNn2gM�릪�c2���T)'���u<���TmN|���>�])���re{����,��lv�e>�P����q��i�؆l1Ƅ�Iy�Q~~��8��O�(�1ʑL}G��	C�\��Q���F&�^ԑ��%�aI�b*��z����ƞDa��A&܈԰���.`��4K*��Ic���T���U!����*T�bL����:]�L���oG��j��	s���@�m��O���8m��lgB�|�N�������,#�����Ȗ�����n�6=h�6�i��]�Y�� �g[��E#��o��+��^�W��5�4j���Q�0��β�[iH.�5���߽v���/��p!6$|N�hi��6��D�r!6w��I�z2�P_������s����%�2n���;�Z�dZ�b�?)�R�_�&^�4����1�Џfac���|R�X&W�(���B���>����|{�n�-GR��^�����{����K��j�1}J۟eқ�Jm��M�m7o��������;��.}B���k��>U9?���B��72Χ�Qh[�l���aO��8J���0�:��2�ǝ2q��:~��<"������JZM���t�I�\��+2щV�6/��%D�"�
X�����/�[ =���G�Y�������%2j���5A�X��;_k!�e7@��j�Mnq��l�x��7j��ƥRj�z�b��.��˚��k��:�Y����׿���7#2Wa����Z�{eR�,�Xiz�4�� E!��[Uٳ�H�J���z�B	I9{�=7�E<��<B�I����*'�mH�Ț;�P�X�sJ>E[,���)�xVI?{��ƍ�-�uo�ȓ�V(�����X��B(�~��i��TA����E�(K��^g�4w��em�qk��hdw��#4V�w{�uo:�kM�W�T\�"1SZkIQ���y|��&L��3�ю_b)@iD0�K�tts�.₟6V����·Z�*>ߑT������ʶd3@w����}>ݎ򓫾�sN��k��V�I s�Y(������ݴ����+KD�'��������&s�@6Y�歓��}e@W7Z}�i�)�/�$�Uz�f��J/S�E!���U(+�|)�:K�Pd�#���`��u���>m�-��PcY�-V�@M]/TO��h����>Y��Y��[��Ɣ�B.d�����L��&���/nUlj��~��?DqĮ�I�z�����$=�!3�:��<˼|
>(AhT�۰�ɀG�n�>o��D1`�@Wa1��:������ e2Ӎ� 8�`@�M�D���%����u�l�t�sǊa�P����i?�E>�t�bV�J����}��urqHoI�6E|TD$6�[nZ�Vl�H��%FH�^^���bx�z$XT�ЌM�Y��A*���*��_��@�b���,*y��Dѹ��R���
*����Z(���E*�2鿮]�n���%ݪ�2ͯ|į
h�M�W5(;�#�9�f��� ��z�(쳦��S�U`S�,�?�,��ü�=��'�:}H�&��sy�9#�ʃ9��/J��-�"~�J\�&	�F�H����t��Ǣv��\��7���h���>,�Ci�vb��xk��s��$}�wP-e����_'L���e�kyB������9͛�����;����/�,�bQ��I[̩T3Ѳ�ɉI*�����_?N�l,7bK�Y*����U��T�����nU�����LL�q��zU,�o�D��o��6'� jd��6����J�WW�XUw1*ekr�Oo�{g�D;{��M�4fIQ/YK�Q~���`�qK}k�d����w��4x�iV��u2�^D�~l>��K�u�c΀pM�*h�`�_�M��,hj�~�:�p&P���Ī-�E-���+���瀝���F��$�Q��Bs�q����B��^�	N�6
�!y��9��ޒ)_x�/{�<	�Cn�E/���������K������Ǵ۹�y�d��ͤ�ڢ�w���c��<��Տ�-�욇lI�J�.oy��4�1�G�Yţ������	&�sA�]��҉O���7�G�_��7֦(�1�>9-�E��*��񆾬�PV����c��;�]�7�������,O>����n��*Gs���4xOff�/��E�	�V��q,o����M�6>r��!�ú
�s�Κ�s8�PC�i���ٮQn��V���+M�Z��5~y�tb�D��,@���2�]�k�D���,o��SH��f��j���t���
m�0D�0�j����=V�z	Q0F��-de��V��Ydí����ͮ�F4{+���T�o���u��e�s�]4��cӱy�Z��[��S~�读�.JdG�Il�3U�4����|���6���SUcF���O��)�Y �M6�0?�O��1؇O�m8�rB	�T|�[�;��H-��&��j����F_;aWr�{��2#�y�(���և��2<��Ic�o�^�h�/��AvXX���`4}KJ��E{e@�hQ�=�돰���f�b2Y�lB���r��Q
lO�<O�M��J78��Y}�]�>�H~,��*Auxxo�MY�;R8���vutQß��d���g��\�j����K7O�t���Ü�J�#�� u��Շ5��uզǃ}UWʒj�rD^��T~>e+H�6���m��/�d� ����1�q�D�M��lm�Ԟ0q�F��fN[Ys&L]��G����*[�>�![-2��-�:(�n�pj�0Mּ�H�#�4\w2�`�׶^�6��v�\3�y,{4�f]������R�}\E��Y] �/��X3�G�,B&�=",zdz�����i-M,Z�W����s�J�����/��7����±�VLHI�s/2�e7��W��jTOZ1yˮl�/���p�����T�U�}�^_�@7��=�P�Z��� {0�Y�K��t�u]���Oرuݤ���ke��8���	�d~�mS�]�������t�lw�g)���������*    �h6ՍI�x�T76�L�i�O�WP��p@W7Kg�l����e��p�3�n�$�3�'#�K��vL�z�]7�~F��`ElG�Vh&�Qp?���'�O^4�n��Y�^pU�m���ܢ��fU*$e��2G����D+V&��g�H��UQ�uW�wm�Gnݙ\�~�����Gh��ݑ���I撝X�u�tP��G�ٵ�Q,�GY�&��]�*�?߆���z�9��SA�x]9(��T�1e�r8�2ʧ}E��^/�Y����E��aQ�joIȕ�;������!�I�פ}�D8RU}�U��m��ch�I�)�bQ�:��OOi�>Q�l�W����+#5�������V�������*@��b��%Р�w5��F@�p	!�b@<'~{�Ʃ��g<��XFq�PYV�Π�$��݆Yw��{p/(MAt�Н6wFH���:e.��A5��e[Z�����Bk�O�&��72�a�[ҦR��[�G��Y�|hC�H���T��(6��HCMu�1&���}�2����'�q�In��p,���Z�lײA�N�1�#l�՘6�&ͽ���RSh�5f����h���4.7#���<��1^�lͪ,�I�?���3}I���E?���qlc]ֵ!$�ց��v�ˬ5�;%@ӊϻ��i4�[�3ĩ�`%o�Z8�V���q�k���)Ĺq*�{c�l�h�tn�%,����'�kN�p.�:�12�|�HU��_�q���;�2��q}�aOM��灦���*��Ԭ����Kǥ��:�4�5�6�������tU�]��hs�M�yw�X�Zۭ�{i�l��
�t�;4�B��Mc� 1�4�^����4���V=�蛦�S��X�����w�49q�-?�8}~b��j5�4�,J1�2�MC��n>�5�i���Ǻq����j�R�����4��L��Ui�F�S>�J��ۼ	��M����"���\iQ5m�7:�v=�nWU�v=����Sӭ����0��n=����<�;�G��rt:�ܪ�n��We�Z�f��q�M�>n��x������A�����t�n-*���#�T6wK�ZX����Շ������Ϗ��!��~:I�ZX��/�V���	1S�BEdk���������DC�PF)b�����F�_٥}D>��#���H��#P�6o�z:�ʚEC��S����eQ�D�P߆� R��A�w�}BS��2�{M߯�mn�з���r��������7D'��-F`[ٻW�c[���0���r)�%Ӄ��3h��ڪͅ�x�0/l�#w�m��㳭|�b��U��x�Q����֘U��ޓNC$bk�{Rz�N����X�A����$�;���$����II~ ٘���ܖiy�f�����ĝq�ӱ���N2�P��F�6�)#[�H�'�1����RV�����6���ak��ҵ>UM/V~�T/"s��h�S�����c<�m��/�u�Ț�٥%0Z�����[�<��i[�u�+C������#��do#SS�%y�f�(UwE��%Qb�鰔��֘�䫰����-l��ZS������k���a�ia<Ii����:ta��E����H�2�>�Q��g��V<cid8h�=�ӞHl�O)kT��mT G������
c��iW<#埡�\b��P�(�j�fk��b(4]&ߺ��C��Uk��֗�D���L4�]w���`&�)�t��>�0Z�dRC��-f��q�a��1&E�g�S\�[by}�%���Ԑ� V��!�vgEkZr�Mv�LH���o��ew��p��fԢ3o?FYBV	� �+�LB�wU��4P:�F�,��w�2Eќ�**j��IM�i3<3���\�����0N/�	+y��Y�d"��;�A�f�mV]E��g��ȮS1<���+P~��{��U�k: ����֛�v���W��hd��T�?"h�`�?^�������M�U��B|��!���2�Ǜ����3�������a`�E�W.�ޭ6) �hNo�Oӿ�vC�Ȫwy�r0��uQ0�>e��N�W���oa?q�X�_�m��;lY|��,�peD�/Q"(gW��i���U�T�DW�����W%�ʥV�pyl�Pp���^F���N�N�r�tU��6v9�^�������}��0�:�K�V��3�Q���F *s<��5�{42�^�\�6�d�Rg:|�6�f���F�w��]���G��l�^�F�˧m9˥�]���i�b�6[�m�I�Ő��ّȤ�/�L��R�OZ�N�έ�W�2�e��
�#����n5�f>�AJ])��|W?R�B�.hH<�;M��Ϲ�ҖJ��ޕ�Ot��BO�X�z�:h�u����"ۓ=|�ؤ��/cYpsG3�}�M�YB�ӭ//���q��JGc�}��/[�I��V�S�[��m:!���o>o!|���[ay�hQ�oL��G�Ѧt�V�k����H�b1�]S/L�$΢�5�U��5��r�58-�Ư���V]�0�r��Z�c٬w��g;6�UN�ۏ�Uv���k��0���+�掩��6����J�i5���f/4Z3�K��^hWW���f�;J����;�H�:4�ޓ'S�����50-w�/k~]l�Q������vM�uX�5�';ڋͷa�]��h*"�m�G��SG3�I}�����؄��竰>��ZG1��:�^uަm��/F7[G���^�W��t���Ŏ&a�M��ߥ�E?�x�;��e�핫����S�P,0����m���ĭ�[+K����ЀK�t}�jL��Q:�\TPvՊ�	vخ���=f����{�`x�F�6�G��2������+���{���l"�����T�O�[B 6V-	i�C�t�-� �+���Ӗ� ;r�����C^H_[��������e��#��T�t���w�p�6o�Шp|:�(�?o�u�x���"�q1�R̨7���:"ޔ���+��Lj��SY��]j���Uͭ�g���m�+Έ钕�/�!@�6IJ�vx�&J�*V�{��nU.$�H��m����V].�y����i
{�{�w����޻�r�6�c	��Ny��7{Wg�-3�w�j!,�ƥû���).�tr�z�Ǿ�c7���u:ou_�UF6�����W����oW����
�����F�nU�g�������!�2<��)j/�`N�k����ʢ�����[��x�a+�&��R�Y�N4�`�)��O=yd+:�<�+��0��w�f�\K�Y��Z�`ⱁo�{}�SB�(��e�7�l�72�W��M�<��o�(�������[�K3X[���Y�U��omz,*]�<P��X���6��]H���aB�w���o�C-i�z����0>�3��s�,�i���#)=����F��#�1��e<K�l��a",L��*��%�p��֘U����T �:��.?{������G�z��`AD�z -Q���MyT������t�oը.^'e���1�SY���TƔx��Q�=.ky��,`z��E��{elm����}��_x���)����7�S���}�l�;)���I�e�ާ����E��ة���
Z_����+e�4��w����{ !+�:|h9�����}���瑵=|]R����r�q1��r�����C�N~��o�6����ã�S��Ĩ�^�D6vS�=��eI��*���B��r	O�2�]�s��Z�ᩒ&'5����e�	m����?aO�����r� 3�u'�����x�	� s��'���f���1�=qb)��'BC��d��jR��0y"R����?3�rv�;�s�\��������Z�۾,|��9�,�ޙ�^v��;�*?��]`wOq�1\�o +o���)C�`؏���i2��b{��;��d?L_�%n��DP�]�S��_ˎ��=]]7���`ھ���S�x_��5��[���$�`����MP��7��%]~:���G�}XMm�� ���u��}���B�F��Qfu���g!����P�v�Ӎc"���g2�4M"Fة�iW���.2���}���    �P?�u����S����а��y�pO�DI�҅�HXV��VI� �z�$�7Ċ�nRtM��-:Y�m��ɯ��Q��i��ib�E��r�.�1eO{�M��3�RĽ����]y�-�w.q�X�}�LC�[3������]�5C�ў�	=#�u�	���/�F�(�c���#6p�	�gO�����POO�o�{�x�<�`T{	�?O����RFh����>�#�7��N�絮��.-"����J��c̫V�g����0Q��u�N�p�#���-��wy`�,)`6���ˬ{��o�^��Iӥz���i��B��,DOb� �۴/�3}z&B|U�d�e�	Ő���k�]S�N���!�@�X/���l�=���vEuT�m�LJA�O�="$`U)_fD�C1�Y���)ŉ�����������kΥ�������lp+��f�i]��sʻ����u�Tes��G<S�j���	e�R��HG�B���]����f�	�����͋FB�ݕ��,+{��S {9K��E�����5�vZ3H�fE���n�!T�}xowAMJZ�V(H_E(�8	���P-��󍠎�S�� ��[XK��D8}�kW,���1�%ko���O���CB���r<q�X~�Q�[mM�,F0��6�>~��,���zB�j�Z&���[)�3!����O�Rݮ��r�8�Q����Xh��h����t�8��3��*��j�J����	g�wy�p�*:^ոU=��PE�m��و棨Yw��ap���R��i\g�>�tٶf�K��502�Da�p�O(	HMTO��}>)(��lq������pL�	q�O�x�ܩ�㇦�`���N��x��6�v�-B�V��'T���y&4��K.�r".�(G1�V��Q��*0���-)U����5�	ԳA�߇�8n:�Tх�"�ꕸx'��`4�F��G��O�k���:�S��I��&��/;Pũ����
�v:��4��,{�. ��Ůބ{�(	�Ŕ�Wvҍd�� W �� S,�P���_H��G4;�\va|e��}�HQ�f�g��{^p �}�W��ǕC�-�����@OH݃������N��~UE����XB�.�0��:A�D�.�
�"�vQ����Bl����޵*��x��]"oK�/�������W���JHn\�A���	���y��!�_NumU�����,�X�Ey�6fU@I7�(��
d���;����<'���p���h).�cӄ�	����=����0��t��=���y[q���on߱9�،�~1��WE��hG��K'%VT��;"�(�w�ȺS4�f=��	����w��}?�������3���'"�G�5��_U��:����(xY���Z�b�0R���+Lx�G�<�k��]�� �E^�z�kww�.���r�����\eGI���X|�]BFHۄq�X��x;�أ�'[7Q��I�P���~��Ņa4�V��Hir5���{.�z�qp"~G��5�p%�����ɪ#踶A��	8O��r�7� ��&���
q�Aȥt��xc5���j��x�_���<��*�!Ty1�Q��Q6��qsQĿ^�7�!,k�Z�����D� ��䄿ѻ��),���	�OM|��фҨ�¦�o }�̯�*�� ���-�N5�υ�1C�o~�|:�'����N�)� ���?����P�=cU6��CP����o��k��Nʅ��aT?q��'P��Ц�uOItq��Ětm¥/M�E�ޜ ������M'������A��d�"F]J��@t[&
�.0.v'�.M�i@<ut��� vjJΣ9H��������Ϡ*���S@��ԇ��}`����3Ս�]W�׌7YA����6[��]=�X���c��݇���xW�u���4�,�*�߲���Sxm��c�[FC',�z()��Ә��~�*��n�ٱ��^b�������f(~�/[uA���c�R�`a�_���#�u5�p3kG�^\���1}/�����!HR��p����[s>�g��nu���ܯd%ۄ���*ka�*�����*����~h�H�2�ɝ9�k��� g�&}{g�o���6����f���_����|�������e�Ql�u���ܭ�(��nQ[.k� ���3i-i�!�/2o���!ܼ/ϭ�����:��PY��Cz_d�  }��b��V�{`�Z۔z>�-PFŠC���xY����cW$�2�*��춶-Jj!�uժLWY4p:�E؞�A�HE*m�ׯV]��+��bק����&�����a��y�0VT���a%��i��;J��o�萃�HHBN�1��F�?a�q�}P�+q��	�����b�H���?|y�m~b�l_�D�/��dX��#.2��g{����:��Q	\�M'G�IY � ����EշUbB�˞�0�UNX���D,{ğ��@�a ~#0�h P�e�^��|>�0�������szE� 7����X��0���M��E)|h�ޏ7��_r��;jT��hZC=d�!*��r$���Ȱ�Ͱ�p � �7��^s ��)�`�v�(T�N�K`�1b��x��Kf�CUXj��׍N��˰y��3�/���yآ�`�Qh���B ���bB�2�g�/����<�.L՚oE���U�$ ��0� 4������C������b a��Ӭd��g��!�t֐�dzB�>b����Yg l̼q�C�,�oаӋ�	��&��mR�����}:S���>�!��������,F���_��A��M}�^�IC���{!���0��o.�s�Hq}�^�� �9��ڄIG�#���x8�P��Ĭ)�zk��j�@&S����|��PpiC�v��
g��6N{Ќ>Ӑ�bb���0��ܪ����`�*}�9�6��/��YC�v)��a'���z~�#-�1�h�,:��'~+�b���70h�A�����b;��Z.�.�����^6{<_�'L����|A�����Ly��|���5���cغ�]*w����
���jq����W�N�c������1oY��G':{��;J�I�G�c�/ �sF.�X�^׆G�Д���m><_�:V�����2��0�m�h��1�������{��;�P旗W����Xq��"��~
��qY[�
�S��e)� }�Ay�}`��^���������*����Bή]��b�h�F����(���n�v��q�_�W]�J��cDJףb+���'p��X,��^ָ}��r�K}��
��a������}�!*23��]�vH�d��bLr�DP�8$��ɹ� Z��C$����<J'|烞��eT��:aj!�X,�^8b3�i|����tۅA߯����p��,��m޾�W��>#���N��yc��٘���#iN�f/�D�/_#�N6k!�9��r�����qH4�
B3VO�VTm<���X��Wy����~fԴqm.S�:�ti�W��l��>v#W(T�R�2�ת����Ua�8G�W�N�
f'���m�B�U�5�c�Oͮ�:S(�4cj���̵B6c,���%�.�Fdb���^��,����\[�������uW�AQ0�0PA�#u��/���H'd_wf�?haG����Q����h������Mv*�C��_�}�h����*�������\6~���e�t� �?z���m:"�+2هI�	��m��reV2C��>�uA�nQ�X/���ɍ�ۙ�����̎]�M��2,AĽ��^j��QmmP���;�z���]�?����띑*f�jU-mK/,6�b�cMZf��\n�'�e%F��vs��;�n!�տ�'={�nQ�YWY0���R9���ɮa<���e�����g3��r���Ȋs� QpUv�-ө�y\]�?��L8b��2L�3�&PU��ߗ����	>ě0�/;f�c3�eC��*���q���2�    3�ҝ�o�M۷�2Y�[J����~��s����~��eF�8�[+ۢ��)~��l�D+�A�g�1HG�����l�Ty����R0'�JDg��@��8��v���k)?�gPo-��(����q�T�e�S���tx����Z�?�
�ԸS'�n|ᣅ�w��"Y_��l�_J�[���y���b��X��qf0���u��3^���=�e�,+N��K� �]�0q�y�(�(Py<8�e�):�WXl�
���kKU��%ǟ��L�]�$^dP_.�a��<_��
����4}�a�e��'鬟Ȥ�9��Q�L����9���9�fFH���7?3#d��	�A��l�A�Q��i	T���&�,	}y��0GB�y]�0E����<�� ���s,���.i�Z��Zg&������k����d1mU~m��iܫ#�Y� a=Q?�����G�{��^�z��V�w̃�ž[�$��}���9`��_/�%�\�����hr�z��%S�n==���E�{�f�3�����P����p}��k�"Jydr�k�r]O]�� �dH���B1���#n2DDS����z&�E��~-͢�X��eD��_XZOӈ������#ex@͵�͛����\�1�_w@�w���w+��6�5��[���]�;8��~-z` ���Bii��k9�MR�\e��5�6Q���P�y@jݯ%�s:� �T�����G�`OQ�sݿ��b怙{����\pW��b넛H ޯ#N�#�"��8pEbr�0��Is9�V���v̍!�h��g�ʰy04Sb�MD�����n�0%����L�a��$�1�F<��l���1�L�(;�0��Cə��yZ�ai7̄�ڐ�`���9�+_�gU'F�0��$}� rf��@�a�[dx1Lp!��t"�Ek� ����UϹ��B�~J�^ii!��P�3(#������N�4�_!����ɧz�����*�o�� F�RX~I��V3G��x"��X�l:��"G�B	N���B(7=oD֊#���_!?��yBL�Mrd(߳"�H���i�e�J��*���R��1��A.!�I��jA.4��c��]�Q�|m4u"��A>H-��^����\���2t��4�X��!�E������dJ����n�$����"���"�,!�J���dm>!{X�n����!�E[�TL�����BP=j��\YV ���mzB��T��i��gZ[�`R���"}>��Gn��u%��b����1�5�4��+��m3=�A��8e�<�٢�AwE�6����i�EC+9,�����l��� ۲��d��J'�M� _��B!������Ė0~ŀD�B|%���n����KK��Sd�X�}ǉ'�����M:殺����F�goyZ�O!�|�Lg� �D�')3�'Q(��wIi��~�^��m�M�z���J����ҵ ��5���O�}}?��: /<��o~��+�PL/;QUQ������K.�� ��h�p}�A%?�36~��H!Ѯ���Gu�T�G���PH֌���Lk�0D���1��7XU�FZǰ���L�`�A�Lё0"iAX!1d��;�,V_d�ȖF����@	��\�l�2�M��d�ZS>�e�L�'�\biD��"�Ĳꕫ��ڌ�і`v���D�;��<��ຜ���4�jĴ�5�)����G�PyѢUK�r���r@-��VW����L���oJ��U�F�}|ީ4��߹�|X!�iժQ��X�e���,fZ��٭�V���e)����������݀Qc(W�u��R?���A�m�w=�Ε�]{ftv�Q4h>�O�0�8�K<P[�+v��u�V����Ȕ��_x��ժ=��6I�6��6��U��>}cKF��m�Z�ۜ-5��ݮZ*m�24>B���U��M��L�6��(�vmW�P����V-�,��b���]��Ý�⩑�B�ʘZ�b��
"}E�v"L-���g����:уm!�X�k�_����e�,x�&��u��a��z^�)��⮆��JE���l�.�Q��������O���X�^����}�ت��B2�E�<�A>�@�)�i~��h"3��Dj3HK�2u��ф�E���Fl�x�	D�ϋE��,4��B���0�����f�� ���{_�=A��l���"�L˝W��6~H=��'������\Bk���D�	�����UK��)!����િ�܇�#�g�o�lxz��j�(B
�#9�-6�B��oN�Bh��p�U,s�C��M��� -���H�f��sd~�u���Q��!��F&�@R�R8����TXdjP�^�*� !��~0���a�*�0����������B6��c��A~*�L����\����A+�(��]�]h�zG���2�#�<�WhM1@q#?�"��R*����bH��fW�I�ـ�8���_lA�v�T�C6����;e��s���	�]`1�'���t?]I���t����c8�#�>��o������<A�2?�&𫿀36H��,wː#!�4h(�#$Z�>@v���;\s����@�t}&�H�(���k2��X"8
����nUjr{�����y�G�z�N]�<ey�>�M��2y(IX��h��\�L�L#mB�BY�A�Rrnh����?�ß�֐[ĤQ����J��ވ�l�B!��jF
�\B�22(���7��ٻ��3E�-�P@���I��!�󧢘 [B�[%薸*!c��s�pZ��%
xF�t0�$U��pE����2��F�؍�����ʹR�8�AM�[}�AX���4��=�M��"R �Z�o��� BkV�H��7��!)���2��8A�:�X�A��5S�����d}���$�#���B��v��6�]Ж�@H:�)��_b�Q]}�뱌��WK�T���E�4�x�-���G.LOyii�����:��|a>�<χ0��UF΍~�6���T���P����jp�[� ��T�qj��=�e��I�t˛µG���n�c>e6�z���j�j�!A�5
����IKt��#�A����<��S�'��g�g���^$1h��(�_P�t ��x�E6m�r���)7:{�� mK���ǎ4鱫RȠf�{��!�ЏM�T6_b?�<sVDr��ٌ�D�h�
7/���� �&6�O���CJF0N���V�1	{�J�7k֡^M�l��j�̻�U��Ws&6U^��A�!�zEG�W���Vi�.Dc�R4a �ܖY�(P�ސ��C����"5c>��6�v��׹�R�WAbQ@j��ѹ�u�f����z�r��f>�̄��W;%�^�#m�% t��J2ًuZܒ�4y4=y�Q�A�VJ1㟾��B�r������^��e���:�	�N�g�ח6a�r��*a�=��#��y�Z�.y�� I@��v�$�
ݪ0� QX���Ҩ�)�4Bˌ~$h�(�ߞ��e�y/����!�.��> �?��H ��d
)�N�c�@S����|���t�7moyH��0��1�$�y��l���l���絿F\��Y����XgRSg-�+h@Gh�i�(��En�� I9�� %@��<1H ����Y�/�� @{�Gk�����9�n�l�QlFYg�۩��=������d���m81B ��xcG~��&ap����[
:=�����T�<r|!@T���ŏ��+����؁�� �?{ghOӁ�F�W��jH����m
M/`�_p(�Et����.��>)��B��m����%�����0�	��:܍��4�I�-/ #������l�iH��oyF[�l��D�	d����،��l�dc1o�����榶6�t<��n)�7,��9�t/�<"s�,fJwwچ����%rtCj�L��k� 2	��ca�>@�)���x�����&�;
�x��,Y!�BБ)�[�\"@����l�}8�"k@V�+J    �NDY�]��ukqJ w@!�9�����{"��߶ee`��T5mL��U�'h:d(J�b4�n`��y��[���x�s����ݝ+Y�J�fJ`�w�[���7�)	���`�N1j:z�q��u��Пb�t�g��s���O��Gу��H�#ݫM���$O����tN��<���3$�r�q��5���}����e�<R�d\1�4���rt.-*�с|R���"���0ဍ�r�]a���gK���
ʌ�_�nwڸ�lU���i�j��Mmf��A�T��_`�f�.�j�,�\6%K1L4`�\?څ�\Mۅ�h2�}h�1����,�M�T�8JV�t"3�tm���3�X1BM�Ȁ��h�H+ Dd�<}��Ē:TO|�,Эp��I@�����m��k��1Ĕ��b3x،��
6���rG$�	-����#+1ՎA���ͳY���>	��8�L��2?�xw��6�C���Kn�=@z T�g�� �L����sD�t�m�;��!�HM5$����$8d�<��S��! �}�RC6�6�GƸ!d"ݖ�16?�F" ^��T�-O��!�ӑ��8�!�c&}Y�^��f�/e"�+~��q+v���?@N����CI�h� �GQ�����������`��_ߖ_�����/~c<�J� ��a�X���w<��v�V��J%�+�!�9]����(�!�]<[�fն��1��T�_p�3�B+�UU�s[����������Ղ�/l�}�����HI������_��Bv$�c����uj}�8���V�5�&Z`�/�a�6#T�w����6�6c�� d��wd3�a���V���԰*n',��!�P��9�a�K9���[Z��ŋ,\_��a�.1�i, �;�7g��m�H� �!��_~#g׉�� � ��n���)V�[b$���t�,&xm	�Q����Z���G�4L�-�q�\���BϷ�]�7k��nl�i�@��S�.�P� 2RƄ|����#�f�}�xz! )I�~���%&YU ��	�l��:���@���oܯX 죯�S�9|��ė.���>���탕�X)X`�����Y��]�Ϡ�`�xܲ���[nԟQ����%�/_h�h�������`��5��� �В��K�CܤM�ٵee C��v~QP��i8�d��e��z�ic��߭`#O7�����ʲ/�琣�&�Ɇw�-@�Ef��/��A��,�u�O��R���C�e|Ǥ��B�ҋ����_j,A����;��zi��/U�ӑ�J����Z`�-�,,v�՗�J�q��u�"&fKѮt2�2�I�/8�R��p��d���eޥ��������)��=
.{
b  p��i����gB���ch����'��f���杖jB�qbh��K��p����b�#ɟD!��A�jY�p���l�����Ks�|�n���}J����4=��W�;���i���Ui��~���w����c21����R�'�`���- ���e[����5�Y' �?�@��Y���btv����JpN4~��N���_��O,��`� X)�G�wQ+T� ��:�_8��3��-�a�~H%����� �/ڠ����Ϻx��+�)��U:$��/zLݍ�����<� ���˙`��0����^8|a��Ŕ�&G�L���%�t��3 ��F)ޮ�X?�~9�� �/z枑ږ5�@�]`7��B����/Q��Ef{6o�����8B�p�v�A�![ �wEF4������kL���Fc�/-@�/^�x 菕����{8����/��t�n��^x^建ib�.�lN��+����t/Y��k���	�]�7��}(ʪ�5 �5�kU���E�� ���<nih�_>�M�����R� ܽ�:���@��K �!&R�Yc�Ս�q����2f�|�[qD��or�"p�:����<��h<��L ��x?>4kZ.���b=C�8KC�KZX ��O��Y`�˿���h�Ђ�u�{�VWo��K�-<��>���� Y��y�4�8)�$��[ ����b���f����x}4}x�|���>q�����j�߶k��g@(�����@�Fg���<��*~��-`�!p���g�/:]�,�Z|x=�О�T' ���'D[@�/�x5{�q�h{)=m�M� �Y�ڷ1��h�FE-��m�a_H�PG�أWe��%�	d0 V�*�/��~~ѠUX�GC�~��R1��T3UYM�t�P��>�]t���b�,P��.�0��~�]�l�l�C�����s����6�+�5Y�m�:������3Lz)- �,p�H�APs�҇o�|
(�V�������{4��B�2/�˄���������ד��'���r����Y�_ögh�� J��Z�aY>#l���E=@�o������5��]��OX1��#gY]Nt�#��3?���|ݛg�E����p[��˥�� �o���� �t�n)����P9�cj�|g��(�x��^�)C<��A\��B��7@�M��+SX����.���].h߭�˹�|W�Y��w&9A`�q�!, ��x��9�=����H�5����k���u�6���(�e�~=�I�!��1�0 �NJ�vl������D2 *^��%:�e��!���{��m��?�I�#ح���*l�Z�N�4u��S[ܓb3��=�[؟=ۅ�8vp?��Q<����	&���g�"�G@���t؞�H�p��w��� ��(��ykS �����1q��;~x�i��+FQj���ۼ��zR����C�|ٴ�z�Y�0N�>��n����k�1͔��a�"�e��F]�ٮq�u��"��wM�"|�:���:z�iBZf�Y���<��s!��hSr��[}s���ʅ�A.�Tmx�p*���L܇��x4��2K�wx�q��ߝ�A��F͛�g)SQ%��mF�w�ե�K�߱�}�2E)���]H��t�����p�f$ղ�|a9`#�;H�)ĥY¼��t�~\'D���q���t��	�'�t8����:󻬬�f�X�N�d�bKcH*���{���Eܜq����(�e������]Wt�U�]�wE���3����r��?�����O,���-��K.�-5ޝfC=_)1���,��sIf.b��ܾ ���)v�a�.rw�D��+/Z��:���Zs�.���+�:��~� ,{�F�Z��C4q�:]?��i��.%�;���� �d��}pé�Q-�]������#��Ʉ�ɀ����|����G�yXu}(M��MO�j��HK7o���wz.N ����B�-0҅�2�3�_$�˥��`�NWk�Χ��[��lX@�KIܗ=pm#������[��r����i��o�0�h�%���o���֪�j�T��җB9슗�b�)V8��ri��//�X`��^
[M�m�U.��!N`�m��R]�!������r���/�<Х�i'|"˨&��)���V' �K�qB#;2s�E^=�U���r�|w�(�0`��{:�}�����Z���� ��4�=y̦xa�<�!2��P~�|a\�+އ�'�z�y�D�"[��]D�&55 �M-z�P��
���j�@���G8!�V%��X x�l͸�wɆz�P���Q��|>�Y v'U�1��LO}_�L[�m-з��&����Kb�����b��g�p� ���?�9 P;v����Y�|��b��L<��l��'���k�c��mu���ʎ"2����h�E���&6���<���Nb(��{������M���BU��N �@�K��k0���^M�^��]k�2i���uQcrx��uQ![ �j]�ݎ�V���.
 ��EO�v՞�K��HB    ^�X5È�0���1����I�I-�C W����o���$��  $=@�a,0��5�u)cė9D� Z̷A�a�E�i�T(��.�a��`�(�I���.��:�	�,���Y��O�0�|eo��27�p�Xt�ͼ�c8�$��m��h���t��b�� t��G���ŤR4{�
(H�2h�x{�� $4�K��4�L(m|��ʞF��(_� `� �gN��+>�=�>���2/�.�A�(?�gdM�@z�U@zF�ߕ��ZY���Ƭ�@�)n- ��H�	(gqB��0gl���c�ݡ���5w��SC�,T��- ��h�v�-<'��r+t�lv�|�7ƣ���(8Qol�-������iC�b? ZFc�q���"�1H�Ry����\�2�95{ ~��M��x��_���CY�Xx�@�u�	�d_�C�UW<C��������KS� d���X�%O^ӥ���:�=Y��`��b[��
`�}��t�'�0���N���"��+|�� �Xȼ��%��ufp�.V�[4/FHgh��ɸo�ݷe�2���J�v�~F~Kx���L}��Pm  ��B�0�j���e;(`6d�a	\D8>�C� ��֓���u�)uW��7����߼�h���t1�"���b���P��X��w1^��g��#�o�Z�{��t�@N�����P���\�r�/JͽÕo��8��]guډ��՜�n���+4�sO�270[�l�\��)�<�L�RJ=ﾞ�
�6� 
�<d.�`k�Z~U8h���$��W��Z"^��Jd�F��9WL��Vh�A�+�Z��!����h�S��f��A8 |����7�Xo�Q�y����h,ᰧt 3XH��8��0Xh�(Rpx,����q�H��XRP-ܠ���)���2�L��N�v<J���>},�M���lk�XR/=���b+���7F�Ң|�[WkA{Մ
�/v��X  �N��������C�.�	�i����r�G�'A]8!�r����8����˹8�~K��~��{��M�Kh�p�]�_�{���-���cJb������lڛ�':r�,=�?�҃���]��aG�>��k.OP����\ ��������uUG�پ����;2�a	r[�߮+ϗ��a#ʌ�� #�ƦD�` �7P��@d�;�AOf4�+�oc��3�oԀ�h���$?1�C66?��o!�	rH��7)����C��@�kQ�js�f=@~�ݳ|�u^+7��{7����������Ewv ����}T��l�"Z`�f*_쎀�ۭ��@�� М��7$���F癸7�\���Q}�pza=rB8�����C��wr��:b"ԣ �aV4�j7(=o��@|���d��V����� lo���'@��w��F�%�z���h����m�(;C��;���Q� ċ*�8�~�Ɩ�n9`�z�|��� 8�..g�u��b����n )�=-`�v��nw�`��j���A�d�c�+/�[��޵1�}�	�n�!:X��v}>G T7Phԃ_��$������9�W��/�ݖ��C�l~��\)HCB��P/Z���I�β2!d��B�'�C�+-�p��6� �E}�[� �BEV��$�����!;_��3������ p�f�[��9�m�sq��Z�ph��t)R�[��z�m1�E�E[O`���?��ߕ-/lQ�6�ܡ1<@�-rP��L�x��F�d�6$i]&"�#��M@j=]���X��1K�,�>s���k�	^n��-� �C��J�,�g�t���"����҇c��ѩW��h��z�Yo�2r `| ���m~Ǝ �>G��@��6��>����w���T�i��7�4�pT��4�/�>g�{,ŔŶ� Ph�ͧ[On�V�<j&Cȳ��.A z��sP(-0h�����6�z����p  �I
(�>g�Y����Eo�h�ܐ��!b��j���5p��WVLܥ��7�������W>��d�M��'_���UV���>ﴕV��lP�>�i}�����6Ʉ5^ �T��:KN��B���0�Wb#� C[�����6�"� ��������E�Ո .-u	�i��;��"�-�i9td��8j J���1���� Zt�4�>g�����h��aj4C�\���9D��V(�̡�4�5狏����@q��`�����>�b�'�?�1~1�G[��uVopi���P���%À�H
����+0}'S=Hz�k&�i�(f�mB ��odL�Y4��P�r��ea�ЂW,9?��'��zB�3��`{-pl�'�o��lp�n5�:{'J���y	�ʬPTF��/�u6�@V�P�m�1�;�lr8�ᣵ�O��@�>�2�M�Y43�� 0yeg�@�����*�bܨ��>}O���BHt�������x �N~K�j�͍+냤j���B4�����X�@Q#(듟��8;x��~t�hY
(�3�@�E�&=H�T�r"j�p�3pfў�.	��r��W���5>�ά�jJ�b4�m�H�Qi��l��SHWe*vą�	��@�M��P�R�%� ����ۯ�t���!������5n?�Z���)�[�!�����]p�sC�#��G�W�[E�~�B&x�z�:�շs����^x��3	goד�IF09�+1�~�em�b[�*޿�"Ԗ;�#�����v�m�t���.0n}��tж�}p�	`[�f� mA��k
8[OD�Tq���Җ8,����-����q�]O�}�r�m�6�ZL�hʔ�'G����0�z��S��y>-�k�r����`�˒u��@��`k�^�iO"�Jׂ Z�[L@�͹�&��M=��Ƒ���&��t�s�i�IGN�*y���v���x!RH;�hS�ûB�zҗ��˄���	P���U��"�P��C��/.;yևKQ'�X�\ }��B��J�"�Y\H�^�p#]/��&�Ѣb��aq �>���J-K��=,����iz8{�-u��Q�:mP�	�N��I��٨�Լՠv��L����\��@V�#����e=��C���/�N���f�/���S4.Ǎ�� �6�`�KW�5�5��- �%[�v�d���!е .S kAy����VEx���;��}^+{��z�����I댫�� R-h4������-�X0D� �� +2�3@�f���څOS�tP�y�$�Z9N:���28݆�5��L7�q]���aR�X�ٖo�	�.�ͪ�X[n[�7݃�����e�2w��,�]���c=��wa��6٠3u�U�'_z+��x�^���f��h�X&��,�3Ux�xo<3�w�C�����Ew_�!��iÃ�� u$��	amF����"��܄�c��=k&;6 �Y�U�+���A��Tl����/PAu�f���w*�������/Q�y�&���Rv]��"Ը�B�����i�X�K�>0�}�u �&T��j~!!_(����{�Z�8a�w+��Z��U�4�1*��fU)b�kF��P�]U��3�v}��p
({��RJ�rC����*2W2ݛ�t�?9�F��U�7
Jײ�Bb�� ��!�������,&��]6Iд���$�-��Q���7S�E!g)�8���Ѷ
�"�p,$`�{ِ?(�8�č ��A�H ?�j�BG�����q�Vq ��j�t��TL��2�����B�55���Q�������B��*�~5�1��* 0A�IZƻ�'�J���8��k�����w 
�߈�m��P1x�E�8 Fp�TZ �ї0¨T 
�*d�#�BS4��Amj @�ʁ�䟩_���}<���z�*�Kn�ð�W�6���4���ή�x�`�-��0�C������qКL��+�`]-��=$��{1s��\p�=    ��b$�l�np֦���x�섯�Ū�F[[x{ߋI����V���|ܨ�u����y���/[�"�#T�C8����0��'�p@�\��驩b�������nn�vf�8�V�?�nb`x���9dxU����z��ǫ�Z M���?��6��_�N4��o1Z�V���g`�}���V�}�i�V@���;A��s�k�M���v-O��$���]��ΛٷkaF`Q���ȝ0������[���}gs杝�5}����I�[�(_�O-�%I��2�H��<܀Vf	�¥�=��AMN+�
�)���
��Q�Ge����5a���_T�����qC����a�<����U<,V5�u�E�<�cS|��a�J��@\�Nc /Ǫ!�	�� ���C��>5��ˠ���,+��f���M�e���Cv�M>��wE��M�| �J�˺�ww�Q�S�r�T�e�: 4/�j9 3�J���m�t��\��ĥs��l則�϶,�,ƴ���͕Y����U�V'�>v�p�]�R�wNnB���*e#rDj�����V:Y� ��u�9e7~��e�{�:b7���=܉pXG�#�sQ�W�{oł��d�3p�svpw�5u��:��1�x���p�gAfw��/ߑ�o)�U�veʸ����l������\'x�}($^�o�[�s{d<���)����.��a1�]e��(�����|l5�]|W�|������#8#�]���e-GJ9��z��x~)���خ�]��<6so�?�vo�7�އ����������*��!�Mv��O�rw��Z���Q?T�Շx�3�,Wb69@;�$�t�mϚ8�� ���GQ~�����|9�?�L��P�
�_� �J�����|"u y�6�xD��bH����ԡM��B!����^y���`��x��*��� ������3V�l�1$�Ubȣ��~�� t�U���Q;Wu��r
i��nם|���_����r��Os�8i�B$��VRx>R���4~幜 �A�Ծ�v �fy�'\E#��K�M]E��{�U4���ޞ�7(M��2��HK7n�#3��Y�a��}�<Ǹ]Wy�.lW4����r��91 �U��%���*�"
�T�k��|�(���*�FZ�\��۲$��}��:{��R��2J`v�$�U}��5��tUo������E.�߮��Z}�i�����GՌG5H����bg���⚆Q&��{��1����5wp������ܙJe��t�l��x;S�X���4qS���čkf��7TS�p�U�T�dƒ����@�j��y��DT�2�B�a&bG�t?ޯ� do�RcL�*Jc��Y�`Fx<t�����F�%��;Cg݂(�l:�����/��_��/��޹��g�K7B����b;}^��Nϲ�|��D��:C7����"�*�}��X�A�hOqY^1���_`��61S�>sۍ���f�!޾�9;Jە�7��b���}|�N�9cUX�1P�lچ�a�[6�)�ET�3N9_K��U;��ޡ��j�+��z�˸��佥��2��`��E��� O|���>�,wE����1a ;S+��%gj��5�"���U��ڮڔjZ�$_�9�����e�4u�Mo�|Fyݕ�j@S��I)���0p���US��`�5��k,�;�4���:Ӹ���w�qmg�����l�@�k-^9Tfj�Tޔ�����6�(t����~�����R���I��^���4p�O*�E2��`0�Ř|�x��ij΍��7�fvE�)��ǹk/{���X\C0!R���o��\�ܙُ���-��7CZ�ggo�y�K7���8�����ǂϻSHZ���)aH�Ǩī�p�b�4�:.�y�)q�5c�(�
J��ͼ����w;deX�f^G��Lp���J�zY\G)��sܐ����4K\K3��$�Y���F9��FI><~�� �Õ�n�7����� ���� ���g��@OM��h��ՠ�+^,q�j��* N �}5/��#)J�W�=�S���Z���` Y�Vt)F�4�}Tk��ͽ���\a@DaW�)`�-m��L,��[���%��`_��Kxw�>��1�?��ݴ�ݮO�Q7�[���3�Wl���� }/��-H�}?ꚉ"
�lW�H�U�eh���R�� l��.x����>\���+���g#p�շCl�kf��~��4 �V_�� �v_u��u�0�Ϡu�z�Q��u�����@�M	z��"�k֒��Z@���?� 잀Ɗ��ޠ��z�J��.4QƁ�
��%���H�:�k��KfKt#�ȣ��N>h\���6�M�m:���r�m���E+8�~�7-�&NRx�f��ṷ�2�Q���8u�<�F�5��O�Hk���Ml7cd� �����1��k�n!,�<h���ꨆ� g��xP�5�+��3���8�Tp���p|�{Lc�%G&��G��0��f�A��Mh��éjڨ�B�w�F�8�ؔn8�,N�]���\ᫍsWy�K���rۧ�&��9?+ވ|k9y���T1����(�X�0�}��)B���ܢ���_g�"L�#�s�9���!���L?��Y�w^��qJ��+���:��Ƀ,C@�9�oNDu�ٙ����zD�^��+q�C-����%,�!Zw��;��nܽޘ��g�!�w���YX�4�wj�}�yeD;�_�ޞ�����ڊ�h�0�{]��,���r>Z�N�}B�؂�߸=[�[��``D�зN'W�̢�R���]������Y�Y�md�±�cAm|�k�p|+�,1�i�ne�"��)�)� d3ͥN���idUVd�tf2C�'�?�d�����^���A���]�����G)���W�i�N}>oJr[L���|e��y��F@Ҍ��!�]���y�݇3RnIJL@ �!�s�3��A����7����7=���]!Z�ÅTN�@�u	�z�Џ=lT�̹Y|�!j0�A�p�p�����)b����q�9�w[�۠�0޹�Q�V �AϨox�f�"����-+	��U���i�v��%������_g�sX�̘!/$��8���e~����pq)�;�0�q�L��"q#����[8�3��zl[����ʊb =ޕ|��v�y��c�>�TAa,�Ɋ$nW#y�*���[��e4�J�N!�!��2`��o��P�A�� /���8�� M��1Ϊ~i'& ��菟�Gzn�9����e��@���r.c�}��>`�K���#��S� [�cR�X*,o�ws�6 ����� |��w�q��A��4q�O('U�p#��5]��B	�c�$����}����/�d���$�ĥ�{�����'�_2��굚*D�?�����Q �)E�侲
{ŋ� O\Km;�}��(��e	`�E�u��+$&�*�� ~x�n6�>\�04EAz8eCN���W������$����'�Z�����o�9B�R9��8]��� 	G��!4�?%6 
1�E7V8�%v�gZ�ב,#�7El�'��>PpM߬-\���1d ���
�a ��� Ñڭk�/����pP>��a9�ѧ �q����  4	1,� � �uS�vi3`�a޿�3 WIԂA����e�0�p�K.�%-W�@]䎑�ߏ5���R ��<�����O�^����{V����z���0� ���"��A�I�8� �)�y~G�Bgq�u꜋�cI�Fp�Y���₇ό���P{�y������f���Wξ�R��w50��T^|s-�;�D��ҕ*xK���fWQs����E7���<$�Hr��("����H\@�*���k�X��B?�>d
:�j&�b����iE9���V�p�~�6'Zq�1�d�rk:�Ľ$
�W��P�����~�xd/�,����X���(:��A���_	��?�/����I�N���    �5t����w�����c+�%?���:�"�i�!�̓Y��ǁ��	�̕�z�*܊��|�n�Z�G�f������JQV'VKe��\I:�[�y8��|�ɋNV"K]h���-����s������*W6I�=]�f��ΏmR9�dm�W�S%�/�2���^�Щ�v�3 �+�
�����0
���<d2��D0A|xp�j�ŗTWJ���vﱫ cZ�4�_��*��j�]�A�-�a*rOz����0W�6-ކE�>C�L�^]K�`UW(\naQ�l�d{��h����v�~�F'b.���8�l�����Lg�-��ҌhnggQ�G��`l�>e��ͨ�6|�{G�� _jf�iʍ`׌������
�n��c�VT7	kǠ:h�I�ӗ�nʳtXܴ~C��Đ�)6n�k�@)a�5%O��ظyQd4�l�������˶^\�Y�+�m�υ��Ń"��)_��N��n^",u��o������[Z���[̍�"uF�[�!���#)�W++��� y�q��([<A6���aKDa�ۍD�\>���SZ��;��>�v�S~�J��mo'�"��vP(��~��5��������
s$ek��i�0D@�C�_����n Ps$+�@������H���2�? ���5���A��H)��<�<�'����@S �y�\a���?T; u.�^��@<�K�������_e1p�j>��c �Aև7���4I�����zT����q���y�� ���{�Q�� C/�W�h�|���.�r�1ک�8��TGT���= �@�����5��(�]`�w�i����9R�A�W=�F���K%e�J���QF�*�]���ݴ��.};��$�@�['e�	 ���@��Y7D��3c��-��,A��0p�SoKT1ud�;`�K�W�> u��U���Ax�G�):� 8$iE�=��ڞ��uG�{a���%X��k���6@�b�5�:�&�0��o �~EO�(\fE����� �N�jY�~\�W���w�2UI>tYDy	��e�DxB��ڽ��z'g6S8�V<���"@$~����O��N>�1�a��^��%�2�]]Z����X���Bd�ZTg���lwW� Y��c �>��M�~Y]l7J,���Dq�T|JVy)��&/�4z�*���P���y�E��:�Shy�y*H��؍^Ty��y�-��9Id��`��TmM+�LfO�*��p��;��:���k�K�5�b�)����u���/y��E�y��"�4 ����/�'�*������"R�mZ���O�*���H=�Q�B�+	�(2��z�ֹnp�E�jD��&���}-�th�^�ql�@��a�T�d�b�U���qb�^�ͤ�x��Л�Ꮃ�,yԦ�@����w�n��Q��_Ϧ}�� a�w�B;y�&��U�7�4稞Zx�箭���-��kVHN��9]"�.7W�e������Qo���|�P�ؼ5�Gu�v�]��x+B.Z��q������k�]�)Y�#��߉�7���8����M�A�ềY^�m����Z���[nX6P����+�>s�hU�����f�y�);����ʞ���wB
���A���v��
�xw�>�E�O�L=^�y?�}��}��u�����ޟzە����6ٿ��jT6ˍQ��z�&��F<����RﯖZ.�u��1���v�����WZ#S'�ⷊ �*R<AR7��s]n�����e�%Vk$�k����
�a�W{5*��Q f�z�Ď�YGٕ�y7
��{y�-|���dD���|d�ai�e���\� �i��l|�nk%�܎�w>�hY�߭�r�,/�}�W�o9�b�Wϖ�"C7}qO��Er-��\�er`��zb�O������;���ro�����z��^��Ҙ�>ƿ�!���m{XX��1�U|��f)�+��NVm�z;Z�o���n`�D�����e0���N�Ļ��ckw��)��|]�&K�:B!e̺��ϻ=B�R0�*��^/�V�Y������i�v��SK�Y���+�i�%ښYy0���O��(y#�9ܳYy�׀7+O��u�<uĻޡa��"�,��?�c�Z�R�'�E�CT�4e0/@�8K���[��� H!sOj����P�q�:�'FXU��̙�f�(��j-��O͍";��j��"lv�qW�_��u�a�ƭ4U^Y��M�Y�5YMf���#yqJd+,K0E�s!/�X��I�7��A�>w��x��>���	�Ȳ�#Lh]�p5 ���f����jC/&�p;�ggB�
�S��c����` �v-9��1Z
m�O�S�*� ���%�X���GN`(�~���/�QA��R`�e����OV��j������?!?ׂ�j녣j>�!|�S �q�k�*8f���Ӗ+�o���B	�&#��(���(� %�$�� CI6紴q���"_�#��B��'�U����%O���l.�%F���BV�^���E�����0��=Js�F
�2 <��YϞ�51�(O%�\�Ax��3 /�! ��i�js'�y��ޚ���yt�^i��W�noE7+-����J�ђ��6U�~�c�'��,+�����Jc��#z�� ��Kw-�����2/Og�!�VT0�,�\�="��Yi��٪J7���Z����_����J�v�o�]E�	���>&�hk��/k��V�&�X˰;����w	�nm���5x���v��0�FA�IxC�^4r�O�9�����:�$��̗Z��|�>OYx��p��xx?�1mV�;�E��9���d�Y�+�*��/�=a���<��A��8��d� Zc�92	T+Rk_�!��F�}�o�0��; �-XY4�
GՄ�r^�kX����Z���Jt�P]�#����	����W�u*�dD�����Z�L��@L	��$ئ����0ux��$X�.`��,�;�h�\���َ��mHrcB����:���6�<�I{�&޻ Q2��"D�h��k��yh��"��J��
�՚q�<�^A$$m �@$��Φh ��4�Q��؂���iđ �n�J�C�;�mjN'���
�+Pqݍl���$�����k����
�S���ʆ���*7:Y�N��3v��$D��D��0��/��O��7;�p�i� �'�V���y6�(���c�:�g��os).�qx��1BC+�}�]�Qn%")2�n��D����U�ZB�ns�\H������`	��
�7��t+4��k9h3���W�?RV%�U8��ĭ��}�:w�ƚO�a�u�V�R`�m�=���QP}�!!0����zD gF.����L%&gI�M%�s�:�ֹ#!%����������l���cp�m5f�ĥ�J%�!�݈���F�3�y���Z��7�����Y�Vڃ��-��0T@����Ϡ$�L������`e� �����|�!�K}�=�k> �"Ĩa�������I�>�D,G�<Ptg\@H�\����(i�W�>}�W�m�?�¢Z�����.[�t�g��V1�V�Hp��}�q�0~�+��r�0ā�qؠk`��0���P��i�k�u��@lD�2���lq+|�1��}�a��VGҝN�@'?b��l�*9^O�"7��0�A�RG�|:�}|ސ'2��&ԯyז���3�*{J%�b�0�װis�)�~��Z���Q����p��P�C���WۈahB��(�o�h�ѓqZ)^��2�AJ� $b��3�:�(�l+��w����)^Ќg�J�{5@;�䨝j��v�(�a���~��dcmB]����5�5��t�����n�I@T��O2�A߈*x����󊵉,:�>�5���F0��$�#��2hA��y���o}�����`��\�;q��P��ұ[?�E�ɉ✑'�����E�D ����0��'�p5y0��0]��G��0tVg�fЁ.�.1���a���4�Q    ��|�fX���61֮���g��h���͉_�n��Iyp~��?lWe��yZt�YE0�	��w\�QA�^���m]̆?���l�Ad�^���>�j�ǉF�Ax�q����[����$�tN�.�����L��	���b ��&�@AO{��3����0����%��v���e,)�)�i/A�� ��|YWd$�o�h� �'��O�a���It���2^AP%�p�w�����$���|قd����\g۱�SP�i��O����`��i��EP'�%�`�"r���X�p�R�"箎��	4�{�M�BPڴ{ަE��l�1��!p�N=��:}c,����$P�r�����'7��N��!:��|�B
�#�"`��P�,��a�X��,��"r�-}����i��g�.�kh���ഥ�"V��S��>��TB��xb?����p�����.���,���C�X���|X��O\��5�,5�-4��x �T����x�r��e�V!�^�� ��av* �Z� ��������;�| �v1|XF��|I��Β�Qz��������!��w��A��8[u-�(ۛe� �0�2:��v#�\o�>d� ���L�U�n�Ă3Oj� L���N�'��)�c����W�}?i*M�X4<;�h��S{�.wZ����;���jɃ9��v�/=��'WY������`����td	��)�-��%�?|��.vR���T�ù{�a��_�Y����"_�H��Z<���6Ǐ���}"Uf��*i	�s��ZsB鼼������us��Wn�i�%��w�ȟ���l��B���=zH�`���{n!�x����WcR�-Z���u\�6�/�e�K��<�6q$�Xb�c	ڇ�鲄�Ϝ�����[�q/g	ͯ��T�wI�OG�3�H��x%���_@�lc��M,�KI�x�ۛ�;<;���/��m�wP�X��/�-a�3�l���_)~vK	1��������c���fH �O|�|5�!� 7�#z�V8���&��s����#L����)gX�E|-0�k�L_�D��_�KZ��B9��H*COV�D�i���F�~����Oh��?~j�ΞAC˳�8r��W�"������}^�`Z��e�{�ɟ�B$�n��k�{K����$�;���Kz�����g�x��(�-����熗 ���N�=X�"��;�#��=Wlv�<���$Vi��UI��G��_��d�Z&�V�4ֻ�# �3�A�@d���y�vbkS?<w����`رv��������~�4>�ӯj��T����@kM��	���(BzI�k���W� OIcHh������ FJ�:�ǳ�y��w�Z8t���S�?�'w��ϭw<~/�z1�X8t�:z)x{�L��S�j�ཿ�6�|������~�3��=C��}�:ν\�;���~Uz����
�Թ����d�d�}A�	e�#��WW����˽��� o�Gh�����(��U�E��w�
2,C�r��jZ6�X ��z��v��e���� �Wqmۉ�	d��_����>���T���-�Ի\�T�51��Xi6,��k4�	�%��Z �i���W�n���G�m\�V�Vͼ�֙u[�0���-*3h\�>?���g���u/ �6���%�踑�`����^:�|�E��yUz�?�ؔ�����<��t����,P��,�����d���x��3� ,R:g��&���a�E ���v�h�R��d����Qr��0��`������1��5�ԉ�]�"vY �� ���W�^S�b�\(����W�;8�[���
S)�Mx���g�)����ܗu�!��"��ȭc~���nu���+�p�K�e�&��FQ�@<�ݲ
�s?@��<}&���K�f��Oeȳ 7�������i���~��ܷ�����Z�� ��c:4���H�.���O��5dW�o�=~EI�h�x�,�=`�XS�J [���`Cע�-�W1��\Q�'�B��oB_	KPR֟���+̪H�^/�@(W�v`��H0^��2� H�<"ޘ��b-����@"���/���T�ߧ��i��5�s��@�}���/7ʛ�|iX�3<�y�'�ɪ�\T�'����1|��˼��<SB��
i���*>�̳y9��3�;�[���6i��a[lZ@a������e;v7���qӼ��k�-�r�ua�<���N�GA���d���|��g8�܈�>;��u�q�?��B	I.%qȀ��H��L������Q��4)*�We��?�}.�e��4G��gVy�o�g���D}&3d��v�����h{��䤿��`�,Zq��V�e���B���Uഀ;�!.}\@5,�͍�^ ����(�	�w�?Ǵ�1��4|�E�۶�>_�l� =_����G�x����BY`�/�$)Oo���|,�r���jG~�V��,�̑L�-�\���a�����P$�L�i>��q��|L��|�jo�e���7����������v�O��tFb��Os���U'M,ʲ&��&��P�N]��������񆛁�yTPc��o/ ��㝱d��[A�;M�$�w#���9���J�UMi�t�p�H�Q��XAw��m _�j>�`h[^j�&�?y�L��yQ1�,���V��]Y���+���ݡܹɘ5����m���`�yL @!����<*���+o�B�w �'���9i��8k�P��/[���Ä~�#`�y�����z�ˁ������8H�*��yAq����E�k��|[X�8� K^�@3 ��-��@�c4� �\��q�)�0��X�aJ�S��fS@��������L� "v��I=1���E�	�lO��M��2Xm�N��*��@[;i3[���Y-p����z9�/y��h�������tFx"�3��-��]|�D���%��*[��*��� �Sy5�j�ڲ&��߾C��A�G��.��O�k�ՂÈ2��lI�.����{��)���� `5��T�a`�['\ð0w��^-Y�80��r�z����/�FP�e�-ѭŁ|�OwY�H���-'d������ �B�$N=�x��2m���)x�d��y���r5��|� ����阂@i_��5tB�n��M�T��Z�U�JP��%UY�t.�;,y�%uz�cR�tsW�> q��mh�~�� |����H'���01����m�<��/A����@0_�,��X /O����-��y"��[X����|	��D
�rr,κX����=ε '�AL���d�hJ��u9(��p�sceJ)���8<��Y�Τ
m�;vn���h���۳X�2[ L.�g�z[���sQ����䬉����h>b�C��۷�8�Lx��K04�̥���q�ן7��^cT|Wu�p��e ���r E|��}����X ����x,��� ޫ<�V�|�S9�G�s�� �O��y�q��m�&��f���T2���g��� p�&���+�i���Mq�~S.r��7rl�}��p���(޹!�iΖ��?��w"����Oo�����ַ���^��o��^�� ���)���C�%��Jצ����ǫ_��8qz���S��e�p���`���i�[��47_,���,��ݮ�7�@�-�wY����(�:�v�4��0������s[� �6S_[چ�4�6�}9�m��hv"���/��f�f�<�`��F�:$�Hx���?hq�u	��tCWD9:��y��\ ��m�y��Da��m�� /{�H gu�$S�r��Z�����(ٕ�
|lԋ%�'�N$;����M2�"[���th�GgI$i�O��;G$bZe}�D�J�i���0j#8`��\l�O ̒�]�    �:�8��_8����E5�o�ߝ���c��צ�̮����>)&U�^Kf� �:e���E~'����	�)��ui��C �%_�����-0�� ?o�����u���+��i;Qo�-Ю͒�S���xT��: zm:o=`^�����i�m"��d�"�Z�뿇�j������ۛ�i��86�T�-�� ��h�+`\��y�*��nIt�?<�μ� �5nU
��u_�<��+��	��e�31v��
lS�Kڛ����<�ŀ�&����' `'���L���G�����k�ܤpN�53�����!���%s���-��3We���$2�G.v��L�x�X�IF��|��VY�B/}�&L~�38<��5-@֦�@�5����A-��c+ ��
��"dYq���v5�jd:?��s�:u#�\��
`F��jc�����L�͠��M���,J���f,b�¨���6���ժJ�6�,�!g�z b�~�Ƕ�����ة���d�`���˔�j���`=lui��Ovu��M��&+Y��[@W�Ͳ��o�W��Z[ސ>������Gg���-�A�|�:n"&X�X[qP, �QZ^���O�� ֨��;�q(p��L(WL��N$���zhq,_��6��m���X�����Q��	U�G�P�f/���|�8=^�b�y�{:����=)���g��>�=�>���:��y�ԇ�����M  �s�*c@�N�_{1����D&nI�N���`��~N����` O�<_g�HX�fx�D�D�q�@ik�z��ae��ڒ�aK�C�D�d�Gi�?1��_I�*�)��v�W�$p���h��F�e.�_��� s��Tr���Τ�c�\����k�x�H!n!�p�f$i7 3���~�� %g��-��a�@Xf{�n8�H�=�ʥ�&A#��H�}�v�i	�i�"���}nh�;�se`�k�$��=�E�!�����ݾd�`�S���(#:�׺2��x*���à���Z\l�1H��ߔ%���U��0�u�y�4*�����c��o��ɕ��g�j�(l�*)����¦8M�C��z� p"��:�ݔԌu�����57�ɀ�5Őz!�6��԰8u���|H� �y�G����� �;���œ��]���O,n1���
t]C��+"��P�+����Z�s���@�M��\��3.C�k$�P-��#C@�&��������\��@��G�4r0�]sK���,�4����/J��@.�(>��������l`�9�,��A�=�&|S\�y�����}Vd.k���`eu�=������-�eY:>  #5T��j$cj;���jc��8�,���l��*�	�m��5��������W3��j`�N��yx=�o2�>��b�n��H�lh�pHi�F��y��WD�����@�Y�� F����\]����n���Q�Ŀ�:�*��S�{b���a{~d҂��������������Er��M��ゑ�2��"���g�M�$��N��e�j�]l������j��t\ ���� �i���V,���j�V;?���\�vؑ��j5��4k��dAݴ�gE�"�Gb�T��X-��n�1Ќ�-�b�n] `M44�.]@\��Ъ�'�bp��9�t�f��k�
�?.��\� d5/筬��W���3-V��ߋ�x�D�#�{��]*M�lMkz�e��juP,��+���`�>ך)���9c鶤$JYp��~v����H���o݀��HUy�*�N�t~`��fV{�TQLU利��ȳޑ���=��Z]���j�oWe��V�^8��yu~��(�@Us�&`O�nu��%�R��jG�+pTQ�"�u@@��(-u�ɯ�f��d��ѕ��>�ϹI@L1�PM$���V�]g�Ʈ�K�ځ����38�S�Y� ��
�͛xjB��x�U{��H�v�%��.�&�t
HY����^wpT��m^�\��]��M��ڥӜ�������@R1�rK��jJ)ZPT���D�6��SE)o@O����Vޓf�!�Sm5�˨�d Ðdc0Tmgj�m����zC�1j�U�0�v�kH�@:��� �
����ϦW�@Iu�� H��cگY��+��X���FTX�ZR^��
����,�������	p�.��(�9�<��5Պ���rH փ�Z?�N�ip :�%8�Ǯs,̩��Z���� D��.�@4M4u�����H��,`Lm��in�k(�L�6fa�k0y2�R�wb���@�6^��'�\j��L@+-�KUˤ\�dj��{@2��]�.odJ�^��.(�6�x� ~i"�N;D^V' �����jb�����7i�!ğ���	S����_��w�Bl�Cs"c��gff�R2`L��W��q4���Xl�2'�RU�������D�x�4`w�J��J�R6�q�d�Xr�/!,�J�03����1�ܑ��Q�Jm�zґ���cّ���J�����m���y��N.Dxd�U���w?���2[�~nR���K��ri���p<��*�KQ@��	d+��a#�T/��R [j���J��,�X�;�W+�J���AX$���T�=	x�W�3��k����O��+:�_�/�NV���;q�a���zZ��pŧv�8i�ꁷc�.�{��[����;���� _�A&{i�<�>jV�'@�r6�L(�ڭ���#ʌk�w��xK:A���3��aM�A"��-�I)H���R7�Z��f�z���r���)�O�r�2��z@�w��+u��  PڗxR7}�����U4�V=Nr��R�#(X`��檁���O�Ҵ����M�n) ��zT �R��Q�P��u T�o<��<��Zx"� ����}��R �"HB^� Q�Zv�]�,Mf�J+��@Hݷ�z�J.���1l@ ��Y� �Z��ڕ�c.��5�P����
�� ��s8 HQ�@SW�[ĩ�X�� M���UJd�˰�O�~�NlQ�� #���0�ni�9�C���^��6 M$�����D��{��@	�Q"�ë�j���.�Dh"U�90Am,(��%���_��DP;��
��v,���o��Y�l�_�9�V`����c���>��6��XX�NQ�٧�{��ࡹ�a�bmT��n�	J���׀Z�K�w���`[���:��@Te�;�6��5:A-��I�Z�� ��J�E�|��D�$~�r���33��*�Og��NzI��x~} Z��vH�_^R�3Q�^��}�v�䟶PL��������i(�4Ȱ(�6p��~��'��ɕw9P��=�~z�#>��+,� �b����X]�v�I(5z���π��M�kI��p�*Z 0����6�"� ��]�/�ӹ���N�y�K/�s&�^��<�q��I�u{)��5��Z'\RD�v0  g&�y+m���OK6/[,9 �y1'�� �l�މ�}v��<�o:�������������b�'Hz$����L�Y�3���; e&ҋ\�#�O є��<vD˜���2;��#X�6�:be^�U3g�|;�e�j�r��,�nن���F�#@fotD��8� ځ�@tr!�2~��W+�a Zɂ>�9�d�e�9bcέ[�1�#'�pq��,o��}��P�j�t�Ŭ�L�BGtL��*�T�#z����
l��ٽ�}"Rfi+!G�̡>Cn�w��4�M�@�3j�;�c&
U?�b��ܲ}���Eu��L��uD̫j����7AR��a�w��t�ARs��Lt�L�	S� ��)C���㲑�<��]TL���b�1�Z�/��������M�"sl4�d<��i:2,�2;���Y� �YE���>��VGފ�"&��Y�o�Ώ�N2�( wؘ� y�    �Ip
��ӭ��L��y� �����_�ş�WAu�̬�8�`�����+��(�P� ���V�����*V��n8`_"c�j;�^��|�w��t�t�৽j�Z�^W�m��}e�z�ZȌ��X7��s�T�ߗt�y>o��x��`�R��$}hw��D	���<8�L���q�׊����ٰ',rx��%]�x������ڕɃ�#�e�g��H�8ԗ;����<�ia|�j[�#
&D#�>iJ�����N*'���<pO�"�܀|�∎�Ȗ�F�s�Jʾe����VGA��,�6�*8"c&������3��/qD�d�������=1�|~Lz?�W���G0�D��N��ￏg\h9�`.ő���qe���8B_��߷�I�H���b��+0�0��a�Ƭ��y�V��bi�p��D[�4�0�A�E�GG\L�������i��a�c/�(�1�Sn�@Ќ>n?����s�m�I爑�ڍB�e�Ʉ�oߡ�ExZ���G�u��L9p0#��#rf'�josD��3�n~��q���`�zK\H�,g��8���W�Ls�uqG�nV��0������D,�h��� �h�(��R�}�C��������"p�;��@ؔ��〳�+E i������/��u֛����*������˿��e��f�`9�k1��È�1s��L��NLs��Z :mŜr@�^O1��&��@
%O�"w�派cF��y��SW�������z��~��W�����uxM'�<r/��M��z�m�3Q���ƷA���� n�;N��e�p ��4h����B�	�	�!d+e���G��˷����V$1��8��K�8�Z߷���6�����F�&u�cO����P9m=�J�0N�7 M'%��.�uՕ������RU>n ��n� Y�����!���!+��;�4x�%L��~��D���7QV�m��is��c/��Ǵ�myfvפ%�*�7�+�+��Jr�rt�޴�*l�x�›�L����B��.�^�6+�"�Ȗ_�K��JӨ!����fuFs}�:#��o��5m1�y���-K ������bx"06�|?k�(�=�6SB�&�l���4Ɂ �(��>�M;L`l"
���p@�do��R��&"��% ����P��D�	T| ��X�_{B����6��y�v,���o��]l�M��*%��F�����d�?\~�Ż�c�7o� ᔐ���t�Ud�����mz��o7�����|=gQA�z�*ZG-%���wMy��ȉ��;�������7�z�8�q2��e�;�ܲl��]^2���5i{��
(����X��� �HI_%"x7��WZš;lf����S=�Sx��7~;]��� ��o!�O�4'�s��'@W�Cu��>������4ZX��mO�刬"�SP�Sw6%[S:���`;�0t-��$")��:�;������SP�EJ'��|���
�������� 0�Z�6���K:��L��Ib{�Lg�W{����[�W��{(O��0s�ٚ]�7�<)�4�wo��q�d�".�ʧH�L!'�� � �H�(��>P�2��=H��	�����C:
�R��ǧ��F�Pr ���"�"b?��'�O�;���� �0)����c��A��3:)0�C�:`v�h�{]����XY�-]͐g8��s��2�J}��ԚD���&-����8@~�$�H�+���=�]��)ώ���IUB�w�+`|%�g(��DP5��
h��0@�s���t7��'?��0��n��t,`������&3@%��}؟��O*�q��F �i\�T ���_~���~�CM�Π^�8`t"Эk�. 9{�,��Rq����bk��5���}A��҄|U��>�e���:?�JU�����4���Y��G�ep,H$�W�~ l��� �}�R�	���_qo:E@�A��:�l���r��#l߁M��6�����s.��а����Q���AAI�R�<$%�B?_��P��Eț�\���؛Aߛ;@o��$�UO����at�������O��'�A�k����x3P���S�v�tf�3̭i*)P7C��� ��b�N�͜Ki����T9�o�u�x�;�m��j��ؽ3,	P���?<��`2u>mgy�2Y�������-8��q��B&̤x-�`7K��v s�E`�_5�i��o�9�9LJ7B�o����p��X� �	��fL��r���u��A>�)�JD�����_��q������^�95���8�qN��@�����x䳺�3(�v��`��K�틎����S?�l�kV�ű��V��ȹ>����RV4n�斿�����$��~���7�1���ae���h�a!�_5���_Ir����rX�E��	:��7�Cs\�ͣ��]Z���CZ��H0H�"����'d�Дw�x	��ř��R�}�$1t)��^� ]�Q6qC�1�[�j��Rl5P"t��H��V��C�k%_i]B&�łft�Z��R�T�,׫�m�U���QV�5(��|�v�q��T��v�뺌���!j�.R�q���������y������op`@��At$b�F�Z�Q1��?ˇ*�UZ�9��G�I�x~ٿ��b$1��~��0� >�~��?}� �RK�����M%g�)��(��@�p1�j]�PÒ8��悺�&
����VZlO�
��,�CR(0[ 
��C&�о�5.��2BA��r'��d�0��1����h�ߍ�NO�(2�A4$�!��+�=~6�
%�5ʑQ*�F����a�oOg�GxJ��
��i����N]�{��4��r���i��i��qngb �F8�c*+���W�@��p�Q 
i"�7\�q��8bC�(K�'� ��Y���9:ִ���	�Gc��Q�px>�V�ߋ�s��ʁ�������G%�L�2 �DXdJސ�r��h���t`Hc�EJ� 12?p�!x�����7y�� ?�(�軥#Hcqʑ�8�QaOQ����4'�`���F+�s��A]9� �4Q����)�#��Ȓv���-	d�I׮�͵��b�E+�(����q�86^]M �4�07P����iԞW�!U"�W�X� @�����&ܨ�����ȣ���}�O��8x;����S�Y >�ˮ��K�ac�{�����J���Y/o���ȩ�c������f��y��Ȥ��%�Ϻ��Tgp��F��}���)S�yMܥJ��3�'= ��B%��i�F��[h�2E���<ӎ/K�tEJ8-v2���|BϾ��Y3��|8��i�?L��z��y���dn��ߜ�l��A�A�mF��Ag�%'��8X]'��K����|5rԺ�N�J��M_8ElRlW�uW��!h���؊[k��dQ��D
��YeXհ�IT��[L_��c����t/��UC�������P�a�P��U�#T����|��\=�p@[�z�퀱��;&�<���}��jX��/x&׶-?�X���� �t X������X�A=kv@YE��{�X�[:�m	E<u��j�*V��� �o���a!��>�6ex}EPahH�c�����)����!�4`X!��+�_�`M��N �[}� �v�$�u�~<n���[8$śIi�kX�;p�5(~� ^E��WX��WЁ�*ْ��t
¸��:Lw��2�`�O�zmG�!�26�GB!; ��.��
k�Z�����\�`�FfF�9`WC��kK]2�5����
�2�,kP���f����7Ռ�� ͚�i�D	 0k��I����8��4����O�{>"�zǍkѐL�ե�[ٝ�S� �z5	���"�t����U���Ý �[1;uLk�֠ � [�)4��a�t�i����4`��%�ZK�s(��ס�~Pb�ҩ��a.�S��µ�g%�ŧ8����v��B�ڱ�Atje��q)����    -�:`ϱWm@�ƌ�t8>��	cN��W����k'Aq�hMT�?0���)v�g��I~�R�:T �5��'�8 ��'�I���~���:_��6�"_%j�t��IW ��k\N"��� �Ɔy�-rE逯u�k���e���h��W-a�7�B��r�W�5���. � 6,����������P�;�h��_ Zcs.kl>(���
r:ӽ쥠��]��5�G^7:��FW@^�No ^��G�&_�s�:�W[�S���˼e�*r���〴Z(�WPZ������U��_� ]5�ނLU4��r9�Ӆ�.�g�/�XZ�W( ������?k�e�������@�����oišI	 ���-�7 ����t ��j�<Q��]���j����NM�Zx.�|)��b`�ƫ�;�K���4&�������u���!���`Cٖ-����!@HM���7(�F�����w1@H�9,���|d�Yߚ*�@R�#��ځ9Ci�cZ�,����#':p�>j·~���I~J������kw��i3!eǩ.��I����!Pj���:s2��Y�����4 F�x�Co�2�a�[1�Q�Z� ��l������T����hPI�T���|���o�n/f�'
U�5��������������N-S~Kl�^b+�H��x��~
��(zg0��H��L |�X�F�QU(l8w�OlS�EUY����T�F�^�����t�H+�f�@�IL��S�a�>�bBV�t1缼m܊��Y��  ��,������R  
~���}�=<9j�,�����������X�!���w�!xp��f.�_I�g����L�,��.-�B�&��q6H�{A�XdU�_��n�ݱc�(Ɛe��� �*�h�Q�O~n�b���f ��k�!��Ơq��V�F�)[/ V�ƭu�V�5̛�jԎL�P�a\�������0��hq+�j��U���2r�N��j�G���ꛭ����(�QI����Q�j[f��WO�E~�IЫ�P3��p�C%� �� �eɥ��� - Q�����^�#�Ze^� �
b[' �ZZ��b �6������le�D� ��8T�Js͢���/�o�HRu2�;������O�c��*���,�u�V�o$y&5h	�T�Py��$ ���{�H��\���aS�� L�^��!9��ᛋX`�"�5�Rং�&����T��"����Hp$� P��#����x��&�3�T� ��*��$2�jλ��AE ��UԲ�՜~�O'H.� \q0Uw�KZU
���j#���-����&��j"�W���r�V�L�V��L�[� �4�##�WK�����ǖ#�Y�-5_y-
�L����f�{�U�� `E��\[��'�kq�4+opJ�q=^}㲮X���,�����qVs�]�E�"źV��涮���Ӻ:UJ�4w&�Y�A[l���`]��|����)��u�2t��o�I�0)nXZТ�J�DE-[��@A� G��>�� M k�b�9��)7�b([C��n��MAtk6^;C���z���n4�`;���h[�����	�����g�6Y��:�<�mJe;����eR�е.����X�K��w�a�nto��&�G:�T��05y4�h�D&�dy��a\f?���8h"�2�ں��G�6��S�a�2R�C-�0�^�Ԃ� �
���4�o��<�=�-Qa.��Q���W�|c�����;�oV-�y��#��
V��Ӥ;��v�=�FQ� �7�����;����8�d�)�2]u��f�Xd�1U��"b�~� ��?�L ���JɆ/.���u7��r�����6)O����6��yu�
�t�t�W3���:晭�&W<�~��(Z@����`I8�.4��b����r�Ǟt��4p�`V�(&?0IMPu�ܨ�U�t��Q��V�qB:4��7��C�x;o�����%��_��[�E��X�]�޶����6�%
��7J������u��} �pp�'��7�i��7�~�t�� Ǔ�M&?���;e� >nJ�x�����gy4��Mh`\������Q�K@h���N8$����2r��������ϗ����hz��jz9&g]0�Q�� �.%���7~��с1�v����?7ފ�퀡���@΍��[dn,A3Һ���J��%4$�~h(A�@\��$��dO�~��\�p6N3w�7�}IG���מÄ7����X�07�l�psu�����p�.�f���j�*��2�I2�m��E1�9/z��EBv�CR��ZԜ*�8Ք<v�\)�mq����ODSi�υh�0�ѥ�۹ݐ���臤O�Oї芸ɸX��GCZ�Y����r��t^�τ"�1B�n7�����Mw[x���1R���%2�C�6�{�H�k�cX��(k��WC%.�.R�*�U�j5�c�cGB ��V��p%�,�	x8ega���8C�����f��Ԭjx�Y�:����\�W]���U�Y'��Zsf�8~ꓭ8����Ypc]\���>Պ����E8�F��EMw���|�'рbHi�H+��;-�U�4M��8���#�XDZ���|LJ���VM|���p��i���U �D$�
l ������� ��L0^���/3aM���]���V���@�eu�a�.' ���s ���qy0o��}����������e8d� �[J���Hc�|u�i����HS�\c_�H+�,oP^�%��T,����oK#�N�0�ip���{��{�����qda&A��Eڕ����F'�<o�v_�|�N�1Ρ���f4!8�����UVڤv!���L��#Oγ���%ty޲��e�p}�-��Z�8�, �J�j��[-����EJ�w]�fo���4���ى^�������D+��U��E#s�Ι��<=��5���&��G�q~z�޸��*�r\�������ubm�Tܼ�r�����;I&J�T��VÜ�_�I����1�5hFe�W,1�11[�ch�p���1������抩�4h�����g+��j�*�b��G��8�y�-��1�&��,�q�t�@��=1�9��f*��)m�;v@,k�`��W5h���)�[	mt�-M��]��=�&�i�]
�VЄ��FH�;�
oo�Ob���ʙ���i�y�0Ĩ��~jU�?Myv�I�덟�a���&X	��)�|T�ӄ�ӜW�CʁG2��7�]���O�~� 
K�^wx����93$���fw5`y�����+g!?ͫ�b8��i����u�I|�܊�3�A.@���i�f�����R��ӎ����i��}(Y�m���_�`r)L'���6��ݼ�i��q������f�c5������V�y~��$i�im�`t�8_������6m�i��*��.�~�Uŗ@���v߂T�u�,	���C��hR��N_`�Ʉ�?�u~2��"���(���d�GF+|λ�_�i��ӎ�?2g�i2S�����۞���
��&Tv+㮟�0�~��I��l�6���ʫ�O6~��]1��M]'���ONDSM[~r"�:̜+��-���1���Q� j��Z��(?9�CvY+���";���5���'�Ƶ����W��?�����뿀*�u/y>1S��x��>OR/\��3^�����@�w��)��L��_u�"������i�4S�0ZEٞ]�w��u�m����C��R��a��!k���Ţ�;��C/J�+�5�<�t'�b=iVAU���Ob�P�5��,aÐ�@]�_S���ЗJ��^��'.��>�����;y��B]&ގ1A&�����u(�Ġr�[�X��'@b���kT��a��x��=���l��
���>,bv���f<b$u:�$q������&F�z_FDA9uz`�B�}�r皊;W�X���A�ǁɬ���4B��q�Q����Ֆ��U��c�UdOO�nĳ�Q��V��q�׀8w���o�%�+�Lȷ�:��*�2�c�DӅ    R�~�|5����7�����x�2�R,��~^�q(kYT����ϋ��~e����]�O���b��B���y	c6~,�~P"���g�����y(����o/[����D�ɾ�~6�ո��&�Ƈ����?��O9��٬WM"9|3���=�8�δ�e�Giv��{��J1z �X$�e�o�3U/S���L%ˌh�u}��t�o��L��dur�
J�ٲf1S�2�,����+�8���h~�e:d?S�ҭ�1�H�Z?��X�pg'|5?;aM�e�r�O
.�LJ�����N�{x�󧟮���!	��:�Rc!�0�nu Y�Ʈ簀"����3��[�I- �J��q���G< �K!m�t1��(�\B���T����c��kZ�:��X��yu�*��z.��ʥ�k�Yĸ�[S����ϡ�w����n�9���#X%��Mו�+s6skyV�T��oBv�9�����������H���X��2���{lbh�0?G��Rh���<ԩl��Z�ԏp�<���Ԍn�?gjH%pL�_��!_px=(s_���P�@�/Ԁ��ڣ�:/ԃ�1�\���ڐ����P�S��~�����/SP|t��2e� �O��,�}�̳jt��,��u�
�����a3- �\�q{���=m��9��}�G�/�0XJ�2�Z>�lW-\G`���}$c���{*&�e���-��_{܄B�˜�6���e�}���~�i@�I.}���PZŚ�ޡ�3B0��ʏ~2�j>���^��*��BM(�+I{\:D�b���٘N�h�lyY�#�HN~����͐��V�a�� o��/F��5M�\�]�Ŭ��#��o~1�\�Q%ٽr�۩�$��>-4?,V�9m�.�ǁ5��j�t2���}�銵���d���jە�Jr_B{x�U�~yH2oL�ٓ��y�6�@ɬS�Rz@$�Z����&d1��N��-��ٲ�Yd��|�;/U��z�"�W�)z�#�j�D��<`�K[S������/����j��0f~�]o><�-Q�����H����M��68�ml�A���/桕$�=�}-����>`h�*�=��ܓ��أ�����Y�
�\�2���k>����	�$�9/��Q�ZV�R��EU{�Y�t-�P�x�|��_�����G	��*>���_��ȣ�r���(��::�$h���ߧ��*�i�)`���c;��~���J�?kTo������I���~�Ki	����Z��G��?iuz�"�� dt�i�ZAF|D��K\+Gm��A�%+����K~e"p;�����#�x3͵6�u�I����D���7���x���l&�i+f�!�M�8łf&�6#�n����$�b|>c�)^�3{�MBǟ� 6��ff��f�l��̹�TgfaB��e�0�,�۽������'�DO�Sv��{A�aB�'��K�F=%hiQE	-��7TM�u�o$&u�0C%���QEQo��	����9��,�bo�3K�V�#o�N�������Ϲ|��rc���mƌ�- Z�"��ѐ \ʈ ���Z��d�:
��I�dC�$�-�!j$Q��I��Z|�et����A�W�� 4S�k*����O-%��1 ��z�g!�PC)���7Vx�8�@�����<��a/Ľ-���2��N@�3�	�8��u-��\�<Y�������G�U1<����V�f�L,�0�����P��� ��)�)��L�kZ]m��;7�U�_�!#=o��ya�����_�����sq�����b��oiI;��Z�k�)Dj�֑��o(K�����VR�[�����R%7s 0~� (pec��Z��L�s��������6W���6�R�ՖL�ߥX5���7�=�<�|;Zw%��RL�[�yy�.͎�p'G*�� L]���U_o�b�9��'�o_W֒��-�@��xM��ɒ���E4U��.�0Zcܥ�!ufn�y������l�%`o�r]{��R�?�zUqY�#N�8"@FL�	ջ��&9W�wi/���/���D�e�j��w��p=�y�h��23�ě~�aD�]�k�LV��.�/�kw)�JY%�nJ�v�lmѯ��^�w���������"�y�[>�ZV�k@�8�$��[2��-s�d�%0vK�R�O�}���s֣�vA�5ڼ�Z��Z �[��`vqtCI�.����B��]!��S��x��T#����1�����"�[dpc�|��Ʃ�]?�s_�= xA�Xys��<��@r�)�����?�*\>��� �J��y��ޢ.҄]�'
� �V(x ^�F����� ���a�Z��+_�Y�;��P#S�ҁ7�x8�}&J:��=��R)�^I�j�����#����b��p�'�g��|�,ؖ��%��r�UC����-u��r�v|PC����	?��8��4/�PYd�@o����f���K�L >o�QuS�����;��;��jԞ���ʬ�	�*��F	?�]Z*$s�?迅欓*��9"�b�:���۳�E`vr<BO^X=��77x��+q���Eg
"�����V�N�ۧ-+���9��a�5��+7�����}Z!!�`�?��3ny�SX鄹W�ɞ��K1��N�J�Ww��@Ew)H�I�T�;b�y���l��]����}��7������6�	Ձ�����?���6@d�#:�]��!�'�mN���NvJÓ,91���R囹����7�9�w�RnZjy͎�&���vSf�,��A����zG� ����09jx��������|����UMTb~�$TG� ����A9���p�Q?�w��,�㢣vy������]-��n�nX��,�-�͡~^�f��$��)S��EX�j�q�%�-�1�ӸEغ���[�U�-�;m]t�0X�n:�[�o�_Bm(�D��o�c�,���ߩ<83�l�V�!c��ߠ	X����@�i���g|J����Y5	᢮:@��KQ�6�{y0'�l����m�m�f��- ����?>p C�0��Ri+%�F([�.F<�H�����	���-���kY��`�6��pP�0��=PkA�B����Ő��3<`��A$F��FD=$9&aL�՚wT�Y�	�δ3:*AX*ᆛ��
q��Ո��(8�0ץ/�`����G m����ߥ���ya�tB�t���f���W�Ϥ�IE�:)1)һu�䏏izq�0�sF�]�������è[��4��X�)��}����n�em^c�NܒI�B��	FJ��S�.��K,iд :����)س�^�� ��ֲ��tG/��v�۰�ba����=c�Q$R����9�	�,�����d>u���ů���GZ6��Vs�J�N�R^�Q8)q�=ph�MgX -�%��c'��\\K�A�07�aG��f��|}ύH�3a��-hx��s;�h猢w�Oǟ��%P��in���c���)igB'����l�+���IE�@�Eʍ��ϙ��3 ����� �}%I�8�~
P��q9V��V�I�9�x�[�W��Hq�X�6G%|���6��&�?�{�]�f1�e���-���Q\�ܖo���[�N|�p[v�������c������2p�]�1� uK9��ZS���23��t*4L6u�i֌-�bg˥atwx^��` y!5G��x���J��ӨJ����`�Ƭ��~��Ȥ�`�{�"��2�)����������&�T�����0O�S�^<�%P�,�$�L���JQI��9�2�R���[�C�䭈�#	����}Sm��G�~��m,�trt"���{7W���斮6�%��Tb�׽ˬf��;w�Q��*��ku�p�j�	�A�g����=ʻ����c���uu�X���F��a�{��{5�z_��vF�b7�Sx���Zbk�&��?W5�D�`������Vqo�6�u������שv����ܵ��*�c;����    o����%E�%���)轠�r@��\��=0|A9���0��R�HrV�?w�/v2������h��\���bZ�k��ū{�љ�k�*����t�@n�m03-��A���nrxϗ�>dn�<��O>x[g2d��`����	�QĴ�s���R0��M���b�i�<��u�#��k�Sy�wi�<���}K�$���8�*bV�y��#��2����ɾY�D4h��4$4��\����D+�1~�t�xW���3�iF�h4����qi�3�Hz1C�U���&��2X�U��d(�LC�6����g)�/M�Ϥ�K���d��Q�3��$�
���$���f9f�K���[�&��: �Ծ�2�&�iM?=�k�V�W�t�!iUZ?5)��Ta35�TVs�$��ɨ=�4.�p�ۻ�)��E���.�z��	L���N{�{���2���/0�'���2c��ڋ��ӄ��m����$9÷w6�K��>�9!�� �ڶ@�2�7U��Q|��*��S�2!|}YHtE����}��I?��!j�m�9,#l����~1|��{1�g�*A{{�w'fo?ޚ7��x��g4�a�Q>�E��$<a�Z�n���؄PE�k�8az��L*%4�/�AtB����%L�[��ۏ� ����ۃwQ��O�!"����F���^��=�t��@@�$=�{dZӵ%�n_��wחm�{���G0����"�����j�9�v�@� ��H�=�_�O�:�?|Qd����׫a�O�}��e9������5��<���Q�Ie�P��(�h�+?���3�9^(�[x�����iv��Pe\��e�ϧW�����
��YP����$�iq8!��yq�C�O�P�E��D��!�z��!N�/P���a���`��=�r}qJ�'T�/ �+��;c�db���]w��;؃f���=h#6.�=쐒Dh\
g�O�,p���±�­���/Xd���Eȯ|g��e��f"���Zr��Mt*	~;��݅K1 ��@�qvp���V?�=^t�$��P�\�vh�;�8��4��D�������������<�F���Ck]�=Jc��'�&�Mg91hƆn���*�"�K:~"��_���Ve�R[N8١���G�![j����#&B����V<�+�wM��|6|���B?�{b��e�<a}WV��L���#9�i{�y0`}a���>@�]*�G\�^�=��)Րa�g�=;�5}(�D\�^�!.M�����'&�Ix�r�r�6~�0� �_�6�0wz*K�ب�`��Z�$K~p!�-�a}����N|����VoQ��0"�&]c7��B5�E&��*���qCo�b&a8êr[<�����TZ���s�
���A��唀������ 76i��Q;��8X�Q�L�UF�����lr���F>�Pd:R�}7NAc6�ڍ�p|8u�C�;zn�����ƇZ�
�_�5]��ԙR? ޔwO��aXϣI�K>�����7M�/��,�6[i<N.<H��nR)?q2|
��N��a��6���[c']�y�%w=��Z��K�#cYV��ޓ��*@����G�|���9��)wR�UR�c�bΡ�-c�!�9^�y�=DJ�]��N��+���C{�5�V�E�9�}F�sA�ٝS��P�lV�B'�2+�� ���7f��Ye�;?�Gs�
x�<^ް1r��cٽ&7� �� c3OFQEx��*Q���1�|�2��?��8��gGp���o"|+P����	)�ЭN��&·���<��8e��5����m�g�H��=#�kQA�;�qPǭa�O��') �ѻ��2B��y�rD��⃜���}]���l��ٟ��R��(�l�X������[4"��=~<��:��Blؕ�u���!px�q�I �a]N_�K)b����]� ��[4R��[�iN�#b����`,n�=n�#m��	e�D+w?"�q� AVƗo߶/;m�\=��(��+ �E�r�{�	����⊯�v&@fӳ�]}~��"���Tr|�I �����N|�d���GASa�T��o�K�p�{T�[��� �
�][�43ih�g��������Û�{��J��-�^x�r��- ٢0'���o��@�~�������ۧeq9���fk<mߕ�0Y��:�u.
���.��^Z([ 3 w�=}��& 7�[�4�j$x+ 墰L'ׯr'$i�?���o��-v|������KC�ܹ]]���;��a���2� ���G�Խ�ڈ�����u�o��}"6�_�5��ϐ������8����r�G��0M������[6W�N�r���������[�=�}��o�������W�����*�ܽ]M-v"�Z9�o�yTn���v�kNV6��W랽�O˴P�t���❦3�/���3e��^��ߙ�A��jm�=�L���'j��<f�f ���U]�{ޞ::P���[��B���¾b��Nu��ʣ6cLk�p(�4D�FzU��W�+����֙��\ί���e�p�#�o� �N��ߚ[�cyW�`�5 չ��fF�[���
�Tl�قzPڪf����@-����nގ#��'�m.��r���^�B��[�%_�b!/�*뤯�[�K񑋺�7��S�(���pU�����7\��ڟ��S����Ҍ��GT���zˣߎsM�7�v�岞�e�!b��/���KNh��߼e�ps�
�6|��^�vp��w�[�Z�p�& l�)����.��'�f�3�>�^�t-@9��>�`:�M�.����Q���iP�E��l� �s�&�pJ�������"@s.k}m_?ya�i{���\���T_�|G�;�I68x� ���@<�8D#�i,�[K�t�*�.��z��Q�H�|�t�BL�k�~��s��=�����MnU9
�,ځ����!��O
ܲ�����y~��`{�/\Zi��z����Z�T-%�s�o��=#M?eq���f�b�n�Ti�Z�:��%hb@�z�%��C=䬎@�ãw~r�U��#j�ғi*��`&380�����������݌�0�F/t��`[�i����תE���i[j�U�hf�`��֨� h�W���|��1֣�T$���F���b:�ؾ"�&��F9��so�ޛ���뫟�~��:����TG$F�����b����6��`�ڢ���E �}cɺב����lU����La��!H���t�����d�H*��Nm����}�l.���VSa�w���_������5k=ٚ���7��s����#J�)��"x)�َ�\��	 �Q��?����3Jn9�u��&�Ծ9
�)�\�&��w�� o_�>�X�@ q_�[O���
�f�2�r{j���������b�u��*�$x�[8#+Z:<�/�.x'~��'��3�lsw{�H��?�:�wr��o���j����4��>  �ο7��T3?��3��l$������)����!hے��̣y���m������[�1�l�؟v�8�<⁊JB�Gv�<g3�Q����y�1�$���e����GM4퀫����w~�q��"�����{����~3�%�<�D�R,Umc:0n:�����h��QgZO�d�p���CⶴO|��w�U����^t�ڶ�0�7��0/�O?O�mm[~��i�z����q֞l�[���I�.�u�[dri.{{�vᮯ�`*�^�▴���|a�����*�����W*��x����?lB+]�4e1%R��a1��	.�ϥ�f��_�؟��>�+�)�;���#8sZ�S��ww>�~�kԛ�����G��|6�P���h���ul}��i駴t�]���H����_��cɏ�������}�#�}����?�l��Xȉ~�K�I�h
'��a�)���M�]=�⡛��B\������}�
�l������wGZZL�F=�]��^T��/z��7���S+!�zQ)_��g	s�)�    �B� 4��lڭa�x{F���x��˞�����;ƫ�B�u�\[�euM���p1;0Q�Q���z�[p�E�:&"��O�*(/�ΧB�u��4h����}��u� "�W����9�a[=|�}���m��=��Bhпh��]�3��v��n�C3tL؂��ð�𼐹��z��+SB|���i�χ/?v�����B��r
�n�S�����{���;��?e��8j�Q����dP[�|�Pﾲ9HB�sR� �!�s,vw���ݭ]�b�;��oz�~9�?Jd��of��j��� hc!���I�BP�j�c�r�b�2�D��w��������Btwg�Q4ٗ�iⲜi�D,�z��������n��=���ݬ*����Λ����D!���A���)^��ܡ���+	z�-�t�2�ÐSϚ��p�W�r7�]a௎e �쎗\jԭMMU�������,�V�"E ���	�^��Z���ڍS��۟X��fW����h8��+�����E����>���^ZT���%�/n�x'Z���5!^}&@�$�9�bח�TB���8�B��e~|1��__6,d|�	�	�K!|=�e^�b#��1S�H���*���$;S�]+�֕x�3����y�_Ƽ	�P��1��^7�%DQ��>�H �x���C���Қ�)��O?]�db���bX;?צ���^ԫ�B���[P:M���1�ip4�8?'ǜx���r
���}!�|�A��]B�2�Fz�C� �'�+�L]p���B@����Y�����jWŠ�.*���/�7�b��Y���L��?�X{�h>�4yIR�����!%[$#���g!>���=��1��4�'	 �ǣz��<���6��! �G�!]���w�"���� z���D�����	��Q��;~a˂� 6��7���o�n��v�iC >�����QCHܐ|�h�Ư
�Ӫ��9�8Mk5z��I%.Q�IOY� ����}�g�j��Q�;�S�g~�d�d��'��8�A��p�~�e2_n�/��O�l����Y��-�}���"(v�=i�I!1���>� ľKN����&ܩ���?��Oc�û�-@�gk��w��� ��>���$3�1�XC��0W�*VVq����4�*g��]��2�d���ehlN�Z,P��j]�yX��ܓ>�7��H u�R��Q�8�
����G}Ϊ�|�I�y_5�y^�&�ܛ�f  ݞO�a%����P�ſ���FB�& ۾����l(���>�EK�	t��:4���k����UceK_���.@����ră��#ʊ���L�`|���N ��"����7���Gu���܏]�p Z��j� 8���vTW(�4M�ҷ�W>��*�Cl^�?�]ԕ����+�V]�Q���f Y�>��:�L;vO��	U{ԩ�2IЃI ����f���}�n_�o��L��Z���'���_P�]i�9��J������>xE[���=�����*)�F)��Vo��T�x����'��������x��j����ݏ���i��hh��!���$x��'Fq<���'�-���;�����m9{��ƴ�wuZ���� ����N����0u� ��%�9d�×¿/��U����{�F���d=6g�x�"� �5��5%cPI�O�.�IF�0��W�E����Ҏ���!��Ģ��迋|���) ��޺� ��
v:�z��A�a]UvL�2K�tml�A �֖�٫� (��r���뽁'���|�������(�Zf�����M�`:�#+q�����ԩP�
b[@�^�����(-*hJq��2�ܵ��+�H�:X�����;�����?�,�4�}��eȥ���>�I@�8Q7�<pt���E�k���]8�6�]���p��j��l���maZ�1[94lNBفK���"F��9,D�.����a��z�	�����B�- ��>�o M��c�gC�T�C�
�aC`�<"�����TƀjW�}��b}��E��*k@ix�3���(k��+��H�, t��S)Y�ź�
H�2p'Q8���)(�����e�z*#��:�F����(�D	B��)G֕8���y�M�(�T�)�(�s�"Px��"pg��D����8�z#9��r�Y^nQ�"ʤ�)�T��#�n���d��`�������Q��p��(y ����Q�3Y��*�$~�J��X�����
��.�����O��G��2�B�w4�Q�D߳�BY��)u � ��m��y��Q� �i��P���׈�.���;ǽ�r����U�ۻ;{�qV�S�%`Ɉ䑎�4��4uTm	��?5���T8�~D�P/a���K�P�?Dij˪L~Ё��<&S���x��i�jAz"�뿢dv����O�Ό>+�@��)���ܞwK�6-M�3��2+m@�U� �%JP��3�������7��`��X3o�0y�C��{��Oy90�s�!�������	e����ǯ�%�f��4�_�7�OÝ!�����tj10(d��m4�dM
#F+��F���������,��Ɛ�����o�Z0�T�#cI���R^
���{'��4-�$�&��2�	T
'"G�]�H���s��q��ݼ�J=d(�|�k�+����GƟ��w�ȀԪʒ���<�ʍ��Fv-��cP�+����XG�)W��B��r��PF���V�	ed\K���M�hdX+�[ydL+<0��Ȑ�2���z3�;k�_��FF��[��\�^�XVG�o~�(���=
�����b8���g�d��d������j���<G��V_)�ee�vdt,�CD�x�jM���ɟPuZ+��ݬ^Ӏ�ح���>V/�b~��`q{����Lm�<�$�QF����W����
s�S@Nqciʻ���O��L�~=t�Y,h���k�`.�7�Eaw�[Z��ɵ��\�
�[��]�\<���E�����샀������D�1#��sF*�l��ˍ���k#�AMi��'�GP9�5V޳;���/?9R��I-�8*�Ay�R��Y��XZf�o�կǩ|�b,���ox޽|�7y/8�(���ʔ��AS>�q.+d7ǫ����1�ȣ�f)��E��_x�z1򠸱C'84#��k���͜�G�MyN��n�vS#���;�)��7���KY܄b��o 7��FA��6�$WFQ9���3J�˂�>�
��ƈJ�z���(��U��6i�]S�abU�Q$h�˭�+*nq�7��PQ���5��mkN�G��f{�<�.�S���.��<�S)���$���N%���m{�s��%�r�wbFQFZǭ��U�I����|V=Dj�R��~��ø�U����!"�d�U	)V�"UHO�XG�>_>�'xb����sŨ�<�E�c�ԄA��𕖧��/N������ϻW<���N�^S��f�~S g��L���ǰ�08�&%m$�lj��H��`N�1��Umx��2 �#:^P�����o�ڮjt6�S����,eR�L����ԵQ�֏���Ў$O���\�>S��Ht|�s��]n��.[@�U��]i��cSW�<��A�*����(S-�g�D��4��+�Қ��V3�Q`7�_#�ar��1~$|�B��R��!�g���>�倫q���?;m�5+{�.��?��)u������C�~��[���e���{�3(yx���"�Iy4G
�>���Y��4�a�'\���y����l�Bz�umn-���G�{�5��f!1hyB���'MIyFD��>ޛ{;��4���c���WDٟ�,hW��']�����M�'f!/Ij��b
�I��d\2�,΀&ާ�ٛ�����6�3������d��.P&ގ�ٮ�@�MDPu�xz����y�� /A��h�2��\�8'^��9�LAe��8!�x�T�    ��$*Q�&QiV��e�.�:�|��F�aC=�P(�"�L2���$*��sw޽s���q�<�3�Q�p�Śσ�ט/1�0��W� pr��1�����XerC)>��K��tۃ���3����+F��Q&�Ή}�T�E��4�\�=���4�l��?͹�r�Ͻ�fk�!�P�9��\�i��Y��0[	��^�Y%4N_���o�q�4��q MS�6{�Ҵ�� +I"�
^����u����y�=����l<`A"3	����o�;!��Zv8I,�U��$�ƿ �&ȕ�`Bf���'h"1�Qܢ؛���5{��H��CJ�-(IIj� !-Ij#���@*#d'I�W�:�'1JhQd�T���=!W�h�� �@ƒe��]P�	iK�;sې�%V�O��{�q��d�a�#
)���UƤ�p�Eʒ���)���#@0_Q�ʾO㴣X�!�-��A<M:�J��t�\%�5d*����$P{�%�}�9*m;�J&b�y}����N����Z�
YK�RCpb��)8�J�rEIZ��ډ��?�o~\p�}P�9'�Id�!.2�L̰8^8����%�7D�L�)��9H�:~m?4�/�	��r�'����tDHh2$��Q�f�r��;���H�fpfK��!��1��`�f=��4'C���.zW�Z!�ɰ�(�[n�% ���l����ji2!�l(C����Zty;a���;Y҉�A���HL'�p�(C���T*K)67�g�t�r�v�Ʊq�J�&������CI�
��ڔ��L~ J�A�ǒ%���I�ܻ�F�J�Z3�"��-��e�sFt��x�Q/�J]�Ҧ�J�bg�үH�7�j6���)A��xc��#�<*��<*q\�S4�S1Q3�H�b�2_Df��s�+a�jg��RV.��$Ö�49V�׸���1��p<�����|+6[� ��T+�V@�V��}��%\1�Ƭ�^�:Vj�V�Wj_\	Xr�E�>�`1�
��1�(ﭔ��v����!�c!Ò��(��#%eYMf�C
�p&����0���m_M=�h�f>_�X��%�.]���%����9��4�H�r��}!̪(wK�:��- ���mttfFr�C��jv(����(�$jI�!仑�eȨ�B������<��.!�Y�FQ[u��!#a�p�����CJ��ɧ�L��e(���E�ydg,UiPH��<�3C��~u�ăYGU���a��������x� i5!K6Ǥ_���dJ��+Y�d�r����Q</C��=���Xl�ʶ9"|�ݗ#�w����	�/ݦ��|w�!r����B! ��IG�k��}��˚��\���W�]3�X�WX7�,]�+@���JQF�V¶ f�����+��1+!�R�����_���5\�&{�Ǐ��O$�M��,)YnW��Ҵ4vڢ�Ea��J����Z���~�tkIZ��~�GA��4�^3N����4��F���b�A*��]ʃ%�KS���o)�h��� �}�-!g�=��MtAΰ{b:���PhÍ���&>9Z��'9���++�bit��<�HIֆ�L�H_�| R��O�~��h2�4w?d�H�I��/��iZ��:�:i+%�����Zg��b2��ᵐvI���*���M�	�]��JN���!�Kcxk��.�� ����b'�(������%���N~(鷪~��/�]�I���S�4�2���ǥ��]��oaԏ��η׭Di!e�G�|CҴ4w_۟4ݤg�{x�R��%�X��҄+QqN�����i\H��
>�_ K���T҅�:y��s��#Ð�O��4�q���*���5�JOQ��I?�k������d�01b�(_�rgm�r�]J���a}�
.Y0B�Hi3�=�m:O H)/��](��3p�	�O*C��*_�ۏ�C	��?3������;?�B�{R�#�HMڜ�>�u{R��l��]��x�|D��ܔ��J��Kn�K�6�K�+�����*1[Sҙ�
z������!U�?�M����Uorb��u� �%KR�|�Α�$�ݎ���0UI\~�n] @1&�'����w�D ��M�~�
EU�,�Q�;��z�5�\����?�nP�&eU���B�|����+�{!�'��QY{���`O)%M�47���,��/��+��	��xJ�X�lQ���yX�2�U��%��f1����j9�Lt���4hL�_Q�#���ڐY��Nբ���ms�7u7_L.kK9��[f������>���f��$1����j�b,Flެ���k���G�`$�GKU�^�_\$���!���ﮁ�`��!!I�'ЃH0����������0�gk��UX���ȟm��0�

E"�eBex�Jt��v �#&�o�� �W�5�j��	i刋#�Ge�X|�H��JI�ɑ�6�1��H�q��#jt�j��Q����B�?�H�1�]	gsXn	?���$vG��<~9�}`/�T������!x���QN��r$�(ڀ�+zi-~�#�G�V$�9r|�a�t������v�(?�Fk��Ne��#�~�{�sv����f�Xb�:�:`���J�H�1��0G2_�pz�7ʱ�v�*M�>T6��͌�#,{F#D-�s?���gn�x4|YXO�$����<L9Cb��b��.|Q�ҝ�^0�g4C��8H�x���
�h��1�*އt���7�2x4�G�����QB��g�:̶Y��-�������Ch�H!��Ձ��;�Á�"ȯ�oA��P��`_P�8j;2��홑"� �	_T�*;�K�^0������t%�Ss�ȁO"?��^����ؽ8�I�r��s`��]6�y��1��D���K�T˹D.#W�WH#���S�@�F��Ê���Qj8�m�2�/I��}b�a!�Pt���z2]ӚP`����0�Ee���R°f�M͔�lzt���k�T�ˀ늒(��(�|���2�����Wf�9�s a�	Yt�Sr`\�wWL�sY[
s���`L��o׹̍m���7���'m9�pXq�{���]Y������}���j��ds:��Ά��t���N�٨����3`�V��k(kW�ƚȈk	���%�k}��Zb��)�۵|�
�5rڨ�l�Ӛ�+��h��j�\K*�J��Sג=���Ӓ>پ>Ϊ�MB%Kֶ�r�9*b��M�}*T�\G&��� B���'�;��W�"|D�#�������k1G��.8a4T����wfD�u`���\Uܑ���;24>`���~�b����UE_y�Ƒ}��:X���F�xЮ<���6��)D��Y�b9sd0~��)v�(�G��M���W���hGҀ�lR
��p�+�.�s@�#DQZ<��Uā' u!p�O4�`���r �m$��L���$u�������IY'!�:@��h�
��wm$�q@��Z�u �E!������|���Q��][4���R�Կk��T�
H��ѿ�?~{f����gd�� �ߵ�����*u�����n �1��]��q����l2'��u�b�L��gfA:@��O��ʲ� ��-�t@�CKr��>?H���4���B)�l�P����	2�&${,c��h�L����e�w������2E�GI�d��՗&U:��WJ�x��-Е��ყ�dQ4�ԼQ�����)G;�]��GzGY~n/��`����2 ��K�`�����ޗ�t������T4���4=�t �����"m���Y=�,T!̅Dl�8grD@� x6��������N>�o��ŕ*�yT������MF�t���W�
�*���O�m4��$޼�^Ɂ
_>�[]���̨x����	��g>P�Ĺ,x��	�ݦ�X�x��:�����JTd;]��n>NT�7y ��'������'��n�m5۪�	|H�A1-�^���TӠ�; OY�,k4�@�GY>ps ��=c�$�@��\9]Z�Tj� Z   TV�|o��<��}n��ws|�^�Xe^�r��M��e-Ӆ}{�%������
ę������Ooq
:������ƍ��������'%�      �   �   x��K�0D��)r��@��JEld�U��:��fF�SV�M�.d,�؜oT,UY��N����=�����t1�m�O5d��ԇ7�I�ݕ6��g�bVC�­{���k�{BFq6���ou�]B �'�         
  x�uX˒�8<�Wp��KY�7GA�2U-#P͒�?���?��!2�z�֬��@
E�{����l�K�i���>�JeU����Mй0,��j������`򲁑_}�v��7��˚SG8�8E�WuVgv�Sq�\��b��j���U�����05���%�O���<Z��ذݮ��R]��I]܂^�&���Fr��� _���'}��?����#�۬���u���V����[a��,����頏��`nZ�fv��G�(�d�w�!W�7%L����	�QL0��ϛ
������=��n��̯�q�y�6x��h�p�m�������ۚ3Y�F���v{����̖�-L)��h���W�;U?Ά�ʚF�M�Y;���|�HN�g]6F����� C
����.����������nf+Fv��8]	c%)ևχ6��e����6:<�m6��g�L4��89�T_�Ok�	��g�Ӫ��M��T�.�Ǵ�'�0�n�xa��tן��*�L]X��y���#����ݿ��L:�2�D�5��߃q.o"�x�v�vs�*��MЫ�E@�_�>��B��V����'�c����Ì �#�Ul���F&�F�Ke*�[\ �%�Nj;�=|^�C8���7��S��	[�����1š��9��|0H�b7�}�q��TwvƉZ<%�L�� �B�32_� �	���ՂZnj{�s�a��<�]���|��ڎX��n�^�Ɏ���$Nqŧ��~��7� 4�%G� �ۤ���dC�`�����iKh��~���Ǫ��'ȴ<���yk�F�g�<o�6/���yj��߬z�ŁEmޖBvȔ~ļ�1:�x� J��b��=�'TAl��=X-i������X��GV:JIRm�u���5H����Ν.A�6��ݜzZ���Y�TY�%!උ^t <�U�}����O���c���� ����ܘ��[ E�ԙ��o���&No���-�5 Fr��AE�Ste�,�=�CG��w�Y���a����򣳧q�d�Pu��;�r���cԉ/�×DB]��.�J�p���O
�S����A)nD��Ƞ�xPcL5���Ѩ�.�*+:L�E$�P
�Ko��BD�ҟ��� �%v���
g}����e����0T0$�;?���(�X��=�;�WՅ#��NJ��`A���h�ug�
$���F5VT%�	-��D�
��\�6�\"WLMB��݆�Z�q�8�8&Gl�@���N����g�ޮo�®��3"beD�⃄�����y@H�Ll��z8z�tT� �I�׷���ɴ���4
Y���bI�r�YS!��VߌL�f��Ě�#
�
 Y�H�;�$��n�YX؞�s)}��z@��ʒ�S�֞�&��VB�����0��i �TҲ�s�,��W茴#���:�����X_%�3`�(��ynQg�|��H�&g�B�����;��'����Tx���D������Aq~����W}�Ѿ��8��k��	����_�Ԍ"�O�t��:��DY��2�U4��42;�س0�߅(m���Z�TY\�u��@0���M��ye?HQF��A9�}�IeYSK�aiC@��"UT�L�����yZ���Nj�*;�	�^�ee��z_XDd5��D���@"������7l��fR��?Z0��^���$
��T��N���I{�8�0nv���;���ի޽c��y�P����q28JOՆ�:,)N�J2��.�C��U��U�N���̞~iϩ��5쿉;�zǥe+�=�Z���sPH@da��]ǭH�� �|��qɐgĚX�����; R�ྮU
�tO�%ڱ(�aخ~��Ϳ�*s`��p/�Щ)�#�����Gg<q��F�N�Ƅ�S�V�A��p]�đz��"��	�B�J��.ΗTy���a��ޒ�I	���0��a�qlCqU�ό"�Z���շ������]�<�4@�<��\���,���ѐ�wty	��Zu4x�H���cL���b�.Yq =Dg��,��jI��mr��w'����D�X���@�:�A�>����jRyGߘ��MN<����It�,����w�L�U҄X05Tބv��Ǝx��r�{��z��g{6J_��2���%���K�j�BD�Wܔ����ï��(jk��CZ��w6�,�m�M`u�n����&0dx���@�����J��5n�����F���
2)T�ڥ��F0�4��;�N�{�����l,o,�e�J�ގ�:@�Irz��,2{��p�jҝH���Ѐ�q�0�B��I_��='U�)������cI��;D�ٛ�£�F4�rTV1����������~AP�7F�$ڋj�������3��
�N# eV����(�k�x�8�>�n���Wq�!��¹&��t%2�s���f��j�J#p4H�����������'\{��$i+~�9�A�� |�p��/5�/(�a���+X
�jђ�F��Ń�XM��ݿ��<��!hF         �   x�E�K�0��)8j�w�V)$i P/�3�b5��F��h�1XI���-mU�%G����dpO��0�����'x"�#�V��H667J��4;6���X]� 6Y	{�g���#���6a�:�`�Sڥ��8.�@s|��hƿK�:�4$��ȡ
�5��53� �4+            x������ � �         �   x�=�Kn�0D��)t�"�?I��	�ʔ![�R=S/V*��8��fȎ��<��b����u4��%�h�z`=�L=��`C�����9b���Wh��j��������D'���܊��δƂ5���B�\v$y��`�Q�e���t��Sv�8<jL��ƴ�N����;=�kS_P���D�.)Nq���7}��p͵*8���|�nYT�b����7U�#��?9��0��0�j_��l�������������� �RO�      	   @   x�3��uv���sTpqU��s�s�2�ts�u�C5FU�zx�P�E5D�1�+F��� �v         1   x�3�t�����tt�rq��
rw�24�r�uu�t����� ���         !   x�3���	q��w�2�tvvt1c���� ]��         "   x�3��qTps��t�tqt�2qÀL�=... fZ'         !   x�3�ts�u�����2��uv��c���� _.         0  x�u�M��@���)8A���ڶ<M7%h'35��f�#�b���E9�b�=�h=�>A	��z�1�[��e8Ѳ����;�P�[f�>��;�gY���Ƨ�EB�b S����K��9�Ja�[�L�k'���w[[=G^�;{��Q��2�-�@1�
"�ǎv���%!�v��(BH��'npl�\�CvKh��#���(U�2�p��RL+R6��J�[-+Ss����L���ԏ�O�-8ϑ�V�]��{6���z����q�h۔���i�Ͱ�k)��0���[�Y��VBo�[B"I����52��A�yh�A*���Lj���]�%O*{b�Y�1VkAbp�L�ոPv*�$�:��;�e�ʕO�#;�� Iθ����U�����SU
��<�,�A"����'dw��v��-X�R8���or߯��}&ϟpߪS�?q��*>��H��:ɳ����w�e�
$F�#~�浤Ԓ����5'�����a�U-�Ԓ�A�`_f]+�i�z�����[�Q�u����D�'�YX�*�t�q��8n�N�1�{O���p8���7^            x�3�prtu�t����� #��         H   x��1� �:�
_�;ʈ�P�a����n�I̯�E�A�"�Yݺ�t��m������(S;z�h�xg .�            x������ � �         �   x�e�A�� E��]�&�dI���aD�.���c�j�`�0��۟F���`\���՚����\���B�7��a���ܔ���a��)fk���jC�.���|� �� H�V�0l�U.?~�	�4?\��zS�V�WH�fd���M�pq��c���>�k�h9+���`L�B���{� #�%�cHp�)��5ǚd�K
He��o��S�<�R޴�Ӛ�� ��"SP�z5~5M�3fW�            x������ � �      ,      x�3��2���
q����� (L�            x������ � �             x������ � �      #   R   x����0Cky8+v�م:��!S�τ�J�cˮ<2C�̍�6�VP�j�̤�it�UY}���s^�Y�9���       *   $   x�3�t��������2��u�u
r�t����� a�=      %   .   x�3�tvu	�q�2�
u�2�t���2�pv�
q����� ��      '      x�3�4���,N�,��,��N����� G�     