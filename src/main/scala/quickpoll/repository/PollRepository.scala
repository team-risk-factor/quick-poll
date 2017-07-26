package quickpoll.repository

import org.springframework.data.repository.CrudRepository
import quickpoll.domain.Poll

trait PollRepository extends CrudRepository[Poll, java.lang.Long] 