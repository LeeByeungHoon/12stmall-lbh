package stmalllbh.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmalllbh.domain.*;

@Component
public class ProductManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ProductManagement>> {

    @Override
    public EntityModel<ProductManagement> process(
        EntityModel<ProductManagement> model
    ) {
        return model;
    }
}
