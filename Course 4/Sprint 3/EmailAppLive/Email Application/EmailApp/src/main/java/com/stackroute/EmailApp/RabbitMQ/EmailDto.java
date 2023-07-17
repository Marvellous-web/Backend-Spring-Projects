package com.stackroute.EmailApp.RabbitMQ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class EmailDto {
    private String receiver,subject,mailBody;
}
