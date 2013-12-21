package br.com.weka.model;

public enum Indicadores {
	
	// Grupo Agua
	I1(1,"Despejo de esgoto",11,"Agua",6),
	I2(2,"Despejo de residuos solidos",11,"Agua",6),
	I3(3,"Despejo de residuos toxicos",11,"Agua",6),
	I4(4,"Uso ilegal da agua",11,"Agua",6),
	I5(5,"Dragagem de leitos de rios ou corregos",11,"Agua",6),
	I6(6,"Poco artesiano irregular ou ilegal",11,"Agua",6),
	
	// Grupo Ar
	I7(7,"Fumaca eliminada por veiculos",12,"Ar",5),
	I8(8,"Fumaca eliminada por fabricas",12,"Ar",5),
	I9(9,"Queimadas",12,"Ar",5),
	I10(10,"Poeira",12,"Ar",5),
	I11(11,"Emissao de odores fetidos",12,"Ar",5),
	
	// Grupo Solo
	I12(12,"Despejo de esgoto no solo",13,"Solo",6),
	I13(13,"Deposito clandestino / irregular de residuos solidos urbanos",13,"Solo",6),
	I14(14,"Deposito clandestino / irregular de residuos de construcao civil",13,"Solo",6),
	I15(15,"Extracao irregular de areia, argila ou cascalho",13,"Solo",6),
	I16(16,"Uso ilegal do solo (plantio etc)",13,"Solo",6),
	I17(17,"Ocorrencia de erosoes (sulcos, ravinas, vocorocas",13,"Solo",6),
	
	// Grupo Desmatamento
	I18(18,"Desmatamento de vegetacao remanescente",14,"Desmatamento",4),
	I19(19,"Extracao ou exploracao de recursos naturais de forma irregular",14,"Desmatamento",4),
	I20(20,"Caca irregular",14,"Desmatamento",4),
	I21(21,"Pesca irregular",14,"Desmatamento",4),
	
	// Grupo Invasao Ambiental
	I22(22,"Invasao em areas protegidas",15,"Invasao",2),
	I23(23,"Invasao em matas ciliares",15,"Invasao",2),
	
	// Grupo Seguranca
	I24(24,"Assalto",21,"Seguranca",8),
	I25(25,"Roubo",21,"Seguranca",8),
	I26(26,"Vandalismo",21,"Seguranca",8),
	I27(27,"Estupro",21,"Seguranca",8),
	I28(28,"Violencia contra mulher, crianca, idoso",21,"Seguranca",8),
	I29(29,"Gangs",21,"Seguranca",8),
	I30(30,"Traficantes",21,"Seguranca",8),
	I31(31,"Usuarios de drogras ilicitas",21,"Seguranca",8),
	
	// Grupo Educacao
	I32(32,"Escola sem professor",22,"Educacao",6),
	I33(33,"Escola com problemas estruturais",22,"Educacao",6),
	I34(34,"Falta de creche",22,"Educacao",6),
	I35(35,"Falta de escola de ensino fundamental",22,"Educacao",6),
	I36(36,"Falta de escola de ensino medio",22,"Educacao",6),
	I37(37,"Falta de faculdade ou universidade",22,"Educacao",6),
	
	// Grupo Saude
	I38(38,"Falta de posto de saude",23,"Saude",8),
	I39(39,"Falta de hospital",23,"Saude",8),
	I40(40,"Falta de medico",23,"Saude",8),
	I41(41,"Falta de medicamento",23,"Saude",8),
	I42(42,"Superlotacao",23,"Saude",8),
	I43(43,"Atendimento ruim",23,"Saude",8),
	I44(44,"Falta de leito",23,"Saude",8),
	I45(45,"Falta de equipamentos",23,"Saude",8),
	
	// Grupo Infraestrutura urbana
	I46(46,"Iluminacao publica deficiente, inexistente",24,"Infraestrutura urbana",12),
	I47(47,"Pavimentacao publica deficiente, inexistente",24,"Infraestrutura urbana",12),
	I48(48,"Rede de coleta de esgoto inexistente",24,"Infraestrutura urbana",12),
	I49(49,"Abastecimento de agua insuficiente, inexistente",24,"Infraestrutura urbana",12),
	I50(50,"Atendimento de energia eletrica insatisfatorio, inexistente",24,"Infraestrutura urbana",12),
	I51(51,"Ponto de alagamento, inundacao ou enchente",24,"Infraestrutura urbana",12),
	I52(52,"Ponto de congestionamento",24,"Infraestrutura urbana",12),
	I53(53,"Acidentes envolvendo veiculos, motos, ciclistas, pedestres",24,"Infraestrutura urbana",12),
	I54(54,"Buracos/erosoes em vias publicas",24,"Infraestrutura urbana",12),
	I55(55,"Inexistencia de bueiros (galerias de agua pluvial)",24,"Infraestrutura urbana",12),
	I56(56,"Dregnagem inadequada de aguas pluviais",24,"Infraestrutura urbana",12),
	I57(57,"Ponto de estrangulamento irregular de drenagem fluvial (represa/barragem clandestina)",24,"Infraestrutura urbana",12),
	
	// Grupo Invasao Social
	I58(58,"Invasao de patrimonio publico",25,"Invasao",2),
	I59(59,"Invasao de terreno publico",25,"Invasao",2)
	
	;
	
	private int idIndicador;
	private int idGrupo;
	private String nomeIndicador;
	private String nomeGrupo;
	private int quantidade;
	
	Indicadores(int idIndicador,String nomeIndicador,int idGrupo,String nomeGrupo, int quantidade) {
		this.idIndicador = idIndicador;
		this.nomeIndicador = nomeIndicador;
		this.idGrupo = idGrupo;
		this.nomeGrupo = nomeGrupo;
		this.quantidade = quantidade;
	}

	public int getIdIndicador() {
		return this.idIndicador;
	}

	public int getIdGrupo() {
		return this.idGrupo;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}

	public String getNomeIndicador() {
		return this.nomeIndicador;
	}

	public String getNomeGrupo() {
		return this.nomeGrupo;
	}

}
