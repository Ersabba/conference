import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Annotazione a livello di classe che va a sostituire l'applicationContext.xml
//
// Avremo un registro di Spring con due Bean
@Configuration
public class AppConfig {

    // Annotazione da usare su un metodo: ci dice che il metodo restituisce uno Spring Bean
    // e può essere usato all'interno della nostra applicazione
    //
    // NOTA: i bean creati sono tutti SINGLETON
    @Bean(name="speakerService")
    public SpeakerService getSpeakerService(){
        // Constructor Injection
        SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
        // Setter Injection
        //service.setRepository(getSpeakerRepository());
        return service;
    }

    // NOTA: il nome dei bean è molto importante (auto-wiring)
    // In questo step definire un bean non sembra importante
    // IL fatto che questo metodo restituisce un bean significa che HibernateSpeakerRepositoryImpl sarà creato una volta sola
    @Bean(name="speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
