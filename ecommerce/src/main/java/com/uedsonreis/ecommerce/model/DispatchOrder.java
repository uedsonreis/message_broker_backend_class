package com.uedsonreis.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.uedsonreis.ecommerce.util.JsonUtil;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DispatchOrder {

    private String productName;
    private String productType;
    private String manufactory;
    private String recipient;

    public String toString() {
        return JsonUtil.toJson(this);
    }

}
