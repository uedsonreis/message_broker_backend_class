package com.uedsonreis.ecommerce.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.uedsonreis.ecommerce.util.JsonUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DispatchOrder {

    @NotBlank(message = "Product Name is required")
    private String productName;

    @NotBlank(message = "Product Type is required")
    private String productType;

    @NotBlank(message = "Manufactory is required")
    private String manufactory;

    @NotBlank(message = "Recipient identification is required")
    private String recipient;

    public String toString() {
        return JsonUtil.toJson(this);
    }

}
