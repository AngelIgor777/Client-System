package com.test.clientservice.mapper;


import com.test.clientservice.dto.request.ClientRequestDto;
import com.test.clientservice.dto.response.ClientResponseDto;
import com.test.clientservice.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toEntity(ClientRequestDto dto);

    ClientResponseDto toDto(Client client);
}
