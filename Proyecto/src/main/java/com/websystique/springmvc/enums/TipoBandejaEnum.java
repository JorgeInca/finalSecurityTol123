package com.websystique.springmvc.enums;

public enum TipoBandejaEnum {
	
	BANDEJA_AFILIACION	(1,"Bandeja afiliacion" ,"jsp/bandejas/afiliacion/bandejaAfiliacion" );
	
	private Integer idBandeja;
	private String descripcion;
	private String vistaBandeja;
	
	public Integer getIdBandeja() {
		return idBandeja;
	}
	public void setIdBandeja(Integer idBandeja) {
		this.idBandeja = idBandeja;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVistaBandeja() {
		return vistaBandeja;
	}

	public void setVistaBandeja(String vistaBandeja) {
		this.vistaBandeja = vistaBandeja;
	}
	
	private TipoBandejaEnum(Integer idBandeja, String descripcion,
			String vistaBandeja) {
		this.idBandeja = idBandeja;
		this.descripcion = descripcion;
		this.vistaBandeja = vistaBandeja;
	}
	
	public static TipoBandejaEnum getById(Integer id) {
	    for(TipoBandejaEnum e : values()) {
	        if(e.idBandeja.equals(id)) return e;
	    }
	    return null;
	}
		
}
