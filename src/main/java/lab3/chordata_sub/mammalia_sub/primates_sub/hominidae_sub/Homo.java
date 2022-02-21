package lab3.chordata_sub.mammalia_sub.primates_sub.hominidae_sub;

import lab3.StringConstants;
import lab3.chordata_sub.mammalia_sub.primates_sub.Hominidae;

public abstract class Homo extends Hominidae {

    @Override
    public String getGenus() {
        return StringConstants.GENUS_HOMO;
    }
}
