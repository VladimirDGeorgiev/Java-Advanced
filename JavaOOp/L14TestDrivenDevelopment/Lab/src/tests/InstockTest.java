import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InstockTest {


    private ProductStock productStock;

    @Before
    public void unit() {
        this.productStock = new Instock();
    }

    //add
    @Test
    public void addOneElementShouldIncreaceSizeCorrectly() {
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);
        Assert.assertEquals(1, this.productStock.getCount());

    }

    @Test
    public void addTenElementsShouldIncreaceSizeCorrectly() {
        List<Product> products = this.createProducts(10);
        for (Product product : products) {

            this.productStock.add(product);
        }
        Assert.assertEquals(10, this.productStock.getCount());

    }

    @Test
    public void addElementsShouldBeTheSameReference() {
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);

        Assert.assertEquals(product, this.productStock.find(0));

    }

    //contains
    @Test
    public void containsShouldReturnTrueIfThereIsSuchElement() {
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);

        Assert.assertTrue(this.productStock.contains(product));

    }

    @Test
    public void containsShouldReturnFalseIfThereIsNoSuchElement() {
        Product product = this.createProducts(1).get(0);


        Assert.assertFalse(this.productStock.contains(product));

    }

    //count
    @Test
    public void countShouldReturnZeroIfIsEmptyCollection() {
        Assert.assertEquals(0, this.productStock.getCount());
    }

    @Test
    public void countShouldReturnCorrectCount() {
        List<Product> products = this.createProducts(5);
        for (Product product : products) {

            this.productStock.add(product);
        }
        Assert.assertEquals(5, this.productStock.getCount());

    }

    //find
    @Test
    public void findShouldReturnFirstElementOfCollection(){
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);

        Assert.assertEquals(product,this.productStock.find(0));
    }

    @Test
    public void findShouldReturnLastElementOfCollection(){
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);

        Assert.assertEquals(product,this.productStock.find(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findShouldThrowExceptionIfIsBelowZero(){
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);

        Assert.assertEquals(product,this.productStock.find(-1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findShouldThrowExceptionIfIndexIsMoreThenCount(){
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);
        product.setLabel("test");
        this.productStock.add(product);

        Assert.assertEquals(product,this.productStock.find(2));
    }

    //changeQuantity

    @Test
    public void changeQuantityShouldWorkCorrect(){
        Product product = new Product("test",1,1);
        this.productStock.add(product);
        this.productStock.changeQuantity("test",5);

        Assert.assertEquals(5,this.productStock.find(0).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowExceptionIfThereIsNoSuchLavel(){
        this.productStock.changeQuantity("test",5);
    }

    //findByLabel

    @Test
    public void findByLabelShouldWorkCorrect(){
        Product product = new Product("test",1,1);
        this.productStock.add(product);
        List<Product> products = createProducts(5);
        for (Product product1 : products) {
            this.productStock.add(product1);
        }

        Assert.assertEquals(product,this.productStock.findByLabel("test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowExceptionIfNoSuchProductInStock(){
        Product product = new Product("test",1,1);
        this.productStock.add(product);

        this.productStock.findByLabel("test1");
    }

    //findFirstByAlphabeticalOrder
    @Test
    public void findFirstByAlphabeticalOrderShouldWorkCorrenct(){
        List<Product> products = createProducts(3);
        for (Product p : products) {
            this.productStock.add(p);
        }
        List<Product> expected = products
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());

        Iterable<Product> actual = this.productStock.findFirstByAlphabeticalOrder(3);

        Assert.assertTrue(isItTheSameCollection(expected, actual));

    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfCountIsBelowOne(){
        List<Product> products = createProducts(3);
        for (Product p : products) {
            this.productStock.add(p);
        }
        List<Product> expected = new ArrayList<>();

        Iterable<Product> actual = this.productStock.findFirstByAlphabeticalOrder(-1);

        Assert.assertTrue(isItTheSameCollection(expected, actual));

    }

    @Test
    public void findFirstByAlphabeticalOrderShouldWorkCorrenctReturnEmptyCollectionIfCountIsMoreThenSize(){
        List<Product> products = createProducts(3);
        for (Product p : products) {
            this.productStock.add(p);
        }
        List<Product> expected = new ArrayList<>();

        Iterable<Product> actual = this.productStock.findFirstByAlphabeticalOrder(4);

        Assert.assertTrue(isItTheSameCollection(expected, actual));

    }

    //findAllInPriceRange

    @Test
    public void findAllInPriceRangeShouldWorkCorrenct(){
        List<Product> products = createProducts(5);
        products.get(0).setPrice(1.4);
        products.get(1).setPrice(1.1);
        products.get(2).setPrice(1.3);
        products.get(3).setPrice(1.2);

        for (Product p : products) {
            this.productStock.add(p);
        }
        Product[] expected = products
                .stream()
                .filter(p->p.getPrice()>=1.1&&p.getPrice()<=1.2)
                .sorted((f,s)->Double.compare(s.getPrice(),f.getPrice()))
                .toArray(Product[]::new);

        Iterable<Product> result = this.productStock.findAllInPriceRange(1.1,1.2);
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);

    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionIfThereAreNoSuckProducts(){

        List<Product> products = createProductsAndAddIt(4);
        Product[] expected = products
                .stream()
                .filter(p->p.getPrice()>=100&&p.getPrice()<=200)
                .sorted((f,s)->Double.compare(s.getPrice(),f.getPrice()))
                .toArray(Product[]::new);

        Iterable<Product> result = this.productStock.findAllInPriceRange(100,200);
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);

    }

    //findAllByPrice
    @Test
    public void findAllByPriceShouldWorkCorrectly(){

        List<Product> products = createProductsAndAddIt(10);
        products.get(0).setPrice(10);
        products.get(1).setPrice(10);
        Product[] expected = products
                .stream()
                .filter(p->p.getPrice()==10)
                .toArray(Product[]::new);

        Iterable<Product> result = this.productStock.findAllByPrice(10);
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllByPriceShouldReturnEmptyCollectionIfNoSuchElement(){

        List<Product> products = createProductsAndAddIt(10);
        Product[] expected = new Product[0];

        Iterable<Product> result = this.productStock.findAllByPrice(10);
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);
    }
    //findFirstMostExpensiveProducts

    @Test
    public void findFirstMostExpensiveProductShouldWorkCorrectly(){

        List<Product> products = createProductsAndAddIt(10);
        Product[] expected = products
                .stream()
                .sorted((f,s)->Double.compare(s.getPrice(),f.getPrice()))
                .limit(3)
                .toArray(Product[]::new);

        Iterable<Product> result = this.productStock.findFirstMostExpensiveProducts(3);
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductShouldThrowExceptionIfParamIsMoreThenSizeOfColletion(){

        List<Product> products = createProductsAndAddIt(10);
        Iterable<Product> result = this.productStock.findFirstMostExpensiveProducts(11);

    }

    //findAllByQuantity
    @Test
    public void findAllByQuantityShouldWorkCorrectly(){

        List<Product> products = createProductsAndAddIt(10);
        products.get(0).setQuantity(100);
        products.get(1).setQuantity(100);
        Product[] expected = products
                .stream()
                .filter(p->p.getQuantity()==100)
                .toArray(Product[]::new);

        Iterable<Product> result = this.productStock.findAllByQuantity(100);
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyCollectionIfNoSuchQuantity(){

        List<Product> products = createProductsAndAddIt(10);
        Product[] expected = new Product[0];

        Iterable<Product> result = this.productStock.findAllByQuantity(100);
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);
    }

    //getIterable
    @Test
    public void getIterableShouldWorkCorrectly(){

        List<Product> products = createProductsAndAddIt(10);
        Product[] expected = products.toArray(Product[]::new);

        Iterable<Product> result = this.productStock.getIterable();
        Product[] actual = StreamSupport.stream(result.spliterator(), false).toArray(Product[]::new);

        Assert.assertArrayEquals(expected,actual);
    }






    private List<Product> createProducts(int n) {
        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            products.add(new Product(UUID.randomUUID().toString(), 5.3 * i, 10 * i));
        }
        return products;
    }

    private List<Product> createProductsAndAddIt(int n) {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Product product = new Product(UUID.randomUUID().toString(), 1.5 * i, 2 * i);
            this.productStock.add(product);
            products.add(product);
        }
        return products;
    }

    private boolean isItTheSameCollection(List<Product> expected, Iterable<Product> actual) {
        boolean isTheCollectionsAreTheSame = true;
        int i = 0;
        for (Product product : actual) {
            if (i>=expected.size()||!product.getLabel().equals(expected.get(i).getLabel())){
                isTheCollectionsAreTheSame=false;
                break;
            }
            i++;
        }
        if (i!=expected.size()){
            isTheCollectionsAreTheSame=false;
        }
        return isTheCollectionsAreTheSame;
    }
}