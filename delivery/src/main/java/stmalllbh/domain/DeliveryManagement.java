package stmalllbh.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmalllbh.DeliveryApplication;
import stmalllbh.domain.DeliveryCancelled;
import stmalllbh.domain.DeliveryCompleted;
import stmalllbh.domain.DeliveryReturned;
import stmalllbh.domain.DeliveryStarted;

@Entity
@Table(name = "DeliveryManagement_table")
@Data
//<<< DDD / Aggregate Root
public class DeliveryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long orderId;

    private String productName;

    private Long productId;

    private Integer qty;

    private String status;

    private Date deliveryDt;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(this);
        deliveryCancelled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

        DeliveryReturned deliveryReturned = new DeliveryReturned(this);
        deliveryReturned.publishAfterCommit();
    }

    public static DeliveryManagementRepository repository() {
        DeliveryManagementRepository deliveryManagementRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryManagementRepository.class
        );
        return deliveryManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(ProductOrdered productOrdered) {
        //implement business logic here:

        /** Example 1:  new item 
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        repository().save(deliveryManagement);

        DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryManagement);
        deliveryStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(productOrdered.get???()).ifPresent(deliveryManagement->{
            
            deliveryManagement // do something
            repository().save(deliveryManagement);

            DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryManagement);
            deliveryStarted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCancelled orderCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        repository().save(deliveryManagement);

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(deliveryManagement);
        deliveryCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(deliveryManagement->{
            
            deliveryManagement // do something
            repository().save(deliveryManagement);

            DeliveryCancelled deliveryCancelled = new DeliveryCancelled(deliveryManagement);
            deliveryCancelled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
