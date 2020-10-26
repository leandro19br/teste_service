package br.com.lcs.projetoinicial.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Leandro on 15/10/20.
 * Entidade para classe veiculo
 */

@Entity
public class Veiculo extends AbstractEntity {

    private String veiculo;
    private String marca;
    private int ano;
    private boolean vendido;
    private LocalDate created;
    private LocalDate updated;


    /**
     * @deprecated hibernate only
     */
    public Veiculo() {
    }

    public Veiculo(String veiculo,String marca, int ano, boolean vendido, LocalDate created, LocalDate updated) {
        this.veiculo = veiculo;
        this.marca = marca;
        this.ano = ano;
        this.vendido = vendido;
        this.created = created;
        this.updated = updated;
    }

    public Veiculo(String marca) {
        this.marca = marca;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "veiculo='" + veiculo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano=" + ano +
                ", vendido=" + vendido +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

}
