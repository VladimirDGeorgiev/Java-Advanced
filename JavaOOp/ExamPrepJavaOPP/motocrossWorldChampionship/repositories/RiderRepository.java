package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class RiderRepository implements Repository<Rider> {

    private Collection<Rider> data;

    public RiderRepository() {
        this.data = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        Rider rider = null;
        rider = this.data.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);

        return rider;
    }

    @Override
    public Collection<Rider> getAll() {
        return this.data;
    }

    @Override
    public void add(Rider model) {
        this.data.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.data.removeIf(m->m.getName().equals(model.getName()));
    }
}

