package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroRepositoryTest {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private static final Item ITEM_OF_FIRST_HERO = new Item(-1, -1, -1);
    private static final Item ITEM_OF_SECOND_HERO = new Item(0, 0, 0);
    private static final Item ITEM_OF_THIRD_HERO= new Item(1, 1, 1);

    private static final Hero FIRST_HERO = new Hero("Ivo", 10, ITEM_OF_FIRST_HERO);
    private static final Hero SECOND_HERO = new Hero("Rado", 20, ITEM_OF_SECOND_HERO);
    private static final Hero THIRD_HERO = new Hero("Sam", 30, ITEM_OF_THIRD_HERO);



    private HeroRepository heroRepository;
    private HeroRepository heroRepositoryEmpty;

    @Before
    public void createHeroRepository() {
        heroRepositoryEmpty = new HeroRepository();
        this.heroRepository = new HeroRepository();
        this.heroRepository.add(FIRST_HERO);
        this.heroRepository.add(SECOND_HERO);
    }

    @Test
    public void HeroRepositoryShouldBeCreateCorrect() {
        Assert.assertEquals(0, this.heroRepositoryEmpty.getCount());
    }

    @Test
    public void addShouldWorcCorrect() {
        this.heroRepository.add(new Hero("Stamat", 30, new Item(30, 30, 30)));
        Assert.assertEquals(3, this.heroRepository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExeptionIfHeroIsDuplicate() {
        this.heroRepository.add(FIRST_HERO);
    }

    @Test
    public void removeShouldWorkCorrect() {
        this.heroRepository.remove("Ivo");
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExeptionIfHeroIsNotPresent() {
        this.heroRepository.remove("IVO");
    }

    //Strength
    @Test
    public void getHeroWithHighestStrengthShouldWorkCorrenct() {

        Item mockitem1 = Mockito.mock(Item.class);
        Mockito.when(mockitem1.getStrength()).thenReturn(1);
        Hero hero1 = new Hero("test1",11,mockitem1);
        Item mockitem2 = Mockito.mock(Item.class);
        Mockito.when(mockitem2.getStrength()).thenReturn(2);
        Hero hero2 = new Hero("test2",22,mockitem2);
        this.heroRepositoryEmpty.add(hero1);
        this.heroRepositoryEmpty.add(hero2);
        Assert.assertEquals(hero2, this.heroRepositoryEmpty.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowExceptionIfThereIsNotPresent() {
        this.heroRepositoryEmpty.getHeroWithHighestStrength();
    }

    //Agility
    @Test
    public void getHeroWithHighestAgilityShouldWorkCorrenct() {


        Item mockitem1 = Mockito.mock(Item.class);
        Mockito.when(mockitem1.getAgility()).thenReturn(1);
        Hero hero1 = new Hero("test1",11,mockitem1);
        Item mockitem2 = Mockito.mock(Item.class);
        Mockito.when(mockitem2.getAgility()).thenReturn(2);
        Hero hero2 = new Hero("test2",22,mockitem2);
        this.heroRepositoryEmpty.add(hero1);
        this.heroRepositoryEmpty.add(hero2);
        Assert.assertEquals(hero2, this.heroRepositoryEmpty.getHeroWithHighestAgility());

    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowExceptionIfThereIsNotPresent() {
        this.heroRepositoryEmpty.getHeroWithHighestAgility();
    }

    //Intelligence
    @Test
    public void getHeroWithHighestIntelligenceShouldWorkCorrenct() {

        Item mockitem1 = Mockito.mock(Item.class);
        Mockito.when(mockitem1.getIntelligence()).thenReturn(1);
        Hero hero1 = new Hero("test1",11,mockitem1);
        Item mockitem2 = Mockito.mock(Item.class);
        Mockito.when(mockitem2.getIntelligence()).thenReturn(2);
        Hero hero2 = new Hero("test2",22,mockitem2);
        this.heroRepositoryEmpty.add(hero1);
        this.heroRepositoryEmpty.add(hero2);
        Assert.assertEquals(hero2, this.heroRepositoryEmpty.getHeroWithHighestIntelligence());


    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowExceptionIfThereIsNotPresent() {
        this.heroRepositoryEmpty.getHeroWithHighestIntelligence();
    }

    @Test
    public void getCountShouldWorkCorrenct(){
        Assert.assertEquals(0,this.heroRepositoryEmpty.getCount());

    }
    @Test
    public void toStringShouldWorkCorrect(){
        String resultStr = FIRST_HERO.toString()+SECOND_HERO.toString();
        Assert.assertEquals(resultStr,this.heroRepository.toString());

    }

}