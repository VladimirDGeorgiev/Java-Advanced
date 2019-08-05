package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final String INITIAL_NAME_OF_THE_FIRST_PERSON = "Ivo";
    private static final int INITIAL_ID_OF_THE_FIRST_PERSON = 1;
    private static final Person[] INITIAL_DATABASE_PARAM = new Person[]{
            new Person(INITIAL_ID_OF_THE_FIRST_PERSON,INITIAL_NAME_OF_THE_FIRST_PERSON),
            new Person(10,"Jon")};
    private static final int MAX_PERSON_PARAM_COUNT = 16;


    private Database database;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
    this.database = new Database(INITIAL_DATABASE_PARAM);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithZeroPersonShouldThrowException() throws OperationNotSupportedException {
        Database databaseWithoutParam = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithMoreThen16PersonShouldThrowException() throws OperationNotSupportedException {
        Database databaseWithoutParam = new Database(new Person[MAX_PERSON_PARAM_COUNT+1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonNullShouldThrowException() throws OperationNotSupportedException {
        this.database.add(null);
    }
    @Test
    public void findByUserNameShouldBeCorrect() throws OperationNotSupportedException {

       Assert.assertEquals(INITIAL_DATABASE_PARAM[0],this.database.findByUsername(INITIAL_NAME_OF_THE_FIRST_PERSON));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifNoUserIsPresentByThisUsernameShouldThrowException() throws OperationNotSupportedException {
        this.database.findByUsername("Pesho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifFindByUsernameParameterIsNullShouldThrowException() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifFindByUsernameArgumentsAreAllCaseSensitiveShouldThrowException() throws OperationNotSupportedException {
        this.database.findByUsername(INITIAL_NAME_OF_THE_FIRST_PERSON.toUpperCase());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifThereIsMoreThenOnePersonShouldThrowException() throws OperationNotSupportedException {
        this.database.add(this.database.findByUsername(INITIAL_NAME_OF_THE_FIRST_PERSON));
        this.database.findByUsername(INITIAL_NAME_OF_THE_FIRST_PERSON);
    }

    @Test
    public void findByIdShouldBeCorrect() throws OperationNotSupportedException {

        Assert.assertEquals(INITIAL_DATABASE_PARAM[0],this.database.findById(INITIAL_ID_OF_THE_FIRST_PERSON));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifNoUserIsPresentByThisIdShouldThrowException() throws OperationNotSupportedException {
    this.database.findById(INITIAL_ID_OF_THE_FIRST_PERSON+1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifIdIsRepeatShouldThrowException() throws OperationNotSupportedException {
        this.database.add(this.database.findById(INITIAL_ID_OF_THE_FIRST_PERSON));
        this.database.findById(INITIAL_ID_OF_THE_FIRST_PERSON);
    }
    @Test
    public void getElementShoudBeCorrect(){
        Assert.assertArrayEquals(INITIAL_DATABASE_PARAM,this.database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ifYouTryToRemoveElementFromEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < INITIAL_DATABASE_PARAM.length; i++) {
            this.database.remove();
        }
        this.database.remove();
    }








}