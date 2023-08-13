package constantapi;

import com.shaft.driver.SHAFT;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class automationApi {


    @Test
    public void automationApi() {

        SHAFT.API api = new SHAFT.API("https://provider.test.carefer.co/api/customer/");
        Response response = api.get("v1/constant")
                .addHeader("Platform", "@vb~sD~KS#2>]pq")
                .perform();

        api.assertThatResponse().extractedJsonValue("message").contains("تم استرجاع الثوابت بنجاح").perform();
        api.assertThatResponse().extractedJsonValue("data.minimum_vehicle_make_year").isEqualTo("2001").perform();

        api.assertThatResponse().extractedJsonValue("data.engine_types[0].name_en").contains("Petrol Engines").perform();
        api.assertThatResponse().extractedJsonValue("data.brands[0].image").contains("gmc.png").perform();
        api.assertThatResponse().extractedJsonValue("data.colors[0].name").isEqualTo("أبيض").perform();
        api.assertThatResponse().extractedJsonValue("data.status.1").isEqualTo("مفعل").perform();
    }

    @Test
    public void socialmediaApi(){

       SHAFT.API api2 = new SHAFT.API( "https://provider.test.carefer.co/api/customer/") ;

    Response response2 = api2.get("v1/constant/socialMedia").addHeader("platform", "@vb~sD~KS#2>]pq").addHeader("Accept-Language","en").perform();
       api2.assertThatResponse().extractedJsonValue("message").contains("All social media links retrieved successfully").perform();
       
    }


}
