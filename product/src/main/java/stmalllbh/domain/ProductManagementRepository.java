package stmalllbh.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stmalllbh.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "productManagements",
    path = "productManagements"
)
public interface ProductManagementRepository
    extends PagingAndSortingRepository<ProductManagement, Long> {}
