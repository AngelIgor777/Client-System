package com.test.clientservice.dto.response;


import lombok.Data;
import java.util.List;

@Data
public class ClientResponseDto {
    private Long id;
    private String name;
    private List<ContactResponseDto> contacts;
}
