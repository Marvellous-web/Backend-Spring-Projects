package com.stackroute.AuthenticationApp.RabbitMQ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class emailDTO {
    private String receiver,subject,mailBody;
}
