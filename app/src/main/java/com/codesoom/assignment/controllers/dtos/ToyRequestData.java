package com.codesoom.assignment.controllers.dtos;

import com.codesoom.assignment.domain.ImageDemo;
import com.codesoom.assignment.domain.Toy;
import com.codesoom.assignment.domain.ToyProducer;
import com.codesoom.assignment.domain.Won;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToyRequestData {
    @NotBlank
    private String name;

    @NotBlank
    private String maker;

    @NotNull
    private BigDecimal price;

    private String url;


    public Toy toEntity() {
        return Toy.builder()
                .name(name)
                .price(new Won(price))
                .producer(ToyProducer.builder().name(maker).build())
                .demo(new ImageDemo(url))
                .build();
    }


}
