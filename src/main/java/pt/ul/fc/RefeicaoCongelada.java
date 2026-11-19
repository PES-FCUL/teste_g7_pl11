package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Cozinhar comida congelada. */
@StateSet({"congelada", "descongelada", "aCozinhar", "cozinhada", "desperdicada"})
public class RefeicaoCongelada {

    @StateRefinement(to="congelada()")
    public RefeicaoCongelada() {}

    /** Descongela a refeição. */
    @StateRefinement(from="congelada()", to="descongelada()")
    public void descongelar() {}

    /** Volta a congelar a refeição (só se ainda não começou a ser cozinhada). */
    @StateRefinement(from="descongelada()", to="congelada()")
    public void voltarACongelar() {}

    /** Deita a refeição fora. */
    @StateRefinement(from="descongelada()", to="desperdicada()")
    public void deitarFora() {}

    /** Termina a cozedura. */
    @StateRefinement(from="descongelada()", to="desperdicada()")
    public void terminarCozedura() {}

    /** Põe a refeição a cozinhar. */
    @StateRefinement(from="aCozinhar()", to="cozinhada()")
    public void iniciarCozedura() {}
}
