package com.stackroute.EmailApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailData {
    private String receiver,subject,mailBody,attachment;
}
