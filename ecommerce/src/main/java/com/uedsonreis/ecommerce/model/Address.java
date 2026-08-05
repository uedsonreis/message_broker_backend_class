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
public class Address {

    private String postalCode;
    private String description;
    private String city;

    public String toString() {
        return JsonUtil.toJson(this);
    }

}
