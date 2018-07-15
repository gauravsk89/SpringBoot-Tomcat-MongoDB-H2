package org.learning.springboot.mongodb.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Order {

    @Id
    private String orderId;

    private String product;

    private String amount;

}
