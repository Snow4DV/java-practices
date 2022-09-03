import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    Dog dog;

    @BeforeEach
    void setUp() {
        dog = new Dog("Test Dog", 15);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals(dog.getName(), "Test Dog");
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(dog.getAge(), 15);
    }

    @org.junit.jupiter.api.Test
    void setName() {
        String[] names = {"NameA", "NameB", "NameC"};
        for (String name :
                names) {
            dog.setName(name);
            assertEquals(dog.getName(), name);
        }
    }

    @org.junit.jupiter.api.Test
    void setAge() {
        dog.setAge(25);
        assertEquals(dog.getAge(), 25);
    }

    @org.junit.jupiter.api.Test
    void getHumanizedAge() {
        assertEquals(dog.getHumanizedAge(), dog.getAge()*7);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals(dog.toString(), "<Dog>\n" +
                "Name: " + dog.getName() + '\n' +
                "Age: " + dog.getAge() + '\n');
        System.out.println(dog.toString());
    }

    @Test
    void checkIfLessAgeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
           dog.setAge(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            dog.setAge(27);
            dog.setAge(1);
        });
    }

    @Test
    void newbornNoAgeConstructor() {
        dog = new Dog("Simple name");
        assertEquals(dog.getName(), "Simple name");
        assertEquals(dog.getAge(), 0);
    }

}