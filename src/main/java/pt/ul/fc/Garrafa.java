package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Verter o conteúdo de uma garrafa. */
@StateSet({"selada", "aberta", "aVerter", "vazia", "tapada"})
public class Garrafa {

    @StateRefinement(to="selada()")
    public Garrafa() {}

    /** Volta a pôr a tampa (definitivo). */
    @StateRefinement(from="aberta() || vazia()", to="tapada()")
    public void tapar() {}

    /** Inclina a garrafa e começa a verter. */
    @StateRefinement(from="aberta()", to="verter()")
    public void inclinar() {}

    /** O último conteúdo sai da garrafa. */
    @StateRefinement(from="aVerter()", to="aberta()")
    public void esvaziar() {}

    /** Endireita a garrafa e pára de verter. */
    @StateRefinement(from="aVerter()", to="aberta()")
    public void endireitar() {}

    /** Tira a tampa da garrafa. */
    @StateRefinement(from="selada()", to="aberta()")
    public void abrir() {
    }
}
