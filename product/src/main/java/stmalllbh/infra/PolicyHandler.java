package stmalllbh.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import stmalllbh.config.kafka.KafkaProcessor;
import stmalllbh.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ProductManagementRepository productManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryCompleted_DecreseStock(
        @Payload DeliveryStarted deliveryCompleted
    ) {
        DeliveryStarted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener DecreseStock : " + deliveryCompleted + "\n\n"
        );

        // Sample Logic //
        ProductManagement.decreseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryReturned'"
    )
    public void wheneverDeliveryReturned_IncreaseStock(
        @Payload DeliveryReturned deliveryReturned
    ) {
        DeliveryReturned event = deliveryReturned;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + deliveryReturned + "\n\n"
        );

        // Sample Logic //
        ProductManagement.increaseStock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
