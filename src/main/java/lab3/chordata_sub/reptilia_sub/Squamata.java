package lab3.chordata_sub.reptilia_sub;

import lab3.StringConstants;
import lab3.chordata_sub.Reptilia;

public abstract class Squamata extends Reptilia {

    @Override
    public String getOrder() {
        return StringConstants.ORDER_SQUAMATA;
    }
}
