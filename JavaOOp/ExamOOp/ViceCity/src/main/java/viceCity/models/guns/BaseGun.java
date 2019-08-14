package viceCity.models.guns;

import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private int currentBullets;


    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        this.currentBullets = bulletsPerBarrel;
        this.setTotalBullets(this.getTotalBullets() - this.getBulletsPerBarrel());

    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }

        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.currentBullets>0;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }

        this.totalBullets = totalBullets;
    }

    @Override
    public int fire() {
        int resultShotes = this.currentBullets - this.getShotes();


        if (resultShotes <= 0) {
            resultShotes = this.currentBullets;
            if (this.getTotalBullets() > this.getBulletsPerBarrel()) {
                this.currentBullets = this.getBulletsPerBarrel();
                this.setTotalBullets(this.getTotalBullets() - this.getBulletsPerBarrel());
            } else {
                this.currentBullets = this.getTotalBullets();
                this.setTotalBullets(0);
            }

        } else {
            this.currentBullets -= this.getShotes();
            resultShotes=this.getShotes();
        }


        return resultShotes;
    }

    protected abstract int getShotes();

    //todo The initial BulletsInBarrel count is the actual capacity of the barrel!
}
