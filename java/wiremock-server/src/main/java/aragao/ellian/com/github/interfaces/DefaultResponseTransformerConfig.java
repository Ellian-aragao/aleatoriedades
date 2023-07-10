package aragao.ellian.com.github.interfaces;

import com.github.tomakehurst.wiremock.extension.ResponseTransformer;

public abstract class DefaultResponseTransformerConfig extends ResponseTransformer {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean applyGlobally() {
        return false;
    }
}
