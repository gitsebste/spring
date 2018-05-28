package com.example.demo;

import com.example.demo.JsonResponse.MessingWithData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        
        
        @Autowired
        MessingWithData messingWithData;
        
        
        	@Override
	public void run(String... arg0) throws Exception {
		// clear all record if existed before do the tutorial with new data 
                
                boolean debugMode=true;
                if(debugMode){
                 //= new MessingWithData();
                    messingWithData.saveData();
                    messingWithData.getData();
                }
                     
                
                //itemRepository.deleteAll();
	}

    
}
