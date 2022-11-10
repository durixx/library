package sk.durixx.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sk.durixx.library.model.entity.Rack;

@Service
public interface RackRepository extends JpaRepository<Rack, Long> {

}
