package JavaOOP.L06InterfacesAndAbstraction.Lab.p08MooD3;

public interface GameObject <T> {
    String getUsername();
    String getCharacterType();
    Number getSpecialPoints();
    int getLevel();
    T getHashedPassword();
    void setHashedPassword(T hash);

}
