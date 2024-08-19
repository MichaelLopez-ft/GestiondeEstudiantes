package customcollections;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomList<T> {
    private List<T> items;

    public CustomList() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public Optional<T> find(T item) {
        return items.stream().filter(i -> i.equals(item)).findFirst();
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return new ArrayList<>(items); // Devolver una copia de la lista para evitar modificaciones directas
    }
}

