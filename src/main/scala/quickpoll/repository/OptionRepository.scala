package quickpoll.repository

import org.springframework.data.repository.CrudRepository
import quickpoll.domain.Option

trait OptionRepository extends CrudRepository[Option, java.lang.Long] 