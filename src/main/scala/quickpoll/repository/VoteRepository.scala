package quickpoll.repository

import org.springframework.data.repository.CrudRepository
import quickpoll.domain.Vote

trait VoteRepository extends CrudRepository[Vote, java.lang.Long] 