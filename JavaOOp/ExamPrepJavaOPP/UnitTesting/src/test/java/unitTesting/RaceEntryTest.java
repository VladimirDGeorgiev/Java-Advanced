package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class RaceEntryTest {

    private static final UnitMotorcycle FIRST_MOTOR = new UnitMotorcycle("A", 1, 1);
    private static final UnitRider FIRST_RIDER = new UnitRider("Ivo", FIRST_MOTOR);
    private RaceEntry raceEntryEmpty;
    private RaceEntry raceEntry;

    @Before
    public void createRaceEntry() {
        this.raceEntry = new RaceEntry();
        this.raceEntry.addRider(FIRST_RIDER);
        this.raceEntryEmpty = new RaceEntry();

    }

    //Constructor
    @Test
    public void RaceEntryShouldWorkCorrect() {
        Collection<UnitRider> riders = this.raceEntryEmpty.getRiders();
        Assert.assertEquals(0, riders.size());
    }

    //addRider()

    @Test
    public void addRiderShouldWorkCorrect() {
        this.raceEntryEmpty.addRider(FIRST_RIDER);
        Collection<UnitRider> riders = this.raceEntryEmpty.getRiders();
        boolean temp = false;
        for (UnitRider rider : riders) {
            if (rider.getName().equals(FIRST_RIDER.getName())) {
                temp = true;
            }
        }
        Assert.assertTrue(temp);
    }

    //tova moje da e izli6no
    @Test
    public void addRiderShouldReturnProprlyMassege() {
        Assert.assertEquals(String.format("Rider %s added in race.", FIRST_RIDER.getName()),
                this.raceEntryEmpty.addRider(FIRST_RIDER));

    }

    @Test(expected = NullPointerException.class)
    public void addRiderShoultThrowExceptionIfRiderIsNull() {
        this.raceEntryEmpty.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderShoultThrowExceptionIfRiderNameAlredyExist() {
        this.raceEntry.addRider(FIRST_RIDER);
    }

    //calculateAverageHorsePower()

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerShouldThrowExceptionIfRidersAreLessThenTwo(){
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAverageHorsePowerShouldWorkReturnAverigeHorsePower(){
        this.raceEntry.addRider(new UnitRider("Rado",new UnitMotorcycle("B",4,2)));
        Assert.assertEquals(3,this.raceEntry.calculateAverageHorsePower(),0.0001);

    }

    //getRiders()
    @Test(expected = UnsupportedOperationException.class)
    public void getRiders(){
        this.raceEntry.getRiders().remove(FIRST_RIDER);

    }


}
