package stmalllbh.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmalllbh.domain.*;
import stmalllbh.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StockIncresed extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;

    public StockIncresed(ProductManagement aggregate) {
        super(aggregate);
    }

    public StockIncresed() {
        super();
    }
}
//>>> DDD / Domain Event
