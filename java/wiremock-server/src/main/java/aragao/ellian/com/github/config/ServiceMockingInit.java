package aragao.ellian.com.github.config;

import aragao.ellian.com.github.interfaces.DefaultResponseTransformerConfig;
import aragao.ellian.com.github.interfaces.StubConfig;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.Extension;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

public class ServiceMockingInit {
    public static void initWireMockAndConfiguration() {
        WireMockServer wireMockServer = new WireMockServer(wiremockConfigsOptions());

        wireMockServer.start();
        initStubs();

        while (true) {
        }
    }

    private static WireMockConfiguration wiremockConfigsOptions() {
        return WireMockConfiguration
                .options()
                .withRootDirectory("src/main/resources/wiremock/")
                .bindAddress("0.0.0.0")
                .asynchronousResponseEnabled(true)
                .extensions(getExtensions())
                .extensions(new ResponseTemplateTransformer(true))
                .port(8080);
    }

    public static Class<? extends Extension>[] getExtensions() {
        List<Extension> responseTransformerConfigs = new LinkedList<>();
        ServiceLoader<DefaultResponseTransformerConfig> loader = ServiceLoader.load(DefaultResponseTransformerConfig.class);
        loader.forEach(responseTransformerConfigs::add);
        return responseTransformerConfigs
                .stream()
                .map(Extension::getClass)
                .toArray(Class[]::new);
    }

    public static void initStubs() {
        ServiceLoader<StubConfig> loader = ServiceLoader.load(StubConfig.class);
        loader.forEach(StubConfig::initStub);
    }
}
