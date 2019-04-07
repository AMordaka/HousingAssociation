package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.repository.LocalRepository;
import pl.dmcs.mordaka.arkadiusz.app.service.LocalService;

import java.util.List;

@Service
@Transactional
public class LocalServiceImpl implements LocalService {

    private final LocalRepository localRepository;

    public LocalServiceImpl(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public List<Local> getAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public void registerLocal(Local local) {
        localRepository.save(local);
    }
}
