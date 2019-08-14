package viceCity.models.guns;

import viceCity.models.guns.BaseGun;

public class Pistol extends BaseGun {

    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int INITIAL_SHOTES = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }


    @Override
    protected int getShotes() {
        return INITIAL_SHOTES;
    }
}
