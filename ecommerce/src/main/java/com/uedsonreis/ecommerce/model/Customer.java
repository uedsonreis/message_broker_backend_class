package com.uedsonreis.ecommerce.model;

import com.uedsonreis.ecommerce.util.JsonUtil;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String cnpjCpf;
    private String name;
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(cnpjCpf, customer.cnpjCpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnpjCpf);
    }

    public String toString() {
        return JsonUtil.toJson(this);
    }
}
