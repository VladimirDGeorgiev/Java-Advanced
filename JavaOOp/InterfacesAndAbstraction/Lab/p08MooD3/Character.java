package JavaOOP.L06InterfacesAndAbstraction.Lab.p08MooD3;

public abstract class Character<P> implements GameObject {
    private String username;
    private String characterType;
    private int level;
    private Number specalPoints;
    private P hashedPassword;

    public Character(String username, String characterType, int level, Number specalPoints) {
        this.username = username;
        this.characterType = characterType;
        this.level = level;
        this.specalPoints = specalPoints;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getCharacterType() {
        return this.characterType;
    }

    @Override
    public Number getSpecialPoints() {
        return this.specalPoints;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public P getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public void setHashedPassword(Object hash) {

    }
}
