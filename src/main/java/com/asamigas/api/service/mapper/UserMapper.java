package com.asamigas.api.service.mapper;

import com.asamigas.api.dto.request.RegisterUserRequest;
import com.asamigas.api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    User toEntity(RegisterUserRequest request, String encodedPassword);

}
