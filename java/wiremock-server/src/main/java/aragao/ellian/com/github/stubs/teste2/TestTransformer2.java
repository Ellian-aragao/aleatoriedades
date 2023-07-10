package aragao.ellian.com.github.stubs.teste2;

import aragao.ellian.com.github.config.DependencyInjection;
import aragao.ellian.com.github.interfaces.DefaultResponseTransformerConfig;
import aragao.ellian.com.github.stubs.teste2.models.ObjectFromPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;
import com.google.auto.service.AutoService;

import java.io.IOException;

@AutoService(DefaultResponseTransformerConfig.class)
public class TestTransformer2 extends DefaultResponseTransformerConfig {

    private final ObjectMapper objectMapper;

    public TestTransformer2() {
        objectMapper = DependencyInjection.getInstanceOf(ObjectMapper.class);
    }

    @Override
    public Response transform(Request request, Response response, FileSource files, Parameters parameters) {
        try {
            ObjectFromPayload objectFromPayload = objectMapper.readValue(request.getBody(), ObjectFromPayload.class);
            System.out.println(files.getPath());
            return Response.Builder.like(response)
                    .body("{'hello': 'world', 'version':" + objectFromPayload.getPayload().getName() + "}")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
