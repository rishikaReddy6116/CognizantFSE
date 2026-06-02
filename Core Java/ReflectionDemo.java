import java.lang.reflect.*;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {

        // Load class dynamically
        Class<?> cls = Class.forName("Demo");

        // Create object dynamically
        Object obj = cls.getDeclaredConstructor().newInstance();

        System.out.println("Methods in Demo:");

        // Display all methods
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println(m.getName());
        }

        // Invoke greet()
        Method greetMethod = cls.getMethod("greet");
        greetMethod.invoke(obj);

        // Invoke showMessage(String)
        Method msgMethod =
                cls.getMethod("showMessage", String.class);

        msgMethod.invoke(obj, "Welcome to Reflection");
    }
}