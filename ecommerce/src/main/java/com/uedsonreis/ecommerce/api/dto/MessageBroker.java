package com.uedsonreis.ecommerce.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.uedsonreis.ecommerce.model.Customer;
import com.uedsonreis.ecommerce.util.JsonUtil;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageBroker {

    private String pattern;
    private Customer data;

    public String toString() {
        return JsonUtil.toJson(this);
    }
}
