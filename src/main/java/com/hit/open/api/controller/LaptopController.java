package com.hit.open.api.controller;

import com.hit.open.api.entity.Laptop;
import com.hit.open.api.model.LaptopModel;
import com.hit.open.api.serviceIpl.LaptopService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hit.open.api.utils.Constants.*;

@RestController
public class LaptopController {
    public static final String ALL_LAPTOP = "getAllLaptop";
    public static final String GET_BY_ID = "/getByID/{id}";
    @Autowired
    private LaptopService laptopService;
    @PostMapping(value = NEW_LAPTOP,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public LaptopModel newLaptop(@RequestBody LaptopModel model) throws Exception {
        return laptopService.createLaptop(model);
    }
    @GetMapping(value = ALL_LAPTOP, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<LaptopModel> getAllLaptop(){
        return laptopService.getAllLaptop();
    }
    @SneakyThrows
    @GetMapping(value = GET_BY_ID, produces = {MediaType.APPLICATION_JSON_VALUE})
    public LaptopModel getById(@PathVariable(name = "id") int id) throws Exception {
        return laptopService.getLaptopById(id);
    }
}
