/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.entidades;

import br.edu.ifpb.enums.Estilo;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author matheus
 */
public class Banda {
    private String nome;
    private String localDeOrigiem;
    private List<String> integrantes;

    public Banda() {
    }

    public Banda(String nome, String localDeOrigiem, List<String> integrantes) {
        this.nome = nome;
        this.localDeOrigiem = localDeOrigiem;
        this.integrantes = integrantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalDeOrigiem() {
        return localDeOrigiem;
    }

    public void setLocalDeOrigiem(String localDeOrigiem) {
        this.localDeOrigiem = localDeOrigiem;
    }

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.localDeOrigiem);
        hash = 37 * hash + Objects.hashCode(this.integrantes);
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
        final Banda other = (Banda) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.localDeOrigiem, other.localDeOrigiem)) {
            return false;
        }
        if (!Objects.equals(this.integrantes, other.integrantes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banda{" + "nome=" + nome + ", localDeOrigiem=" + localDeOrigiem + ", integrantes=" + integrantes + '}';
    }
    
    

}
