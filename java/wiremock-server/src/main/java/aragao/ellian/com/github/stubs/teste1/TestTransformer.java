package aragao.ellian.com.github.stubs.teste1;

import aragao.ellian.com.github.interfaces.DefaultResponseTransformerConfig;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;
import com.google.auto.service.AutoService;

@AutoService(DefaultResponseTransformerConfig.class)
public class TestTransformer extends DefaultResponseTransformerConfig {
    @Override
    public Response transform(Request request, Response response, FileSource files, Parameters parameters) {
        return Response.Builder.like(response).build();
    }
}
