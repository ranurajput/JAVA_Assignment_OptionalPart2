package com.knoldus.kup.Optional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
public class PhoneBookTests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private final PhoneBook phoneBookTest = new PhoneBook();

    @Test
    public void findPhoneNumberByName_CorrectIfFound() {
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("Ranu");
        assertThat(phoneNumber.get()).isEqualTo("6397466392");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findPhoneNumberByName("Rajput");
        phoneNumber.get();
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfFound(){
        Optional<String> name = phoneBookTest.findNameByPhoneNumber("7060120756");
        assertThat(name.get()).isEqualTo("Lazmi");
    }

    @Test
    public void findNameByPhoneNumber_CorrectIfNotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBookTest.findNameByPhoneNumber("12456888");
        phoneNumber.get();
    }
}
