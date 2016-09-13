package overuse;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * Created by Igor Dmitriev on 9/13/16
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Object> jpaProperties = jpaProperties2();
        // мораль такова что нефиг использовать Stream API где надо и не надо
        // на идею натолкнула вот эта статья https://www.mkyong.com/java8/java-8-convert-map-to-list/
        // в которой так же Stream API используется не к месту
    }

    //  не читабильно, больше кода и стремно выглядит, а главное зачем ?????
    public static Map<String, Object> jpaProperties1() {
        Map<String, Object> jpaProperties = Collections.unmodifiableMap(
                Stream.of(
                        new AbstractMap.SimpleEntry<>("hibernate.show_sql", "true"),
                        new AbstractMap.SimpleEntry<>("hibernate.format_sql", "true")
                ).collect(toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))
        );
        return jpaProperties;
    }

    // просто, понятно, православно
    public static Map<String, Object> jpaProperties2() {
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        return Collections.unmodifiableMap(jpaProperties);
    }
}
