package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {
    private ArrayDeque<Gun> models;

    public GunRepository() {
        this.models = new ArrayDeque<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        if (this.models.stream().noneMatch(e->e.getName().equals(model.getName()))){
            this.models.add(model);
        }

    }

    @Override
    public boolean remove(Gun model) {

        return this.models.removeIf(e->e.getName().equals(model.getName()));
    }

    @Override
    public Gun find(String name) {
        Gun gun = this.models.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        return gun;
    }
}
