package lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub.felis_sub;

import lab3.StringConstants;
import lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub.Felis;

public final class FelisCatus extends Felis {

    public FelisCatus(String name) {
        this.name = name;
    }

    @Override
    public String getSpecies() {
        return StringConstants.SPECIES_FELIS_CATUS;
    }
}
