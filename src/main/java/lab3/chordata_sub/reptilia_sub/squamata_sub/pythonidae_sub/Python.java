package lab3.chordata_sub.reptilia_sub.squamata_sub.pythonidae_sub;

import lab3.StringConstants;
import lab3.chordata_sub.reptilia_sub.squamata_sub.Pythonidae;

public abstract class Python extends Pythonidae {

    @Override
    public String getGenus() {
        return StringConstants.GENUS_PYTHON;
    }
}
