create table tb_usuario
( 
	tb_usuario_id serial not null,
	tb_usuario_cod character(4) not null,
	tb_usuario_apepat character varying(50) not null,
	tb_usuario_apemat character varying(50) not null,
	tb_usuario_nom character varying(50) not null,
	tb_usuario_corele character varying(50) not null,
	tb_usuario_usenam character varying(50) not null,
	tb_usuario_pas character varying(50) not null,
	constraint pk_usuario primary key(tb_usuario_id),
	constraint unq_usuario_cod unique(tb_usuario_cod),
	constraint unq_usuario_apepatapematnom unique(tb_usuario_apepat,tb_usuario_apemat,tb_usuario_nom),
	constraint unq_usuario_corele unique(tb_usuario_corele),
	constraint unq_usuario_usenampas unique(tb_usuario_usenam,tb_usuario_pas),
	constraint chk_usuario_id check(tb_usuario_id > 0),
	constraint chk_usuario_cod check(tb_usuario_cod similar to '[0-9][0-9][0-9][0-9]')
);

create table tb_acceso
(
	tb_acceso_id serial not null,
	tb_acceso_fecini date not null,
	tb_acceso_fecter date not null,
	tb_acceso_rol character(1) not null, -- Puede ser: R(Operador de recepción de pedidos), D(Operador de despacho de pedidos), A(Administrador del negocio)
	tb_usuario_id integer not null,
	constraint pk_acceso primary key(tb_acceso_id),
	constraint fk_usuario_pedido foreign key(tb_usuario_id) references tb_usuario(tb_usuario_id),
	constraint chk_acceso_fecini check(tb_acceso_fecini <= cast(now() as date)),
	constraint chk_acceso_fecter check(tb_acceso_fecter <= cast(now() as date)),
	constraint chk_acceso_fecinifecter check(tb_acceso_fecini <= tb_acceso_fecter),
	constraint chk_acceso_rol check(tb_acceso_rol in ('R','D','A'))
);

create table tb_producto
(
	tb_producto_id serial not null,
	tb_producto_cod character(4) not null,
	tb_producto_nom character varying(50) not null,
	tb_producto_desc character varying(140) not null,
	tb_producto_img character varying(50) not null,
	tb_producto_preuni decimal(10,2) not null,
	constraint pk_producto primary key(tb_producto_id),
	constraint unq_producto_cod unique(tb_producto_cod),
	constraint unq_producto_nom unique(tb_producto_nom),
	constraint unq_producto_img unique(tb_producto_img),
	constraint chk_producto_id check(tb_producto_id > 0),
	constraint chk_producto_cod check(tb_producto_cod similar to '[0-9][0-9][0-9][0-9]'),
	constraint chk_producto_preuni check(tb_producto_preuni > 0.00)
);

create table tb_ciudad
(
	tb_ciudad_id serial not null,
	tb_ciudad_cod character(4) not null,
	tb_ciudad_nom character varying(50) not null,
	tb_ciudad_pretel character(2) not null,
	constraint pk_ciudad primary key(tb_ciudad_id),
	constraint unq_ciudad_cod unique(tb_ciudad_cod),
	constraint unq_ciudad_nom unique(tb_ciudad_nom),
	constraint unq_ciudad_pretel unique(tb_ciudad_pretel),
	constraint chk_ciudad_id check(tb_ciudad_id > 0),
	constraint chk_ciudad_cod check(tb_ciudad_cod similar to '[0-9][0-9][0-9][0-9]'),
	constraint chk_ciudad_pretel check(tb_ciudad_pretel similar to '[0-9][0-9]')
);

create table tb_pedido
(
	tb_pedido_id serial not null,
	tb_pedido_fechor timestamp not null default now(),
	tb_pedido_cli character varying(50) not null,
	tb_pedido_dir character varying(50) not null,
	tb_pedido_telfij character(6) not null,
	tb_pedido_imp decimal(10,2) not null,
	tb_pedido_pag decimal(10,2) not null,
	tb_pedido_vue decimal(10,2) not null,
	tb_pedido_est character(1) not null default 'P',
	tb_ciudad_id integer not null,
	tb_usuario_id integer not null,
	constraint pk_pedido primary key(tb_pedido_id),
	constraint fk_ciudad_pedido foreign key(tb_ciudad_id) references tb_ciudad(tb_ciudad_id),
	constraint fk_usuario_pedido foreign key(tb_usuario_id) references tb_usuario(tb_usuario_id),
	constraint chk_pedido_id check(tb_pedido_id > 0),
	constraint chk_pedido_fechor check(tb_pedido_fechor <= now()),
	constraint chk_pedido_telfij check(tb_pedido_telfij similar to '[0-9][0-9][0-9][0-9][0-9][0-9]'),
	constraint chk_pedido_imp check(tb_pedido_imp > 0.00),
	constraint chk_pedido_pag check(tb_pedido_pag > 0.00),
	constraint chk_pedido_vue check(tb_pedido_vue >= 0.00),
	constraint chk_pedido_est check(tb_pedido_est in ('P','C','D','A')) 
	-- P: Pedido por confirmar, C: Pedido confirmado, D: Pedido despachado, A: Pedido Anulado
);

create table tb_detallepedido
(
	tb_detallepedido_id serial not null,
	tb_detallepedido_can decimal(10,2) not null,
	tb_detallepedido_preuni decimal(10,2) not null,
	tb_detallepedido_subtot decimal(10,2) not null,
	tb_pedido_id integer not null, tb_producto_id integer not null,
	constraint pk_detallepedido primary key(tb_detallepedido_id),
	constraint fk_pedido_detallepedido foreign key(tb_pedido_id) references tb_pedido(tb_pedido_id),
	constraint fk_producto_detallepedido foreign key(tb_producto_id) references tb_producto(tb_producto_id),
	constraint chk_detallepedido_id check(tb_detallepedido_id > 0),
	constraint chk_detallepedido_can check(tb_detallepedido_can > 0.00),
	constraint chk_detallepedido_preuni check(tb_detallepedido_preuni > 0.00),
	constraint chk_detallepedido_subtot check(tb_detallepedido_subtot = (tb_detallepedido_can * tb_detallepedido_preuni))
);



select nextval('tb_pedido_tb_pedido_id_seq')
select MAX(tb_usuario_id) as maximo from tb_usuario