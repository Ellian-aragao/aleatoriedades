package aragao.ellian.com.github.stubs.teste2;

import aragao.ellian.com.github.interfaces.StubConfig;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.auto.service.AutoService;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@AutoService(StubConfig.class)
public class TestStub2 implements StubConfig {
    @Override
    public void initStub() {
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/api/endpoint/2"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withTransformers(TestTransformer2.class.getSimpleName())));
    }
}
