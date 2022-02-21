package lab3.chordata_sub.reptilia_sub.squamata_sub.pythonidae_sub.python_sub;

import lab3.StringConstants;
import lab3.chordata_sub.reptilia_sub.squamata_sub.pythonidae_sub.Python;

public final class PythonRegius extends Python {

    public PythonRegius(String name) {
        this.name = name;
    }

    @Override
    public String getSpecies() {
        return StringConstants.SPECIES_PYTHON_REGIUS;
    }
}
