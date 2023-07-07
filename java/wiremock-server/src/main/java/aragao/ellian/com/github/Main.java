package aragao.ellian.com.github;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class Main {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration
                .options()
                .extensions(new ResponseTemplateTransformer(true))
                .port(8080));

        wireMockServer.start();

        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/api/endpoint"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("response-template.json")));

        while (true) {
        }
    }
}
