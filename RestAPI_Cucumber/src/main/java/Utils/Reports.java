package Utils;
import org.junit.jupiter.api.AfterAll;
import java.awt.Desktop;
import java.net.URI;
import java.nio.file.*;


public class Reports {

        @AfterAll
        static void openReport() throws Exception {
            // Assuming you also generate a local HTML report
            Path reportPath = Paths.get(ConstantPath.cucumberhtmlreport);
            if (Files.exists(reportPath)) {
                Desktop.getDesktop().browse(reportPath.toUri());
            }
        }
}
