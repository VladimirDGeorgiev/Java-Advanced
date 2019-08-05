package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class DatabaseTest {

    private static final Integer[] INITIAL_CORRECT_ARRAY = {1, 2, 3, 5, 8};
    private static final int INVALID_MAX_ELEMENT_COUNT = 17;
    private static final int ADD_ELEMENT = 13;


    private Database database;

    @Before
    public void createDatabaseTest() throws OperationNotSupportedException {
        this.database = new Database(INITIAL_CORRECT_ARRAY);
    }

    @Test
    public void creatingDatabaseShouldBeCorrect() throws OperationNotSupportedException {
        Assert.assertArrayEquals(this.database.getElements(), INITIAL_CORRECT_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithoutArgumentsShouldThrowException() throws OperationNotSupportedException {
        Database databaseFail = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithMoreThen16IntegersShouldThrowIfOperationNotSupportedException() throws OperationNotSupportedException {
        Database databaseFail = new Database(INVALID_MAX_ELEMENT_COUNT);
    }

    @Test
    public void addOperationShouldAddAnElementAtTheNextFreeCell() throws OperationNotSupportedException {
        this.database.add(ADD_ELEMENT);
        int result = this.database.getElements()[5];
        Assert.assertEquals(ADD_ELEMENT, result);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addOperationShouldThrowExceptionIfAddNull() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void removeOperationShouldSupportOnlyRemovingAnElementAtTheLastIndex() throws OperationNotSupportedException {
        this.database.remove();
        Integer[] resultArrayAfterRemove = new Integer[]{1, 2, 3, 5};
        Assert.assertArrayEquals(resultArrayAfterRemove, this.database.getElements());
    }

    @Test
    public void removeOperationShouldDecreaseElementCount() throws OperationNotSupportedException {
        this.database.remove();

        Assert.assertEquals(INITIAL_CORRECT_ARRAY.length-1,this.database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeElementFromEmptyDatabaseThrowsOperationNotSupportedException() throws OperationNotSupportedException {
        for (Integer integer : INITIAL_CORRECT_ARRAY) {
            this.database.remove();
        }
        this.database.remove();
        //Database databaseWithOneElement = new Database(1);
        //databaseWithOneElement.remove();
        //databaseWithOneElement.remove();
    }

    @Test
    public void ConstructorsShouldTakeIntegersOnly() throws NoSuchMethodException {
        boolean res = true;
        Constructor<?>[] constructors = Database.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (!constructor.getParameters()[0].getParameterizedType().equals(Integer[].class)) {
                res = false;
                break;
            }
        }

        Assert.assertTrue(res);
    }
    @Test
    public void fetchMethodShouldReturnTheElementsAsArray(){
        Assert.assertEquals(Integer[].class,this.database.getElements().getClass());
    }




}