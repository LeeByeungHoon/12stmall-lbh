package stmalllbh.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmalllbh.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "orderHistories",
    path = "orderHistories"
)
public interface OrderHistoryRepository
    extends PagingAndSortingRepository<OrderHistory, Long> {}
