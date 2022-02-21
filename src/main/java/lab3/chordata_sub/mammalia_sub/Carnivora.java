package lab3.chordata_sub.mammalia_sub;

import lab3.StringConstants;
import lab3.chordata_sub.Mammalia;

public abstract class Carnivora extends Mammalia {

    @Override
    public String getOrder() {
        return StringConstants.ORDER_CARNIVORA;
    }
}
