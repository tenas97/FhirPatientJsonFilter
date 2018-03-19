package org.librehealth.commons.patientjsonfilter.setup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpClientGet {


    public ApacheHttpClientGet() {

    }


    public String executeGet(String url) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            //HttpGet getRequest = new HttpGet(
            //		"https://toolkit.librehealth.io/master/ws/rest/v1/person/4088066f-12b4-4fbb-8cf3-f7791dc6e5e6");
            HttpGet request = new HttpGet(
                    url);
            request.addHeader(HttpHeaders.ACCEPT_CHARSET, "utf-8");
            request.addHeader(HttpHeaders.ACCEPT, "application/fhir+json;q=1.0, application/json+fhir;q=0.9");
            request.addHeader(HttpHeaders.USER_AGENT, "HAPI-FHIR/3.1.0 (FHIR Client; FHIR 3.0.1/DSTU3; apache)");
            request.addHeader(HttpHeaders.CONTENT_TYPE, "application/fhir+json; charset=UTF-8");
            HttpResponse response = httpClient.execute(request);

            /*if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }*/

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            String fhirResource = "";
            String output;
            while ((output = br.readLine()) != null) {
                fhirResource = fhirResource + output;
            }

            httpClient.getConnectionManager().shutdown();
            return fhirResource;
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
