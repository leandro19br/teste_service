package br.com.lcs.projetoinicial.exeption;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Leandro on 15/10/20.
 * Entidade para classe veiculo
 */


public class ObjectNotFound extends Exception {

    public ObjectNotFound() {
        super("Objeto não encontrado");
    }
}
