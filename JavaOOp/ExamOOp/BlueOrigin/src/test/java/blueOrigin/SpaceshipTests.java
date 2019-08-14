package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship

    @Test
    public void  SpaceshipShoulBECorect(){
        Spaceship spaceship = new Spaceship("name",1);

        Assert.assertEquals(0,spaceship.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void  setNameMustThrowExpIfNameIsNull(){
        Spaceship spaceship = new Spaceship(null,1);

    }

    @Test(expected = NullPointerException.class)
    public void  setNameMustThrowExpIfNameIsEmpty(){
        Spaceship spaceship = new Spaceship(" ",1);

    }

    @Test
    public void  setNameMustSetCorrectly(){
        Spaceship spaceship = new Spaceship("name",1);

        Assert.assertEquals("name",spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityMustThrowExp(){
        Spaceship spaceship = new Spaceship("name",-1);
    }

    @Test
    public void setCapacityMustWorkCorrectly(){
        Spaceship spaceship = new Spaceship("name",0);
        Assert.assertEquals(spaceship.getCapacity(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAstronavtMustThrowExpIfCapacityITSTheSameWithSize(){
        Spaceship spaceship = new Spaceship("name",1);
        Astronaut astronaut1 = new Astronaut("Ast1",1);
        Astronaut astronaut2 = new Astronaut("Ast2",2);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAstronavtMustThrowExpIfAlredyExists(){
        Spaceship spaceship = new Spaceship("name",3);
        Astronaut astronaut1 = new Astronaut("Ast1",1);

        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }

    @Test
    public void addAstronavtMustWorkCorrectly(){
        Spaceship spaceship = new Spaceship("name",2);
        Astronaut astronaut1 = new Astronaut("Ast1",1);
        Astronaut astronaut2 = new Astronaut("Ast2",2);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        Assert.assertEquals(2,spaceship.getCount());
    }

    @Test
    public void removeMustReturnTrue(){
        Spaceship spaceship = new Spaceship("name",3);
        Astronaut astronaut1 = new Astronaut("Ast1",1);
        Astronaut astronaut2 = new Astronaut("Ast2",2);
        Astronaut astronaut3 = new Astronaut("Ast3",3);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
        Assert.assertTrue(spaceship.remove("Ast1"));

    }

    @Test
    public void removeMustReturnFalse(){
        Spaceship spaceship = new Spaceship("name",3);
        Astronaut astronaut1 = new Astronaut("Ast4",1);
        Astronaut astronaut2 = new Astronaut("Ast2",2);
        Astronaut astronaut3 = new Astronaut("Ast3",3);

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);

        Assert.assertFalse(spaceship.remove("Ast1"));
    }


}
