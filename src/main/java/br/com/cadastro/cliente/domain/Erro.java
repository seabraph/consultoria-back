package br.com.cadastro.cliente.domain;

public class Erro {

    private String msg;
    private String status;

    public Erro() {
        this.msg = "erro";
        this.status = "status ruim";
    }

    public Erro(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
