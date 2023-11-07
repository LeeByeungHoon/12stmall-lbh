package stmalllbh.domain;

import java.util.*;
import lombok.*;
import stmalllbh.domain.*;
import stmalllbh.infra.AbstractEvent;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String userId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
}
