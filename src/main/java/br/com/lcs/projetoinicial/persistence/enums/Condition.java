package br.com.lcs.projetoinicial.persistence.enums;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Leandro on 15/10/20.
 * Entidade para classe veiculo
 */


public enum  Condition {

    LIKE("like"),EQUAL("=");

    private String condition;

    Condition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
