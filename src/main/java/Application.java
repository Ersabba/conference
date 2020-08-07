import com.pluralsight.model.Speaker;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;

public class Application {

    public static void main(String[] args){

        // Punto dolente del codice: se cambio implementazione devo ricompilare tutto l'applicativo
        SpeakerService service = new SpeakerServiceImpl();

        System.out.println(service.findAll().get(0).getFirstName());

    }
}
