package com.superherogame.cleonildo.domain.client;

import com.superherogame.cleonildo.api.dto.response.AvengerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "avenger", url = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json")
public interface AvengerClient {
    @GetMapping
    List<AvengerResponse> getListOfAvengers();

}
