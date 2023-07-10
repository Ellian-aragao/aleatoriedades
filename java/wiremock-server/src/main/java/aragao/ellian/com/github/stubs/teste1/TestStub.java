package aragao.ellian.com.github.stubs.teste1;

import aragao.ellian.com.github.interfaces.StubConfig;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.auto.service.AutoService;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@AutoService(StubConfig.class)
public class TestStub implements StubConfig {
    @Override
    public void initStub() {
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/api/teste1"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withTransformers(TestTransformer.class.getSimpleName(), "response-template")));
    }
}
