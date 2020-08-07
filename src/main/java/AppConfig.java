import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Annotazione a livello di classe che va a sostituire l'applicationContext.xml
@Configuration
public class AppConfig {

    // Annotazione da usare su un metodo: ci dice che il metodo restituisce uno Spring Bean
    // e può essere usato all'interno della nostra applicazione
    @Bean(name="speakerService")
    public SpeakerService getSpeakerService(){
        // Constructor Injection
        SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
        // Setter Injection
        //service.setRepository(getSpeakerRepository());
        return service;
    }

    // NOTA: il nome dei bean è molto importante (auto-wiring)
    @Bean(name="speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
