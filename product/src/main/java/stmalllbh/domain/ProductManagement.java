package stmalllbh.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmalllbh.ProductApplication;
import stmalllbh.domain.StockIncresed;

@Entity
@Table(name = "ProductManagement_table")
@Data
//<<< DDD / Aggregate Root
public class ProductManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String productImg;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        StockIncresed stockIncresed = new StockIncresed(this);
        stockIncresed.publishAfterCommit();

        StockDecresed stockDecresed = new StockDecresed(this);
        stockDecresed.publishAfterCommit();
    }

    public static ProductManagementRepository repository() {
        ProductManagementRepository productManagementRepository = ProductApplication.applicationContext.getBean(
            ProductManagementRepository.class
        );
        return productManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreseStock(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        ProductManagement productManagement = new ProductManagement();
        repository().save(productManagement);

        */
        
        repository().findById(deliveryStarted.getProductId()).ifPresent(productManagement->{
            
            productManagement.setStock(productManagement.getStock()- deliveryStarted.getQty());
            repository().save(productManagement);
         });
        

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryReturned deliveryReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        ProductManagement productManagement = new ProductManagement();
        repository().save(productManagement);

        StockIncresed stockIncresed = new StockIncresed(productManagement);
        stockIncresed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(productManagement->{
            
            productManagement // do something
            repository().save(productManagement);

            StockIncresed stockIncresed = new StockIncresed(productManagement);
            stockIncresed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
