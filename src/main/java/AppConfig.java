import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import com.pluralsight.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

// Annotazione a livello di classe che va a sostituire l'applicationContext.xml
//
// Avremo un registro di Spring con due Bean
//
// Commentato tutto il codice: i bean non sono più configurati ma vengono
// creati facendo lo scan del package com.pluralsight e carcando le annotazione stereotype
@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

    @Bean(name = "cal4")
    public CalendarFactory calFactory(){
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        return calFactory().getObject();
    }

    // Annotazione da usare su un metodo: ci dice che il metodo restituisce uno Spring Bean
    // e può essere usato all'interno della nostra applicazione
    //
    // NOTA: i bean creati sono tutti SINGLETON
/*    @Bean(name="speakerService")
    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
    public SpeakerService getSpeakerService(){
        // Constructor Injection
        // SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());

        // Non faccio l'injection del repository
        SpeakerServiceImpl service = new SpeakerServiceImpl();

        // Setter Injection
        //service.setRepository(getSpeakerRepository());
        return service;
    }*/

    // In questo step non sembra importante il nome del bean: è importante che però Spring abbia registrato il bean
    // e che sia disponibile come candidato per una futura injection
    // IL fatto che questo metodo restituisce un bean significa che HibernateSpeakerRepositoryImpl sarà creato
    // una volta sola
    /*@Bean(name="speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }*/
}
