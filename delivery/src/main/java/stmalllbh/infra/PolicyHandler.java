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
    DeliveryManagementRepository deliveryManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductOrdered'"
    )
    public void wheneverProductOrdered_StartDelivery(
        @Payload ProductOrdered productOrdered
    ) {
        ProductOrdered event = productOrdered;
        System.out.println(
            "\n\n##### listener StartDelivery : " + productOrdered + "\n\n"
        );

        // Comments //
        //1. CJ logis 에게 배송 전문 발송
        // 2. 고객에게 배송시작 알림
        // 3. 우리 장부에도 키핑

        // Sample Logic //
        DeliveryManagement.startDelivery(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_CancelDelivery(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener CancelDelivery : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        DeliveryManagement.cancelDelivery(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
