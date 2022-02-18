package com.knoldus.kup.Optional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.assertj.core.api.Assertions.assertThat;
public class PhoneBookCrawlerTests {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());
    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No phone number is found");
        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Rajput");
        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Raj");
    }
    @Test
    public void findPhoneNumberByName_CorrectIfFind(){
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Ranu");
        assertThat(phoneNumberActual).isEqualTo("6397466392");
    }
    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBookActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Dhairya");
        assertThat(phoneBookActual).isEqualTo("PhoneBook{ PhoneBook = {Ranu=6397466392, Lazmi=7060120756}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByName() {
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Ranu", "12456578");
        assertThat(phoneNumberActual).isEqualTo("6397466392");
    }
    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Dhairya", "9760666142");
        assertThat(name).isEqualTo("Lazmi");
    }
}