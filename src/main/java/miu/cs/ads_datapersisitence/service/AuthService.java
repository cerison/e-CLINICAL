package miu.cs.ads_datapersisitence.service;

import miu.cs.ads_datapersisitence.dto.request.LoginRequest;
import miu.cs.ads_datapersisitence.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}
