package lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub;

import lab3.StringConstants;
import lab3.chordata_sub.mammalia_sub.carnivora_sub.Felidae;

public abstract class Felis extends Felidae {

    @Override
    public String getGenus() {
        return StringConstants.GENUS_FELIS;
    }
}
