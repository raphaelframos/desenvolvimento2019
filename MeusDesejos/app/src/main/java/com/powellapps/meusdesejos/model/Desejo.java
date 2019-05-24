package com.powellapps.meusdesejos.model;

import android.content.ContentValues;

import com.powellapps.meusdesejos.db.DbHelper;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Desejo implements Serializable {

    private String nome;
    private int prioridade;
    private int estado;
    private Long data;
    private Integer idUsuario;
    private Perfil perfil;
    private Integer id;

    public Desejo(){}

    public Desejo(String nome) {
        setNome(nome);
        Calendar dataDeHoje = Calendar.getInstance();
        setData(dataDeHoje.getTimeInMillis());
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getDataFormatada(){
        Calendar calendar =  Calendar.getInstance();
        calendar.setTime(new Date(data));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        return format.format(calendar.getTime());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public ContentValues getValues() {
        ContentValues values = new ContentValues();
        values.put(DbHelper.DESEJO_NOME, nome);
        values.put(DbHelper.DESEJO_DATA, data);
        values.put(DbHelper.DESEJO_ID_USUARIO, idUsuario);
        values.put(DbHelper.DESEJO_ESTADO, estado);
        values.put(DbHelper.DESEJO_PRIORIDADE, prioridade);

        return values;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
