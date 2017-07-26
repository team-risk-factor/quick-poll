package quickpoll.controller

import javax.inject.Inject
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}
import quickpoll.domain.Poll
import quickpoll.repository.PollRepository

@RestController
class PollController {
    @Inject
    val pollRepository: PollRepository = null

    @RequestMapping(value=Array("/polls"), method=Array(RequestMethod.GET))
    def getAllPolls: ResponseEntity[java.lang.Iterable[Poll]] = {
        val allPolls = pollRepository.findAll()
        new ResponseEntity(allPolls, HttpStatus.OK)
    }

} 