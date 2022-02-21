package lab3.chordata_sub;

import lab3.Chordata;
import lab3.StringConstants;

public abstract class Mammalia extends Chordata {

    @Override
    public String getClassName() {
        return StringConstants.CLASS_MAMMALIA;
    }
}
