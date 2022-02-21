package lab3;

import java.time.temporal.ChronoField;

import lab3.chordata_sub.mammalia_sub.carnivora_sub.felidae_sub.felis_sub.FelisCatus;
import lab3.chordata_sub.mammalia_sub.primates_sub.hominidae_sub.homo_sub.HomoHabilis;
import lab3.chordata_sub.mammalia_sub.primates_sub.hominidae_sub.homo_sub.HomoSapiens;
import lab3.chordata_sub.reptilia_sub.squamata_sub.pythonidae_sub.python_sub.PythonRegius;

public class Main {

    public static void main(String[] args) {
        Chordata ivan = new HomoSapiens("Иван");
        Chordata nikolay = new HomoHabilis("Николай");
        Chordata mrsNorris = new FelisCatus("Миссис Норрис");
        Chordata grisha = new PythonRegius("Гриша");

        Queue<Chordata> queue = new Queue<>(4);
        queue.add(ivan);
        queue.add(nikolay);
        queue.add(mrsNorris);
        queue.add(grisha);

        queue.consume(queue.produce());
        System.out.println();

        System.out.println("Все:");
        while (queue.getSize() > 0) {
            System.out.println(queue.get());
        }
    }
}
