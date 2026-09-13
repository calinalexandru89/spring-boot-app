package com.loocos.auth;

import com.loocos.customer.CustomerDTO;

public record AuthenticationResponse(String token, CustomerDTO customerDTO) {
}
