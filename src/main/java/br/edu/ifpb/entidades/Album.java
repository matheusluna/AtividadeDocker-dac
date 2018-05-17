/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.entidades;

import br.edu.ifpb.enums.Estilo;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author matheus
 */
public class Album {
    private int id;
    private Estilo estilo;
    private Banda banda;
    private LocalDate anoDeLancamento;

    public Album() {
    }

    public Album(Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        this.estilo = estilo;
        this.banda = banda;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Album(int id, Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        this.id = id;
        this.estilo = estilo;
        this.banda = banda;
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public LocalDate getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(LocalDate anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.estilo);
        hash = 13 * hash + Objects.hashCode(this.banda);
        hash = 13 * hash + Objects.hashCode(this.anoDeLancamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.estilo != other.estilo) {
            return false;
        }
        if (!Objects.equals(this.banda, other.banda)) {
            return false;
        }
        if (!Objects.equals(this.anoDeLancamento, other.anoDeLancamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", estilo=" + estilo + ", banda=" + banda + ", anoDeLancamento=" + anoDeLancamento + '}';
    }
    
}
