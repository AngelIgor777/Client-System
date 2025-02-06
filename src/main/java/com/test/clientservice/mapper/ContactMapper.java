package com.test.clientservice.mapper;

import com.test.clientservice.dto.request.ContactRequestDto;
import com.test.clientservice.dto.response.ContactResponseDto;
import com.test.clientservice.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    Contact toEntity(ContactRequestDto dto);
    ContactResponseDto toDto(Contact contact);
}