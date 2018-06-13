/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.domain.Item;
import com.example.demo.domain.Person;
import com.example.demo.domain.Unit;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author device02
 */

@Service
public class ItemService {
    
    ItemRepository itemRepository;

    public ItemRepository getItemRepository() {
        return itemRepository;
    }
@Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    
        public Iterable<Item> getAll(){
return itemRepository.findAll();
    }
           public void save(Item i){
               if(itemRepository==null)System.out.println("itemRepository==null");
               itemRepository.save(i);
    }    
}
