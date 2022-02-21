package lab3.chordata_sub.mammalia_sub.primates_sub.hominidae_sub.homo_sub;

import lab3.StringConstants;
import lab3.chordata_sub.mammalia_sub.primates_sub.hominidae_sub.Homo;

public final class HomoSapiens extends Homo {

    public HomoSapiens(String name) {
        this.name = name;
    }

    @Override
    public String getSpecies() {
        return StringConstants.SPECIES_HOMO_SAPIENS;
    }
}
