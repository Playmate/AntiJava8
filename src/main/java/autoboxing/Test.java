package autoboxing;

import java.util.stream.Stream;

/**
 * Created by Igor Dmitriev on 8/20/16
 */
public class Test {
    public static void main(String[] args) {
        Stream<User> users = Stream.of(new User(26), new User(33), new User(28));
        //Integer totalWeight = users.stream().map(User::getAge).reduce(0, Integer::sum); // плохо, боксинг
        int totalWeight = users.mapToInt(User::getAge).sum();// хорошо
        System.out.println(totalWeight);
    }
}

class User {
    private final int age;

    User(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

