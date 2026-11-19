package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Preparar o solo para plantar sementes. */
@StateSet({"duro", "solto", "adubado", "semeado", "colhido"})
public class Canteiro {

    @StateRefinement(to="duro()")
    public Canteiro() {}

    /** Lavra a terra, deixando-a solta. */
    @StateRefinement(from="duro()", to="solto()")
    public void lavrar() {}

    /** Deixa o canteiro repousar; a terra volta a ficar dura. */
    @StateRefinement(from="solto()", to="duro()")
    public void repousar() {}

    /** Colhe o que foi semeado. */
    @StateRefinement(from="semeado()", to="colhido()")
    public void colher() {}

    /** Aduba a terra solta. */
    @StateRefinement(from="solto()", to="adubado")
    public void adubar() {}

    /** Semeia (com ou sem adubo). */
    @StateRefinement(from="!semeado()", to="semeado()")
    public void semear() {}
}
