package stmalllbh.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmalllbh.domain.*;

@Component
public class OrderManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrderManagement>> {

    @Override
    public EntityModel<OrderManagement> process(
        EntityModel<OrderManagement> model
    ) {
        return model;
    }
}
