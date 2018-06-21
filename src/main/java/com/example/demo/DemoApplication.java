package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{//, ApplicationContextAware {
    
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
                    //messingWithData.saveData();
                    messingWithData.getData();
                }
                     
                
                //itemRepository.deleteAll();
	}

    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         private ApplicationContext context;
//
//        @Autowired @Override
//        public void setApplicationContext(ApplicationContext ac) throws BeansException {
//            this.context = ac;
//        }
//    
//    
//  @Bean
//public SpringResourceTemplateResolver templateResolver(){
//    // SpringResourceTemplateResolver automatically integrates with Spring's own
//    // resource resolution infrastructure, which is highly recommended.
//    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//    templateResolver.setApplicationContext(this.context);
//    templateResolver.setPrefix("/WEB-INF/templates/");
//    templateResolver.setSuffix(".html");
//    // HTML is the default value, added here for the sake of clarity.
//    templateResolver.setTemplateMode(TemplateMode.HTML);
//    // Template cache is true by default. Set to false if you want
//    // templates to be automatically updated when modified.
//    templateResolver.setCacheable(true);
//    return templateResolver;
//}
//@Bean
//public ThymeleafViewResolver viewResolver(){
//    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//    viewResolver.setTemplateEngine(templateEngine());
//    // NOTE 'order' and 'viewNames' are optional
//    viewResolver.setOrder(1);
//    viewResolver.setViewNames(new String[] {".html", ".xhtml", ".jsp"});
//    return viewResolver;
//}
//
//@Bean
//public SpringTemplateEngine templateEngine(){
//    // SpringTemplateEngine automatically applies SpringStandardDialect and
//    // enables Spring's own MessageSource message resolution mechanisms.
//    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//    templateEngine.setTemplateResolver(templateResolver());
//    // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
//    // speed up execution in most scenarios, but might be incompatible
//    // with specific cases when expressions in one template are reused
//    // across different data types, so this flag is "false" by default
//    // for safer backwards compatibility.
//    templateEngine.setEnableSpringELCompiler(true);
//    return templateEngine;
//}
}
