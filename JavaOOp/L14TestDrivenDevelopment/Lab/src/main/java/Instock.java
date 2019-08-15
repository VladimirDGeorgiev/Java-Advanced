import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> productList;

    public Instock() {
        this.productList =new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.productList.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.productList.contains(product);
    }

    @Override
    public void add(Product product) {
        this.productList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (isItContainSuchLabel(product)) {
            Product product1 = getProductByName(product);
            product1.setQuantity(quantity);
        }else {

            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        if (index<0||index>=this.productList.size()){
            throw new IndexOutOfBoundsException();
        }
        Product product = this.productList.get(index);
        return product;
    }

    @Override
    public Product findByLabel(String label) {
        if (this.isItContainSuchLabel(label)){
            return this.getProductByName(label);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count<=0||count>this.productList.size()){
            return new ArrayList<>();
        }
        return this.productList.stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInPriceRange(double lo, double hi) {

         return this.productList.stream()
                 .filter(p->p.getPrice()>=lo&&p.getPrice()<=hi)
                 .sorted((f,s)->Double.compare(s.getPrice(),f.getPrice()))
                 .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.productList.stream()
                .filter(p->p.getPrice()==price)
                .collect(Collectors.toList());

    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count>this.getCount()){
            throw new IllegalArgumentException();
        }

        return this.productList
                .stream()
                .sorted((f,s)->Double.compare(s.getPrice(),f.getPrice()))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.productList
                .stream()
                .filter(p->p.getQuantity()==100)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> getIterable() {
        return this.productList;
    }

    private boolean isItContainSuchLabel(String product) {
        return this.productList.stream().anyMatch(e->e.getLabel().equals(product));
    }

    private Product getProductByName(String product) {
        return this.productList.stream().filter(e -> e.getLabel().equals(product)).findFirst().orElse(null);
    }
}
