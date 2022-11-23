package com.nhom13.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nhom13.dto.BookDTO;
import com.nhom13.dto.CartDTO;
import com.nhom13.dto.OrderDTO;
import com.nhom13.dto.OrderDetailDTO;
import com.nhom13.dto.UserDTO;
import com.nhom13.model.Book;
import com.nhom13.model.Cart;
import com.nhom13.model.Order;
import com.nhom13.model.OrderDetail;
import com.nhom13.model.User;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(Book.class, BookDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getCategory().getId(), (dst, value) -> dst.setId_category((Long) value));

        });

        modelMapper.createTypeMap(User.class, UserDTO.class).addMappings(mapper -> {

        });

        modelMapper.createTypeMap(Cart.class, CartDTO.class).addMappings(mapper -> {

        });

        modelMapper.createTypeMap(Order.class, OrderDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getUser().getId(), (dest, value) -> dest.setId_user((Long) value));
            mapper.map(src -> src.getPaymentMethod().getName(), (dest, value) -> dest.setPaymentMethod((String) value));

        });

        modelMapper.createTypeMap(OrderDetail.class, OrderDetailDTO.class).addMappings(mapper -> {

        });
        return modelMapper;

    }
}
