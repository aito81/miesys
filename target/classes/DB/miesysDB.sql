PGDMP         ,                x           miesysDB    12.1    12.1 �    $           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            %           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            &           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            '           1262    18292    miesysDB    DATABASE     �   CREATE DATABASE "miesysDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Paraguay.1252' LC_CTYPE = 'Spanish_Paraguay.1252';
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
       public          postgres    false    245            (           0    0    Tenencia_tenencia_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public."Tenencia_tenencia_seq" OWNED BY public.tenencia.tenencia;
          public          postgres    false    244            �            1259    18293    cabildo    TABLE     �   CREATE TABLE public.cabildo (
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
       public          postgres    false    202            )           0    0    cabildo_id_cabildo_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.cabildo_id_cabildo_seq OWNED BY public.cabildo.cabildo;
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
       public          postgres    false    204            *           0    0    ciudad_id_ciudad_seq    SEQUENCE OWNED BY     J   ALTER SEQUENCE public.ciudad_id_ciudad_seq OWNED BY public.ciudad.ciudad;
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
       public          postgres    false    206            +           0    0    departamento_departamento_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.departamento_departamento_seq OWNED BY public.departamento.departamento;
          public          postgres    false    207            �            1259    18317 	   direccion    TABLE     �   CREATE TABLE public.direccion (
    direccion integer NOT NULL,
    persona integer NOT NULL,
    descripcion character varying NOT NULL,
    laboral boolean NOT NULL,
    ciudad integer
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
       public          postgres    false    208            ,           0    0    direccion_id_direccion_seq    SEQUENCE OWNED BY     V   ALTER SEQUENCE public.direccion_id_direccion_seq OWNED BY public.direccion.direccion;
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
       public          postgres    false    210            -           0    0    distrito_id_distrito_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.distrito_id_distrito_seq OWNED BY public.distrito.distrito;
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
       public          postgres    false    212            .           0    0    division_id_division_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.division_id_division_seq OWNED BY public.division.division;
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
       public          postgres    false    214            /           0    0    empresa_id_empresa_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.empresa_id_empresa_seq OWNED BY public.empresa.empresa;
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
       public          postgres    false    216            0           0    0     estado_civil_id_estado_civil_seq    SEQUENCE OWNED BY     b   ALTER SEQUENCE public.estado_civil_id_estado_civil_seq OWNED BY public.estado_civil.estado_civil;
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
       public          postgres    false    218            1           0    0    estudio_estudio_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.estudio_estudio_seq OWNED BY public.estudio.estudio;
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
       public          postgres    false    220            2           0    0    genero_genero_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.genero_genero_seq OWNED BY public.genero.genero;
          public          postgres    false    221            �            1259    18373    han    TABLE     �   CREATE TABLE public.han (
    han integer NOT NULL,
    distrito integer NOT NULL,
    descripcion character varying NOT NULL,
    direccion character varying,
    cantidad_miembros integer,
    ciudad integer
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
       public          postgres    false    222            3           0    0    han_id_han_seq    SEQUENCE OWNED BY     >   ALTER SEQUENCE public.han_id_han_seq OWNED BY public.han.han;
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
       public          postgres    false    224            4           0    0     nacionalidad_id_nacionalidad_seq    SEQUENCE OWNED BY     b   ALTER SEQUENCE public.nacionalidad_id_nacionalidad_seq OWNED BY public.nacionalidad.nacionalidad;
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
       public          postgres    false    226            5           0    0    ocupacion_id_ocupacion_seq    SEQUENCE OWNED BY     V   ALTER SEQUENCE public.ocupacion_id_ocupacion_seq OWNED BY public.ocupacion.ocupacion;
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
       public          postgres    false    228            6           0    0    perfil_perfil_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.perfil_perfil_seq OWNED BY public.perfil.perfil;
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
       public          postgres    false    230            7           0    0    persona_id_persona_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public.persona_id_persona_seq OWNED BY public.persona.persona;
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
       public          postgres    false    232            8           0    0    recomendado_id_recomendado_seq    SEQUENCE OWNED BY     ^   ALTER SEQUENCE public.recomendado_id_recomendado_seq OWNED BY public.recomendado.recomendado;
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
       public          postgres    false    247            9           0    0    region_region_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.region_region_seq OWNED BY public.region.region;
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
       public          postgres    false    235            :           0    0 )   reunion_asistencia_reunion_asistencia_seq    SEQUENCE OWNED BY     w   ALTER SEQUENCE public.reunion_asistencia_reunion_asistencia_seq OWNED BY public.reunion_asistencia.reunion_asistencia;
          public          postgres    false    236            �            1259    18426    reunion_reunion_seq    SEQUENCE     �   CREATE SEQUENCE public.reunion_reunion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.reunion_reunion_seq;
       public          postgres    false    234            ;           0    0    reunion_reunion_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.reunion_reunion_seq OWNED BY public.reunion.reunion;
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
       public          postgres    false    238            <           0    0    telefono_id_telefono_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.telefono_id_telefono_seq OWNED BY public.telefono.telefono;
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
       public          postgres    false    240            =           0    0 $   tipo_documento_id_tipo_documento_seq    SEQUENCE OWNED BY     j   ALTER SEQUENCE public.tipo_documento_id_tipo_documento_seq OWNED BY public.tipo_documento.tipo_documento;
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
       public          postgres    false    242            >           0    0    usuario_usuario_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.usuario_usuario_seq OWNED BY public.usuario.usuario;
          public          postgres    false    243                       2604    18452    cabildo cabildo    DEFAULT     u   ALTER TABLE ONLY public.cabildo ALTER COLUMN cabildo SET DEFAULT nextval('public.cabildo_id_cabildo_seq'::regclass);
 >   ALTER TABLE public.cabildo ALTER COLUMN cabildo DROP DEFAULT;
       public          postgres    false    203    202                       2604    18453    ciudad ciudad    DEFAULT     q   ALTER TABLE ONLY public.ciudad ALTER COLUMN ciudad SET DEFAULT nextval('public.ciudad_id_ciudad_seq'::regclass);
 <   ALTER TABLE public.ciudad ALTER COLUMN ciudad DROP DEFAULT;
       public          postgres    false    205    204                       2604    18454    departamento departamento    DEFAULT     �   ALTER TABLE ONLY public.departamento ALTER COLUMN departamento SET DEFAULT nextval('public.departamento_departamento_seq'::regclass);
 H   ALTER TABLE public.departamento ALTER COLUMN departamento DROP DEFAULT;
       public          postgres    false    207    206                       2604    18455    direccion direccion    DEFAULT     }   ALTER TABLE ONLY public.direccion ALTER COLUMN direccion SET DEFAULT nextval('public.direccion_id_direccion_seq'::regclass);
 B   ALTER TABLE public.direccion ALTER COLUMN direccion DROP DEFAULT;
       public          postgres    false    209    208                       2604    18456    distrito distrito    DEFAULT     y   ALTER TABLE ONLY public.distrito ALTER COLUMN distrito SET DEFAULT nextval('public.distrito_id_distrito_seq'::regclass);
 @   ALTER TABLE public.distrito ALTER COLUMN distrito DROP DEFAULT;
       public          postgres    false    211    210                       2604    18457    division division    DEFAULT     y   ALTER TABLE ONLY public.division ALTER COLUMN division SET DEFAULT nextval('public.division_id_division_seq'::regclass);
 @   ALTER TABLE public.division ALTER COLUMN division DROP DEFAULT;
       public          postgres    false    213    212                       2604    18458    empresa empresa    DEFAULT     u   ALTER TABLE ONLY public.empresa ALTER COLUMN empresa SET DEFAULT nextval('public.empresa_id_empresa_seq'::regclass);
 >   ALTER TABLE public.empresa ALTER COLUMN empresa DROP DEFAULT;
       public          postgres    false    215    214                       2604    18459    estado_civil estado_civil    DEFAULT     �   ALTER TABLE ONLY public.estado_civil ALTER COLUMN estado_civil SET DEFAULT nextval('public.estado_civil_id_estado_civil_seq'::regclass);
 H   ALTER TABLE public.estado_civil ALTER COLUMN estado_civil DROP DEFAULT;
       public          postgres    false    217    216                       2604    18460    estudio estudio    DEFAULT     r   ALTER TABLE ONLY public.estudio ALTER COLUMN estudio SET DEFAULT nextval('public.estudio_estudio_seq'::regclass);
 >   ALTER TABLE public.estudio ALTER COLUMN estudio DROP DEFAULT;
       public          postgres    false    219    218                       2604    18461    genero genero    DEFAULT     n   ALTER TABLE ONLY public.genero ALTER COLUMN genero SET DEFAULT nextval('public.genero_genero_seq'::regclass);
 <   ALTER TABLE public.genero ALTER COLUMN genero DROP DEFAULT;
       public          postgres    false    221    220                        2604    18462    han han    DEFAULT     e   ALTER TABLE ONLY public.han ALTER COLUMN han SET DEFAULT nextval('public.han_id_han_seq'::regclass);
 6   ALTER TABLE public.han ALTER COLUMN han DROP DEFAULT;
       public          postgres    false    223    222            !           2604    18463    nacionalidad nacionalidad    DEFAULT     �   ALTER TABLE ONLY public.nacionalidad ALTER COLUMN nacionalidad SET DEFAULT nextval('public.nacionalidad_id_nacionalidad_seq'::regclass);
 H   ALTER TABLE public.nacionalidad ALTER COLUMN nacionalidad DROP DEFAULT;
       public          postgres    false    225    224            "           2604    18464    ocupacion ocupacion    DEFAULT     }   ALTER TABLE ONLY public.ocupacion ALTER COLUMN ocupacion SET DEFAULT nextval('public.ocupacion_id_ocupacion_seq'::regclass);
 B   ALTER TABLE public.ocupacion ALTER COLUMN ocupacion DROP DEFAULT;
       public          postgres    false    227    226            #           2604    18465    perfil perfil    DEFAULT     n   ALTER TABLE ONLY public.perfil ALTER COLUMN perfil SET DEFAULT nextval('public.perfil_perfil_seq'::regclass);
 <   ALTER TABLE public.perfil ALTER COLUMN perfil DROP DEFAULT;
       public          postgres    false    229    228            $           2604    18466    persona persona    DEFAULT     u   ALTER TABLE ONLY public.persona ALTER COLUMN persona SET DEFAULT nextval('public.persona_id_persona_seq'::regclass);
 >   ALTER TABLE public.persona ALTER COLUMN persona DROP DEFAULT;
       public          postgres    false    231    230            %           2604    18467    recomendado recomendado    DEFAULT     �   ALTER TABLE ONLY public.recomendado ALTER COLUMN recomendado SET DEFAULT nextval('public.recomendado_id_recomendado_seq'::regclass);
 F   ALTER TABLE public.recomendado ALTER COLUMN recomendado DROP DEFAULT;
       public          postgres    false    233    232            ,           2604    18659    region region    DEFAULT     n   ALTER TABLE ONLY public.region ALTER COLUMN region SET DEFAULT nextval('public.region_region_seq'::regclass);
 <   ALTER TABLE public.region ALTER COLUMN region DROP DEFAULT;
       public          postgres    false    247    246    247            &           2604    18468    reunion reunion    DEFAULT     r   ALTER TABLE ONLY public.reunion ALTER COLUMN reunion SET DEFAULT nextval('public.reunion_reunion_seq'::regclass);
 >   ALTER TABLE public.reunion ALTER COLUMN reunion DROP DEFAULT;
       public          postgres    false    237    234            '           2604    18469 %   reunion_asistencia reunion_asistencia    DEFAULT     �   ALTER TABLE ONLY public.reunion_asistencia ALTER COLUMN reunion_asistencia SET DEFAULT nextval('public.reunion_asistencia_reunion_asistencia_seq'::regclass);
 T   ALTER TABLE public.reunion_asistencia ALTER COLUMN reunion_asistencia DROP DEFAULT;
       public          postgres    false    236    235            (           2604    18470    telefono telefono    DEFAULT     y   ALTER TABLE ONLY public.telefono ALTER COLUMN telefono SET DEFAULT nextval('public.telefono_id_telefono_seq'::regclass);
 @   ALTER TABLE public.telefono ALTER COLUMN telefono DROP DEFAULT;
       public          postgres    false    239    238            +           2604    18642    tenencia tenencia    DEFAULT     x   ALTER TABLE ONLY public.tenencia ALTER COLUMN tenencia SET DEFAULT nextval('public."Tenencia_tenencia_seq"'::regclass);
 @   ALTER TABLE public.tenencia ALTER COLUMN tenencia DROP DEFAULT;
       public          postgres    false    245    244    245            )           2604    18471    tipo_documento tipo_documento    DEFAULT     �   ALTER TABLE ONLY public.tipo_documento ALTER COLUMN tipo_documento SET DEFAULT nextval('public.tipo_documento_id_tipo_documento_seq'::regclass);
 L   ALTER TABLE public.tipo_documento ALTER COLUMN tipo_documento DROP DEFAULT;
       public          postgres    false    241    240            *           2604    18472    usuario usuario    DEFAULT     r   ALTER TABLE ONLY public.usuario ALTER COLUMN usuario SET DEFAULT nextval('public.usuario_usuario_seq'::regclass);
 >   ALTER TABLE public.usuario ALTER COLUMN usuario DROP DEFAULT;
       public          postgres    false    243    242            �          0    18293    cabildo 
   TABLE DATA           ?   COPY public.cabildo (cabildo, descripcion, region) FROM stdin;
    public          postgres    false    202   ��       �          0    18301    ciudad 
   TABLE DATA           C   COPY public.ciudad (ciudad, departamento, descripcion) FROM stdin;
    public          postgres    false    204   ��       �          0    18309    departamento 
   TABLE DATA           A   COPY public.departamento (departamento, descripcion) FROM stdin;
    public          postgres    false    206   ��       �          0    18317 	   direccion 
   TABLE DATA           U   COPY public.direccion (direccion, persona, descripcion, laboral, ciudad) FROM stdin;
    public          postgres    false    208   ��       �          0    18325    distrito 
   TABLE DATA           B   COPY public.distrito (distrito, cabildo, descripcion) FROM stdin;
    public          postgres    false    210    �       �          0    18333    division 
   TABLE DATA           9   COPY public.division (division, descripcion) FROM stdin;
    public          postgres    false    212   O�                  0    18341    empresa 
   TABLE DATA           7   COPY public.empresa (empresa, descripcion) FROM stdin;
    public          postgres    false    214   ��                 0    18349    estado_civil 
   TABLE DATA           A   COPY public.estado_civil (estado_civil, descripcion) FROM stdin;
    public          postgres    false    216   ��                 0    18357    estudio 
   TABLE DATA           7   COPY public.estudio (estudio, descripcion) FROM stdin;
    public          postgres    false    218   �                 0    18365    genero 
   TABLE DATA           5   COPY public.genero (genero, descripcion) FROM stdin;
    public          postgres    false    220   C�                 0    18373    han 
   TABLE DATA           _   COPY public.han (han, distrito, descripcion, direccion, cantidad_miembros, ciudad) FROM stdin;
    public          postgres    false    222   t�       
          0    18381    nacionalidad 
   TABLE DATA           A   COPY public.nacionalidad (nacionalidad, descripcion) FROM stdin;
    public          postgres    false    224   ��                 0    18389 	   ocupacion 
   TABLE DATA           ;   COPY public.ocupacion (ocupacion, descripcion) FROM stdin;
    public          postgres    false    226   ��                 0    18397    perfil 
   TABLE DATA           5   COPY public.perfil (perfil, descripcion) FROM stdin;
    public          postgres    false    228   1�                 0    18405    persona 
   TABLE DATA           �   COPY public.persona (persona, nombre, apellido, tipo_documento, numero_documento, nacionalidad, estado_civil, cantidad_hijos, ocupacion, fecha_nacimiento, empresa, fecha_inicio, division, han, genero, miembro_con) FROM stdin;
    public          postgres    false    230   N�                 0    18413    recomendado 
   TABLE DATA           Y   COPY public.recomendado (recomendado, persona, recomendador1, recomendador2) FROM stdin;
    public          postgres    false    232   M�       !          0    18656    region 
   TABLE DATA           5   COPY public.region (region, descripcion) FROM stdin;
    public          postgres    false    247   j�                 0    18418    reunion 
   TABLE DATA           `   COPY public.reunion (reunion, han, estudio, fecha, persona, cantidad_participantes) FROM stdin;
    public          postgres    false    234   ��                 0    18421    reunion_asistencia 
   TABLE DATA           R   COPY public.reunion_asistencia (reunion_asistencia, reunion, persona) FROM stdin;
    public          postgres    false    235   ��                 0    18428    telefono 
   TABLE DATA           K   COPY public.telefono (telefono, descripcion, laboral, persona) FROM stdin;
    public          postgres    false    238   ��                 0    18639    tenencia 
   TABLE DATA           9   COPY public.tenencia (tenencia, descripcion) FROM stdin;
    public          postgres    false    245   1�                 0    18436    tipo_documento 
   TABLE DATA           E   COPY public.tipo_documento (tipo_documento, descripcion) FROM stdin;
    public          postgres    false    240   e�                 0    18444    usuario 
   TABLE DATA           O   COPY public.usuario (usuario, persona, perfil, descripcion, clave) FROM stdin;
    public          postgres    false    242   ��       ?           0    0    Tenencia_tenencia_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."Tenencia_tenencia_seq"', 4, true);
          public          postgres    false    244            @           0    0    cabildo_id_cabildo_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cabildo_id_cabildo_seq', 2, true);
          public          postgres    false    203            A           0    0    ciudad_id_ciudad_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.ciudad_id_ciudad_seq', 1, false);
          public          postgres    false    205            B           0    0    departamento_departamento_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.departamento_departamento_seq', 1, false);
          public          postgres    false    207            C           0    0    direccion_id_direccion_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.direccion_id_direccion_seq', 12, true);
          public          postgres    false    209            D           0    0    distrito_id_distrito_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.distrito_id_distrito_seq', 4, true);
          public          postgres    false    211            E           0    0    division_id_division_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.division_id_division_seq', 4, true);
          public          postgres    false    213            F           0    0    empresa_id_empresa_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.empresa_id_empresa_seq', 10, true);
          public          postgres    false    215            G           0    0     estado_civil_id_estado_civil_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.estado_civil_id_estado_civil_seq', 1, false);
          public          postgres    false    217            H           0    0    estudio_estudio_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.estudio_estudio_seq', 3, true);
          public          postgres    false    219            I           0    0    genero_genero_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.genero_genero_seq', 1, false);
          public          postgres    false    221            J           0    0    han_id_han_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.han_id_han_seq', 7, true);
          public          postgres    false    223            K           0    0     nacionalidad_id_nacionalidad_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.nacionalidad_id_nacionalidad_seq', 1, true);
          public          postgres    false    225            L           0    0    ocupacion_id_ocupacion_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.ocupacion_id_ocupacion_seq', 12, true);
          public          postgres    false    227            M           0    0    perfil_perfil_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.perfil_perfil_seq', 1, false);
          public          postgres    false    229            N           0    0    persona_id_persona_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.persona_id_persona_seq', 11, true);
          public          postgres    false    231            O           0    0    recomendado_id_recomendado_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.recomendado_id_recomendado_seq', 1, false);
          public          postgres    false    233            P           0    0    region_region_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.region_region_seq', 2, true);
          public          postgres    false    246            Q           0    0 )   reunion_asistencia_reunion_asistencia_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.reunion_asistencia_reunion_asistencia_seq', 97, true);
          public          postgres    false    236            R           0    0    reunion_reunion_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.reunion_reunion_seq', 15, true);
          public          postgres    false    237            S           0    0    telefono_id_telefono_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.telefono_id_telefono_seq', 11, true);
          public          postgres    false    239            T           0    0 $   tipo_documento_id_tipo_documento_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.tipo_documento_id_tipo_documento_seq', 1, false);
          public          postgres    false    241            U           0    0    usuario_usuario_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.usuario_usuario_seq', 1, true);
          public          postgres    false    243            X           2606    18644    tenencia Tenencia_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tenencia
    ADD CONSTRAINT "Tenencia_pkey" PRIMARY KEY (tenencia);
 B   ALTER TABLE ONLY public.tenencia DROP CONSTRAINT "Tenencia_pkey";
       public            postgres    false    245            .           2606    18474    cabildo cabildo_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cabildo
    ADD CONSTRAINT cabildo_pkey PRIMARY KEY (cabildo);
 >   ALTER TABLE ONLY public.cabildo DROP CONSTRAINT cabildo_pkey;
       public            postgres    false    202            0           2606    18476    ciudad ciudad_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (ciudad);
 <   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT ciudad_pkey;
       public            postgres    false    204            2           2606    18478    departamento departamento_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (departamento);
 H   ALTER TABLE ONLY public.departamento DROP CONSTRAINT departamento_pkey;
       public            postgres    false    206            4           2606    18480    direccion direccion_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT direccion_pkey PRIMARY KEY (direccion);
 B   ALTER TABLE ONLY public.direccion DROP CONSTRAINT direccion_pkey;
       public            postgres    false    208            6           2606    18482    distrito distrito_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.distrito
    ADD CONSTRAINT distrito_pkey PRIMARY KEY (distrito);
 @   ALTER TABLE ONLY public.distrito DROP CONSTRAINT distrito_pkey;
       public            postgres    false    210            8           2606    18484    division division_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.division
    ADD CONSTRAINT division_pkey PRIMARY KEY (division);
 @   ALTER TABLE ONLY public.division DROP CONSTRAINT division_pkey;
       public            postgres    false    212            :           2606    18486    empresa empresa_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (empresa);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            postgres    false    214            <           2606    18488    estado_civil estado_civil_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.estado_civil
    ADD CONSTRAINT estado_civil_pkey PRIMARY KEY (estado_civil);
 H   ALTER TABLE ONLY public.estado_civil DROP CONSTRAINT estado_civil_pkey;
       public            postgres    false    216            >           2606    18490    estudio estudio_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.estudio
    ADD CONSTRAINT estudio_pkey PRIMARY KEY (estudio);
 >   ALTER TABLE ONLY public.estudio DROP CONSTRAINT estudio_pkey;
       public            postgres    false    218            @           2606    18492    genero genero_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (genero);
 <   ALTER TABLE ONLY public.genero DROP CONSTRAINT genero_pkey;
       public            postgres    false    220            B           2606    18494    han han_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY public.han
    ADD CONSTRAINT han_pkey PRIMARY KEY (han);
 6   ALTER TABLE ONLY public.han DROP CONSTRAINT han_pkey;
       public            postgres    false    222            D           2606    18496    nacionalidad nacionalidad_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.nacionalidad
    ADD CONSTRAINT nacionalidad_pkey PRIMARY KEY (nacionalidad);
 H   ALTER TABLE ONLY public.nacionalidad DROP CONSTRAINT nacionalidad_pkey;
       public            postgres    false    224            F           2606    18498    ocupacion ocupacion_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.ocupacion
    ADD CONSTRAINT ocupacion_pkey PRIMARY KEY (ocupacion);
 B   ALTER TABLE ONLY public.ocupacion DROP CONSTRAINT ocupacion_pkey;
       public            postgres    false    226            H           2606    18500    perfil perfil_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (perfil);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public            postgres    false    228            J           2606    18502    persona persona_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (persona);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    230            L           2606    18504    recomendado recomendado_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_pkey PRIMARY KEY (recomendado);
 F   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_pkey;
       public            postgres    false    232            Z           2606    18664    region region_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.region
    ADD CONSTRAINT region_pkey PRIMARY KEY (region);
 <   ALTER TABLE ONLY public.region DROP CONSTRAINT region_pkey;
       public            postgres    false    247            P           2606    18506 *   reunion_asistencia reunion_asistencia_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.reunion_asistencia
    ADD CONSTRAINT reunion_asistencia_pkey PRIMARY KEY (reunion_asistencia);
 T   ALTER TABLE ONLY public.reunion_asistencia DROP CONSTRAINT reunion_asistencia_pkey;
       public            postgres    false    235            N           2606    18508    reunion reunion_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_pkey PRIMARY KEY (reunion);
 >   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_pkey;
       public            postgres    false    234            R           2606    18510    telefono telefono_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.telefono
    ADD CONSTRAINT telefono_pkey PRIMARY KEY (telefono);
 @   ALTER TABLE ONLY public.telefono DROP CONSTRAINT telefono_pkey;
       public            postgres    false    238            T           2606    18512 "   tipo_documento tipo_documento_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT tipo_documento_pkey PRIMARY KEY (tipo_documento);
 L   ALTER TABLE ONLY public.tipo_documento DROP CONSTRAINT tipo_documento_pkey;
       public            postgres    false    240            V           2606    18514    usuario usuario_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    242            [           2606    18665    cabildo cabildo_region_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cabildo
    ADD CONSTRAINT cabildo_region_fkey FOREIGN KEY (region) REFERENCES public.region(region) NOT VALID;
 E   ALTER TABLE ONLY public.cabildo DROP CONSTRAINT cabildo_region_fkey;
       public          postgres    false    2906    202    247            \           2606    18515    ciudad ciudad_departamento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_departamento_fkey FOREIGN KEY (departamento) REFERENCES public.departamento(departamento) NOT VALID;
 I   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT ciudad_departamento_fkey;
       public          postgres    false    204    206    2866            ]           2606    18520 "   direccion direccion_id_ciudad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT direccion_id_ciudad_fkey FOREIGN KEY (ciudad) REFERENCES public.ciudad(ciudad) NOT VALID;
 L   ALTER TABLE ONLY public.direccion DROP CONSTRAINT direccion_id_ciudad_fkey;
       public          postgres    false    208    204    2864            ^           2606    18525 #   direccion direccion_id_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.direccion
    ADD CONSTRAINT direccion_id_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 M   ALTER TABLE ONLY public.direccion DROP CONSTRAINT direccion_id_persona_fkey;
       public          postgres    false    208    230    2890            _           2606    18530 !   distrito distrito_id_cabildo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.distrito
    ADD CONSTRAINT distrito_id_cabildo_fkey FOREIGN KEY (cabildo) REFERENCES public.cabildo(cabildo) NOT VALID;
 K   ALTER TABLE ONLY public.distrito DROP CONSTRAINT distrito_id_cabildo_fkey;
       public          postgres    false    210    202    2862            a           2606    18670    han han_ciudad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.han
    ADD CONSTRAINT han_ciudad_fkey FOREIGN KEY (ciudad) REFERENCES public.ciudad(ciudad) NOT VALID;
 =   ALTER TABLE ONLY public.han DROP CONSTRAINT han_ciudad_fkey;
       public          postgres    false    2864    222    204            `           2606    18535    han han_id_distrito_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.han
    ADD CONSTRAINT han_id_distrito_fkey FOREIGN KEY (distrito) REFERENCES public.distrito(distrito) NOT VALID;
 B   ALTER TABLE ONLY public.han DROP CONSTRAINT han_id_distrito_fkey;
       public          postgres    false    210    222    2870            b           2606    18540    persona persona_division_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_division_fkey FOREIGN KEY (division) REFERENCES public.division(division) NOT VALID;
 G   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_division_fkey;
       public          postgres    false    230    212    2872            c           2606    18545    persona persona_empresa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_empresa_fkey FOREIGN KEY (empresa) REFERENCES public.empresa(empresa) NOT VALID;
 F   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_empresa_fkey;
       public          postgres    false    2874    230    214            d           2606    18550 !   persona persona_estado_civil_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_estado_civil_fkey FOREIGN KEY (estado_civil) REFERENCES public.estado_civil(estado_civil) NOT VALID;
 K   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_estado_civil_fkey;
       public          postgres    false    216    2876    230            e           2606    18555    persona persona_genero_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_genero_fkey FOREIGN KEY (genero) REFERENCES public.genero(genero) NOT VALID;
 E   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_genero_fkey;
       public          postgres    false    230    220    2880            f           2606    18560    persona persona_han_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_han_fkey FOREIGN KEY (han) REFERENCES public.han(han) NOT VALID;
 B   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_han_fkey;
       public          postgres    false    230    222    2882            j           2606    18645     persona persona_miembro_con_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_miembro_con_fkey FOREIGN KEY (miembro_con) REFERENCES public.tenencia(tenencia) NOT VALID;
 J   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_miembro_con_fkey;
       public          postgres    false    245    2904    230            g           2606    18565 !   persona persona_nacionalidad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_nacionalidad_fkey FOREIGN KEY (nacionalidad) REFERENCES public.nacionalidad(nacionalidad) NOT VALID;
 K   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_nacionalidad_fkey;
       public          postgres    false    224    230    2884            h           2606    18570    persona persona_ocupacion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_ocupacion_fkey FOREIGN KEY (ocupacion) REFERENCES public.ocupacion(ocupacion) NOT VALID;
 H   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_ocupacion_fkey;
       public          postgres    false    230    226    2886            i           2606    18575 #   persona persona_tipo_documento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_tipo_documento_fkey FOREIGN KEY (tipo_documento) REFERENCES public.tipo_documento(tipo_documento) NOT VALID;
 M   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_tipo_documento_fkey;
       public          postgres    false    240    230    2900            k           2606    18580 '   recomendado recomendado_id_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_id_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 Q   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_id_persona_fkey;
       public          postgres    false    2890    232    230            l           2606    18585 -   recomendado recomendado_id_recomendador1_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_id_recomendador1_fkey FOREIGN KEY (recomendador1) REFERENCES public.persona(persona) NOT VALID;
 W   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_id_recomendador1_fkey;
       public          postgres    false    2890    230    232            m           2606    18590 -   recomendado recomendado_id_recomendador2_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.recomendado
    ADD CONSTRAINT recomendado_id_recomendador2_fkey FOREIGN KEY (recomendador2) REFERENCES public.persona(persona) NOT VALID;
 W   ALTER TABLE ONLY public.recomendado DROP CONSTRAINT recomendado_id_recomendador2_fkey;
       public          postgres    false    230    2890    232            q           2606    18595 2   reunion_asistencia reunion_asistencia_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion_asistencia
    ADD CONSTRAINT reunion_asistencia_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 \   ALTER TABLE ONLY public.reunion_asistencia DROP CONSTRAINT reunion_asistencia_persona_fkey;
       public          postgres    false    235    230    2890            r           2606    18600 2   reunion_asistencia reunion_asistencia_reunion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion_asistencia
    ADD CONSTRAINT reunion_asistencia_reunion_fkey FOREIGN KEY (reunion) REFERENCES public.reunion(reunion) NOT VALID;
 \   ALTER TABLE ONLY public.reunion_asistencia DROP CONSTRAINT reunion_asistencia_reunion_fkey;
       public          postgres    false    234    235    2894            n           2606    18605    reunion reunion_estudio_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_estudio_fkey FOREIGN KEY (estudio) REFERENCES public.estudio(estudio) NOT VALID;
 F   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_estudio_fkey;
       public          postgres    false    218    2878    234            o           2606    18610    reunion reunion_han_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_han_fkey FOREIGN KEY (han) REFERENCES public.han(han) NOT VALID;
 B   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_han_fkey;
       public          postgres    false    234    2882    222            p           2606    18615    reunion reunion_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reunion
    ADD CONSTRAINT reunion_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 F   ALTER TABLE ONLY public.reunion DROP CONSTRAINT reunion_persona_fkey;
       public          postgres    false    2890    234    230            s           2606    18620    telefono telefono_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.telefono
    ADD CONSTRAINT telefono_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 H   ALTER TABLE ONLY public.telefono DROP CONSTRAINT telefono_persona_fkey;
       public          postgres    false    230    238    2890            t           2606    18625    usuario usuario_perfil_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_perfil_fkey FOREIGN KEY (perfil) REFERENCES public.perfil(perfil) NOT VALID;
 E   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_perfil_fkey;
       public          postgres    false    2888    228    242            u           2606    18630    usuario usuario_persona_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_persona_fkey FOREIGN KEY (persona) REFERENCES public.persona(persona) NOT VALID;
 F   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_persona_fkey;
       public          postgres    false    2890    242    230            �      x�3����srv�4�����  �)      �   
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
�jђ�F��Ń�XM��ݿ��<��!hF      �   �   x�E�K�0��)8j�w�V)$i P/�3�b5��F��h�1XI���-mU�%G����dpO��0�����'x"�#�V��H667J��4;6���X]� 6Y	{�g���#���6a�:�`�Sڥ��8.�@s|��hƿK�:�4$��ȡ
�5��53� �4+      �   g   x�]�I
�@��+|��N��_�4n.���wF<Ir�)P���Z��m� )�e����$�2%��[tԳ���E�atp�;��;��Q��oJ�ң��nR����      �      x�3�4�q��22�C}]�B�b���� ?c�      �   @   x�3��uv���sTpqU��s�s�2�ts�u�C5FU�zx�P�E5D�1�+F��� �v          1   x�3�t�����tt�rq��
rw�24�r�uu�t����� ���         !   x�3���	q��w�2�tvvt1c���� ]��         "   x�3��qTps��t�tqt�2qÀL�=... fZ'         !   x�3�ts�u�����2��uv��c���� _.         ,   x�3�4�v�u
rt�rVpqUp��qt�� �=... ��	K      
      x�3�prtu�t����� #��         H   x��1� �:�
_�;ʈ�P�a����n�I̯�E�A�"�Yݺ�t��m������(S;z�h�xg .�            x������ � �         �   x�e��n� ��ͻd���pI�Q�0ѦU��9f�a݊�9����Vp��R�K(!�+ hM�x�� %��M��I=<�u����18�t�����Z=�!��q��$�k_{�a���S��ri J!᫾��������O����`�P�kv��˿!88�2���[k�6z秕�vh*���W�,<�%4�f�M���֏� }��d���)<��e|�����I�ap����C��Y1            x������ � �      !      x�3��2���
q����� (L�            x������ � �            x������ � �         R   x����0Cky8+v�م:��!S�τ�J�cˮ<2C�̍�6�VP�j�̤�it�UY}���s^�Y�9���          $   x�3�t��������2��u�u
r�t����� a�=         .   x�3�tvu	�q�2�
u�2�t���2�pv�
q����� ��            x�3�4���,N�,��,��N����� G�     