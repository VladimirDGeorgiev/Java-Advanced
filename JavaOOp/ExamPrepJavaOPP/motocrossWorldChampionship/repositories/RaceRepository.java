package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class RaceRepository implements Repository<Race> {


    private Collection<Race> data;

    public RaceRepository() {
        this.data = new ArrayList<> ();
    }

    @Override
    public Race getByName(String name) {
        Race race = null;
        race = this.data.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);

        return race;
    }

    @Override
    public Collection<Race> getAll() {
        return this.data;
    }

    @Override
    public void add(Race model) {
        this.data.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.data.removeIf(m->m.getName().equals(model.getName()));
    }
}
