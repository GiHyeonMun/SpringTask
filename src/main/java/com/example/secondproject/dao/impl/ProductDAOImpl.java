package com.example.secondproject.dao.impl;

import com.example.secondproject.dao.ProductDAO;
import com.example.secondproject.entity.Product;
import com.example.secondproject.repository.ProductRepository;
import com.example.secondproject.repository.QProductRepository;
//import com.querydsl.core.types.Predicate;
//import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//import static com.example.secondproject.entity.QProduct.product;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;
    //private final JPAQueryFactory jpaQueryFactory;
    private final QProductRepository qProductRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository,
                          //JPAQueryFactory jpaQueryFactory,
                          QProductRepository qProductRepository) {
        this.productRepository = productRepository;
        //this.jpaQueryFactory = jpaQueryFactory;
        this.qProductRepository = qProductRepository;
    }

    /*public Product selectProduct(Long number) {
        Predicate predicate = product.number.eq(number);
        Optional<Product> selectProduct = qProductRepository.findOne(predicate);
        return selectProduct.isPresent() ? selectProduct.get() : null;
    }*/
    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public List<Product> listByStock(int stock) {
        return productRepository.listByStock(stock);
    }

    @Override
    public List<Product> selectProductByName(String name) {
        List<Product> product =
                productRepository.findByName(name, Sort.by(Sort.Order.asc("price")));
        return product;
    }

    @Override
    public Product selectProduct(Long number) {
        return null;
    }


    @Override
    public Long countByPrice(int price) {
        return productRepository.countByPrice(price);
    }

    @Override
    public boolean existsByNumber(Long number) {
        return productRepository.existsByNumber(number);
    }

    @Override
    public Product selectProductByNameAndPrice(String name, int price) {
        return productRepository.findByNameAndPrice(name, price);
    }

    @Override
    public List<Product> listProductByName(String name) {
        return productRepository.findByNameOrderByPriceDesc(name);
    }

    @Override
    public List<Product> listAllProductByName() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> allProduct() {
        return null;
    }

    /*public List<Product> allProduct() {
        return jpaQueryFactory.selectFrom(product).
                where(product.name.eq("aaa")).
                orderBy(product.price.desc()).fetch();
    }*/

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else throw new Exception();
        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else throw new Exception();
    }
}