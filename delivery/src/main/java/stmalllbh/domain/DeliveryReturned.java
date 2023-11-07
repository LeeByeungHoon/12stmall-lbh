package stmalllbh.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmalllbh.domain.*;
import stmalllbh.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryReturned extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private Long productId;
    private Integer qty;

    public DeliveryReturned(DeliveryManagement aggregate) {
        super(aggregate);
    }

    public DeliveryReturned() {
        super();
    }
}
//>>> DDD / Domain Event
