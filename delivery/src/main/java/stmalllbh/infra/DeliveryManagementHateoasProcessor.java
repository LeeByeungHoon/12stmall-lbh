package stmalllbh.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import stmalllbh.domain.*;

@Component
public class DeliveryManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeliveryManagement>> {

    @Override
    public EntityModel<DeliveryManagement> process(
        EntityModel<DeliveryManagement> model
    ) {
        return model;
    }
}
