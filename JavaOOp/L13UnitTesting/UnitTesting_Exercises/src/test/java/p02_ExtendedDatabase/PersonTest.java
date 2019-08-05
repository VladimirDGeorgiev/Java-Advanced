package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private static final String INITIAL_NAME = "Pesho";
    private static final int INITIAL_ID = 10;

    private Person person;

    @Before
    public void createPersonShouldBeCorrect(){
        this.person = new Person(INITIAL_ID,INITIAL_NAME);
    }
    @Test
    public void getUsernameShouldBeCorrect(){
        Assert.assertEquals(INITIAL_NAME,this.person.getUsername());
    }
    @Test
    public void getIdShouldBeCorrect(){
        Assert.assertEquals(INITIAL_ID,this.person.getId());
    }

}