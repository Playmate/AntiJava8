package mutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Igor Dmitriev on 8/20/16
 */
public class Test {
    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(
                new Client("Igor"),
                new Client("Mikalai"),
                new Client("Andrey")
        );
        List<String> names = new ArrayList<>();

        clients.stream().map(Client::getName).forEach(names::add); // плохо, такое сплош и рядом вижу
        clients.stream().map(Client::getName).collect(toList()); // хорошо
    }
}

class Client {
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
