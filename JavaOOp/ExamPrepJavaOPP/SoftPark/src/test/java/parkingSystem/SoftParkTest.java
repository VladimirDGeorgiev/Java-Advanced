package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

public class SoftParkTest {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS SoftPark

    private SoftPark softPark;
    private Car testCar;
    private Car secondTestCar;

    @Before
    public void createSoftPark() {
        this.softPark = new SoftPark();
        Car mockCar = Mockito.mock(Car.class);
        Mockito.when(mockCar.getRegistrationNumber()).thenReturn("6666");
        Mockito.when(mockCar.getMake()).thenReturn("VW");
        this.testCar = mockCar;

        Car secondMockCar = Mockito.mock(Car.class);
        Mockito.when(secondMockCar.getRegistrationNumber()).thenReturn("5555");
        Mockito.when(secondMockCar.getMake()).thenReturn("OPEL");
        this.secondTestCar = secondMockCar;

    }

    @Test
    public void SoftParkShouldWorkCorrect() {
        SoftPark softParkTest = new SoftPark();
        Assert.assertEquals(12, softParkTest.getParking().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkingSpotDoesntExists() {
        this.softPark.parkCar("D1", this.testCar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkingSpotIsAlreadyTaken() {
        this.softPark.parkCar("A1", this.testCar);
        this.softPark.parkCar("A1", this.testCar);
    }

    @Test(expected = IllegalStateException.class)
    public void parkCarShouldThrowExceptionIfCarIsAlreadyParked() {
        this.softPark.parkCar("A1", this.testCar);
        this.softPark.parkCar("B1", this.testCar);
    }

    @Test
    public void parkCarShouldWorkCorrect() {

      // Car cartemp1 = new Car("OPEL", "555");
      // Car cartemp2 = new Car("asd", "666");
        Assert.assertEquals(String.format("Car:%s parked successfully!", this.testCar.getRegistrationNumber()),
                this.softPark.parkCar("A1", this.testCar));
       // Assert.assertEquals(String.format("Car:%s parked successfully!", cartemp1.getRegistrationNumber()),
        //        this.softPark.parkCar("B1", cartemp1));

        //return String.format("Car:%s parked successfully!",car.getRegistrationNumber());
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkingSpotDoesntExists(){
        this.softPark.removeCar("D1", this.testCar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfCarForThatSpotDoesntExists(){
        this.softPark.removeCar("A2", this.testCar);
    }

    @Test
    public void removeCarShouldWriteNullOnTheParkSpot(){
        this.softPark.parkCar("A1",this.testCar);
        this.softPark.removeCar("A1", this.testCar);
        Map<String, Car> parking = this.softPark.getParking();
        Car a1 = parking.get("A1");
        Assert.assertNull(a1);
    }

    @Test
    public void removeCarShouldReturnString(){
        this.softPark.parkCar("A1",this.testCar);

        Assert.assertEquals(String.format("Remove car:%s successfully!",this.testCar.getRegistrationNumber()),
                this.softPark.removeCar("A1", this.testCar) );
    }





}