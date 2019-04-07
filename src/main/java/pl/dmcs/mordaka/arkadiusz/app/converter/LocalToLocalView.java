package pl.dmcs.mordaka.arkadiusz.app.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.dmcs.mordaka.arkadiusz.app.exception.LocalNotFoundException;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.repository.LocalRepository;

@Component
public class LocalToLocalView implements Converter<Object, Local> {

    private static final Logger logger = LoggerFactory.getLogger(LocalToLocalView.class);

    private final LocalRepository localRepository;

    public LocalToLocalView(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public Local convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        Local local = localRepository.findById(id).orElseThrow(() -> new LocalNotFoundException(String.valueOf(id)));
        logger.info("Local : {}", local);
        return local;
    }
}
