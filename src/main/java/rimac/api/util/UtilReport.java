package rimac.api.util;

//import cucumber.api.java.en;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepEventBus;
import org.apache.commons.lang3.StringUtils;
import io.restassured.specification.RequestSpecification;
import rimac.util.ConexionAWS;
import rimac.util.Constantes;

public class UtilReport {
	
    public void showStepMessage(String message) {
        // TODO: escape message string for use in HTML
        String escapedMessage = StringUtils.replace(message, " ", "&nbsp;");

        StepEventBus.getEventBus().stepStarted(ExecutedStepDescription.withTitle(escapedMessage));
        StepEventBus.getEventBus().stepFinished();
    }

}
