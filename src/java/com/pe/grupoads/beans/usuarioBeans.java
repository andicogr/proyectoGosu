
package com.pe.grupoads.beans;

import java.sql.Date;




public class usuarioBeans {
    private int CODIGOUSUARIO;
    private int DNI;
    private String IDLOGIN;
    private String IDPASSWORD;
    private String ESTADO;
    private String NOMBRE;
    private String APELLIDOPATERNO;
    private String APELLIDOMATERNO;
    private String DIRECCION;
    private String EMAIL;
    private int CELULAR;
    private int FIJO;
    private Date FECHAINGRESO;

    public int getCODIGOUSUARIO() {
        return CODIGOUSUARIO;
    }

    public void setCODIGOUSUARIO(int CODIGOUSUARIO) {
        this.CODIGOUSUARIO = CODIGOUSUARIO;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getIDLOGIN() {
        return IDLOGIN;
    }

    public void setIDLOGIN(String IDLOGIN) {
        this.IDLOGIN = IDLOGIN;
    }

    public String getIDPASSWORD() {
        return IDPASSWORD;
    }

    public void setIDPASSWORD(String IDPASSWORD) {
        this.IDPASSWORD = IDPASSWORD;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDOPATERNO() {
        return APELLIDOPATERNO;
    }

    public void setAPELLIDOPATERNO(String APELLIDOPATERNO) {
        this.APELLIDOPATERNO = APELLIDOPATERNO;
    }

    public String getAPELLIDOMATERNO() {
        return APELLIDOMATERNO;
    }

    public void setAPELLIDOMATERNO(String APELLIDOMATERNO) {
        this.APELLIDOMATERNO = APELLIDOMATERNO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public int getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(int CELULAR) {
        this.CELULAR = CELULAR;
    }

    public int getFIJO() {
        return FIJO;
    }

    public void setFIJO(int FIJO) {
        this.FIJO = FIJO;
    }

    public Date getFECHAINGRESO() {
        return FECHAINGRESO;
    }

    public void setFECHAINGRESO(Date FECHAINGRESO) {
        this.FECHAINGRESO = FECHAINGRESO;
    }
    
    

  
}
