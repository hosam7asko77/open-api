package com.hit.open.api.serviceIpl;

import com.hit.open.api.entity.Laptop;
import com.hit.open.api.model.LaptopModel;
import com.hit.open.api.repository.LaptopRepository;
import com.hit.open.api.utils.FilterField;
import com.hit.open.api.utils.LaptopSort;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.hit.open.api.utils.Constants.*;
@Slf4j
@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository ;
    @Transactional
    public LaptopModel createLaptop(LaptopModel model) throws Exception {
        Laptop entity = new Laptop();
        BeanUtils.copyProperties(model, entity);
        Laptop save = laptopRepository.save(entity);
        BeanUtils.copyProperties(save, model);
        return model;
    }
    @Transactional(readOnly = true)
    public List<LaptopModel> getAllLaptop() {
        List<LaptopModel> models = new ArrayList<>();
        laptopRepository.findAll().stream().forEach( laptop -> {
            LaptopModel model = new LaptopModel();
            BeanUtils.copyProperties(laptop, model);
            models.add(model);
        });
        log.error(models.toString());
        return models;
    }
    @Transactional(readOnly = true)
    public  List<Laptop> getAll(){
        return laptopRepository.findAll();
    }
    @SneakyThrows
    @Transactional(readOnly = true)
    public LaptopModel getLaptopById(int id) throws Exception {
        Optional<Laptop> byId = laptopRepository.findById(id);
        if (byId.isPresent()) {
            LaptopModel laptopModel = new LaptopModel();
            BeanUtils.copyProperties(byId.get(), laptopModel);
            return  laptopModel;
        }
        else {
            throw new Exception("no data found with given id"+id);
        }
    }
    public List<LaptopModel> getAll(int page, int size,  LaptopSort sort){
        List<LaptopModel> models = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size, sort == null ? Sort.unsorted(): sort.getSort());
          laptopRepository.findAll(pageable).toList().forEach(laptop -> {
              LaptopModel model = new LaptopModel();
              BeanUtils.copyProperties(laptop, model);
              models.add(model);
          });
          return models;
    }
    public List<Laptop> getAll(LaptopSort sort){
        return  laptopRepository.findAll(sort.getSort());
    }
    public List<Laptop> getAll(FilterField filter){
        Specification<Laptop> spec = null;
        if (filter.getField()!= null) {
            spec = by(filter);
            return laptopRepository.findAll(spec);
        }
        else {
            return laptopRepository.findAll();
        }

    }
    private <T> Specification<T> by(FilterField filterField){
        return (root, query, builder) -> filterField.generateCriteria(builder,root.get(filterField.getField()));
    }
}
