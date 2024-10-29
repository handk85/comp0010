package uk.ac.ucl.comp0010.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.ucl.comp0010.model.Rate;

/**
 * A repository for rate instances.
 */
public interface RateRepository extends CrudRepository<Rate, Long> {

}
