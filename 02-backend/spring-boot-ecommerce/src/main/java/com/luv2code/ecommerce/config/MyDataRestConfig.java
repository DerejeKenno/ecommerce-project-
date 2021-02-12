package com.luv2code.ecommerce.config;


import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsupportedAcctions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

//disable HTTp methods for Product:PUT,POST,DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAcctions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAcctions));

        //disable HTTp methods for Product-category:PUT,POST,DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAcctions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAcctions));
    }
}
