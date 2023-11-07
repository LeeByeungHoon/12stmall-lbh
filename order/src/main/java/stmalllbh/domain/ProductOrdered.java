package stmalllbh.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmalllbh.domain.*;
import stmalllbh.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductOrdered extends AbstractEvent {

    private Long id;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private String address;

    public ProductOrdered(OrderManagement aggregate) {
        super(aggregate);
    }

    public ProductOrdered() {
        super();
    }
}
//>>> DDD / Domain Event
