package mutation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by Igor Dmitriev on 8/20/16
 */
public class Test {
    public static void main(String[] args) {
        Stream<Client> clients = Stream.of(new Client("Igor", 1),
                new Client("Mikalai", 2),
                new Client("Andrey", 3));

        List<String> names = new ArrayList<>();
        clients.map(Client::getName).forEach(names::add); // плохо, такое сплош и рядом вижу

        AtomicInteger sum = new AtomicInteger(); // вот так тоже делать не фонтан, такое 3 раза встречал
        clients.map(Client::getAge).forEach(sum::addAndGet);
        System.out.println(sum);

        //long sum = clients.mapToInt(Client::getAge).sum();// хорошо

        //clients.map(Client::getName).collect(toList()); // хорошо
    }
}

class Client {
    private final String name;
    private final int age;

    Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
