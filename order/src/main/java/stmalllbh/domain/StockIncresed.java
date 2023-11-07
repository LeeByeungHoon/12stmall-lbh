package stmalllbh.domain;

import java.util.*;
import lombok.*;
import stmalllbh.domain.*;
import stmalllbh.infra.AbstractEvent;

@Data
@ToString
public class StockIncresed extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;
}
