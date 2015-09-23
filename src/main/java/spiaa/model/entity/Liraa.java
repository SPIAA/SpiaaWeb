package spiaa.model.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import spiaa.model.base.BaseEntity;

public class Liraa extends BaseEntity {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataTermino;

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
}
