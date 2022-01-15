package icns.smartplantdashboardapi;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartPlantDashboardApiApplication {

    public static void main(String[] args) {

        String posFolderPath = new File("").getAbsolutePath() + "/pos";
        File posFolder = new File(posFolderPath);

        if (!posFolder.exists()) {
            try {
                posFolder.mkdir();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        String sopDiagramFolder = new File("").getAbsolutePath() + "/sop-diagram";
        File sopFolder = new File(sopDiagramFolder);

        if (!sopFolder.exists()) {
            try {
                sopFolder.mkdir();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        String csv = new File("").getAbsolutePath() + "/data-csv";
        File csvFolder = new File(csv);

        if (!csvFolder.exists()) {
            try {
                csvFolder.mkdir();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        SpringApplication.run(SmartPlantDashboardApiApplication.class, args);


    }

}
