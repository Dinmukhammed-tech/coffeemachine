package coffeemachine.service;

import org.springframework.stereotype.Service;

@Service
public interface OperationalService {
    boolean isWorkingHours();
}
