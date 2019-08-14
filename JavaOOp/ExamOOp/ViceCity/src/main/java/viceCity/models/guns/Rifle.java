package viceCity.models.guns;

import viceCity.models.guns.BaseGun;

public class Rifle extends BaseGun {

    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int INITIAL_SHOTES = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    protected int getShotes() {
        return INITIAL_SHOTES;
    }
}
