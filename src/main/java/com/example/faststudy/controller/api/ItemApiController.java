package com.example.faststudy.controller.api;

import com.example.faststudy.controller.CrudController;
import com.example.faststudy.ifs.CrudInterface;
import com.example.faststudy.model.entity.Item;
import com.example.faststudy.model.network.Header;
import com.example.faststudy.model.network.request.ItemApiRequest;
import com.example.faststudy.model.network.response.ItemApiResponse;
import com.example.faststudy.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

//    @Autowired
//    private ItemApiLogicService itemApiLogicService;
//
//    @PostConstruct
//    public void init(){
//        this.baseService = itemApiLogicService;
//    }

//    @Override
//    @PostMapping("")
//    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}")
//    public Header<ItemApiResponse> read(@PathVariable Long id) {
//        return itemApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping("")
//    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
//        return itemApiLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}")
//    public Header delete(@PathVariable Long id) {
//        return itemApiLogicService.delete(id);
//    }
}
