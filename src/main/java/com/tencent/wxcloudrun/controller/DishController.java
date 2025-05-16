package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Dish;
import com.tencent.wxcloudrun.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/available")
    public List<Dish> getAvailableDishes() {
        return dishService.getAvailableDishes();
    }

    @GetMapping("/{id}")
    public Dish getById(@PathVariable Integer id) {
        return dishService.getById(id);
    }

    @PostMapping
    public boolean save(@RequestBody Dish dish) {
        return dishService.save(dish);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Dish dish) {
        dish.setDishId(id);
        return dishService.updateById(dish);
    }

    @PutMapping("/{id}/status")
    public boolean updateStatus(@PathVariable Integer id, @RequestParam Boolean isAvailable) {
        return dishService.updateAvailableStatus(id, isAvailable);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return dishService.removeById(id);
    }
} 