package autoboxing;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Igor Dmitriev on 8/20/16
 */
public class Test {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(26),
                new User(33),
                new User(28)
        );
        //Integer totalWeight = users.stream().map(User::getAge).reduce(0, Integer::sum); // плохо, боксинг
        int totalWeight = users.stream().mapToInt(User::getAge).sum();// хорошо
        System.out.println(totalWeight);
    }
}

class User {
    private final int age;

    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

